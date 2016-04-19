package kuaishuoquna.web;

import kuaishuoquna.service.EventService;
import kuaishuoquna.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/event")
public class EventController {

    EventService eventService;

    public EventController() {
        eventService = new EventService();
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.GET)
    public ModelAndView createAccountForm(ModelMap model) {
        return new ModelAndView("create", "validationMessage", model);
    }
//
//    @RequestMapping(value = {"/create"}, method = RequestMethod.POST)
//    public ModelAndView processCreate(HttpServletRequest request) throws IOException {
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//        String name = request.getParameter("name");
//        String phoneNumber = request.getParameter("phoneNumber");
//
//        Account account = new Account()
//                .setEmail_address(email)
//                .setPassword(password)
//                .setAccount_name(name)
//                .setPhoneNumber(phoneNumber)
//                .setEnabled(true);
//
//        HashMap errors = verifyInputs(account);
//        if(!errors.isEmpty()) {
//            return showErrors(errors);
//        }
//
//        try {
//            return showSuccess(accountService.createAccount(account));
//        } catch (Exception e) {
//            return showError();
//        }
//    }
//
//
//
//
//    private ModelAndView showErrors(Map errors) {
//        ModelMap model = new ModelMap();
//        model.put("errors", errors);
//        return new ModelAndView("account/create", "validationMessage", model);
//    }
//
//    private ModelAndView showError() {
//        return new ModelAndView("account/createFailure");
//    }
//
//    private ModelAndView showSuccess(Account account) {
//        ModelMap model = new ModelMap();
//        model.put("name", account.getAccount_name());
//        return new ModelAndView("account/createSuccess", "postedValues", model);
//    }

}