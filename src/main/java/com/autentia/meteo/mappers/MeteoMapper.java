/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autentia.meteo.mappers;

import com.autentia.meteo.model.RegistroMeteo;
import java.util.List;

/**
 *
 * @author Carlos
 */
public interface MeteoMapper {
    
    public void insertMeteo(RegistroMeteo registroMeteo);
    
    public List<RegistroMeteo> getAll();
    
    public List<RegistroMeteo> getRegistros(FiltroQuery filtroQuery);
        
    public List<String> getLocalidades();
    
    
}
