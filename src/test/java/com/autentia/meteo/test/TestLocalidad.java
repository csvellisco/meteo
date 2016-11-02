/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autentia.meteo.test;

import com.autentia.meteo.mappers.FiltroQuery;
import com.autentia.meteo.mappers.MeteoMapper;
import com.autentia.meteo.model.RegistroMeteo;
import java.util.List;
import javax.annotation.Resource;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author Carlos
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContextMybatis-test.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class TestLocalidad {
    
    @Resource
    MeteoMapper meteoMapper;
    
    @Test
    public void testLocalidad(){
        
        FiltroQuery filtro = new FiltroQuery();
        
        filtro.setLocalidad("");
        filtro.setOrderBy("TEMP_DESC");
        filtro.setNumElemsPorPagina(2);
        filtro.setPagina(2);
        
        List<RegistroMeteo> lista = meteoMapper.getRegistros(filtro);
        
        int numElementos = lista.size();
        RegistroMeteo registroMeteo;
        
        for (int i = 0; i< numElementos ; i++){
            registroMeteo = lista.get(i);
            System.out.println(registroMeteo.toString());
        }
    }
    
    @Test
    public void getLocalidades(){
        List<String> lista = meteoMapper.getLocalidades();
        int numElementos = lista.size();
        
        for (int i = 0; i < numElementos; i++){
            System.out.println(lista.get(i));
        }
        
    }
}
