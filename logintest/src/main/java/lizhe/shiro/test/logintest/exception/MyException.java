package lizhe.shiro.test.logintest.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class MyException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private final int code;
	
	private final String msg;
	
	public MyException(int code, String msg) {
		this.code =code;
		this.msg = msg;
	}
	
	public MyException(int code, String msg, Exception e) {
		super(e);
		this.code =code;
		this.msg = msg;
	}
}
