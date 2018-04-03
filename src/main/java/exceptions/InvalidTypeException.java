package exceptions;

public class InvalidTypeException extends Exception{
	private static final long serialVersionUID = -69637829093235855L;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	private String msg;

	public InvalidTypeException(String msg) {
		this.msg = msg;
	}
}
