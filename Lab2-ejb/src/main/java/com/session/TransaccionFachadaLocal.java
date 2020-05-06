/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.session;

import com.entity.Cliente;
import com.entity.Tarjeta;
import javax.ejb.Local;

/**
 *
 * @author CarlosMedina
 */
@Local
public interface TransaccionFachadaLocal {

    boolean registrar(Cliente cliente, Tarjeta tarjeta,  double valor);
    
}
