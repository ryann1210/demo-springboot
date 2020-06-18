package com.ruanyangyang.demo.config.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.SimpleHash;

public class ShiroCredentialsMatcher extends SimpleCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {

        // 获取用户输入密码
        String inputPassword = String.valueOf((char[]) token.getCredentials());

        // 进行加密（加密类型 密码 盐 加密次数）
        SimpleAuthenticationInfo simpleAuthenticationInfo = (SimpleAuthenticationInfo) info;
        String salt = new String(simpleAuthenticationInfo.getCredentialsSalt().getBytes());

        Object tokenCredentials = new SimpleHash("md5", inputPassword, salt, 2).toHex();

        // 数据库密文密码
        Object accountCredentials = getCredentials(info);

        // 内容一致就返回true 不一致就返回false
        return equals(tokenCredentials, accountCredentials);
    }
}
