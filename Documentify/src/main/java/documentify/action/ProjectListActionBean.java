package documentify.action;

import java.util.List;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.SimpleMessage;
import documentify.model.Project;

/**
 *
 * @author Russ
 */
public class ProjectListActionBean extends ProjectBaseActionBean {

    private static final String LIST = "/WEB-INF/jsp/project_list.jsp";
    private static final String VIEW = "/WEB-INF/jsp/project_view.jsp";

    @DefaultHandler
    public Resolution list() {
        return new ForwardResolution(LIST);
    }

    public Resolution view() {
        return new ForwardResolution(VIEW);
    }

    public Resolution delete() {
        Project toBeDeleted = getProject();
        getProjectDao().delete(toBeDeleted);
        getContext().getMessages().add(new SimpleMessage("Deleted {0}", toBeDeleted));
        return new RedirectResolution(getClass());
    }

    public List<Project> getProjects() {
        return getProjectDao().read();
    }
}
