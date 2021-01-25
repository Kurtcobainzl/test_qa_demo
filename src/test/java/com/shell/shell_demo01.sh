#!/usr/bin/env bash
# ide拯救全人类
#echo "hello world" #hello world

my_name="kurt"  #不能加空格，加了空格就报错了...
#echo $my_name  #kurt
#mkdir /Users/kurt/Downloads/comdemoqa/src/test/java/com/shell/A

i=10
j=12
k=$(($i+$j))



printf "%s \n"   hellooooooooooooooohellooooooooooooooo
#echo $i+$j   #10+12
#echo $k     #22
#echo today is `date "+%Y-%m-%d"`

#for k in $(seq 1 10)
#    do
##        mkdir  /Users/kurt/Downloads/custom${k}/${k}
#        mkdir -p /Users/kurt/Downloads/custom${k}/${k}
#    done
#

#mkdir /Users/kurt/Downloads/comdemoqa/aaa   #在绝对路径创建文件夹


#printf "%d %s \n" 100 "hello"   #100 hello

#printf "%-10s %-2s %-4s\n"  姓名 性别 体重
#printf "%-10s %-2s %-4.2f\n" cobainnnnn 男 62
#printf "%-10s %-2s %-4.2f\n" kurt 男 62.321
#printf "%-10s %-2s %-4.2f\n" 骆驼祥子 男 62.128
#printf "%-10s %-2s %-4.2f\n" 柯妮 女 52.25

#num1=100
#num2=1001
#if test ${num1} -eq ${num2};
# then
#echo "equal"
#    else
#    echo "no equal"
#fi


#num=101
#filePath=/Users/kurt/Downloads/custom1112
#if  [[ -e ${filePath} ]] && [[ ${num} -ge 100 ]]
# then
#    echo "已经存在"
# else
#    echo "不存在 且 数值小于100"
# fi


#if   [[ a -eq 10 ]] &&  [[ b -eq 12 ]]
# then
#    echo "相等"
#    else
#    echo "不相等"
#fi






#if [[ a<c ]] && [[ b<c ]]
#    then
#    echo "succ--"
#
#fi
b=12
a=13
c=100

#if ((a<c)) && ((b<c))
#    then
#    echo "succ1"
#
#fi

#if [[ a < c ]] && [[ b < c ]]
#    then
#    echo "succ--"
#    else
#    echo "error--"
#
#fi


#if [[ ${a} -lt ${c} ]] && [[ ${b} -lt ${c} ]]
#    then
#    echo "succ--"
#    else
#    echo "error--"
#
#fi


if [ $a -lt $c -a $b -lt $c ]
    then
    echo "succ----"
    else
    echo "error--"
fi






























