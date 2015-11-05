package documentify.action;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;

/**
 *
 * @author Russ
 */
public class BaseActionBean implements ActionBean{
    
    private ActionBeanContext actionBeanContext;

    @Override
    public void setContext(ActionBeanContext context) {
        this.actionBeanContext = context;
    }

    @Override
    public ActionBeanContext getContext() {
        return actionBeanContext;
    }
}
