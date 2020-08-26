package com.ebay.ironbank.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Evgeny Borisov
 */
@Service
@Profile("WINTERE_IS_COMING")
public class PredictionServiceImpl implements PredictionService {
    @Override
    public boolean willSurvive(String name) {
        return !name.toLowerCase().contains("stark");

    }
}
