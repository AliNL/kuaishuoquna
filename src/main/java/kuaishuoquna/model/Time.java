package kuaishuoquna.model;

public class Time {
    private long time_id;
    private String event_url;
    private String note;
    private int count_number;
    private String id = "time" + time_id;

    public String getId() {
        return id;
    }

    public String getEvent_url() {
        return event_url;
    }

    public Time setEvent_url(String event_url) {
        this.event_url = event_url;
        return this;
    }

    public long getTime_id() {
        return time_id;
    }

    public Time setTime_id(long time_id) {
        this.time_id = time_id;
        return this;
    }

    public String getNote() {
        return note;
    }

    public Time setNote(String note) {
        this.note = note;
        return this;
    }

    public int getCount_number() {
        return count_number;
    }

    public Time setCount_number(int count_number) {
        this.count_number = count_number;
        return this;
    }
}
