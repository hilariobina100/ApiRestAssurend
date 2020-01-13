package steps;

import org.junit.Assert;

import com.github.javafaker.Faker;

import classesAuxiliares.VariaveisEstaticas;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import funcionalidades.ContaFuncionalidade;
import funcionalidades.LoginFuncionalidade;

public class ContaStep {
	
	private LoginFuncionalidade login;
	private ContaFuncionalidade conta;
	Faker nome = new Faker();
	
	public ContaStep() {
		this.login = new LoginFuncionalidade();
		this.conta = new ContaFuncionalidade();
	}
	
	
	@Dado("^que estou logado no site do Senhor Barriga$")
	public void acessoApiSenhorBarriga(){
	    this.login.dadosAutenticacao();
	}

	@Quando("^crio uma nova conta$")
	public void criarNovaConta(){
		
		this.login.criarConta(nome.funnyName().name());
	    
	}

	@Entao("^deve ser retornardo o valor \"([^\"]*)\"$")
	public void validarRetorno(String valor){
		Assert.assertEquals(valor, VariaveisEstaticas.getCONTA_CRIADA());
	    
	}


	@Quando("^altero uma conta ja criada$")
	public void alteroUmaContaJaCriada(){
		this.conta.alteraConta(nome.funnyName().name());
	}


}
