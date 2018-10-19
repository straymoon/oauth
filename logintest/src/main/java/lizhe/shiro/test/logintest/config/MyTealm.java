package lizhe.shiro.test.logintest.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import lizhe.shiro.test.logintest.pojo.User;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class MyTealm extends AuthorizingRealm{

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		log.info("AuthorizationInfo");
		
		 SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        return simpleAuthorizationInfo;		
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		log.info("AuthenticationInfo");
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		User userinfo = new User();
		
		userinfo.setUserName(usernamePasswordToken.getUsername());
		userinfo.setPassWord("123456");
		
	   return new SimpleAuthenticationInfo(userinfo, userinfo.getPassWord().toCharArray(), getName());
	}
	
}
