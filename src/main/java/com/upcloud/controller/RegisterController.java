package com.upcloud.controller;

import com.upcloud.mapper.UserMapper;
import com.upcloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class RegisterController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/register")
    public String register(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
//        userMapper.save(user);
        userMapper.save(user);
        return "register";
    }


    @RequestMapping("/login/{id}")
    public String login(Map<String, Object> map, Model model, @PathVariable(name = "id") String id) {

//        map.put("hello", "你好");
//        map.put("hi", "100");

        User users = userMapper.select(id);
        model.addAttribute("users", users);

        return "login";
    }


}
