package commons;

import cucumber.api.java.Before;

public class Hooks extends Inicializar{
	@Before
	public void beforeInit() {
		setup();
	}
}
