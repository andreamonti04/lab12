package it.unibo.es1;

import java.util.*;
import java.util.stream.*;

public class LogicsImpl implements Logics {
	
	private final List<Integer> values;
	
	public LogicsImpl(int size) {
		this.values = new ArrayList<>(Collections.nCopies(size,0));	//crea una collezione
	}
	//collections ha metodi statici al posto di fare operazioni singoli --> static factory
	//mi crea un oggetto di tipo collections e me lo restituisce 
	@Override
	public int size() {
		return this.values.size();
	}

	@Override
	public List<Integer> values() {
		return Collections.unmodifiableList(values); //ritorna una nuova copia della lista
	}

	@Override
	public List<Boolean> enablings() {
		return values.stream().map(x -> x < values.size()).toList();
	}
	//condizione restituisce dei booleani mi sice se contenuto del bottone è della stessa dimensione 
	//lista di booleani se bottone deve essere disabilitato o no

	@Override
	public int hit(int elem) {
		int n = this.values.get(elem);
		this.values.set(elem, ++n);	//post incremento -> mette la n e poi fa ++.
		//su variabile privata e perde contenuto
		return n;
	}

	@Override
	public String result() {
		return this.values
				.stream()
				.map(String::valueOf)		//prendo tutti i valori, converte un interger in stringa
				//map(x -> String.valueOf(x))
				.collect(Collectors.joining("|", "<<", ">>")); //chiuso lo stream e lo restituisce in stringa
	}

	@Override
	public boolean toQuit() {
		return this.values.stream().allMatch(i -> i == this.values.get(0));
	}
	//elemento in posizione 0, tutti devono essere uguali al primo 
}