package kuaishuoquna.web;

import kuaishuoquna.model.*;
import kuaishuoquna.service.EventService;
import kuaishuoquna.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
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

    @RequestMapping(value = "/{url:[0-9]*}", method = RequestMethod.GET)
    public ModelAndView get(@PathVariable String url, Model model) {
        Event event = eventService.findEventByUrl(url);
        if (event == null) {
            return new ModelAndView("redirect:/");
        }
        List<Time> times = voteService.findTimeByEventUrl(url);
        List<Address> addresses = voteService.findAddressByEventUrl(url);
        model.addAttribute("eventDetail", event);
        model.addAttribute("times", times);
        model.addAttribute("addresses", addresses);
        return new ModelAndView("event");
    }

    @RequestMapping(value = "/add-time", method = RequestMethod.POST)
    public ModelAndView CreateTime(HttpServletRequest request) throws IOException {
        Time time = createTime(request);
        voteService.createTime(time);
        return new ModelAndView("redirect:/event/" + time.getEvent_url(), null);
    }

    @RequestMapping(value = "/add-address", method = RequestMethod.POST)
    public ModelAndView CreateAddress(HttpServletRequest request) throws IOException {
        Address address = createAddress(request);
        voteService.createAddress(address);
        return new ModelAndView("redirect:/event/" + address.getEvent_url(), null);
    }

    @RequestMapping(value = "/add-people", method = RequestMethod.POST)
    public ModelAndView CreatePeople(HttpServletRequest request) throws IOException {
        People people = createPeople(request);
        long people_id = voteService.createPeople(people);
        List<VoteDetail> voteDetails = createVoteDetail(request,people_id);
        voteService.createVoteDetails(voteDetails);
        return new ModelAndView("redirect:/event/" + people.getEvent_url(), null);
    }

    @RequestMapping(value = "/end", method = RequestMethod.POST)
    public ModelAndView EndEvent(HttpServletRequest request) throws IOException {
        String event_url = request.getParameter("url");
        voteService.EndEventByUrl(event_url);
        return new ModelAndView("redirect:/event/" + event_url, null);
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

    private Address createAddress(HttpServletRequest request) {
        String note = request.getParameter("address");
        String url = request.getParameter("url");

        return new Address()
                .setEvent_url(url)
                .setNote(note);
    }

    private Time createTime(HttpServletRequest request) {
        String note = request.getParameter("time");
        String url = request.getParameter("url");

        return new Time()
                .setEvent_url(url)
                .setNote(note);
    }

    private People createPeople(HttpServletRequest request) {
        String name = request.getParameter("people-name");
        String url = request.getParameter("url");

        return new People()
                .setName(name)
                .setEvent_url(url);
    }

    private List<VoteDetail> createVoteDetail(HttpServletRequest request, long people_id) {
        String[] times = request.getParameterValues("time-id");
        String[] addresses = request.getParameterValues("address-id");
        List<VoteDetail> list = new ArrayList<VoteDetail>();

        for (String time : times)
            list.add(new VoteDetail().setPeople_id(people_id).setType("time").setItem_id(Integer.parseInt(time)));

        for (String address : addresses)
            list.add(new VoteDetail().setPeople_id(people_id).setType("address").setItem_id(Integer.parseInt(address)));

        return list;
    }

}