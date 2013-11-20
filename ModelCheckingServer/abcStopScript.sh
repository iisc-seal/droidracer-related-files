#!/bin/bash

echo "ABC run completed at " >> /home/pallavi/eclipse_workspace/ModelCheckingServer/abcError.log
date >> /home/pallavi/eclipse_workspace/ModelCheckingServer/abcError.log

/home/pallavi/adt-bundle-linux-x86_64-20130911/sdk/platform-tools/adb -s emulator-5554 shell am force-stop ${16}

#race detection summary stats
echo "" >> /home/pallavi/eclipse_workspace/ModelCheckingServer/pldi-race.log
echo "#traces collected: " $1  >> /home/pallavi/eclipse_workspace/ModelCheckingServer/pldi-race.log
echo "avg. trace generation time (sec): " $8 >> /home/pallavi/eclipse_workspace/ModelCheckingServer/pldi-race.log
echo "avg. race detection time (sec): " $9 >> /home/pallavi/eclipse_workspace/ModelCheckingServer/pldi-race.log
echo "avg. trace length: " $2 >> /home/pallavi/eclipse_workspace/ModelCheckingServer/pldi-race.log
echo "avg. thread count: " $3  >> /home/pallavi/eclipse_workspace/ModelCheckingServer/pldi-race.log
echo "avg. threads with MQ: " $4 >> /home/pallavi/eclipse_workspace/ModelCheckingServer/pldi-race.log
echo "avg. async-blocks count: " $5 >> /home/pallavi/eclipse_workspace/ModelCheckingServer/pldi-race.log
echo "avg. event sequence depth: " $6 >> /home/pallavi/eclipse_workspace/ModelCheckingServer/pldi-race.log
echo "avg. app fields: " $7 >> /home/pallavi/eclipse_workspace/ModelCheckingServer/pldi-race.log
echo "total no. of multi-threaded races detected: " ${10} >> /home/pallavi/eclipse_workspace/ModelCheckingServer/pldi-race.log
echo "total no. of async races detected: " ${11} >> /home/pallavi/eclipse_workspace/ModelCheckingServer/pldi-race.log
echo "total no. of delay-post races detected: " ${12} >> /home/pallavi/eclipse_workspace/ModelCheckingServer/pldi-race.log
echo "total no. of cross-post races detected: " ${13} >> /home/pallavi/eclipse_workspace/ModelCheckingServer/pldi-race.log
echo "total no. of co-enabled UI widget races detected: " ${14} >> /home/pallavi/eclipse_workspace/ModelCheckingServer/pldi-race.log
echo "total no. of co-enabled non-UI widget races detected: " ${15} >> /home/pallavi/eclipse_workspace/ModelCheckingServer/pldi-race.log

echo "" >> /home/pallavi/eclipse_workspace/ModelCheckingServer/pldi-race.log