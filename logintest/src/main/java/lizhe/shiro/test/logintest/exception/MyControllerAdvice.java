package lizhe.shiro.test.logintest.exception;

import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;




@Order(-1001)
@ControllerAdvice(basePackages ="lizhe.shiro.test.logintest.ctl")
public class MyControllerAdvice {
	
	
	@ExceptionHandler(value= {MyException.class})
	@ResponseBody
	public String handeleException(MyException e) {
		return "MyControllerAdvice异常";
	} 

}
