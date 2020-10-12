package com.java;

import org.junit.Test;

/**
 * Description:	   <br/>
 * Date:     2020/10/12 11:13 <br/>
 *
 * @author Aaron CHEN
 * @see
 */
public class test {
    /**
     * 传统方式验证手机号
     */
    @Test
    public void test1() {
        String phone = "12345678910";
        /**
         * 手机号码规则
         * 1.长度为11位, 全部是纯数字
         * 2.第2位是3/5/7/8/9
         */
        int length = phone.length();
        boolean flag = true;
        if (length == 11) {
            if (phone.startsWith("13") || phone.startsWith("15") || phone.startsWith("17") || phone.startsWith("18") || phone.startsWith("19")) {
                char[] chars = phone.toCharArray();
                for (int i = 2; i < chars.length; i++) {
                    if (!('0' <= chars[i] && chars[i] <= '9')) {
                        System.out.println("3-----手机号码格式不对!");
                        flag = false;
                        break;
                    }
                }
            } else {
                flag = false;
                System.out.println("2-----手机号码格式不对!");
            }
        } else {
            flag = false;
            System.out.println("1-----手机号码格式不对!");
        }
        if (flag) {
            System.out.println("手机号码格式完全正确!");
        } else {
            System.out.println("手机号码格式不正确!");
        }
    }

}
