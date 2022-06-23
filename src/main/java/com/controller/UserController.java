package com.controller;

import com.dao.UserDao;
import com.dto.UserDTO;
import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao;

    @GetMapping("/create")
    public String create(Model model){
        UserDTO userDTO = new UserDTO();
        model.addAttribute(userDTO);
//        List<Role> roleList = Arrays.asList(Role.values()); // role db te save hoy na
//        List<String> roleList = Stream.of(Role.values()).map(Enum::name).collect(Collectors.toList());
        List<String> roleList = new ArrayList<>(List.of("ADMIN","STUDENT","TEACHER"));
        model.addAttribute("roleList",roleList);
        return "/user/create";
    }

    @PostMapping("/store")
    public String store(Model model,@ModelAttribute("userDTO") UserDTO userDTO){
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

//        user.setRole(Role.valueOf(userDTO.getRole()));

        user.setRole(userDTO.getRole());
        userDao.store(user);
        model.addAttribute("user",user);
        return "/user/show";
    }
}
