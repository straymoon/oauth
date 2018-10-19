package lizhe.shiro.test.logintest.config;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;

public class MyCredentialsMatcher implements CredentialsMatcher {

	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		if(new String((char[])token.getCredentials()).equals(new String((char[])info.getCredentials()))) {
			return true;
		}
			return false;
	}

}
