#!/usr/bin/env bash
readonly val=hello
echo $val

#val=world  报错  只读
#unset val   报错 无法重置 只读常量

var=what
echo ${#var}
unset var
echo ${#var}    #打印字符串的长度
