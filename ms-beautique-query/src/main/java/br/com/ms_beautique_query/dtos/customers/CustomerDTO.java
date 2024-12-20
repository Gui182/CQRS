package br.com.ms_beautique_query.dtos.customers;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "customers")
public class CustomerDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
}
