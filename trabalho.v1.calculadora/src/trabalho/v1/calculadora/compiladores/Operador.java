package trabalho.v1.calculadora.compiladores;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;


public class Operador extends JFrame {
   
    static String numeros = "([0-9])+";
    static String operadores = "(\\+|-|\\/|\\*{1,2})";
    static String parenteses = "(\\(|\\))";
    static String regex = "("+parenteses+"?"+operadores+"?"+parenteses+"?"+"(-)?"+numeros+parenteses+"?"+")+";
    
    public boolean validador(String expressao){
        return expressao.matches(regex);
    }
    
    public static ArrayList valores(String expressao){
         ArrayList<Object> valores = new ArrayList();
         Pattern num = Pattern.compile(numeros);
        Matcher mat = num.matcher(expressao);
        while(mat.find()){
            valores.add(mat.group());
        }
        Pattern numPar = Pattern.compile(parenteses);
        Matcher matPar = numPar.matcher(expressao);
        while(matPar.find()){
            valores.add(matPar.group());
        }
        Pattern numOpe = Pattern.compile(operadores);
        Matcher matOpe = numOpe.matcher(expressao);
        while(matOpe.find()){
            valores.add(matOpe.group());
        }
        return valores;
    }
   
}