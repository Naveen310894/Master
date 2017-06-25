/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author 7ravis
 */
public interface SnackDao {
    public Snack getSnackById(int id);
    public List<Snack> getSnacks();
}
