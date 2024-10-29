package az.edu.turing.crmtask.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class RegisterResponse {
    private String username;
    private String email;
    private String message;

    public RegisterResponse(String username, String email, String message) {
        this.username = username;
        this.email = email;
        this.message = message;
    }
    public RegisterResponse(String message) {
        this.message = message;
    }
}
