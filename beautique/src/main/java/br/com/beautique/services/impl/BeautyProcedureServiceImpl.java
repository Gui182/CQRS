package br.com.beautique.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.beautique.dtos.BeautyProcedureDTO;
import br.com.beautique.entities.BeautyProceduresEntity;
import br.com.beautique.repositories.BeautyProcedureRepository;
import br.com.beautique.services.BeautyProcedureService;
import br.com.beautique.services.BrokerService;
import br.com.beautique.utils.ConverterUtil;

@Service
public class BeautyProcedureServiceImpl implements BeautyProcedureService {

    @Autowired
    private BeautyProcedureRepository beautyProcedureRepository;

    @Autowired
    private BrokerService brokerService;

    private final ConverterUtil<BeautyProceduresEntity, BeautyProcedureDTO> converterUtil = new ConverterUtil<>(
            BeautyProceduresEntity.class, BeautyProcedureDTO.class);

    @Override
    public BeautyProcedureDTO create(BeautyProcedureDTO beautyProcedureDTO) {
        BeautyProceduresEntity beautyProceduresEntity = converterUtil.convertToSource(beautyProcedureDTO);
        BeautyProceduresEntity newBeautyProceduresEntity = beautyProcedureRepository.save(beautyProceduresEntity);
        sendBeautyProcedureToQueue(newBeautyProceduresEntity);
        return converterUtil.convertToTarget(newBeautyProceduresEntity);
    }

    @Override
    public void delete(Long id) {
        Optional<BeautyProceduresEntity> beautyProcedureOptional = beautyProcedureRepository.findById(id);
        if (beautyProcedureOptional.isEmpty()) {
            throw new RuntimeException("Beauty Procedure not found");
        }

        beautyProcedureRepository.deleteById(id);
    }

    @Override
    public BeautyProcedureDTO update(BeautyProcedureDTO beautyProcedureDTO) {
        Optional<BeautyProceduresEntity> beautyProcedureOptional = beautyProcedureRepository
                .findById(beautyProcedureDTO.getId());
        if (beautyProcedureOptional.isEmpty()) {
            throw new RuntimeException("Beauty Procedure Not Found");
        }
        BeautyProceduresEntity beautyProceduresEntity = converterUtil.convertToSource(beautyProcedureDTO);
        beautyProceduresEntity.setAppointments(beautyProcedureOptional.get().getAppointments());
        beautyProceduresEntity.setCreatedAt(beautyProcedureOptional.get().getCreatedAt());

        BeautyProceduresEntity updaBeautyProceduresEntity = beautyProcedureRepository.save(beautyProceduresEntity);

        sendBeautyProcedureToQueue(updaBeautyProceduresEntity);

        return converterUtil.convertToTarget(updaBeautyProceduresEntity);
    }

    private void sendBeautyProcedureToQueue(BeautyProceduresEntity beautyProceduresEntity) {
        BeautyProcedureDTO beautyProcedureDTO = BeautyProcedureDTO.builder()
                .id(beautyProceduresEntity.getId())
                .name(beautyProceduresEntity.getName())
                .description(beautyProceduresEntity.getDescription())
                .price(beautyProceduresEntity.getPrice())
                .build();
        brokerService.send("beautyProcedures", beautyProcedureDTO);                
    }

}
