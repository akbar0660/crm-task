package az.edu.turing.crmtask.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CustomerRequest {
    private String companyName;
    private String name;
    private String phoneNumber;
}
