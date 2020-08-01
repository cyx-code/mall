package com.cyx.mall.controller;

import cn.hutool.core.util.StrUtil;
import com.cyx.mall.common.utils.R;
import com.cyx.mall.service.IUmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 会员登录注册管理Controller
 * @author: cyx
 * @create: 2020/07/31
 */
@Api(tags = "UmsMemberController", description = "会员登录注册管理")
@RestController
@RequestMapping("/sso")
public class UmsMemberController {

    @Autowired
    private IUmsMemberService umsMemberService;

    @ApiOperation("获取验证码")
    @GetMapping("/getAuthCode")
    public R getAuthCode(String phone) {
        if (StrUtil.isBlank(phone)) {
            return R.error("电话号码不能为空");
        }
        return umsMemberService.generateAuthCode(phone);
    }

    @ApiOperation("校验验证码")
    @PostMapping("/verifyAuthCode")
    public R verifyAuthCode(String phone, String code) {
        if (StrUtil.isBlank(phone)) {
            return R.error("电话号码不能为空");
        }
        return umsMemberService.verifyAuthCode(phone, code);
    }
}
