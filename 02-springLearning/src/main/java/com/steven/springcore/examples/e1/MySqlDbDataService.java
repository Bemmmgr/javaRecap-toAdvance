package com.steven.springcore.examples.e1;

import org.springframework.stereotype.Repository;

// @Component
@Repository
public class MySqlDbDataService implements DataService {
    @Override
    public int[] retrieveData() {
        return new int[]{1, 2, 3, 4, 5};
    }
}
