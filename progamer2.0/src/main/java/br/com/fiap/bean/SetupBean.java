package br.com.fiap.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.fiap.dao.SetupDao;
import br.com.fiap.model.Setup;

//mais atual que o @managed do JSF
@Named //CDI
//definir o escopo do bean, o padrao é view
@RequestScoped

public class SetupBean {
	
	private Setup setup = new Setup();

	public void save() {
		new SetupDao().save(this.setup);
		System.out.println("Salvando..." + this.setup);
		//retorna mensagem de sucesso
		FacesContext.getCurrentInstance().
			addMessage(null, new FacesMessage("Setup cadastrado com sucesso"));
	}
	
	public List<Setup> getSetups(){
		return new SetupDao().getAll();
	}

	public Setup getSetup() {
		return setup;
	}

	public void setSetup(Setup setup) {
		this.setup = setup;
	}


}