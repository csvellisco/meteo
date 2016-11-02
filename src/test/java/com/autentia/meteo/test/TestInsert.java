/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autentia.meteo.test;

import com.autentia.meteo.mappers.MeteoMapper;
import com.autentia.meteo.model.RegistroMeteo;
import java.util.Date;
import java.util.Random;
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
public class TestInsert {
    
    private final static String LOCALIDADES[] = {"Madrid","Barcelona","Sevilla","Santander","Pontevedra","San Sebastian","Valencia"};
    
    public String dameLocalidadAleat(){
        int numLocalidades = LOCALIDADES.length;
        return LOCALIDADES[(int)(Math.random() * numLocalidades)];
    }
    
    @Resource
    MeteoMapper meteoMapper;
    @Test   
    public void testInsert(){
        
        int sizeInicial = meteoMapper.getAll().size();  
        
        int numInserciones = 0;
        
        int validado;
        int dia;
        int mes;
        int anyo;
        
        Random aleatorio = new Random();
        
        for (int i = 0; i<numInserciones; i++){
            
            dia = 1 + aleatorio.nextInt(28);
            mes = 1  + aleatorio.nextInt(12);
            anyo = 2014 + aleatorio.nextInt(3) - 1900;
                          
            RegistroMeteo registroMeteo = new RegistroMeteo();
            registroMeteo.setFecha(new Date(anyo,mes, dia));
            registroMeteo.setLocalidad(dameLocalidadAleat());
            registroMeteo.setTemperatura(-20 + aleatorio.nextInt(60));
            registroMeteo.setHumedad(aleatorio.nextInt(99));
            registroMeteo.setPrecipitacion(aleatorio.nextInt(60));
            registroMeteo.setTipoDia(aleatorio.nextInt(4));
            if (Math.random() <= 0.8) validado = 1; else validado = 0;
            registroMeteo.setValidado(validado);

            meteoMapper.insertMeteo(registroMeteo);
        }
        
        assertEquals(meteoMapper.getAll().size(),sizeInicial + numInserciones);               
        
        
    }
    
}
