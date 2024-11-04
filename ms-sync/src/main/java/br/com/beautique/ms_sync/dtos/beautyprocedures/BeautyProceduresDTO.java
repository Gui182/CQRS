package br.com.beautique.ms_sync.dtos.beautyprocedures;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "beautyprocedures")
public class BeautyProceduresDTO {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
}
