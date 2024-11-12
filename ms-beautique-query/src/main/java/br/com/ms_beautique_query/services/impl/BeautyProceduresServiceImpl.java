package br.com.ms_beautique_query.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ms_beautique_query.dtos.beautyprocedures.BeautyProcedureDTO;
import br.com.ms_beautique_query.repositories.BeautyProcedureRepository;
import br.com.ms_beautique_query.services.BeautyProcedureService;

@Service
public class BeautyProceduresServiceImpl implements BeautyProcedureService {

    private final BeautyProcedureRepository beautyProcedureRepository;

    public BeautyProceduresServiceImpl(BeautyProcedureRepository beautyProcedureRepository) {
        this.beautyProcedureRepository = beautyProcedureRepository;
    }

    @Override
    public List<BeautyProcedureDTO> listAllBeautyProcedures() {
        try {
            return beautyProcedureRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error listening all beauty procedures");
        }
    }

    @Override
    public List<BeautyProcedureDTO> listByNameIgnoreCase(String name) {
        try {
            return beautyProcedureRepository.findByNameIgnoreCase(name);
        } catch (Exception e) {
            throw new RuntimeException("Error listening all beauty procedures by name");
        }
    }

    @Override
    public List<BeautyProcedureDTO> listByDescriptionIgnoreCase(String description) {
        try {
            return beautyProcedureRepository.findByDescriptionLikeIgnoreCase(description);
        } catch (Exception e) {
            throw new RuntimeException("Error listening all beauty procedures by description");
        }
    }

}
