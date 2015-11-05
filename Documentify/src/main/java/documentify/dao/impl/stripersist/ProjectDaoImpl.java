package documentify.dao.impl.stripersist;

import org.stripesstuff.stripersist.Stripersist;
import java.util.List;
import documentify.dao.ProjectDao;
import documentify.model.Project;
import documentify.model.User;

public class ProjectDaoImpl extends BaseDaoImpl<Project,Integer>
    implements ProjectDao
{
    @Override
    public Project findByEmail(String email, User user) {
        return findBy("email", email, user);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Project> findByName(String startsWith, User user) {
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
