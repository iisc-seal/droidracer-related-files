#!/bin/bash

echo "ABC run completed at " >> <path-to-eclipse-workspace>/ModelCheckingServer/abcError.log
date >> <path-to-eclipse-workspace>/ModelCheckingServer/abcError.log

<path-to-adb-tool>/adb -s emulator-${17} shell am force-stop ${16}

#race detection summary stats
echo "" >> <path-to-eclipse-workspace>/ModelCheckingServer/pldi-race.log
echo "#traces collected: " $1  >> <path-to-eclipse-workspace>/ModelCheckingServer/pldi-race.log
echo "avg. trace generation time (sec): " $8 >> <path-to-eclipse-workspace>/ModelCheckingServer/pldi-race.log
echo "avg. race detection time (sec): " $9 >> <path-to-eclipse-workspace>/ModelCheckingServer/pldi-race.log
echo "avg. trace length: " $2 >> <path-to-eclipse-workspace>/ModelCheckingServer/pldi-race.log
echo "avg. thread count: " $3  >> <path-to-eclipse-workspace>/ModelCheckingServer/pldi-race.log
echo "avg. threads with MQ: " $4 >> <path-to-eclipse-workspace>/ModelCheckingServer/pldi-race.log
echo "avg. async-blocks count: " $5 >> <path-to-eclipse-workspace>/ModelCheckingServer/pldi-race.log
echo "avg. event sequence depth: " $6 >> <path-to-eclipse-workspace>/ModelCheckingServer/pldi-race.log
echo "avg. app fields: " $7 >> <path-to-eclipse-workspace>/ModelCheckingServer/pldi-race.log
echo "total no. of multi-threaded races detected: " ${10} >> <path-to-eclipse-workspace>/ModelCheckingServer/pldi-race.log
echo "total no. of async races detected: " ${11} >> <path-to-eclipse-workspace>/ModelCheckingServer/pldi-race.log
echo "total no. of delay-post races detected: " ${12} >> <path-to-eclipse-workspace>/ModelCheckingServer/pldi-race.log
echo "total no. of cross-post races detected: " ${13} >> <path-to-eclipse-workspace>/ModelCheckingServer/pldi-race.log
echo "total no. of co-enabled UI widget races detected: " ${14} >> <path-to-eclipse-workspace>/ModelCheckingServer/pldi-race.log
echo "total no. of co-enabled non-UI widget races detected: " ${15} >> <path-to-eclipse-workspace>/ModelCheckingServer/pldi-race.log

echo "" >> <path-to-eclipse-workspace>/ModelCheckingServer/pldi-race.log
