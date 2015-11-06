package documentify.action;

import documentify.dao.ProjectDao;
import documentify.dao.impl.stripersist.ProjectDaoImpl;
import documentify.model.Project;

/**
 *
 * @author Russ
 */
public abstract class ProjectBaseActionBean extends BaseActionBean {
    
    private final ProjectDao projectDao = new ProjectDaoImpl();
    private Project project;

    public ProjectDao getProjectDao() {
        return projectDao;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

}
