package by.pshsnk.shop.controllers;

import by.pshsnk.shop.payload.request.LoginRequest;
import by.pshsnk.shop.payload.request.SignupRequest;
import by.pshsnk.shop.security.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/shop/auth")
public class AuthController {

  @Autowired
  AuthService authService;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
    return authService.authenticateUser(loginRequest);
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    return authService.createUser(signUpRequest);
  }
}
