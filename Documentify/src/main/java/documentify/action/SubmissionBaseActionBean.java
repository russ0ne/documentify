package documentify.action;

import documentify.dao.SubmissionDao;
import documentify.dao.impl.stripersist.SubmissionDaoImpl;
import documentify.model.Submission;

/**
 *
 * @author Russ
 */
public abstract class SubmissionBaseActionBean extends BaseActionBean {

    // this is only used when there is a completely empty database
    // otherwise we get: java.lang.ClassNotFoundException
    /*static {
        Stripersist.getEntityManager().getMetamodel().entity(Request.class);
    }*/
    
    private final SubmissionDao submissionDao = new SubmissionDaoImpl();
    private Submission submission;

    public SubmissionDao getSubmissionDao() {
        return submissionDao;
    }

    public Submission getSubmission() {
        return submission;
    }

    public void setSubmission(Submission submission) {
        this.submission = submission;
    }

}
