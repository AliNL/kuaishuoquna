package kuaishuoquna.web;

import kuaishuoquna.model.Address;
import kuaishuoquna.model.Event;
import kuaishuoquna.model.Time;
import kuaishuoquna.service.EventService;
import kuaishuoquna.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {

    @Autowired
    EventService eventService;

    @Autowired
    VoteService voteService;

    @RequestMapping(value = {"/create"}, method = RequestMethod.GET)
    public String viewForm() {
        return "create";
    }

    @RequestMapping(value = {"/submit"}, method = RequestMethod.POST)
    public ModelAndView Create(HttpServletRequest request, Model model) throws IOException {
        Event event = createEvent(request);
        return checkValidationErrors(event, model);
    }

    @RequestMapping(value = "/{url:.*}", method = RequestMethod.GET)
    public ModelAndView get(@PathVariable String url, Model model) {
        Event event = eventService.findEventByUrl(url);
        if (event == null) {
            return new ModelAndView("index");
        }

        List<Time> times = voteService.findTimeByEventId(event.getEvent_id());
        List<Address> addresses = voteService.findAddressByEventId(event.getEvent_id());
        model.addAttribute("eventDetail", event);
        model.addAttribute("times",times);
        model.addAttribute("addresses",addresses);
        return new ModelAndView("event");
    }

    private ModelAndView checkValidationErrors(Event event, Model model) {

        try {
            if (existUrl(event.getUrl())) {
                return new ModelAndView("createFailed");
            }
            eventService.createEvent(event);
            model.addAttribute("eventDetail", event);
            return new ModelAndView("redirect:/event/" + event.getUrl(), null);
        } catch (Exception e) {
            return new ModelAndView("createFailed");
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