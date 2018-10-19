package lizhe.shiro.test.logintest.ctl;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lizhe.shiro.test.logintest.exception.MyException;


@Controller
@RequestMapping("test")
public class LoginCtl {

	@PostMapping("login")
	@ResponseBody
	public String longin(@RequestParam Map<String, Object> map) {
		
		 Subject subject = SecurityUtils.getSubject();
		 String username = (String) map.get("username");
		 String password = (String) map.get("password");
		 try {
			UsernamePasswordToken token = new UsernamePasswordToken(username,password.toCharArray());
			subject.login(token);
		} catch (Exception e) {
			throw new MyException(500,e.getMessage());
		}
		return username;
	}
	
	
	@GetMapping("login")
	public String login(@RequestParam Map<String, Object> map) {
		return "login";
	}
	
/*	@ExceptionHandler(value= {MyException.class})
	@ResponseBody
	public String handeleException(MyException e) {
		return "异常";
	}*/
	
	
}
