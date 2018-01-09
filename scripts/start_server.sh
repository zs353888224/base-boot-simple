#!/usr/bin/env bash
s=$BASH_EXECUTION_STRING
n=${s%/scripts/start_server.sh}
cd ${n}
nohup gradle -info bootRun -Penv=dev &