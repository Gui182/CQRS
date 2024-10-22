package br.com.beautique.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.beautique.dtos.CustomerDTO;
import br.com.beautique.entities.CustomerEntity;
import br.com.beautique.repositories.CustomerRepository;
import br.com.beautique.services.CustomerService;
import br.com.beautique.utils.ConverterUtil;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    private final ConverterUtil<CustomerEntity, CustomerDTO> converterUtil = new ConverterUtil<>(CustomerEntity.class,
            CustomerDTO.class);

    @Override
    public CustomerDTO create(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = converterUtil.convertToSource(customerDTO);
        CustomerEntity newCustomerEntity = customerRepository.save(customerEntity);
        return converterUtil.convertToTarget(newCustomerEntity);
    }

    @Override
    public void delete(Long id) {
        Optional<CustomerEntity> customerEntityOptional = customerRepository.findById(id);
        if (customerEntityOptional.isEmpty()) {
            throw new RuntimeException("Customer Not Found");
        }
        customerRepository.delete(customerEntityOptional.get());
    }

    @Override
    public CustomerDTO update(CustomerDTO customerDTO) {
        Optional<CustomerEntity> customerEntityOptional = customerRepository.findById(customerDTO.getId());
        if (customerEntityOptional.isEmpty()) {
            throw new RuntimeException("Customer Not Found");
        }   
        CustomerEntity customerEntity = converterUtil.convertToSource(customerDTO);

        customerEntity.setAppointments(customerEntityOptional.get().getAppointments());
        customerEntity.setCreatedAt(customerEntityOptional.get().getCreatedAt());

        return converterUtil.convertToTarget(customerRepository.save(customerEntity));
    }
}
