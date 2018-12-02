package mx.ipn.escom.wad.tarea6.exception;

public class UserBlockedException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserBlockedException() {
		super();
	}

	public UserBlockedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserBlockedException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserBlockedException(String message) {
		super(message);
	}

	public UserBlockedException(Throwable cause) {
		super(cause);
	}

}
