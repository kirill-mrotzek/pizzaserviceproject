package org.telran.pizzaservice.de.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.telran.pizzaservice.de.entity.Pizza;
import org.telran.pizzaservice.de.exception.PizzaNotFoundException;
import org.telran.pizzaservice.de.repository.PizzaJpaRepository;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class) //юнит-тест, тестируем только один метод
class PizzaServiceImplTest {

    @Mock
    private PizzaJpaRepository pizzaJpaRepository;

    @InjectMocks
    private PizzaServiceImpl pizzaService;

    @Test
    public void getPizzaByTitleWhenPizzaExists() {
        String pizzaTitle = "Hawaii";
        Pizza pizzaExpected = new Pizza();
        pizzaExpected.setTitle("Hawaii");

        when(pizzaJpaRepository.findByTitle(pizzaTitle))
                .thenReturn(List.of(pizzaExpected));

        Pizza pizzaActual = pizzaService.getPizzaByTitle(pizzaTitle);

        assertEquals(pizzaExpected.getTitle(), pizzaActual.getTitle());
    }

    @Test
    public void getPizzaByTitleWhenPizzaNotExists() {
        String pizzaTitle = "NonExistentPizza";

        when(pizzaJpaRepository.findByTitle(pizzaTitle))
                .thenThrow(new PizzaNotFoundException("Pizza not found"));

        assertThrows(PizzaNotFoundException.class,
                () -> pizzaService.getPizzaByTitle(pizzaTitle));
    }
}