package documentify.dao.impl.stripersist;

import org.stripesstuff.stripersist.Stripersist;
import java.util.List;
import documentify.dao.RequestDao;
import documentify.dao.SubmissionDao;
import documentify.model.Request;
import documentify.model.Submission;
import documentify.model.User;

public class SubmissionDaoImpl extends BaseDaoImpl<Submission,Integer>
    implements SubmissionDao
{
    @Override
    public Submission findByEmail(String email, User user) {
        return findBy("email", email, user);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Submission> findByName(String startsWith, User user) {
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
