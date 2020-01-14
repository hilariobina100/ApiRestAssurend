package funcionalidades;

import static io.restassured.RestAssured.given;

import classesAuxiliares.Movimentacao;
import classesAuxiliares.VariaveisEstaticas;
import commons.Inicializar;
import io.restassured.response.Response;

public class MovimentacaoFuncionaldiade extends Inicializar {
	
	private Movimentacao mov;
	private ContaFuncionalidade conta;
	private LoginFuncionalidade aut;
	
	public MovimentacaoFuncionaldiade() {
		this.mov = new Movimentacao();
		this.conta = new ContaFuncionalidade();
		this.aut = new LoginFuncionalidade();
	}
	
	public Movimentacao getMovimentacao() {
		mov.setConta_id(this.conta.retornaIDContaCriada());
		mov.setDescricao("Descriçãoo da Movimentacao");
		mov.setEnvolvido("Envolvido na Movimentação");
		mov.setTipo("REC");
		mov.setData_transacao("14/01/2020");
		mov.setData_pagamento("15/01/2020");
		mov.setValor(100.0);
		mov.setStatus(true);
		return mov;
	}
	
	public Movimentacao getMovimentacaoSemDataTransasicao() {
		mov.setConta_id(this.conta.retornaIDContaCriada());
		mov.setDescricao("Descri��o da Movimentacao");
		mov.setEnvolvido("Envolvido na Movimenta��o");
		mov.setTipo("REC");
		mov.setData_pagamento("15/01/2020");
		mov.setValor(100.0);
		mov.setStatus(true);
		return mov;
	}
	
	public void inserirMovimentacao() {
		String token = aut.getToken();
		String cod = String.valueOf(given().header("Authorization", "JWT " + token).body(this.getMovimentacao()).when()
				.post("/transacoes").then().extract().statusCode());

		VariaveisEstaticas.setCONTA_CRIADA(cod);
	}
	
	public String validarCampoObrigatorioDataMovimentacao() {
		String token = aut.getToken();
		String Response = String.valueOf(given().header("Authorization", "JWT " + token).body(this.getMovimentacaoSemDataTransasicao()).when()
				.post("/transacoes").then().extract().jsonPath().get("msg"));
		
		return Response.replace("[", "").replace("]", "");

	}

}
