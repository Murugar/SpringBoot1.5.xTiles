package com.iqmsoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iqmsoft.model.User;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class DashboardController {

    @RequestMapping(value = {"/dashboard", "/", ""}, method = RequestMethod.GET)
    public String dashboard(Model model) {
        model.addAttribute("users", getUsers());
        return "dashboard";
    }

    private List<User> getUsers() {
        User user1 = new User();
        user1.setEmail("test1@test1.com");
        user1.setName("Test1");
        user1.setAddress("Test1, Test1");
        User user2 = new User();
        user2.setEmail("test2@test2@com");
        user2.setName("Test2");
        user2.setAddress("Test2, Test2");
        User user3 = new User();
        user3.setEmail("test3@test3.com");
        user3.setName("Test3");
        user3.setAddress("Test3, Test3");
        User user4 = new User();
        user4.setEmail(new Date().getTime() + "@test4.com");
        user4.setName("Test4");
        user4.setAddress("Test4");
        List<User> users = Arrays.asList(user1, user2, user3, user4);
        return users;
    }


}
