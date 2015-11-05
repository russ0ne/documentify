package documentify.dao;

import java.util.List;
import documentify.model.User;

public interface UserDao extends Dao<User,Integer> {
    public User findByEmail(String email, User user);
    public List<User> findByName(String startsWith, User user);
}
