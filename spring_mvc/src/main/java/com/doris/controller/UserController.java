package com.doris.controller;

import com.doris.domain.User;
import com.doris.domain.VO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    //-------------------------------response----------------------------
    //页面跳转
    @RequestMapping(value = "/quick", method = RequestMethod.GET, params = {"username"})
    public String save(){
        System.out.println("Controller save run");
        return "success";
    }

    /**
     * 自己创建 ModelAndView对象，写入model和view
     * @return
     */
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

    /**
     * 直接传参定义成ModelAndView，自动注入
     * @param modelAndView
     * @return
     */
    @RequestMapping("/quick3")
    public ModelAndView save3(ModelAndView modelAndView){
        modelAndView.addObject("username", "doris2");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    /**
     * 只用model，返回时返回一个view的string
     * @param model
     * @return
     */
    @RequestMapping("/quick4")
    public String save4(Model model){
        model.addAttribute("username", "model");
        return "success";
    }

    /**
     * 手动通过HttpServletRequest setAttribute
     * @param request
     * @return
     */
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

    //--------------------------------request--------------------------

    /**
     * 基本类型参数
     * 接受参数名称和请求中参数名称一致时，会自动获取
     * @param username
     * @param age
     */
    @ResponseBody
    @RequestMapping("/quick11")
    public void save11(String username, int age){
        System.out.println(username);
        System.out.println(age);
    }

    /**
     * 一般java bean自动封装  pojo类型
     * 传入参数名称对应了java bean的参数，可以进行set方法
     */
    @ResponseBody
    @RequestMapping("/quick12")
    public void save12(User user){
        System.out.println(user);
    }

    /**
     * 获取数组类型参数
     * 传入参数名称与数组名称一致，会自动映射匹配
     * http://localhost:8080/user/quick13?str=zjjj&str=22
     */
    @ResponseBody
    @RequestMapping("/quick13")
    public void save13(String[] str){
        System.out.println(Arrays.asList(str));
    }

    /**
     * 映射集合，将集合参数包装到一个pojo之中 即java bean
     */
    @ResponseBody
    @RequestMapping("/quick14")
    public void save14(VO vo){
        System.out.println(vo);
    }


    /**
     * 集合直接接受数据，不进行POJO包装
     * ajax提交时，传入json，指定application/json格式
     * 传参需要加入@RequestBody
     */
    @ResponseBody
    @RequestMapping("/quick15")
    public void save15(@RequestBody List<User> userList){
        System.out.println(userList);
    }

    /**
     * 参数访问注解@RequestParam
     * 参数名称与业务方法参数名称不一致时，来绑定
     * @param username url传参是name时 required=false 则name不是必须的，不报错,defaultValue不传参是走默认值
     * @param age
     */
    @ResponseBody
    @RequestMapping("/quick16")
    public void save16(@RequestParam(value = "name", required = false, defaultValue = "default") String username, int age){
        System.out.println(username);
        System.out.println(age);
    }

    /**
     * restful风格 占位的{name} 和 PathVariable中value要一直
     * @param username
     */
    @ResponseBody
    @RequestMapping("/quick17/{name}")
    public void save17(@PathVariable(value = "name") String username){
        System.out.println(username);
    }

    /**
     * 自定义类型转换器 springmvc中自带一些，如string转成int，但不够，如时间
     * 开发捕捉
     * 定义转换器实现Converter接口 controller/DateConverter
     * 配置文件中声明转换器，spring-mvc.xml <bean id="conversionService" class="org.springframework.context.support.ConversionServiceFactoryBean">
     *     <mvc:annotation-driven conversion-service="conversionService"/> 引用转换器
     */
    @ResponseBody
    @RequestMapping("/quick18")
    public void save18(Date date){
        System.out.println(date);
    }

    /**
     * 原始servletAPI进行参数注入
     */
    @ResponseBody
    @RequestMapping("/quick19")
    public void save19(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    /**
     * 获取请求头 @RequestHeader 赋给userAgent
     */
    @ResponseBody
    @RequestMapping("/quick20")
    public void save20(@RequestHeader("User-Agent") String userAgent){
        System.out.println(userAgent);
    }

    /**
     * 直接获取cookie @CookieValue
     */
    @ResponseBody
    @RequestMapping("/quick21")
    public void save21(@CookieValue("JSESSIONID") String cookie){
        System.out.println(cookie);
    }
}
