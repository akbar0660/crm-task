package az.edu.turing.crmtask.mapper;

import az.edu.turing.crmtask.dao.domain.Customer;
import az.edu.turing.crmtask.dto.request.CustomerRequest;
import az.edu.turing.crmtask.dto.response.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);

    Customer requestToEntity(CustomerRequest customerRequest);

    Customer responseToEntity(CustomerResponse customerResponse);

    CustomerResponse entityToResponse(Customer customer);

    CustomerRequest entityToRequest(Customer customer);
}
