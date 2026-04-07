package com.oddsapiio.backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = "oddsapi.api-key=test-key")
class OddsApiIoBackendApplicationTests {

    @Test
    void contextLoads() {
    }
}
