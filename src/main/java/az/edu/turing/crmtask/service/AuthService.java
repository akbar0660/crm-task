package az.edu.turing.crmtask.service;

import az.edu.turing.crmtask.dao.domain.User;
import az.edu.turing.crmtask.dao.repository.UserRepository;
import az.edu.turing.crmtask.dto.enums.UserRole;
import az.edu.turing.crmtask.dto.request.LoginRequest;
import az.edu.turing.crmtask.dto.request.RegisterRequest;
import az.edu.turing.crmtask.dto.response.LoginResponse;
import az.edu.turing.crmtask.dto.response.RegisterResponse;
import az.edu.turing.crmtask.securityconfig.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements AuthServiceInter {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;


    public ResponseEntity<RegisterResponse> register(RegisterRequest registerRequest) {
        if (userRepository.existsByUsername(registerRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new RegisterResponse("Username is already taken!"));
        }

        User user = new User(registerRequest.getUsername(), registerRequest.getEmail(), UserRole.USER);
        User savedUser = userRepository.save(user);
        new RegisterResponse();
        return ResponseEntity.ok(RegisterResponse.builder().username(savedUser.getUsername()).message("Registered successfully").email(savedUser.getEmail()).build());
    }

    public ResponseEntity<LoginResponse> login(LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername()).orElseThrow(() -> new RuntimeException("Username or password is incorrect!"));

        String token = jwtTokenProvider.createAccessToken(loginRequest.getUsername());


        LoginResponse loginResponse = LoginResponse.builder()
                .message("Login successful")
                .username(loginRequest.getUsername())
                .token(token)
                .email(user.getEmail())
                .build();

        return ResponseEntity.ok(loginResponse);
    }
}
