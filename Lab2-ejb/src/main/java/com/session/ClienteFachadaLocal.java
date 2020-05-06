/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.session;

import com.entity.Cliente;
import javax.ejb.Local;

/**
 *
 * @author CarlosMedina
 */
@Local
public interface ClienteFachadaLocal {
    public boolean registrar(Cliente cliente);
    public Cliente find(String id);
}
