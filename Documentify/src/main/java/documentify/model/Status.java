package documentify.model;

public enum Status {

    OPEN("Open"),
    CLOSED("Closed"),
    
    ACCEPTED("Accepted"),
    PENDING("Pending")
    ;

	

    private final String desc;

    Status(String desc) {
        this.desc = desc;
    }

    public String getStatus() {
        return desc;
    }
}
