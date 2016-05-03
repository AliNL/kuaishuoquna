package kuaishuoquna.model;

/**
 * Created by yzhou on 16-5-2.
 */
public class People {
    private long people_id;
    private String name;
    private String event_url;

    public long getPeople_id() {
        return people_id;
    }

    public People setPeople_id(long people_id) {
        this.people_id = people_id;
        return this;
    }

    public String getName() {
        return name;
    }

    public People setName(String name) {
        this.name = name;
        return this;
    }

    public String getEvent_url() {
        return event_url;
    }

    public People setEvent_url(String event_url) {
        this.event_url = event_url;
        return this;
    }
}
