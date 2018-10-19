package lizhe.shiro.test.logintest.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class MyFormShiroFilter extends FormAuthenticationFilter{
	
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		//HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		String vcode = request.getParameter("code");
		//String vvcode = (String) httpServletRequest.getSession().getAttribute("code");
		String vvcode = "1234";
		boolean codeValid = vcode != null && vcode.equalsIgnoreCase(vvcode);
		
		if (codeValid) {
			return true;
		} else {
			String data = "验证码错误";
			responseJson(response, data);
			return false;
		}
	}
	
	
	private void responseJson(ServletResponse response, Object data) throws IOException {
		response.setContentType("text/plain;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		out.print(data);
		out.flush();
		out.close();
	}
	
}
