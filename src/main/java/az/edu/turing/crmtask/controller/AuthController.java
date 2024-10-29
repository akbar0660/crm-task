package az.edu.turing.crmtask.controller;

import az.edu.turing.crmtask.dto.request.LoginRequest;
import az.edu.turing.crmtask.dto.request.RegisterRequest;
import az.edu.turing.crmtask.dto.response.LoginResponse;
import az.edu.turing.crmtask.dto.response.RegisterResponse;
import az.edu.turing.crmtask.service.AuthService;
import az.edu.turing.crmtask.service.AuthServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthServiceInter authService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> registerUser(@RequestBody RegisterRequest registerRequest) {
        return authService.register(registerRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }
}
