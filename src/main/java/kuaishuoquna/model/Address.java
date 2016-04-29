package kuaishuoquna.model;

/**
 * Created by yzhou on 16-4-29.
 */
public class Address {
    private String event_url;
    private long address_id;
    private String note;
    private int count_number;
    private String id = "address" + address_id;

    public String getId() {
        return id;
    }

    public String getEvent_url() {
        return event_url;
    }

    public Address setEvent_url(String event_url) {
        this.event_url = event_url;
        return this;
    }

    public long getAddress_id() {
        return address_id;
    }

    public Address setAddress_id(long address_id) {
        this.address_id = address_id;
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
