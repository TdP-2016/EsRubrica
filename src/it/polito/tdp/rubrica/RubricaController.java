package it.polito.tdp.rubrica;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.rubrica.model.RubricaModel;
import it.polito.tdp.rubrica.model.Voce;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RubricaController {
	
	private RubricaModel model ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtTelefono;
    
    @FXML
    private Label lblStato ;
    
    @FXML
    private ComboBox<String> boxCerca;

    @FXML
    void doCerca(ActionEvent event) {
    	
    	String nome = txtNome.getText() ;
    	
    	if(nome.length()==0) {
    		lblStato.setText("Dati mancanti") ;
    	} else {
    		Voce v = model.findVoceByNome(nome) ;
    		
    		if(v!=null) {
    			// trovato
    			txtEmail.setText(v.getEmail());
    			txtTelefono.setText(v.getTelefono());
    			lblStato.setText("Elemento trovato") ;
    		} else {
    			// non trovato
    			//txtEmail.setText("");
    			txtEmail.clear();
    			txtTelefono.setText("");
    			lblStato.setText("Elemento non trovato") ;
    		}
    	}

    }
    
    @FXML
    void doCercaTendina(ActionEvent event) {
    	String nome = boxCerca.getValue() ;
    	
    	if(nome==null) {
    		lblStato.setText("Dati mancanti") ;
    	} else {
    		Voce v = model.findVoceByNome(nome) ;
    		
    		if(v!=null) {
    			// trovato
    			txtEmail.setText(v.getEmail());
    			txtTelefono.setText(v.getTelefono());
    			lblStato.setText("Elemento trovato") ;
    		} else {
    			// Non deve capitare!!!
    			lblStato.setText("Elemento non trovato") ;
    		}
    	}

    }

    @FXML
    void doInserisci(ActionEvent event) {
    	
    	// estrai i data dalla UI
    	String nome = txtNome.getText() ;
    	String email = txtEmail.getText() ;
    	String tel = txtTelefono.getText() ;
    	
    	// valida i dati inseriti dall'utente
    	if( nome.length()==0 ||
    			(email.length()==0 && tel.length()==0)) {
    		// errore
    		lblStato.setText("Dati mancanti");
    		
    	} else {
    		// dati validi
    		boolean result = model.addVoce(new Voce(nome, email, tel)) ;
    		
    		// aggiorna la vista
    		if(result==false) {
        		lblStato.setText("Voce già in elenco");
    		} else {
        		lblStato.setText("Voce inserita");
        		aggiornaTendina() ;
    		}
    	}
    }

    private void aggiornaTendina() {
    	boxCerca.getItems().clear() ;
    	boxCerca.getItems().addAll(model.getAllNome()) ;
    	
    	//TODO: aggiornare la tendina in modo incrementale anziché ricrearla da zero ogni volta
    }
    
    public void setModel( RubricaModel model ) {
    	this.model = model ;
    }
    
    @FXML
    void initialize() {
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert txtEmail != null : "fx:id=\"txtEmail\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert txtTelefono != null : "fx:id=\"txtTelefono\" was not injected: check your FXML file 'Rubrica.fxml'.";

    }
}
