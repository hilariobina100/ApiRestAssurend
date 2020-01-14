package steps;

import org.junit.Assert;

import classesAuxiliares.VariaveisEstaticas;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import funcionalidades.MovimentacaoFuncionaldiade;


public class MovimentacaoStep {
	
	private MovimentacaoFuncionaldiade mov;
	
	public MovimentacaoStep() {
		this.mov = new MovimentacaoFuncionaldiade();
	}
	
	@Quando("^insiro uma movimentacao$")
	public void insiroUmaMovimentacao(){
	  this.mov.inserirMovimentacao();   
	}

	@Quando("^insiro uma movimentacao sem o campo Data Transacao$")
	public void insiroUmaMovimentacaoSemOCampoDataTransacao(){
		VariaveisEstaticas.setMENSAGEM(this.mov.validarCampoObrigatorioDataMovimentacao());
	}

	@Entao("^deve ser retornardo a mensagem \"([^\"]*)\"$")
	public void deveSerRetornardoMensagem(String msg){
		Assert.assertEquals(msg, VariaveisEstaticas.getMENSAGEM());
	}

}
