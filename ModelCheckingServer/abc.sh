#!/bin/bash

/home/pallavi/adt-bundle-linux-x86_64-20130911/sdk/platform-tools/adb -s emulator-5554 pull /data/data/$1/databases/abc.db /home/pallavi/eclipse_workspace/ModelCheckingServer/
/home/pallavi/adt-bundle-linux-x86_64-20130911/sdk/platform-tools/adb -s emulator-5554 pull /data/data/$1/databases/abc.db-journal /home/pallavi/eclipse_workspace/ModelCheckingServer/
/home/pallavi/adt-bundle-linux-x86_64-20130911/sdk/platform-tools/adb -s emulator-5554 pull /data/data/$1/abc_log.txt /home/pallavi/eclipse_workspace/ModelCheckingServer/
sleep 60
#/home/pallavi/adt-bundle-linux-x86_64-20130911/sdk/platform-tools/adb -s emulator-5554 uninstall $1
#/home/pallavi/adt-bundle-linux-x86_64-20130911/sdk/platform-tools/adb -s emulator-5554 install $2
#/home/pallavi/adt-bundle-linux-x86_64-20130911/sdk/platform-tools/adb -s emulator-5554 shell ps | grep $1 | awk '{print $2}' | xargs /home/pallavi/adt-bundle-linux-x86_64-20130911/sdk/platform-tools/adb shell kill
/home/pallavi/adt-bundle-linux-x86_64-20130911/sdk/platform-tools/adb -s emulator-5554 shell am force-stop $1
/home/pallavi/adt-bundle-linux-x86_64-20130911/sdk/platform-tools/adb -s emulator-5554 shell rm /data/data/$1/abc_log.txt
#/home/pallavi/adt-bundle-linux-x86_64-20130911/sdk/platform-tools/adb -s emulator-5554 shell pm clear $1
#/home/pallavi/adt-bundle-linux-x86_64-20130911/sdk/platform-tools/adb -s emulator-5554 shell mkdir /data/data/$1/databases
#/home/pallavi/adt-bundle-linux-x86_64-20130911/sdk/platform-tools/adb -s emulator-5554 push /home/pallavi/eclipse_workspace/ModelCheckingServer/abc.db  /data/data/$1/databases/
#/home/pallavi/adt-bundle-linux-x86_64-20130911/sdk/platform-tools/adb -s emulator-5554 push /home/pallavi/eclipse_workspace/ModelCheckingServer/abc.db-journal /data/data/$1/databases/
/home/pallavi/adt-bundle-linux-x86_64-20130911/sdk/platform-tools/adb -s emulator-5554 shell am force-stop abc.abcclientapp

if [ $5 -eq 1 ];
then
    echo "error detected at sequence "  $4  " at " >> /home/pallavi/eclipse_workspace/ModelCheckingServer/abcError.log
    date >> /home/pallavi/eclipse_workspace/ModelCheckingServer/abcError.log
    echo "" >> /home/pallavi/eclipse_workspace/ModelCheckingServer/abcError.log
else
#	/home/pallavi/adt-bundle-linux-x86_64-20130911/sdk/platform-tools/adb -s emulator-5554 shell am start -a android.intent.action.MAIN -n $3
	echo "model-checking run " $4 " completed at " >> /home/pallavi/eclipse_workspace/ModelCheckingServer/abcError.log
	date >> /home/pallavi/eclipse_workspace/ModelCheckingServer/abcError.log
    echo "" >> /home/pallavi/eclipse_workspace/ModelCheckingServer/abcError.log
fi

# log race detection statistics
echo "traceTime:" $6 "s raceTime:" $7 "s #trace:" $8 " #thread:" $9 " #mq:" ${10} " #async:" ${11} " #event-depth:" ${12} " #field:" ${13} " #multi-thread-races:" ${14} \
         " #asyncRaces:" ${15} " #delay-races:" ${16} " #cross-post-races:" ${17} " #co-enabled-uiRaces:" ${18} \
         " co-enabled-non-ui-races:" ${19} >> /home/pallavi/eclipse_workspace/ModelCheckingServer/pldi-race.log
echo "" >> /home/pallavi/eclipse_workspace/ModelCheckingServer/pldi-race.log

# restart app for next run
/home/pallavi/adt-bundle-linux-x86_64-20130911/sdk/platform-tools/adb -s emulator-5554 shell am start -a android.intent.action.MAIN -n $3

cp /home/pallavi/eclipse_workspace/ModelCheckingServer/abc.db /home/pallavi/eclipse_workspace/ModelCheckingServer/backupDatabase/abc.db$4
cp /home/pallavi/eclipse_workspace/ModelCheckingServer/abc.db-journal /home/pallavi/eclipse_workspace/ModelCheckingServer/backupDatabase/abc.db-journal$4
cp /home/pallavi/eclipse_workspace/ModelCheckingServer/abc_log.txt /home/pallavi/eclipse_workspace/ModelCheckingServer/backupDatabase/abc_log.txt$4
#sleep 10
#rm /home/pallavi/eclipse_workspace/ModelCheckingServer/abc.db
#rm /home/pallavi/eclipse_workspace/ModelCheckingServer/abc.db-journal
#rm /home/pallavi/eclipse_workspace/ModelCheckingServer/abc_log.txt
