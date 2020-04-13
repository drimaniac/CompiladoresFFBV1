package trabalho.v1.calculadora.compiladores;

import java.util.ArrayList;

class TabelaController extends Operador {
	public static Object[][] montarTabela(String expressao) {
		Object [][] tabela = null;		
		
			ArrayList<Object> valor = new ArrayList();
			
			valor = valores(expressao);
			
			tabela = new Object[valor.size()][3];
			
			int indice = 0;
			
			while (indice < valor.size()) {
				String val;
				String tipo;
				String teste = (valor.get(indice)).toString();
	            if(teste.equals("/")){
	            	val = "DIV";
	            	tipo = "Operador";
	            }else if(teste.equals("*")){
	            	val = "MULT";
	            	tipo = "Operador";
	            }else if(teste.equals("-")){
	            	val = "SUB";
	            	tipo = "Operador";
	            }else if(teste.equals("+")){
	            	val = "SOMA";
	            	tipo = "Operador";
	            }else if (teste.equals("**")){
	            	val = "POTEN";
	            	tipo = "Operador";
	            }else if(teste.equals("(")){
	            	val = "PARESQ";
	            	tipo = "Parentese";
	            }else if(teste.equals(")")){
	            	val = "PARDIR";
	            	tipo = "Parentese";
	            }else {
	            	val = (valor.get(indice)).toString();
	            	tipo = "Número";
	            }
					
				tabela[indice][0] = valor.get(indice);
				tabela[indice][1] = tipo;
				tabela[indice][2] = val;
				
				indice++;
			}
		
		return tabela;		
	}
}