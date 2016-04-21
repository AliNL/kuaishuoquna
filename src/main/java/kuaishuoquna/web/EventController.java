package kuaishuoquna.web;

import kuaishuoquna.model.Event;
import kuaishuoquna.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("/event")
public class EventController {

    @Autowired
    EventService eventService;

    @RequestMapping(value = {"/create"}, method = RequestMethod.GET)
    public String viewForm() {
        return "create";
    }

    @RequestMapping(value = {"/submit"}, method = RequestMethod.POST)
    public String Create(HttpServletRequest request) throws IOException {
        Event event = createEvent(request);
        return checkValidationErrors(event);
    }

    @RequestMapping(value = "/{url:.*}", method = RequestMethod.GET)
    public String get(@PathVariable String url) {
        Event event = eventService.findEventByUrl(url);

        if (event == null) {
            return "index";
        }
        new ModelMap().addAttribute("eventDetail", event);
        return "event";
    }

    private String checkValidationErrors(Event event) {

        try {
            if (existUrl(event.getUrl())) {
                return "createFailed";
            }
            eventService.createEvent(event);
            return get(event.getUrl());
        } catch (Exception e) {
            return "createFailed";
        }
    }

    private boolean existUrl(String url) {
        return eventService.findEventByUrl(url) != null;
    }


    private Event createEvent(HttpServletRequest request) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String owner = request.getParameter("owner");
        String description = request.getParameter("description");

        return new Event()
                .setName(name)
                .setPassword(password)
                .setOwner(owner)
                .setDescription(description)
                .setUrl(Integer.toString(new Date().hashCode()).substring(0, 8))
                .setActive(true);
    }

}