package it.polito.tdp.rubrica.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.rubrica.db.VoceDAO;

/**
 * L'insieme di tutte le {@link Voce} della rubrica,
 * ed i metodi per poter gestire tale insieme
 * @author Fulvio
 *
 */
public class RubricaModel {

	
	public RubricaModel() {
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
		
		VoceDAO dao = new VoceDAO() ;
		if( dao.findVoceByNome(v.getNome()) != null )
			return false ;
		
		return dao.addVoce(v) ;
		
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
		
		VoceDAO dao = new VoceDAO() ;
		Voce v = dao.findVoceByNome(nome) ;
		return v ;
	}
	
}
