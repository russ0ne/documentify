package documentify.action;

import java.util.List;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.SimpleMessage;
import org.stripesstuff.stripersist.Stripersist;
import documentify.model.Request;

/**
 *
 * @author Russ
 */
public class RequestListActionBean extends RequestBaseActionBean {

    private static final String LIST = "/WEB-INF/jsp/request_list.jsp";
    private static final String VIEW = "/WEB-INF/jsp/request_view.jsp";

    @DefaultHandler
    public Resolution list() {
        return new ForwardResolution(LIST);
    }

    public Resolution view() {
        return new ForwardResolution(VIEW);
    }

    public Resolution delete() {
        Request toBeDeleted = getRequest();
        getRequestDao().delete(toBeDeleted);
        getContext().getMessages().add(new SimpleMessage("Deleted {0}", toBeDeleted));
        return new RedirectResolution(getClass());
    }

    public List<Request> getRequests() {
        return getRequestDao().read();
    }
}
