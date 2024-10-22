package br.com.beautique.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.beautique.dtos.BeautyProcedureDTO;
import br.com.beautique.entities.BeautyProceduresEntity;
import br.com.beautique.repositories.BeautyProcedureRepository;
import br.com.beautique.services.BeautyProcedureService;
import br.com.beautique.utils.ConverterUtil;

@Service
public class BeautyProcedureServiceImpl implements BeautyProcedureService {

    @Autowired
    private BeautyProcedureRepository beautyProcedureRepository;

    private final ConverterUtil<BeautyProceduresEntity, BeautyProcedureDTO> converterUtil = new ConverterUtil<>(
            BeautyProceduresEntity.class, BeautyProcedureDTO.class);

    @Override
    public BeautyProcedureDTO create(BeautyProcedureDTO beautyProcedureDTO) {
        BeautyProceduresEntity beautyProceduresEntity = converterUtil.convertToSource(beautyProcedureDTO);
        BeautyProceduresEntity newBeautyProceduresEntity = beautyProcedureRepository.save(beautyProceduresEntity);
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

        return converterUtil.convertToTarget(beautyProcedureRepository.save(beautyProceduresEntity));
    }

}
