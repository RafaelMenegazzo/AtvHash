package hash;

public class mainHash {
	
	public static void main(String[] args) {
		testeHash tabelahash = new testeHash(10);
		tabelahash.inserir("012.532.534-53", "Bernardo");
		tabelahash.inserir("999.999.999-99", "Eduardo");
		tabelahash.inserir("012.532.534-54", "Davi brito");
		
		System.out.println(tabelahash.recuperar("012.532.534-53"));
		System.out.println(tabelahash.recuperar("999.999.999-99"));
		System.out.println(tabelahash.recuperar("012.532.534-54"));
	}
	

}
