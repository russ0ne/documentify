package documentify.dao.impl.stripersist;

import org.stripesstuff.stripersist.Stripersist;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.NonUniqueResultException;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import documentify.dao.Dao;
import documentify.model.User;

public abstract class BaseDaoImpl<T, ID extends Serializable>
        implements Dao<T, ID> {

    private final Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
        entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> read() {
        return Stripersist.getEntityManager()
                .createQuery("SELECT FROM " + entityClass.getName())
                .getResultList();
    }

    @Override
    public T read(ID id) {
        return Stripersist.getEntityManager().find(entityClass, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T save(T object) {
        return Stripersist.getEntityManager().merge(object);
    }

    @Override
    public void delete(T object) {
        Stripersist.getEntityManager().remove(object);
    }

    @Override
    public void commit() {
        Stripersist.getEntityManager().getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public T findBy(String fieldName, Object value) {
        Query query = Stripersist.getEntityManager()
                .createQuery(getQuery(fieldName, null))
                .setParameter(fieldName, value);
        return getSingleResult(query);
    }

    @SuppressWarnings("unchecked")
    public T findBy(String fieldName, Object value, User user) {
        Query query = Stripersist.getEntityManager()
                .createQuery(getQuery(fieldName, user))
                .setParameter(fieldName, value)
                .setParameter("user", user);
        return getSingleResult(query);
    }

    private String getQuery(String fieldName, User user) {
        String query
                = "SELECT t FROM " + entityClass.getName() + " t "
                + "where t." + fieldName + " = :" + fieldName;
        if (user == null) {
            return query;
        }
        return query + " AND t.user = :user";
    }

    @SuppressWarnings("unchecked")
    private T getSingleResult(Query query) {
        try {
            return (T) query.getSingleResult();
        } catch (NonUniqueResultException exc) {
            return (T) query.getResultList().get(0);
        } catch (NoResultException exc) {
            return null;
        }
    }
}
