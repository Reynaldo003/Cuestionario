package Almacenar;

import TDA.Preguntas;
import java.util.ArrayList;

public class Almacenar {
    
    ArrayList<Preguntas> array;

    public Almacenar() {
        array = new <Preguntas>ArrayList();
    }
    
    public void añadirPreg(Preguntas p){
        array.add(p);
    }
    
    public String devRespuesta(int i){
        return array.get(i).getRespuesta();    
    }
    
    public String devPregunta(int i){
        return array.get(i).getPregunta();    
    }
    
    public String devA(int i){
        return array.get(i).getA();
    }
    
    public String devB(int i){
        return array.get(i).getB();
    }
    
    public String devC(int i){
        return array.get(i).getC();
    }
    
    public String devD(int i){
        return array.get(i).getD();
    }
    
    public String devRuta(int i){
        return array.get(i).getRuta();
    }
    
}
