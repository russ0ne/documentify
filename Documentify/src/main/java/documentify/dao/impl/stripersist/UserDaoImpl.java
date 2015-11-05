package documentify.dao.impl.stripersist;

import org.stripesstuff.stripersist.Stripersist;
import java.util.List;
import documentify.dao.UserDao;
import documentify.model.User;

public class UserDaoImpl extends BaseDaoImpl<User,Integer>
    implements UserDao
{
    @Override
    public User findByEmail(String email, User user) {
        return findBy("email", email, user);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<User> findByName(String startsWith, User user) {
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
