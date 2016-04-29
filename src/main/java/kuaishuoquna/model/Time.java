package kuaishuoquna.model;

/**
 * Created by yzhou on 16-4-29.
 */
public class Time {
    private long event_id;
    private long time_id;
    private String note;
    private int count_number;
    private String id="time"+time_id;

    public String getId() {
        return id;
    }

    public long getEvent_id() {
        return event_id;
    }

    public Time setEvent_id(long event_id) {
        this.event_id = event_id;
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
