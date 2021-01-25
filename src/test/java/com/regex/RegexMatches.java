package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {


    public static void main(String[] args) {
        // 按指定模式在字符串查找
        String content = "";
        String pattern = "";
//        content = "abcaa";
//        pattern = "^(abc)(a){2}$";
//
//
//        //[]匹配字符组内的字符
//        content = "abc@hx.com";
//        pattern = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]{2,}$";


        //()匹配小括号内的字符串，可以是一个，也可以是多个
//        content = "a-zA-Z0-9a-zA-Z0-9@hx.com";
//        pattern = "^(a-zA-Z0-9)+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]{2,}$";

        //^ 限制开头  $限制结尾
//        content = "a-za-zA-Za-zA-ZA-Z@hx.com";
//        pattern = "^(a-z|A-Z)+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]{2,}$";


        content = "dododo";
        pattern = "^(do){1,}$";

        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println(isMatch);
        patternMatcher();
    }


    public static void patternMatcher() {
        String str = "baidu@baidu.com     qsbaidu@baidu.com     qsbaidu@baidu.com     qs";
        String rex = "[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]{2,}\\.[a-zA-Z0-9_-]{2,}\\b";
        Pattern pattern1 = Pattern.compile(rex);
        Matcher matcher = pattern1.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
