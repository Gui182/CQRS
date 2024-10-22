package br.com.beautique.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeautyProcedureDTO {

    private long id;
    private String name;
    private String description;
    private BigDecimal price;
}