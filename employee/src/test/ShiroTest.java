package test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

public class ShiroTest {
	@Test
	public void test() {
		Factory<org.apache.shiro.mgt.SecurityManager> factory =
		new IniSecurityManagerFactory("classpath:shiro.ini");
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("root", "123456");
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
		}
		if (subject.isAuthenticated()) {
			System.out.println("success");
		}// 断言用户已经登录
		subject.logout();
	}
}
