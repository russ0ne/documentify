package documentify.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Russ
 */
@Entity
public class Request extends EntityBase {

    @ManyToOne
    private User requester;
    @ManyToOne
    private Project project;
    private String comments;
    @Enumerated(EnumType.STRING)
    private Priority assignedPriority;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOfRequest;
    private int pointsWorth;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date reviewDate;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String requestTitle;
    private String requestDesc;

//Related section of project
  
    public User getRequester() {
        return requester;
    }

    public void setRequester(User requester) {
        this.requester = requester;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Priority getAssignedPriority() {
        return assignedPriority;
    }

    public void setAssignedPriority(Priority assignedPriority) {
        this.assignedPriority = assignedPriority;
    }

    public Date getDateOfRequest() {
        return dateOfRequest;
    }

    public void setDateOfRequest(Date dateOfRequest) {
        this.dateOfRequest = dateOfRequest;
    }

    public int getPointsWorth() {
        return pointsWorth;
    }

    public void setPointsWorth(int pointsWorth) {
        this.pointsWorth = pointsWorth;
    }

    @Override
    public String toString() {
        return "" + getId();
    }

    /**
     * @return the reviewDate
     */
    public Date getReviewDate() {
        return reviewDate;
    }

    /**
     * @param reviewDate the reviewDate to set
     */
    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    /**
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @return the requestDesc
     */
    public String getRequestDesc() {
        return requestDesc;
    }

    /**
     * @param requestDesc the requestDesc to set
     */
    public void setRequestDesc(String requestDesc) {
        this.requestDesc = requestDesc;
    }

    /**
     * @return the requestTitle
     */
    public String getRequestTitle() {
        return requestTitle;
    }

    /**
     * @param requestTitle the requestTitle to set
     */
    public void setRequestTitle(String requestTitle) {
        this.requestTitle = requestTitle;
    }

}
