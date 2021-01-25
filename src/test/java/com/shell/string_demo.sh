#!/usr/bin/env bash
echo hello

str1=你好
str2=world

pwd

#字符串拼接

#val=$str1$str2              #这种写法不能有空格隔开。
#echo $val
#val=${str1}world${str2}     #你好world
#echo $val                   #你好worldworld
#val="$str1 hello  $str2"    #被双引号括起来 可以有空格等其他字符
#echo $val                   #你好 hello world
#val=$str1"what???好..."$str2
#echo $val                   #你好what???好...world
#val=http://www.${str1}/${str2}.com
#echo $val                   #http://www.你好/world.com


#字符串截取
val=http://www.baidu.com
#echo ${val#*.}   #从左边开始删除 第一个 . 以及它左边的字符
#echo ${val##*.}  #从左边开始删除最后一个 . 以及它左边的字符

val=http://www.baidu/index.com

#echo ${val%/*}    #从右边开始删除第一个 /以及它右边的字符
#echo ${val%%/*}   #从右边开始删除最后一个 / 以及它右边的字符
#
#echo ${val:1:3}   #截取字符串 闭区间
#echo ${val:3}     #截取字符串 从左边第3个字符开始，直到结束

#echo ${val:0-7:3}   # 从右边第几个字符开始，及字符的个数
#echo ${val:0-7}      #从右边第几个字符开始，一直到结束。















