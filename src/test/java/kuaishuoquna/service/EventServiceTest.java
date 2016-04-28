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
                .setName("some-name")
                .setPassword("password")
                .setOwner("some-Owner")
                .setUrl("some-url")
                .setDescription("some-Description")
                .setActive(true);
    }

    @Test
    public void shouldGetWhatYouCreate() throws Exception {
        eventService.createEvent(event);
        assertEquals("some-name", eventService.findEventByUrl("some-url").getName());
    }
}