package az.edu.turing.crmtask.service;

import az.edu.turing.crmtask.dao.domain.User;
import az.edu.turing.crmtask.dto.request.LoginRequest;
import az.edu.turing.crmtask.dto.request.RegisterRequest;
import az.edu.turing.crmtask.dto.response.LoginResponse;
import az.edu.turing.crmtask.dto.response.RegisterResponse;
import org.springframework.http.ResponseEntity;

public interface AuthServiceInter {
    ResponseEntity<RegisterResponse> register(RegisterRequest registerRequest);

    ResponseEntity<LoginResponse> login(LoginRequest loginRequest);
}
