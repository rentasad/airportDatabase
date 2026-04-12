package rentasad.library.configFileTool;

public class TokenNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public TokenNotFoundException() {
		super("Requested configuration token was not found.");
	}

	public TokenNotFoundException(String message) {
		super(message);
	}
}
