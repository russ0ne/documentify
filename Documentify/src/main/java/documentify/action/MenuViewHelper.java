package documentify.action;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

/**
 *
 * @author Russ
 */
public class MenuViewHelper extends BaseActionBean{
    
    private Section currentSection;
    
    public Section getCurrentSection(){
        return currentSection;
    }
    
    public void setCurrentSection(Section currentSection){
        this.currentSection = currentSection;
    }
    
    public Section[] getSections(){
        return Section.values();
    }
    
    @DefaultHandler
    public Resolution view(){
        return new ForwardResolution("/WEB-INF/jsp/common/menu.jsp");
    }
    
    public enum Section{
       
        RequestList("Request List", RequestListActionBean.class),
        ProjectList("Project List", ProjectListActionBean.class);
        
        private final String text, beanclass;

        private Section(String text, Class<? extends ActionBean> beanclass) {
            this.text = text;
            this.beanclass = beanclass.getName();
        }

        public String getText() {
            return text;
        }

        public String getBeanclass() {
            return beanclass;
        }
    }
}
