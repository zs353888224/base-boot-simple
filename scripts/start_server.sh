#!/usr/bin/env bash
cd $BASH_EXECUTION_STRING
cd ..
gradle -info bootRun -Penv=dev