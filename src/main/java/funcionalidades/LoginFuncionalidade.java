package funcionalidades;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import classesAuxiliares.VariaveisEstaticas;
import commons.Inicializar;

public class LoginFuncionalidade extends Inicializar {

	public LoginFuncionalidade() {

	}

	public Map<String, String> dadosAutenticacao() {
		Map<String, String> login = new HashMap<String, String>();
		login.put("email", "bina@bina");
		login.put("senha", "bina");

		return login;
	}

	public String getToken() {
		String token = given().body(this.dadosAutenticacao()).when().post("/signin").then().extract().path("token");
		return token;
	}

	public void criarConta(String nomeConta) {
		String token = this.getToken();
		String cod = String.valueOf(given().header("Authorization", "JWT " + token).body("{\"nome\" :\"" + nomeConta + "\"}").when()
				.post("/contas").then().extract().statusCode());

		VariaveisEstaticas.setCONTA_CRIADA(cod);

	}

}
