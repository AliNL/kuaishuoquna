package kuaishuoquna.service;

import kuaishuoquna.model.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class VoteServiceTest {
    private static VoteService voteService;

    @BeforeClass
    public static void setUp() throws Exception {
        Time time;
        Address address;
        People people;

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
        List<VoteDetail> voteDetails = new ArrayList<VoteDetail>();
        voteDetails.add(new VoteDetail().setPeople_id(1).setType("time").setItem_id(1));
        voteDetails.add(new VoteDetail().setPeople_id(1).setType("address").setItem_id(1));

        voteService.createTime(time);
        voteService.createAddress(address);
        voteService.createPeople(people);
        voteService.createVoteDetails(voteDetails);
    }

    @Test
    public void shouldGetTimeAfterCreate() throws Exception {
        assertEquals("2016-4-29 12:42", voteService.findTimeByEventUrl("some-url").get(0).getNote());
    }

    @Test
    public void shouldGetAddressAfterCreate() throws Exception {
        assertEquals("No.40A DongYue Road", voteService.findAddressByEventUrl("some-url").get(0).getNote());
    }

    @Test
    public void shouldGetPeopleAfterCreate() throws Exception {
        assertEquals("People name", voteService.findPeopleByEventUrl("some-url").get(0).getName());
    }

    @Test
    public void shouldGetVoteDetailAfterCreate() throws Exception {
        assertEquals(1, voteService.findTimeByEventUrl("some-url").get(0).getCount_number());
        assertEquals(1, voteService.findAddressByEventUrl("some-url").get(0).getCount_number());
    }

    @Test
    public void shouldGetPeopleList() throws Exception {
        assertEquals("People name",voteService.findPeopleByAddressId(1).get(0).getName());
    }
}