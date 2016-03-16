package it.polito.tdp.rubrica.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * L'insieme di tutte le {@link Voce} della rubrica,
 * ed i metodi per poter gestire tale insieme
 * @author Fulvio
 *
 */
public class RubricaModel {

	private List<Voce> rubrica ;
	
	public RubricaModel() {
		this.rubrica = new ArrayList<Voce>() ;
	}

	/**
	 * Aggiunge una nuova voce alla rubrica, se questa non
	 * esiste ancora. Se invece esiste, non fa nulla e segnala
	 * il problema restituendo {@code false}
	 *  
	 * @param v la nuova Voce da aggiungere
	 * @return {@code true} se la voce è stata aggiunta correttamente,
	 * {@code false} se esisteva già e quindi non è stata aggiunta.
	 */
	public boolean addVoce(Voce v) {
		
		if( rubrica.contains(v) ) {
			return false ;
		} else {
			rubrica.add(v) ;
			return true ;
		}
		
	}
	
	/**
	 * Ricerca nell'intera rubrica una {@link Voce} che abbia il 
	 * nome uguale a quello specificato. Se esiste, ritorna tale oggetto,
	 * altrimenti ritorna {@code null}.
	 * 
	 * @param nome il nome da ricercare
	 * @return la {@link Voce} corrispondente, oppure {@code null} se non 
	 * l'ha trovata.
	 */
	public Voce findVoceByNome(String nome) {
		
		for( Voce v : rubrica ) {
			if( v.getNome().equals(nome)) {
				return v ;
			}
		}
		
		return null ;
		
	}
	
	/**
	 * Restituisce tutti i nomi degli elementi inseriti in rubrica,
	 * in ordine alfabetico.
	 * 
	 * @return
	 */
	public List<String> getAllNome() {
		List <String> nomi = new LinkedList<String>() ;
		for(Voce v: rubrica) {
			nomi.add(v.getNome()) ;
		}
		
		Collections.sort(nomi);
		return nomi ;
	}
	
	/**
	 * Restituisce la copia integrale della rubrica
	 * @return
	 */
	public List<Voce> getAllVoce() {
		return rubrica ;
	}

	
	public static void main(String [] args) {
		
		RubricaModel m = new RubricaModel() ;
		
		boolean r1 = m.addVoce(new Voce("Fulvio", "fulvio.corno@polito.it", "7053")) ;
		boolean r2 = m.addVoce(new Voce("Giovanni", "giovanni.squillero@polito.it", "7077")) ;
		boolean r3 = m.addVoce(new Voce("Fulvio", "f.qualcunaltro@gmail.com", "345543")) ;
		
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		
		Voce v1 = m.findVoceByNome("Giovanni") ;
		Voce v2 = m.findVoceByNome("Piero") ;
		
		System.out.println(v1);
		System.out.println(v2);

	}
}
