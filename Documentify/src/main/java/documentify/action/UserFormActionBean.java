package documentify.action;

import documentify.dao.UserDao;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.SimpleMessage;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import documentify.model.User;

/**
 *
 * @author Russ
 */
public class UserFormActionBean extends UserBaseActionBean {
    
    private static final String FORM = "/WEB-INF/jsp/user_form.jsp";
    
    @DefaultHandler
    public Resolution form(){
        return new ForwardResolution(FORM);
    }
    
    public Resolution save(){
        User user = getUser();
        UserDao dao = getUserDao();
        user = dao.save(user);
        dao.commit();
        getContext().getMessages().add(new SimpleMessage("User {0} has been saved.", user));
        return new RedirectResolution(UserListActionBean.class);
    }
    
    @DontValidate
    public Resolution cancel(){
        getContext().getMessages().add(new SimpleMessage("Action cancelled."));
        return new RedirectResolution(UserListActionBean.class);
    }
    
    @ValidateNestedProperties({
        @Validate(field = "userName", required = true, on = "save")
    })
    @Override
    public void setUser(User user){
        super.setUser(user);
    }
}
