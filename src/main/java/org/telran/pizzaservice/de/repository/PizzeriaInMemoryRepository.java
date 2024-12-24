package org.telran.pizzaservice.de.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.telran.pizzaservice.de.entity.Pizzeria;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PizzeriaInMemoryRepository implements PizzeriaRepository {

    private Map<String, Pizzeria> pizzeriaMap = new HashMap<String, Pizzeria>();

    public PizzeriaInMemoryRepository() {
        init();
    }

    private void init() {
        Pizzeria pizzeria1 = new Pizzeria("city1", "street1", 9.00-15.00);
        Pizzeria pizzeria2 = new Pizzeria("city2", "street2", 9.00-15.00);
        Pizzeria pizzeria3 = new Pizzeria("city3", "street3", 9.00-15.00);
        pizzeriaMap.put("city1", pizzeria1);
        pizzeriaMap.put("city2", pizzeria2);
        pizzeriaMap.put("city3", pizzeria3);
    }

    @Override
    public List<Pizzeria> getAll() {
        return pizzeriaMap.values().stream().toList();
    }
}
