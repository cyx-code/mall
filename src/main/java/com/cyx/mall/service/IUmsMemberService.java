package com.cyx.mall.service;

import com.cyx.mall.common.utils.R;

/**
 * @description: 会员管理
 * @author: cyx
 * @create: 2020/07/31
 */
public interface IUmsMemberService {

    /**
     * @Author: cyx
     * @Description: 生成验证码
     * @Date: 2020-07-31
     * @param: phone
     * @return: com.cyx.mall.common.utils.R
     */
    R generateAuthCode(String phone);

    /**
     * @Author: cyx
     * @Description: 校验验证码
     * @Date: 2020-07-31
     * @param: phone
     * @param: code
     * @return: com.cyx.mall.common.utils.R
     */
    R verifyAuthCode(String phone, String code);
}
