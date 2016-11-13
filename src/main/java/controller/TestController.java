package controller;

import entity.Planner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.PlannerService;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by Marisha on 06/11/16.
 */


@Controller
@RequestMapping("/")
public class TestController {

    @Autowired
    private PlannerService service;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView sayHello(HttpServletRequest request) {
        String status = request.getParameter("status");
        Boolean st = null;
        if("done".equals(status)) {
            st = true;
        } else if ("undone".equals(status)) {
            st = false;
        }

        List<Planner> list = service.find(st);
        ModelAndView model = new ModelAndView("home");
        model.addObject("data", list);
        if(st != null) {
            model.addObject("statuses", updateStatuses(status));
        }

        return model;
    }

    @RequestMapping(value="save", method = RequestMethod.POST)
    public String save(HttpServletRequest request) {
        String taskName = request.getParameter("taskname");
        if(!StringUtils.isEmpty(taskName)) {
            Planner planner = new Planner();
            planner.setItem(taskName);
            planner.setStatus(false);
            service.createOrUpdate(planner);
        }
        return "redirect:/";
    }

    @RequestMapping(value="update", method = RequestMethod.GET)
    public String update(Long id) {
        service.updateStatus(id);
        return "redirect:/";
    }

    @RequestMapping(value="delete", method = RequestMethod.GET)
    public String delete(Long id) {
        service.delete(id);
        return "redirect:/";
    }


    @ModelAttribute("statuses")
    public Map<String, Boolean> statuses() {
        Map<String, Boolean> statuses = new TreeMap<>();
        statuses.put("all",true);
        statuses.put("done",false);
        statuses.put("undone",false);
        return statuses;
    }

    private Map<String, Boolean> updateStatuses(String key) {
        Map<String, Boolean> statuses = new TreeMap<>();
        statuses.put("all",false);
        statuses.put("done",false);
        statuses.put("undone",false);
        statuses.put(key, true);
        return statuses;
    }
}
