package com.doris.controller;

import com.doris.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    //页面跳转
    @RequestMapping(value = "/quick", method = RequestMethod.GET, params = {"username"})
    public String save(){
        System.out.println("Controller save run");
        return "success";
    }

    @RequestMapping("/quick2")
    public ModelAndView save2(){
        /**
         * model 封装数据
         * view 展示数据
         */
        ModelAndView modelAndView = new ModelAndView();
        //设置模型数据
        modelAndView.addObject("username", "doris");
        //设置试图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/quick3")
    public ModelAndView save3(ModelAndView modelAndView){
        modelAndView.addObject("username", "doris2");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/quick4")
    public String save4(Model model){
        model.addAttribute("username", "model");
        return "success";
    }

    @RequestMapping("/quick5")
    public String save5(HttpServletRequest request){
        request.setAttribute("username", "httpservlet");
        return "success";
    }


    //页面回写
    @RequestMapping("/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello response");
    }

    @ResponseBody//告知SpringMvc框架，该方法不进行试图跳转，直接数据返回
    @RequestMapping("/quick7")
    public String save7(){
        return "@ResponseBody";
    }

    @ResponseBody
    @RequestMapping("/quick8")
    public String save8(){
        return "{\"username\":\"zhangsan\",\"age\":18}";
    }

    /**
     * 页面回写json
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @RequestMapping("/quick9")
    public String save9() throws JsonProcessingException {
        User user = new User();
        user.setUsername("lisi");
        user.setAge(20);
        //使用json转换工具，将对象转换成json
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;
    }

    /**
     * SpringMvc自动将对象或集合转换成json,spring-mvc.xml中进行配置转换器或者使用注解<mvc:annotation-driver/>
     * @return
     */
    @ResponseBody
    @RequestMapping("/quick10")
    public User save10(){
        User user = new User();
        user.setUsername("spring");
        user.setAge(20);
        return user;
    }
}
