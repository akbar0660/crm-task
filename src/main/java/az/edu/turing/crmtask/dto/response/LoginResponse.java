package az.edu.turing.crmtask.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class LoginResponse {
    private String username;
    private String email;
    private String token;
    private String message;
}

