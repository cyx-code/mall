package com.cyx.mall.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.cyx.mall.common.utils.R;
import com.cyx.mall.service.IRedisService;
import com.cyx.mall.service.IUmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @description: 会员管理Service实现类
 * @author: cyx
 * @create: 2020/07/31
 */
@Service
public class UmsMemberServiceImpl implements IUmsMemberService {

    @Autowired
    private IRedisService redisService;


    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;

    @Value("${redis.key.expire.authCode}")
    private long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    public R generateAuthCode(String phone) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(RandomUtil.randomInt(10));
        }
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + phone, sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + phone, AUTH_CODE_EXPIRE_SECONDS);
        return R.success("获取验证码成功", sb.toString());
    }

    @Override
    public R verifyAuthCode(String phone, String code) {
        if (StrUtil.isBlank(code)) {
            return R.error("请输入验证码");
        }
        String authCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + phone);
        return code.equals(authCode) ? R.success("验证码校验成功") : R.error("验证码错误");
    }
}
