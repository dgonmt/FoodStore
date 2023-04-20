package se.iths.foodstore.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.mock.mockito.MockBean;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StoreServiceTest {

    StoreService storeService;



    @BeforeAll
    public void initialize() {
        storeService = new StoreService();
    }

}
