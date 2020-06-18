package com.ruanyangyang.demo.controller;

import com.ruanyangyang.demo.common.annotation.OperationLog;
import com.ruanyangyang.demo.entity.Result;
import com.ruanyangyang.demo.entity.dto.TestDTO;
import com.ruanyangyang.demo.entity.pojo.SysUser;
import com.ruanyangyang.demo.service.SysUserService;
import io.swagger.annotations.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.ruanyangyang.demo.entity.ResultCode.*;

@RestController
@RequestMapping
@Api(tags = {"测试模块"})
@CrossOrigin(origins = "*", maxAge = 3600)
public class TestController extends BaseController{
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation(value="测试接口", notes="测试接口")
    @RequestMapping(path = "/test", method = RequestMethod.POST)
    @OperationLog(module = "测试模块", method = "测试方法")
    public Result<TestDTO> test(@RequestBody TestDTO dto) {
        log.info(dto.toString());
        return Result.ok(dto);
    }

    @ApiOperation(value="测试登录接口", notes="测试登录接口")
    @RequestMapping(path = "/login", method = RequestMethod.GET)
    @OperationLog(module = "测试登录接口", method = "测试登录接口")
    public Result<String> login(@RequestParam String loginName, @RequestParam String loginPwd) {

        //封装用户登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(loginName, loginPwd);

        try{
            SecurityUtils.getSubject().login(token);
        }catch (UnknownAccountException e){
            return Result.error(ERR_WRONG_ACCOUNT);
        }catch (LockedAccountException e){
            return Result.error(ERR_LOCKED_USER);
        }catch (IncorrectCredentialsException e){
            return Result.error(ERR_WRONG_PASSWORD);
        }

        return Result.ok();
    }

    @ApiOperation(value="测试登出接口", notes="测试登出接口")
    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    @OperationLog(module = "测试登出接口", method = "测试登出接口")
    public Result<String> logout() {
        logger.info("Logout 进入");

        return Result.ok();
    }

    @ApiOperation(value="测试登录接口", notes="测试登录接口")
    @RequestMapping(path = "/unauthorized", method = RequestMethod.GET)
    @OperationLog(module = "测试登出接口", method = "测试登出接口")
    public Result<String> unauthorized() {
        logger.info("Unauthorized 进入");

        return Result.ok();
    }

    @ApiOperation(value="测试用户注册接口", notes="测试用户注册接口")
    @RequestMapping(path = "/register", method = RequestMethod.GET)
    @OperationLog(module = "测试登出接口", method = "测试登出接口")
    public Result<String> register(@RequestParam String userName, @RequestParam String password, @RequestParam String salt) {
        logger.info("Unauthorized 进入");

        SimpleHash simpleHash = new SimpleHash("MD5", password, ByteSource.Util.bytes(salt), 2);

        SysUser sysUser = new SysUser();
        sysUser.setAccount(userName);
        sysUser.setLoginPassword(simpleHash.toString());
        sysUser.setSalt(salt);
        boolean save = sysUserService.save(sysUser);

        if (Boolean.FALSE.equals(save)) {
            return Result.error(ERR);
        }
        return Result.ok();
    }
}
