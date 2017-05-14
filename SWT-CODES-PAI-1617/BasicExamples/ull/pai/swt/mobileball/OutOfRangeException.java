package ull.pai.swt.mobileball;

public class OutOfRangeException extends Exception {
	private static final long serialVersionUID = -5741460407323620462L;

	public OutOfRangeException() {
		super();
	}

	public OutOfRangeException(String message) {
		super(message);
	}

	public OutOfRangeException(Throwable cause) {
		super(cause);
	}

	public OutOfRangeException(String message, Throwable cause) {
		super(message, cause);
	}

	public OutOfRangeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}