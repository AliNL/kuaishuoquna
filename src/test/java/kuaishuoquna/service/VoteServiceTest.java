package kuaishuoquna.service;

import kuaishuoquna.model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.ParallelComputer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class VoteServiceTest {
    private VoteService voteService;
    private Time time;
    private Address address;
    private People people;

    @Before
    public void setUp() throws Exception {
        voteService = new VoteService();
        time = new Time()
                .setEvent_url("some-url")
                .setNote("2016-4-29 12:42");
        address = new Address()
                .setEvent_url("some-url")
                .setNote("No.40A DongYue Road");

        people = new People()
                .setEvent_url("some-url")
                .setName("People name");
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

    @Test
    public void shouldGetPeopleAfterCreate() throws Exception {
        voteService.createPeople(people);
        assertEquals("People name", voteService.findPeopleByEventUrl("some-url").get(0).getName());
    }

    @Test
    public void shouldGetVoteDetailAfterCreate() throws Exception {
        List<VoteDetail> voteDetails = new ArrayList<VoteDetail>();
        voteDetails.add(new VoteDetail().setPeople_id(1).setType("time").setItem_id(1));
        voteDetails.add(new VoteDetail().setPeople_id(1).setType("address").setItem_id(1));
        voteService.createVoteDetails(voteDetails);
        assertEquals(1, voteService.findTimeByEventUrl("some-url").get(0).getCount_number());
        assertEquals(1, voteService.findAddressByEventUrl("some-url").get(0).getCount_number());
    }
}