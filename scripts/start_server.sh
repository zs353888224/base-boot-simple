#!/usr/bin/env bash
s = $BASH_EXECUTION_STRING
n = ${s%start_server.sh}
cd n
gradle -info bootRun -Penv=dev