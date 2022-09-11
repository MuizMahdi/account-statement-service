package com.nagarro.statementservice.infrastructure.controllers;

import com.nagarro.statementservice.infrastructure.controllers.payload.LoginRequest;
import com.nagarro.statementservice.infrastructure.helpers.constants.Endpoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping(Endpoints.Authentication.Login)
    public ResponseEntity login(@RequestBody LoginRequest loginRequest, HttpServletRequest request) {
        Authentication currentAuthentication = SecurityContextHolder.getContext().getAuthentication();
        // TODO: Return proper response message if already authenticated
        boolean isAlreadyAuthenticated = currentAuthentication.isAuthenticated()
                && !(currentAuthentication instanceof AnonymousAuthenticationToken);
        if (!isAlreadyAuthenticated) {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
            if (authentication != null && authentication.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(authentication);
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(5*60);
                // TODO: Return proper response message
                return ResponseEntity.ok(session.getId());
            }
        }
        // TODO: Return proper response message
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping(Endpoints.Authentication.Logout)
    public ResponseEntity logout(HttpServletRequest request) {
        SecurityContextHolder.getContext().setAuthentication(null);
        request.getSession().invalidate();
        // TODO: Return proper response message
        return ResponseEntity.ok().build();
    }

}
