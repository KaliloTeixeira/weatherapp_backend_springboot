package com.itware.weatherapp_backend.Controllers;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.web.bind.annotation.*;

import com.itware.weatherapp_backend.Entities.AuthRequest;
import com.itware.weatherapp_backend.Entities.UserInfo;
import com.itware.weatherapp_backend.Services.JwtService;
import com.itware.weatherapp_backend.Services.UserInfoService;


@RestController
@RequestMapping("/auth")
public class UserController {
  private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

  @Autowired
  private UserInfoService service;

  @Autowired
  private JwtService jwtService;

  @Autowired
  private AuthenticationManager authenticationManager;

  @PostMapping("/addNewUser")
  public String addNewUser(@RequestBody UserInfo userInfo) {
    LOGGER.info("addNewUser method called");
    return service.addUser(userInfo);
  }

  @GetMapping("/user/userProfile")
  @PreAuthorize("hasAuthority('ROLE_USER')")
  public String userProfile() {
    LOGGER.info("userProfile method called");
    return "Welcome to User Profile";
  }

  @GetMapping("/admin/adminProfile")
  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
  public String adminProfile() {
    LOGGER.info("adminProfile method called");
    return "Welcome to Admin Profile";
  }

  @PostMapping("/generateToken")
  public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
    LOGGER.info("authenticateAndGetToken method called");
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
    if (authentication.isAuthenticated()) {
      return jwtService.generateToken(authRequest.getUsername());
    } else {
      throw new UsernameNotFoundException("invalid user request!");
    }
  }
}
