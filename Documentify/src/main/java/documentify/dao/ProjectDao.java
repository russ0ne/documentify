package documentify.dao;

import java.util.List;
import documentify.model.Project;
import documentify.model.User;

public interface ProjectDao extends Dao<Project,Integer> {
    public Project findByEmail(String email, User user);
    public List<Project> findByName(String startsWith, User user);
}
