package documentify.action;

import documentify.dao.UserDao;
import documentify.dao.impl.stripersist.UserDaoImpl;
import documentify.model.User;

/**
 *
 * @author Russ
 */
public abstract class UserBaseActionBean extends BaseActionBean {
    
    private final UserDao userDao = new UserDaoImpl();
    private User user;

    public UserDao getUserDao() {
        return userDao;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
