#!/usr/bin/env bash


#####注意！！！！不能起变量名叫 PATH
#####当用PATH这个变量的时候，系统会自动的覆盖掉PATH环境变量，所以
#我们的命令也就没有办法使用了
#path=$(pwd)
#echo ${path}
#path=${path}/A.txt
#echo ${path}
#touch   ${path}
#touch   这个文件就在当前文件夹中产生.txt
#cat ${path}

#
#touch a.txt         #创建文件夹
#mv a.txt b.txt      #更改文件名 a.txt 为 b.txt
#mkdir mycache       #创建文件夹
#cd ./mycache/
#touch c.txt         #创建文件
#cd ../              #返回上一层
#mv mycache/  logs   # 将mycache 目录放入 logs 目录中，如果没有，则将mycache 更名为logs


#
#touch a.txt         #创建文件夹
#mv a.txt b.txt      #更改文件名 a.txt 为 b.txt
#mkdir mycache       #创建文件夹
#mkdir logs       #创建文件夹
#cd ./mycache/
#touch c.txt         #创建文件
#cd ../              #返回上一层
#pwd
#mv ./mycache/*  logs/   # 将mycache 目录中的内容放入 logs 目录中，如果没有，则将mycache 更名为logs
##

#cat demo.sh      # 查看文件内容










echo "hello"
ps -a


