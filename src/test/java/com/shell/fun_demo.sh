#!/usr/bin/env bash
stringdex(){
echo  $1
}
#stringdex "hello world"



strindex1() {
  x="${1%%$2*}"
  [[ $x = $1 ]] && echo -1 || echo ${#x}
}

strindex1 "hello"  "l"

