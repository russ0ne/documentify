package documentify.view;

import java.util.List;
import documentify.dao.ProjectDao;
import documentify.dao.impl.stripersist.ProjectDaoImpl;
import documentify.model.Project;

/**
 *
 * @author Russ
 */
public class ProjectsViewHelper {

    private final ProjectDao projectDao = new ProjectDaoImpl();

    public List<Project> getProjects() {
        return projectDao.read();
    }
}
