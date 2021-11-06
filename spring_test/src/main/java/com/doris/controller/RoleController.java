package com.doris.controller;

import com.doris.domain.Role;
import com.doris.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 角色列表
     * @param modelAndView
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public ModelAndView roleList(ModelAndView modelAndView){
        List<Role> roleList = roleService.findAll();
        System.out.println(roleList);
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    /**
     * 添加角色
     * @param role
     * @return
     */
    @RequestMapping("/add")
    public String roleAdd(Role role){
        roleService.add(role);
        return "redirect:/role/list";
    }

}
