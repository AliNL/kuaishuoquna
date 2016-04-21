package kuaishuoquna.model;

/**
 * Created by yzhou on 4/21/16.
 */
public class Event {
    private int event_id;

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    private String name;
    private String description;
    private String owner;
    private String password;
    private String url;
    private boolean active;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (active != event.active) return false;
        if (name != null ? !name.equals(event.name) : event.name != null) return false;
        if (description != null ? !description.equals(event.description) : event.description != null) return false;
        if (owner != null ? !owner.equals(event.owner) : event.owner != null) return false;
        if (password != null ? !password.equals(event.password) : event.password != null) return false;
        return url != null ? url.equals(event.url) : event.url == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (active ? 1 : 0);
        return result;
    }
}
