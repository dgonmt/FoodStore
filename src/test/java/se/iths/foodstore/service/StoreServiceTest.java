package se.iths.foodstore.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import se.iths.foodstore.model.CartProduct;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StoreServiceTest {

    @Mock
    private StoreService storeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        storeService = new StoreService();
    }

    @Test
    void decrItem_decreasesQuantityOfCartItem() {

        CartProduct cartProduct = new CartProduct(1L, "Product A", "10", "2");
        storeService.getCart().add(cartProduct);

        storeService.decrItem(0);

        assertEquals("1", storeService.getCart().get(0).getQuantity());
    }

    @Test
    void incrItem_increasesQuantityOfCartItem() {

        CartProduct cartProduct = new CartProduct(1L, "Product A", "10", "2");
        storeService.getCart().add(cartProduct);

        storeService.incrItem(0);

        assertEquals("3", storeService.getCart().get(0).getQuantity());
    }

}
