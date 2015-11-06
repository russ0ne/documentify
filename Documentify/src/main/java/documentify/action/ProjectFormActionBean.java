package documentify.action;

import documentify.dao.ProjectDao;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.SimpleMessage;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import documentify.model.Project;

/**
 *
 * @author Russ
 */
public class ProjectFormActionBean extends ProjectBaseActionBean {
    
    private static final String FORM = "/WEB-INF/jsp/project_form.jsp";
    
    @DefaultHandler
    public Resolution form(){
        return new ForwardResolution(FORM);
    }
    
    public Resolution save(){
        Project project = getProject();
        ProjectDao dao = getProjectDao();
        project = dao.save(project);
        dao.commit();
        getContext().getMessages().add(new SimpleMessage("Project {0} has been saved.", project));
        return new RedirectResolution(ProjectListActionBean.class);
    }
    
    @DontValidate
    public Resolution cancel(){
        getContext().getMessages().add(new SimpleMessage("Action cancelled."));
        return new RedirectResolution(ProjectListActionBean.class);
    }
    
    @ValidateNestedProperties({
        @Validate(field = "projectName", required = true, on = "save")
    })
    @Override
    public void setProject(Project project){
        super.setProject(project);
    }
}
