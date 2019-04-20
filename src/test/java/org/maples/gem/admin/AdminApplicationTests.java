package org.maples.gem.admin;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminApplicationTests {

    class UserRealm extends AuthorizingRealm {
        @Override
        protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

            Set<String> roles = new HashSet<>();
            Set<String> permissions = new HashSet<>();

            roles.add("admin");

            info.setRoles(roles);
            info.addStringPermissions(permissions);
            return null;
        }

        @Override
        protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
                throws AuthenticationException {
            return new SimpleAuthenticationInfo("maples", "123456", "admin");
        }
    }

    @Test
    public void testSecurity() {
        SecurityManager securityManager = new DefaultSecurityManager(new UserRealm());
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("maples", "123456");
        try {
            subject.login(token);
            log.info("{}", subject.hasRole("admin"));
            subject.logout();
        } catch (AuthenticationException e) {
            log.info(e.getLocalizedMessage());
        }

    }
}

