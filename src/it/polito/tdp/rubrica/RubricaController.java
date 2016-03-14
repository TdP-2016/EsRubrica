package it.polito.tdp.rubrica;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.rubrica.model.RubricaModel;
import it.polito.tdp.rubrica.model.Voce;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RubricaController {

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

	private RubricaModel model;

    @FXML
    void doCercaNome(ActionEvent event) {

    	String nome = txtNome.getText() ;
    	if(nome.length()==0) {
    		// errore
    		return ;
    	}
    	
    	Voce v = model.findVoceByNome(nome) ;
    	
    	if(v==null) {
    		// not found
    		txtEmail.setText("???");
    		txtTelefono.setText("???");
    	} else {
    		txtEmail.setText(v.getEmail());
    		txtTelefono.setText(v.getTelefono()) ;
    	}

    }

    @FXML
    void doInserisci(ActionEvent event) {
    	
    	String nome = txtNome.getText() ;
    	if(nome.length()==0) {
    		// errore
    		return ;
    	}
    	String email = txtEmail.getText() ;
    	String tel = txtTelefono.getText() ;
    	
    	Voce v = new Voce(nome, email, tel) ;
    	
    	model.addVoce(v);
    	
    	txtNome.clear();
    	txtEmail.clear() ;
    	txtTelefono.clear();

    }

    @FXML
    void initialize() {
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert txtEmail != null : "fx:id=\"txtEmail\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert txtTelefono != null : "fx:id=\"txtTelefono\" was not injected: check your FXML file 'Rubrica.fxml'.";

    }

    /**
     * Comunica al controller la classe {@link RubricaModel} con cui lavorare
     * @param model
     */
	public void setModel(RubricaModel model) {
		this.model = model ;	
	}
}
