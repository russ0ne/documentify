package documentify.dao.impl.stripersist;

import org.stripesstuff.stripersist.Stripersist;
import java.util.List;
import documentify.dao.RequestDao;
import documentify.model.Request;
import documentify.model.User;

public class RequestDaoImpl extends BaseDaoImpl<Request,Integer>
    implements RequestDao
{
    @Override
    public Request findByEmail(String email, User user) {
        return findBy("email", email, user);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Request> findByName(String startsWith, User user) {
        return null;
        /*return Stripersist.getEntityManager()
            .createQuery("select distinct c from "
              + getEntityClass().getName() + " c "
              + "where (c.firstName like '" + startsWith + "%' or "
              + "c.lastName like '" + startsWith + "%') "
              + "and c.user = :user"
             ).setParameter("user", user).getResultList();*/
    }
    
}
