package documentify.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.SimpleMessage;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import documentify.dao.SubmissionDao;
import documentify.model.Submission;

/**
 *
 * @author Russ
 */
public class SubmissionFormActionBean extends SubmissionBaseActionBean {
    
    private static final String FORM = "/WEB-INF/jsp/submit_form.jsp";
    
    @DefaultHandler
    public Resolution form(){
        return new ForwardResolution(FORM);
    }
    
    public Resolution submit(){
        Submission submission = getSubmission();
        SubmissionDao dao = getSubmissionDao();
        submission = dao.save(submission);
        dao.commit();
        getContext().getMessages().add(new SimpleMessage("Submission {0} has been saved.", submission));
        return new RedirectResolution(RequestListActionBean.class);
    }
    
    @DontValidate
    public Resolution cancel(){
        getContext().getMessages().add(new SimpleMessage("Action cancelled."));
        return new RedirectResolution(RequestListActionBean.class);
    }
    
    @ValidateNestedProperties({
        @Validate(field = "body", required = true, on = "submit"),
    })
    
    @Override
    public void setSubmission(Submission submission){
        super.setSubmission(submission);
    }
    
}
