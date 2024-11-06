package br.com.beautique.ms_sync.services.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.beautique.ms_sync.dtos.beautyprocedures.BeautyProceduresDTO;
import br.com.beautique.ms_sync.repositories.BeautyProcedureRepository;
import br.com.beautique.ms_sync.services.BeautyProcedureService;
import br.com.beautique.ms_sync.utils.SyncLogger;

@Service
public class BeautyProcedureServiceImpl implements BeautyProcedureService {

    @Autowired
    private BeautyProcedureRepository beautyProcedureRepository;

    @Override
    public void saveBeautyProcedure(BeautyProceduresDTO beautyProceduresDTO) {
        try {
            SyncLogger.info("Saving beauty procedure:  " + beautyProceduresDTO.getId());
            beautyProcedureRepository.save(beautyProceduresDTO);
        } catch (Exception e) {
            SyncLogger.error("Error saving beauty procedure: " + beautyProceduresDTO.getId());
            SyncLogger.trace(Arrays.toString(e.getStackTrace()));
        }
    }

}
