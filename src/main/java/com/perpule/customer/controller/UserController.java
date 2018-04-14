package com.perpule.customer.controller;

import com.perpule.customer.exception.ResourceNotFoundException;
import com.perpule.customer.model.User;
import com.perpule.customer.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.util.Date;

/**
 * Created by Gowtham on 14/04/18.
 */
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody User user) throws ServletException {


        if (user.getUserName() == null || user.getPassWord() == null) {
            throw new ResourceNotFoundException("Please fill in username and password");
        }

        String userName = user.getUserName();
        String password = user.getPassWord();

        User loginUser = userRepository.findById(userName)
                .orElse(null);

        if (loginUser == null) {
            throw new ResourceNotFoundException("Username is not Found");
        }

        String pwd = loginUser.getPassWord();

        if (!password.equals(pwd)) {
            throw new ResourceNotFoundException("Invalid login. Please check your name and password.");
        }

        return Jwts.builder().setSubject(userName).claim("roles", "user").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

    }
}
