package kuaishuoquna.service;

import kuaishuoquna.model.Address;
import kuaishuoquna.model.Event;
import kuaishuoquna.model.Time;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class VoteServiceTest {
    private VoteService voteService;
    private Time time;
    private Address address;

    @Before
    public void setUp() throws Exception {
        voteService = new VoteService();
        time = new Time()
                .setEvent_url("some-url")
                .setNote("2016-4-29 12:42");
        address = new Address()
                .setEvent_url("some-url")
                .setNote("No.40A DongYue Road");
    }

    @Test
    public void shouldGetTimeAfterCreate() throws Exception {
        voteService.createTime(time);
        assertEquals("2016-4-29 12:42", voteService.findTimeByEventUrl("some-url").get(0).getNote());
    }

    @Test
    public void shouldGetAddressAfterCreate() throws Exception {
        voteService.createAddress(address);
        assertEquals("No.40A DongYue Road", voteService.findAddressByEventUrl("some-url").get(0).getNote());
    }
}