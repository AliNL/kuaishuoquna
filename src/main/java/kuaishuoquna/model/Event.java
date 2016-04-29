package kuaishuoquna.model;

/**
 * Created by yzhou on 4/21/16.
 */
public class Event {
    private int event_id;

    private String name;

    private String description;
    private String owner;
    private String password;
    private String url;
    private boolean active;

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public boolean isActive() {
        return active;
    }

    public Event setActive(boolean active) {
        this.active = active;
        return this;
    }

    public String getName() {
        return name;
    }

    public Event setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Event setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getOwner() {
        return owner;
    }

    public Event setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Event setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Event setUrl(String url) {
        this.url = url;
        return this;
    }
}
