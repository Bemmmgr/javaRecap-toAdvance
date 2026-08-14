package com.steven.springcore.examples.e1;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessCalService {
    private DataService dataService;

    public BusinessCalService(DataService dataService) {
        super();
        this.dataService = dataService;
    }

    public int findMax() {
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}
