package org.maples.gem.admin.service;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.maples.gem.admin.model.Role;
import org.maples.gem.admin.repository.RoleMapper;
import org.maples.gem.admin.repository.UserMapper;
import org.maples.gem.admin.repository.UserRolePermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SecurityService extends AuthorizingRealm {
    private static final String REALM_NAME = "SecurityService";

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRolePermissionMapper userRolePermissionMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String principal = (String) principals.getPrimaryPrincipal();
        Integer userId = userMapper.selectUserIdByPrincipal(principal);

        Set<String> roles = new HashSet<>();
        if (userId != null) {
            List<Integer> roleIdList = userRolePermissionMapper.selectRoleIdByUserId(userId);
            for (Integer roleId : roleIdList) {
                Role role = roleMapper.selectByPrimaryKey(roleId);
                if (role != null) {
                    roles.add(role.getName());
                }
            }
        }
        return new SimpleAuthorizationInfo(roles);
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String) token.getPrincipal();
        String credential = userMapper.selectCredentialByPrincipal(principal);

        if (StringUtils.isEmpty(credential)) {
            throw new UnknownAccountException("Invalid principal");
        }

        return new SimpleAuthenticationInfo(principal, credential, REALM_NAME);
    }
}
