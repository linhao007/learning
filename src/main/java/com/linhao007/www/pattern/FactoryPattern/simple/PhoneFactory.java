package com.linhao007.www.pattern.FactoryPattern.simple;

import com.linhao007.www.pattern.FactoryPattern.simple.impl.ApplePhone;
import com.linhao007.www.pattern.FactoryPattern.simple.impl.MiPhone;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/3/11 10:37
 * @description:
 */
public class PhoneFactory {
    /**
     * 根据手机类型  创建相应的制造商
     *
     * @param phoneType
     * @return
     */
    public Phone getMatchePhone(int phoneType) {
        Phone phone = null;
        switch (phoneType) {
            case 0:
                phone = new MiPhone();
                break;
            case 1:
                phone = new ApplePhone();
                break;
            default:
        }
        return phone;
    }
}
