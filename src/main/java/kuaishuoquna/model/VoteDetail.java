package kuaishuoquna.model;

import kuaishuoquna.service.VoteService;

/**
 * Created by yzhou on 16-5-3.
 */
public class VoteDetail {
    private long people_id;
    private String type;
    private long item_id;

    public long getPeople_id() {
        return people_id;
    }

    public VoteDetail setPeople_id(long people_id) {
        this.people_id = people_id;
        return this;
    }

    public String getType() {
        return type;
    }

    public VoteDetail setType(String type) {
        this.type = type;
        return this;
    }

    public long getItem_id() {
        return item_id;
    }

    public VoteDetail setItem_id(long item_id) {
        this.item_id = item_id;
        return this;
    }
}
