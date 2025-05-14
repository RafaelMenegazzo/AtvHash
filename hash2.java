package hash;

public class hash2 {

	//tratamento de colisões utilizando posições alternativas do array
	private final double FATOR_DE_CARGA = 0.7;
	private Nodo[] array;
	private int tamanhoAtual;
	private int totalColisoes; 
	
	
	public int getTotalColisoes() {
		return totalColisoes;
	}


	public void setTotalColisoes(int totalColisoes) {
		this.totalColisoes = totalColisoes;
	}
	
	
	
	
	public Nodo[] getArray() {
		return array;
	}


	public void setArray(Nodo[] array) {
		this.array = array;
	}


	public int getTamanhoAtual() {
		return tamanhoAtual;
	}


	public void setTamanhoAtual(int tamanhoAtual) {
		this.tamanhoAtual = tamanhoAtual;
	}


	public double getFATOR_DE_CARGA() {
		return FATOR_DE_CARGA;
	}


	public hash2(int capa) {
		array = new Nodo[capa];
		tamanhoAtual = 0;
		this.setTotalColisoes(0);
	}
	
	
	private int calcularHash(String chave) {
		int hash = 0;
		for(byte b : chave.getBytes()) {
			hash += b;
		}
		return hash% array.length;
	}
	
	private int calcularHash(String chave, int colisoes) {
		
		int hash = 0;
		for(byte b : chave.getBytes()) {
			hash += b;
		}
		return (hash + colisoes) % array.length;
	}
	
	
	public void inserir(String chave, String valor) {
		
		if((double) tamanhoAtual / array.length >= FATOR_DE_CARGA){
			redimensionar();
			
		}
		
		int indice = calcularHash(chave);
		int colisoes = 0;
		
		while(array[indice] != null && !array[indice].getChave().equals(chave)) {
			colisoes++;
			totalColisoes++;
			indice = calcularHash(chave, colisoes);
			
		}
		if(array[indice] == null) {
			tamanhoAtual++;
		}
		
		array[indice] = new Nodo(chave,valor);
		
	}
	
	public String recuperar(String chave) {
		int indice = calcularHash(chave);
		int colisoes = 0;
		while(array[indice] != null) {
			if(array[indice].getChave().equals(chave)) {
				return array[indice].getValor();
			}
			
			colisoes++;
			indice = calcularHash(chave,colisoes);
			
		}
		
		return null;
	}
	
	private void redimensionar() {
		Nodo[] antigoArray = array;
		
		array = new Nodo[antigoArray.length *2];
		tamanhoAtual = 0;
		
		for(Nodo nodo : antigoArray) {
			if(nodo!= null) {
				inserir(nodo.getChave(), nodo.getValor());
				
	
			}
		}
	}


}
