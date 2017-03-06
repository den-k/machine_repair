package edu.machine.repair.controller;


import edu.machine.repair.db.dao.OrderDao;
import edu.machine.repair.dto.RegistrationCredentials;
import edu.machine.repair.db.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OperationsController {

    @Autowired
    private UserDao userDao;

    @Transactional
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registration(@ModelAttribute("registrationForm") RegistrationCredentials credentials) {
        System.out.println(credentials.getLogin());
        System.out.println(userDao.list());
        return "redirect:registration";
    }
}

