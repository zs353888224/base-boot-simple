#!/bin/bash
cd /home/ec2-user/project/
java -jar build/libs/sss-SNAPSHOT.jar > /dev/null 2>&1 &
echo $! > tpid
echo Start Success!