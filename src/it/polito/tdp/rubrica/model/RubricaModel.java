package it.polito.tdp.rubrica.model;

import java.util.ArrayList;
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

	public void addVoce(Voce v) {
		rubrica.add(v) ;
	}
	
	public Voce findVoceByNome(String nome) {
		
		for(Voce v: rubrica) {
			if(v.getNome().equals(nome)) {
				return v ;
			}
		}
		
		return null ;
		
	}
	
	public static void main(String []args) {
		
		RubricaModel m = new RubricaModel() ;
		
		m.addVoce( new Voce("Fulvio", "fulvio.corno@polito.it", "7053")) ;
		m.addVoce( new Voce("Giovanni", "giovanni.squillero@polito.it", "7077")) ;
		m.addVoce( new Voce("Andrea", "andrea.marcelli@polito.it", "7088")) ;
		
		Voce giovanni = m.findVoceByNome("Giovanni") ;
		Voce fulvio = m.findVoceByNome("Fulvio") ;
		Voce antonio = m.findVoceByNome("Antonio") ;
		
		System.out.format("giovanni: %s -> %s\n", giovanni.getNome(), giovanni.getEmail());
		System.out.format("fulvio: %s -> %s\n", fulvio.getNome(), fulvio.getEmail());
		System.out.format("antonio: %s -> %s\n", antonio.getNome(), antonio.getEmail());
	}
}
