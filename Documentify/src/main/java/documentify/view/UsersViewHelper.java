package documentify.view;

import java.util.List;
import documentify.dao.UserDao;
import documentify.dao.impl.stripersist.UserDaoImpl;
import documentify.model.User;

/**
 *
 * @author Russ
 */
public class UsersViewHelper {

    private final UserDao userDao = new UserDaoImpl();

    public List<User> getUsers() {
        return userDao.read();
    }
}
