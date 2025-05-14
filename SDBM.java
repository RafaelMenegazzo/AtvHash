package hash;

public class SDBM {
	
	
	private Nodo[] array;
	private int TamAtual;
	private int totalInseridos;
	private final double FATOR_DE_CARGA = 0.7;
	private int totalColisoes;
	
	
	public SDBM(int tam) {
		array = new Nodo[tam];
		totalInseridos = 0;
		TamAtual = array.length;
		totalColisoes = 0;
	}
	
	
	
	
	public int getTotalColisoes() {
		return totalColisoes;
	}




	public void setTotalColisoes(int totalColisoes) {
		this.totalColisoes = totalColisoes;
	}




	public int getTotalInseridos() {
		return totalInseridos;
	}




	public void setTotalInseridos(int totalInseridos) {
		this.totalInseridos = totalInseridos;
	}




	public int getTamAtual() {
		return TamAtual;
	}


	public void setTamAtual(int tamAtual) {
		TamAtual = tamAtual;
	}


	public double getFATOR_DE_CARGA() {
		return FATOR_DE_CARGA;
	}


	public Nodo[] getArray() {
		return array;
	}
	
	
	public void setArray(Nodo[] array) {
		this.array = array;
	}
	
	 public static long sdbmHash(String str) {
	        long hash = 0;
	        for (int i = 0; i < str.length(); i++) {
	            hash = (int) str.charAt(i) + (hash << 6) + (hash << 16) - hash;
	        }
	        return hash & 0x7FFFFFFF;
	 }
	 
	 public static long sdbmHash(String str, int colisoes) {
	        long hash = 0;
	        for (int i = 0; i < str.length(); i++) {
	            hash = (int) str.charAt(i) + (hash << 6) + (hash << 16) - hash;
	        }
	        return(hash + colisoes)& 0x7FFFFFFF;
	 }

	 
	 public void inserir(String chave, String valor) {
		 
		 if((double) totalInseridos / array.length >= FATOR_DE_CARGA) {
			 redimensionar();
		 }
		 
		 int indice = (int) sdbmHash(chave) % array.length;
		 int colisoes = 0;
		 
		 while (array[indice] != null && !array[indice].getChave().equals(chave)) {
			 	colisoes++;
			 	totalColisoes++;
				indice = (int) sdbmHash(chave, colisoes) %  array.length;
				
	        }
		
			if(array[indice] == null) {
				totalInseridos++;
			}
			
			array[indice] = new Nodo(chave,valor);
		 
		 
		 
	 }
	 
	 private void redimensionar() {
		Nodo[] antigoArray = array;
		
		array = new Nodo[antigoArray.length * 2];
		totalInseridos = 0;
		
		
		for(Nodo nodo : antigoArray) {
			if(nodo != null) {
				inserir(nodo.getChave(),nodo.getValor());
			}
		}
		
	}

	 
	 public void mostrarHash() {
		 int i = 0;
		  
		 for(Nodo nodo : array) {
			 if(nodo != null) {
				 System.out.println("lista " + i);
				 System.out.print("Chave: ");
				 System.out.print(nodo.getChave());
				 System.out.print(" valor: ");
				 System.out.println(nodo.getValor());
				 i++;
				 
			 } else {
				 System.out.println("lista " + i);
				 i++;
			 }
		 }
	 }

	public String recuperar(String chave) {
		 
		 int indice = (int) sdbmHash(chave) % array.length;
		 int colisoes = 0;
		 while(array[indice] != null) {
				if(array[indice].getChave().equals(chave)) {
					return array[indice].getValor();
				}
				
				colisoes++;
				indice = (int) sdbmHash(chave, colisoes) %  array.length;
				
				
		 }
		 return null;
		 
	 }
	 
	 
	 

}
