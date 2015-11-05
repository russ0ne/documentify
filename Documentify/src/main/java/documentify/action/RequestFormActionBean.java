package documentify.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.SimpleMessage;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import documentify.dao.RequestDao;
import documentify.model.Request;

/**
 *
 * @author Russ
 */
public class RequestFormActionBean extends RequestBaseActionBean {
    
    private static final String FORM = "/WEB-INF/jsp/request_form.jsp";
    
    @DefaultHandler
    public Resolution form(){
        return new ForwardResolution(FORM);
    }
    
    public Resolution save(){
        Request request = getRequest();
        RequestDao dao = getRequestDao();
        request = dao.save(request);
        dao.commit();
        getContext().getMessages().add(new SimpleMessage("Request {0} has been saved.", request));
        return new RedirectResolution(RequestListActionBean.class);
    }
    
    @DontValidate
    public Resolution cancel(){
        getContext().getMessages().add(new SimpleMessage("Action cancelled."));
        return new RedirectResolution(RequestListActionBean.class);
    }
    
    @ValidateNestedProperties({
        @Validate(field = "project", required = true, on = "save"),
        @Validate(field = "requester", required = true, on = "save"),
        @Validate(field = "assignedPriority", required = true, on = "save"),
        @Validate(field = "dateOfRequest", required = true, expression = "${self <= today}", on = "save"),
        @Validate(field = "pointsWorth", required = true, on = "save", minvalue = 1, maxvalue = 100)
    })
    @Override
    public void setRequest(Request request){
        super.setRequest(request);
    }
    
    public Date getToday() {
        return new Date();
    }
    
}
