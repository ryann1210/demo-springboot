package com.ruanyangyang.demo.config.shiro;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ruanyangyang.demo.common.constant.UserConstant;
import com.ruanyangyang.demo.entity.pojo.SysUser;
import com.ruanyangyang.demo.service.SysResourceService;
import com.ruanyangyang.demo.service.SysRoleService;
import com.ruanyangyang.demo.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShiroRealm extends AuthorizingRealm {
    private Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysResourceService sysResourceService;

    /**
     * 重写授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("执行ShiroRealm授权");

        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        Integer userId = user.getId();

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        // 获取用户角色集
//        List<SysRole> roleList = sysRoleService.queryRoleListByUserId(userId);
//        Set<String> roleSet = roleList.stream().map(SysRole::getRoleKey).collect(Collectors.toSet());
//        simpleAuthorizationInfo.setRoles(roleSet);

        // 获取用户权限集
//        List<SysResource> resourceList = sysResourceService.queryResourceListByUserId(userId);
//        Set<String> permissionSet = resourceList.stream().map(SysResource::getResKey).collect(Collectors.toSet());
//        simpleAuthorizationInfo.setStringPermissions(permissionSet);

        return simpleAuthorizationInfo;
    }

    /**
     * 重写认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        logger.info("执行ShiroRealm认证");

        // 获取用户输入的用户名
        String inputAccount = (String) token.getPrincipal();

        // 查询数据库用户信息 不存在返回
        SysUser user = sysUserService.getOne(
                Wrappers.<SysUser>lambdaQuery().eq(SysUser::getAccount, inputAccount)
        );
        if (user == null) { return null; }

        // 用户是否锁定
        String dbPassword = user.getLoginPassword();
        String dbSalt = user.getSalt();
        Integer locked = user.getLocked();
        if (UserConstant.LOCK.equals(locked)) {
            throw new LockedAccountException();
        }

        ByteSource credentialsSalt = ByteSource.Util.bytes(dbSalt);
        return new SimpleAuthenticationInfo(user, dbPassword, credentialsSalt, getName());
    }

    /**
     * 重写加密匹配器
     */
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        ShiroCredentialsMatcher shiroCredentialsMatcher = new ShiroCredentialsMatcher();
        super.setCredentialsMatcher(shiroCredentialsMatcher);
    }
}
