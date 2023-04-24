package se.iths.foodstore.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import se.iths.foodstore.entity.Orders;
import se.iths.foodstore.repo.OrdersRepo;

public class OrderServiceTest {

    @Mock
    private OrdersRepo ordersRepo;

    @InjectMocks
    private OrderService ordersService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindUnhandledOrder_WithHandledTrue_ReturnsEmptyList() {

        boolean isHandled = true;

        when(ordersRepo.findByHandled(isHandled)).thenReturn(new ArrayList<>());


    }

    @Test
    public void testIfFindByHandledCallsExpectedAmountOfTimes() {

        boolean isHandled = true;

        when(ordersRepo.findByHandled(isHandled)).thenReturn(new ArrayList<>());

    }


}