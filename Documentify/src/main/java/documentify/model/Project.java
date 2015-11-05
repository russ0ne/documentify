package documentify.model;

import javax.persistence.Entity;

/**
 *
 * @author Russ
 */
@Entity
public class Project extends EntityBase {

    private String projectName;

    /**
     * @return the projectName
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * @param projectName the projectName to set
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return projectName;
    }

}
