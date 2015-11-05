package documentify.dao;

import java.util.List;
import documentify.model.Request;
import documentify.model.User;

public interface RequestDao extends Dao<Request,Integer> {
    public Request findByEmail(String email, User user);
    public List<Request> findByName(String startsWith, User user);
}
