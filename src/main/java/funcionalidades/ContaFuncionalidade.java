package funcionalidades;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import classesAuxiliares.VariaveisEstaticas;
import commons.Inicializar;

public class ContaFuncionalidade extends Inicializar{
	
	private LoginFuncionalidade aut;
	
	public ContaFuncionalidade() {
		this.aut = new LoginFuncionalidade();
	}
	
	public int retornaIDContaCriada() {
		String token = aut.getToken();
		 Object Response = given().header("Authorization", "JWT " + token).when()
				.get("/contas?id").then().extract().jsonPath().getInt("id[0]");

		return Integer.parseInt(Response.toString());
	}
	
	public void alteraConta(String nome) {
		String token = aut.getToken();
		String cod = String.valueOf(given().header("Authorization", "JWT " + token).body("{\"nome\" :\"" + nome + "\"}").when()
				.put("/contas/" +this.retornaIDContaCriada()).then().extract().statusCode());

		VariaveisEstaticas.setCONTA_CRIADA(cod);
	}

}
