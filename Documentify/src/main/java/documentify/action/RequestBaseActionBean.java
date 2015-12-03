package documentify.action;

import documentify.dao.RequestDao;
import documentify.dao.impl.stripersist.RequestDaoImpl;
import documentify.model.Request;
import org.stripesstuff.stripersist.Stripersist;

/**
 *
 * @author Russ
 */
public abstract class RequestBaseActionBean extends BaseActionBean {

    // this is only used when there is a completely empty database
    // otherwise we get: java.lang.ClassNotFoundException
    /*static {
        Stripersist.getEntityManager().getMetamodel().entity(Request.class);
    }*/
    
    private final RequestDao requestDao = new RequestDaoImpl();
    private Request request;

    public RequestDao getRequestDao() {
        return requestDao;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

}
