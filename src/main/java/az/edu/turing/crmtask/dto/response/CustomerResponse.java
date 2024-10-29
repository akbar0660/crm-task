package az.edu.turing.crmtask.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomerResponse {
    private String companyName;
    private String name;
    private String phoneNumber;
}
