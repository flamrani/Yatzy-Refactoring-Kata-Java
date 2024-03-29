package exceptions;

public class CategoryException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private String message;
	
	public CategoryException() {
		super();
	}
	
	public CategoryException(String message) {
		super();
		this.message = message;
	}
	
	public CategoryException(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
