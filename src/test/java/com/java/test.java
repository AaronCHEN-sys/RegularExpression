package com.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    /**
     * 字符串的替换之去掉叠词
     */
    @Test
    public void test6() {
        String comment = "联系电话:13541183398";
        //叠词规则: 多个字符挨在一起, 并且字符相同
        //使用(模块): 形成一个组, 组有组编号
        String regex = "(.)\\1+";
        String newComment = comment.replaceAll(regex, "$1");
        System.out.println(newComment);
    }

    /**
     * 作业1讲解
     */
    @Test
    public void test7() {
        String string = "许立成：我...我我...我...喜喜...喜...喜.喜.....欢欢...欢...编...编编...程程...程程";
        //1.使用替换: 将"."替换成""
        String string1 = string.replaceAll("\\.+", "");
        //2.去叠词
        String string2 = string1.replaceAll("(.)\\1+", "$1");
        System.out.println(string2);
    }

    /**
     * 作业2讲解
     */
    @Test
    public void test8() {
        /**
         * 模块1@模块2模块3
         * 模块1: 可以为数字、字母、下划线、长度3-12位
         * 模块2: 要么纯数字、要么纯字母、长度2-6位
         * 模块3: .com, 可以出现的次数为1-3
         */
        String email = "Aaron.chen07@outlook.com";

        String regex1 = "[0-9a-zA-z.]{3,12}@[a-zA-Z]{2,7}(\\.[a-zA-Z]{2,3}){1,3}";
        String regex2 = "[0-9a-zA-z.]{3,12}(\\.[a-zA-Z]{2,3}){1,3}";

        String regex = "[0-9a-zA-z.]{3,12}@([a-zA-Z]{2,7}|@\\d{2,7})(\\.[a-zA-Z]{2,3}){1,3}";

        boolean flag1 = email.matches(regex1) || email.matches(regex2);
        boolean flag2 = email.matches(regex);

        System.out.println(flag1 ? "格式正确!" : "格式不正确!");
        System.out.println(flag2 ? "格式正确!" : "格式不正确!");
    }

    /**
     * 正则拔高
     * IP地址: A.B.C.D
     * A-D的取值范围是1~255
     * 对IP地址归类
     * 102.254.38.12
     * 11.12.122.25
     * 123.123.45.12
     * 1.12.122.25
     */
    @Test
    public void test9() {
        String ipStrings = "102.254.38.12,11.12.122.25,123.123.45.12,1.12.122.25";
        //0.将每个IP地址中的位数前添加两个0
        ipStrings = ipStrings.replaceAll("(\\d{1,3})", "00$1");
        ipStrings = ipStrings.replaceAll("0+(\\d{3})", "$1");
        //1.切割
        String[] split = ipStrings.split("\\,");
        //2.创建HashSet集合，存放字符串
        Set<String> ipSet = new TreeSet<>();
        for (String s : split) {
            ipSet.add(s);
        }
        List<String> ipList = new ArrayList<>();
        for (String s : ipSet) {
            String temp = s.replaceAll("0*([1-9]{1,3})", "$1");
            ipList.add(temp);
        }
        ipList.forEach(ip -> System.out.println(ip));
    }

    /**
     * 校验身份证：
     * 1.长度为18位
     * 2.前面17位必须为纯数字
     * 3.最后一位可以为X，也可以为数字
     * 4.不用校验出生日期等
     */
    @Test
    public void test10() throws ParseException {
        String regex = "\\d{17}[0-9X]";
        String id = "510184202010205573";
        /**
         * 校验身份证出生日期
         * 1.出生日期不能大于当前日期
         * 2.年份不能太大
         */
        long currentTime = System.currentTimeMillis();
        String substring = id.substring(6, 14);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date parse = sdf.parse(substring);
        long time = parse.getTime();
        long cha = currentTime - time;
        boolean flag = id.matches(regex);
        if (flag) {
            if (cha < 0) {
                System.out.println("出生日期不正确!");
            } else {
                System.out.println("格式正确!");
            }
        } else {
            System.out.println("格式不正确!");
        }
    }

    /**
     * 校验QQ号码：
     * 1.长度为5-12位
     * 2.必须为纯数字
     * 3.第一个数字不能够为0
     */
    @Test
    public void test11() {
        String qq = "1070791642";
        String regex = "[1-9]\\d{4,11}";
        boolean flag = qq.matches(regex);
        System.out.println(flag ? "格式正确!" : "格式不正确!");
    }
}

