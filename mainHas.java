package hash;

import java.util.Random;

class mainHas {

	public static void main(String[] args) {
		
		Random r = new Random();
		Long startTime = System.nanoTime();
		
		hash2 hash2 = new hash2(500);
		hash3 tabelahash = new hash3(500);
		SDBM sdbm = new SDBM(100);
		
		
		//inserção hash encadeado
		for(int i = 0; i <= 5000; i++ ) {
			
			String chave = r.nextInt(500) + "";
			String value = r.nextInt(500) + "";
			
			
			tabelahash.inserir(chave, value);
		}
		
		long endTime = System.nanoTime();
//		
		System.out.println((double) (endTime - startTime) / 1000000000 + "Segundos");
		System.out.println(tabelahash.getArray().length);
		
//		
		startTime = System.nanoTime();
//		
		//Procura hash encadeado
		for(int i = 0; i < 100; i++) {
			
			String chave = r.nextInt(500) + "";
			System.out.println(tabelahash.recuperar(chave));
			
		}
		
		endTime = System.nanoTime();
		System.out.println((double) (endTime - startTime) / 1000000000 + "Segundos procurando - Hash encadeado");

		
		
//		
		startTime = System.nanoTime();
		
		//inserção hash endereçamento aberto
		for(int i = 0; i < 500; i++) {
			
			String chave = r.nextInt(500) + "";
			String value = r.nextInt(500) + "";
			
			hash2.inserir(chave, value);
			
		}
		
		endTime = System.nanoTime();
		System.out.println((double) (endTime - startTime) / 1_000_000_000.0 + "Segundos");
		System.out.println("Colisões " + hash2.getTotalColisoes());
		System.out.println(hash2.getArray().length);
		
//		
		startTime = System.nanoTime();
//		
		//Procura hash endereçamento aberto
		for(int i = 0; i < 100; i++) {
//			
			String chave = r.nextInt(500) + "";
			System.out.println(hash2.recuperar(chave));
			
		}
//		
		endTime = System.nanoTime();
		System.out.println((double) (endTime - startTime) / 1000000000 + "Segundos procurando: Lista endereçamento");
//		
		long startTime1 = System.nanoTime();
		
		//int[] indices = new int[50];
		
		for(int i = 0; i < 50; i++) {
			
			int ind = r.nextInt(50);
			//indices[ind]++;
			String chave = ind + "";
			String valor = r.nextInt(50) + "";	
			
			sdbm.inserir(chave, valor);
			
		}
		
		long endTime1 = System.nanoTime();
		
		sdbm.mostrarHash();
		System.out.println(sdbm.getArray().length);
//		
		// contabilizando até o cinquenta por conta do EX2
//		int x = 0;
//		for(int i : indices) {
//			System.out.println("posição "+ x + " qtd: " + i);
//			x++;
//		}
		
		
		
		
		
		System.out.println("Desvio padrão aproximadamente 0,872");
		System.out.println("SDBM: " + (double) (endTime1 - startTime1) / 1000000000 + " Segundos");
		System.out.println("Colisoes hash encadeado " + tabelahash.getColisoes());
		System.out.println("Lista encadeada: " +(double) (endTime - startTime) / 1000000000 + " Segundos");
		System.out.println("Colisões SDBM " + sdbm.getTotalColisoes());
		
		startTime = System.nanoTime();
		//pesquisa sdbm
		for(int i = 0; i < 1000; i++){
			
			String chave = r.nextInt() + "";
			sdbm.recuperar(chave);
			
		}
		endTime = System.nanoTime();
		System.out.println((double) (endTime - startTime) / 1000000000 + "Segundos pesquisa SDBM");
		
	}

}
