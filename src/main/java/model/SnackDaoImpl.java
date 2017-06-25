/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author 7ravis
 */
public class SnackDaoImpl implements SnackDao {
    HashMap<Integer,Snack> snacks;
    
    public SnackDaoImpl() {
        snacks = new HashMap<>();
        snacks.put(1, new Snack(1,"Snickers",new BigDecimal("1.85"),1));
        snacks.put(2, new Snack(2,"M & Ms",new BigDecimal("1.50"),9));
        snacks.put(3, new Snack(3,"Pringles",new BigDecimal("2.10"),2));
        snacks.put(4, new Snack(4,"Reese's",new BigDecimal("1.85"),5));
        snacks.put(5, new Snack(5,"Pretzels",new BigDecimal("1.25"),4));
        snacks.put(6, new Snack(6,"Twinkies",new BigDecimal("1.95"),0));
        snacks.put(7, new Snack(7,"Doritos",new BigDecimal("1.75"),3));
        snacks.put(8, new Snack(8,"Almond Joy",new BigDecimal("1.85"),11));
        snacks.put(9, new Snack(9,"Trident",new BigDecimal("1.95"),1));        
    }

    @Override
    public Snack getSnackById(int id) {
        return snacks.get(id);
    }

    @Override
    public List<Snack> getSnacks() {
        return new ArrayList<>(snacks.values());
    }
    
}
