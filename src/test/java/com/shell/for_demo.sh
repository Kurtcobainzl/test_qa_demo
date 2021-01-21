#!/usr/bin/env bash

mkdir shellcache
for file in `ls`
do
    echo $file
#    mv $file  shellcache/   不要执行。这句把当前目录所有的文件都copy到另一个文件夹中了
done
