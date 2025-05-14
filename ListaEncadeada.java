package hash;

public class ListaEncadeada {
	
	private Nodo inicio;
	
	
	public ListaEncadeada(String chave, String valor) {
		inicio = new Nodo(chave, valor);
	}

	public Nodo getInicio() {
		return inicio;
	}

	public void setInicio(Nodo inicio) {
		this.inicio = inicio;
	}

	public void add(String chave, String valor) {
		Nodo novoNodo = new Nodo(chave,valor);
		novoNodo.setProx(inicio);
		inicio = novoNodo; 
	}
	
}
