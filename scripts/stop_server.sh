#!/bin/bash
isExistApp=`pgrep java`
if [[ -n  ${isExistApp} ]]; then
   killall java
fi