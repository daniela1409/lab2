/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.session;

import com.entity.Tarjeta;
import javax.ejb.Local;

/**
 *
 * @author CarlosMedina
 */
@Local
public interface TarjetaFachadaLocal {
    public boolean registrar(Tarjeta tarjeta);
    public Tarjeta find(String numero);
}
