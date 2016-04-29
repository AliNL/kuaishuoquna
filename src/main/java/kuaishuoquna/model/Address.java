package kuaishuoquna.model;

/**
 * Created by yzhou on 16-4-29.
 */
public class Address {
    private long event_id;
    private long address_id;
    private String note;
    private int count_number;
    private String id="address"+address_id;

    public String getId() {
        return id;
    }

    public long getEvent_id() {
        return event_id;
    }

    public Address setEvent_id(long event_id) {
        this.event_id = event_id;
        return this;
    }
    public long getAddress_id() {
        return address_id;
    }

    public Address setAddress_id(long time_id) {
        this.address_id = time_id;
        return this;
    }

    public String getNote() {
        return note;
    }

    public Address setNote(String note) {
        this.note = note;
        return this;
    }

    public int getCount_number() {
        return count_number;
    }

    public Address setCount_number(int count_number) {
        this.count_number = count_number;
        return this;
    }
}
