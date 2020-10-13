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

    /**
     * 正则表达式验证手机号
     */
    @Test
    public void test2() {
        /**
         * 手机号码规则
         * 1.长度为11位, 全部是纯数字
         * 2.第2位是3/5/7/8/9
         */
        String phone = "18227680217";
        String regex = "[1][35789]\\d{9}";
        boolean flag = phone.matches(regex);
        System.out.println(flag ? "手机号码格式完全正确！" : "手机号码格式不正确!");
    }

    /**
     * 正则表达式常用匹配规则
     */
    @Test
    public void test3() {
        /**
         * [0-9]: 纯数字, 等价于\d
         * \w: 单词字符, 等价于[0-9a-zA-Z]
         * .: 代表任意字符
         * 量词: 指定某个整体出现的数量
         * X{n}: X, 恰好出现n次
         * X{n,}: X, 至少出现n次
         * X{n,m}: X, 至少出现n次, 但是不超过m次
         */
    }

    /**
     * 字符串的切割
     */
    @Test
    public void test4() {
        String nameString = "Aaron.Lucien.Evelyn.Bob";
        //切割的时候, 建议在正则符号前添加"\\"
        String[] strings = nameString.split("\\.");
        for (String string : strings) {
            System.out.println(string);
        }
    }

    /**
     * 字符串的替换
     */
    @Test
    public void test5() {
        String comment = "联系电话:13541183398";
        String newComment = comment.replaceAll("1[35789]\\d{9}", "18227680217");
        System.out.println(newComment);
    }

}
