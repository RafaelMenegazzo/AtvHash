package hash;

public class hash3 {
	private int tamArray;
	private int tamanhoAtual;
	private final double FATOR_DE_CARGA = 0.7;
	private ListaEncadeada[] array;
	private int colisoes;
	
	
	
	public int getColisoes() {
		return colisoes;
	}

	public void setColisoes(int colisoes) {
		this.colisoes = colisoes;
	}

	public int getTamArray() {
		return tamArray;
	}

	public void setTamArray(int tamArray) {
		this.tamArray = tamArray;
	}

	public ListaEncadeada[] getArray() {
		return array;
	}

	public void setArray(ListaEncadeada[] array) {
		this.array = array;
	}

	public double getFATOR_DE_CARGA() {
		return FATOR_DE_CARGA;
	}
	public int getTamanhoAtual() {
		return tamanhoAtual;
	}
	
	public void setTamanhoAtual(int tamanhoAtual) {
		this.tamanhoAtual = tamanhoAtual;
	}

	public hash3(int tamArray) {
		this.tamArray = tamArray;
		array = new ListaEncadeada[tamArray];
		this.colisoes = 0;
		setTamanhoAtual(0);
		
	}
	
	private int calcularHash(String chave) {
		int hash = 0;
		for(byte b : chave.getBytes()) {
			hash += b;
		}
		return hash% array.length;
	}

	
	public void inserir(String chave, String valor) {
		
		if((double) tamArray / array.length >= FATOR_DE_CARGA) {
			
			redimensionar();
		}
		
		
		int indice = calcularHash(chave);
		
		
		
		if(array[indice] == null) {
			array[indice] = new ListaEncadeada(chave,valor);
			setTamanhoAtual(getTamanhoAtual() + 1);
			return;
		}
		
		colisoes++;
		Nodo aux = array[indice].getInicio();
			
		while(aux != null) {
			if(aux.getChave().equals(chave)) {
				aux.setValor(valor);
					
				return;
			}
			aux = aux.getProx();
		}
		
		
		array[indice].add(chave, valor);
		
		
		
	}
	
	public String recuperar(String chave) {
		int indice = calcularHash(chave);
		
		
		if(array[indice] == null) {
			return null;
		}
		
		Nodo aux = array[indice].getInicio();
		
		while(aux != null) {
			if(aux.getChave().equals(chave)) {
				return aux.getValor();
			}
			
			
			aux = aux.getProx();
		}
		return null;
	}
	
	
	private void redimensionar() {
		
		ListaEncadeada[] antigoArray = array;
		array = new ListaEncadeada[antigoArray.length * 2];
		setTamanhoAtual(0);
		
		
		
		for(ListaEncadeada li : antigoArray) {
			
			if(li != null) {
				
				Nodo aux = li.getInicio();
				while(aux != null) {
					inserir(aux.getChave(),aux.getValor());
					aux = aux.getProx();
				}
			
			
			}
		}
		
	}
	
	
	public void mostrarHash() {
		
		int i = 0;
		for(ListaEncadeada li : array) {
			
			if(li != null) {
				
				Nodo aux = li.getInicio();
				
				System.out.println("Lista" + i);
				while(aux != null) {
					System.out.println(aux.getValor());
					aux = aux.getProx();
				} 
				i++;
			} else {
				System.out.println("Lista" + i);
				i++;
			}
		}
		
	}

}
	
