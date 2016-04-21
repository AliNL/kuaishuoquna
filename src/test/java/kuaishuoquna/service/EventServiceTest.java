package kuaishuoquna.service;

import kuaishuoquna.model.Event;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yzhou on 4/21/16.
 */
public class EventServiceTest {
    private EventService eventService;
    private Event event;

    @Before
    public void setUp() throws Exception {
        eventService = new EventService();
        event = new Event()
                .setName("Name")
                .setPassword("password")
                .setOwner("Owner")
                .setUrl("some-url")
                .setDescription("description")
                .setActive(true);
    }

    @Test
    public void shouldGetWhatYouCreate() throws Exception {
        eventService.createEvent(event);
        assertEquals("Name", eventService.findEventByUrl("some-url").getName());
    }
}