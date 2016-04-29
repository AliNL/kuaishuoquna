package kuaishuoquna.web;

import kuaishuoquna.model.Address;
import kuaishuoquna.model.Event;
import kuaishuoquna.model.Time;
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

@Controller
@RequestMapping("/event")
public class VoteController {

    @Autowired
    VoteService voteService;

    @RequestMapping(method = RequestMethod.POST, params = "add=add-time")
    public String CreateTime(HttpServletRequest request, @ModelAttribute Event event) throws IOException {
        Time time = createTime(request, event);
        voteService.createTime(time);
        return "redirect:/event/" + event.getUrl();
    }

    @RequestMapping(method = RequestMethod.POST, params = "add=add-address")
    public String CreateAddress(HttpServletRequest request, @ModelAttribute Event event) throws IOException {
        Address address = createAddress(request, event);
        voteService.createAddress(address);
        return "redirect:/event/" + event.getUrl();
    }

    private Address createAddress(HttpServletRequest request, Event event) {
        String note = request.getParameter("address");

        return new Address()
                .setEvent_id(event.getEvent_id())
                .setNote(note);
    }


    private Time createTime(HttpServletRequest request, Event event) {
        String note = request.getParameter("time");

        return new Time()
                .setEvent_id(event.getEvent_id())
                .setNote(note);
    }
}
