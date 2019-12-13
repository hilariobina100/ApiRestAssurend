package steps;

import org.junit.Assert;

import com.github.javafaker.Faker;

import classesAuxiliares.VariaveisEstaticas;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

import funcionalidades.LoginFuncionalidade;

public class ContaStep {
	
	private LoginFuncionalidade login;
	
	public ContaStep() {
		this.login = new LoginFuncionalidade();
	}
	
	
	@Dado("^que estou logado no site do Senhor Barriga$")
	public void acessoApiSenhorBarriga(){
	    this.login.dadosAutenticacao();
	}

	@Quando("^crio uma nova conta$")
	public void criarNovaConta(){
		Faker nome = new Faker();
		this.login.criarConta(nome.funnyName().name());
	    
	}

	@Entao("^deve ser retornardo o valor \"([^\"]*)\"$")
	public void validarRetorno(String valor){
		Assert.assertEquals(valor, VariaveisEstaticas.getCONTA_CRIADA());
	    
	}

}
