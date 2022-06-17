/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.estacionamento;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Willian
 */
public class Data {

    public Data() {
    }
    
    public String mes, dia, ano, hora;
    SimpleDateFormat horaformatada = new SimpleDateFormat("HH:mm");
    
    public void le_hora(){
        Date data = new Data();
        hora = horaformatada.format(data);
        
    }
    
    public void le_data(){
        Data data = new Data();
        mes = ""+data.getMonth();
        dia = ""+data.getDay();
        ano = ""+ (1900 + data.getYear());
        
        switch (data.getMonth()){
            
            case 0: mes = "01";break;
            case 1: mes = "02";break;
            case 2: mes = "03";break;
            case 3: mes = "04";break;
            case 4: mes = "05";break;
            case 5: mes = "06";break;
            case 6: mes = "07";break;
            case 7: mes = "08";break;
            case 8: mes = "09";break;
            case 9: mes = "10";break;
            case 10: mes = "11";break;
            case 11: mes = "12";break;
            
        }
        
        switch(+data.getDate()){
            case 1 : dia = "1";break;
            case 2 : dia = "2";break;
            case 3 : dia = "3";break;
            case 4 : dia = "4";break;
            case 5 : dia = "5";break;
            case 6 : dia = "6";break;
            case 7 : dia = "7";break;
            case 8 : dia = "8";break;
            case 9 : dia = "9";break;
            
        }
    }
    
    private int getMonth() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private int getYear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getDay() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private int getDate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
