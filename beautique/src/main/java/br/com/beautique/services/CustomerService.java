package br.com.beautique.services;

import br.com.beautique.dtos.CustomerDTO;

public interface CustomerService {
    CustomerDTO create(CustomerDTO customerDTO);
    void delete(Long id);
    CustomerDTO update(CustomerDTO customerDTO);
}
