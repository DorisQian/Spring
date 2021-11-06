package com.doris.controller;

import com.doris.domain.Role;
import com.doris.domain.User;
import com.doris.service.RoleService;
import com.doris.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @ResponseBody
    @RequestMapping("/list")
    public ModelAndView findAll(ModelAndView modelAndView){
        List<User> all = userService.findAll();
        modelAndView.addObject("userList", all);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/addUI")
    public ModelAndView findRoles(ModelAndView modelAndView){
        List<Role> roles = roleService.findAll();
        modelAndView.addObject("roles", roles);
        modelAndView.setViewName("user-add");
        return modelAndView;
    }

    @RequestMapping("/add")
    public String userAdd(User user, Long[] roleIds){
        userService.add(user, roleIds);
        return "redirect:/user/list";
    }

    @RequestMapping("/delete")
    public String userDelete(Long userId){
        userService.delete(userId);
        return "redirect:/user/list";
    }

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){
        User user = userService.login(username, password);
        if (user != null){
            session.setAttribute("user", user);
            return "main";
        }
        return "redirect:/login.jsp";
    }
}
