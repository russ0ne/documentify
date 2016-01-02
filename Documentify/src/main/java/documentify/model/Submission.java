package documentify.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Submission extends EntityBase {

	private String body;
	@ManyToOne
	private Request request;
	@ManyToOne
	private User Submitter;
	@Enumerated(EnumType.STRING)
	private Status status;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dateOfSubmission;
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Request getRequest() {
		return request;
	}
	public void setRequest(Request request) {
		this.request = request;
	}
	public User getSubmitter() {
		return Submitter;
	}
	public void setSubmitter(User submitter) {
		Submitter = submitter;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Date getDateOfSubmission() {
		return dateOfSubmission;
	}
	public void setDateOfSubmission(Date dateOfSubmission) {
		this.dateOfSubmission = dateOfSubmission;
	}
  
	@Override
    public String toString() {
        return "" + getId();
    }

	
	
	
	
}
