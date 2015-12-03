package documentify.model;

public enum Status {

    OPEN("Open"),
    CLOSED("Closed");

    private final String desc;

    Status(String desc) {
        this.desc = desc;
    }

    public String getStatus() {
        return desc;
    }
}
