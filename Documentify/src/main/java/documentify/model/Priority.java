package documentify.model;

public enum Priority {

    LOW("Low"),
    MEDIUM("Medium"),
    HIGH("High");

    private final String desc;

    Priority(String desc) {
        this.desc = desc;
    }

    public String getPriority() {
        return desc;
    }
}
