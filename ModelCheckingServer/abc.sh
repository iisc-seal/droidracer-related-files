#!/bin/bash

<path-to-adb-tool>/adb -s emulator-${20} pull /data/data/$1/databases/abc.db  <path-to-eclipse-workspace>/ModelCheckingServer/
<path-to-adb-tool>/adb -s emulator-${20} pull /data/data/$1/databases/abc.db-journal  <path-to-eclipse-workspace>/ModelCheckingServer/
<path-to-adb-tool>/adb -s emulator-${20} pull /data/data/$1/abc_log.txt  <path-to-eclipse-workspace>/ModelCheckingServer/

#wait till abc_log.txt is entirely copied
sleep 60  

<path-to-adb-tool>/adb -s emulator-${20} shell am force-stop $1
<path-to-adb-tool>/adb -s emulator-${20} shell rm /data/data/$1/abc_log.txt
<path-to-adb-tool>/adb -s emulator-${20} shell pm clear $1
<path-to-adb-tool>/adb -s emulator-${20} shell mkdir /data/data/$1/databases
<path-to-adb-tool>/adb -s emulator-${20} push <path-to-eclipse-workspace>/ModelCheckingServer/abc.db  /data/data/$1/databases/
<path-to-adb-tool>/adb -s emulator-${20} push <path-to-eclipse-workspace>/ModelCheckingServer/abc.db-journal /data/data/$1/databases/
<path-to-adb-tool>/adb -s emulator-${20} shell am force-stop abc.abcclientapp

if [ $5 -eq 1 ];
then
    echo "error detected at sequence "  $4  " at " >> <path-to-eclipse-workspace>/ModelCheckingServer/abcError.log
    date >> <path-to-eclipse-workspace>/ModelCheckingServer/abcError.log
    echo "" >> <path-to-eclipse-workspace>/ModelCheckingServer/abcError.log
else
    echo "model-checking run " $4 " completed at " >> <path-to-eclipse-workspace>/ModelCheckingServer/abcError.log
    date >> <path-to-eclipse-workspace>/ModelCheckingServer/abcError.log
    echo "" >> <path-to-eclipse-workspace>/ModelCheckingServer/abcError.log
fi

# log race detection statistics
echo "traceTime:" $6 "s raceTime:" $7 "s #trace:" $8 " #thread:" $9 " #mq:" ${10} " #async:" ${11} " #event-depth:" ${12} " #field:" ${13} " #multi-thread-races:" ${14} \
         " #asyncRaces:" ${15} " #delay-races:" ${16} " #cross-post-races:" ${17} " #co-enabled-uiRaces:" ${18} \
         " co-enabled-non-ui-races:" ${19} >> <path-to-eclipse-workspace>/ModelCheckingServer/pldi-race.log
echo "" >> <path-to-eclipse-workspace>/ModelCheckingServer/pldi-race.log

# restart app for next run
<path-to-adb-tool>/adb -s emulator-${20} shell am start -a android.intent.action.MAIN -n $3

cp <path-to-eclipse-workspace>/ModelCheckingServer/abc.db <path-to-eclipse-workspace>/ModelCheckingServer/backupDatabase/abc.db$4
cp <path-to-eclipse-workspace>/ModelCheckingServer/abc.db-journal <path-to-eclipse-workspace>/ModelCheckingServer/backupDatabase/abc.db-journal$4
cp <path-to-eclipse-workspace>/ModelCheckingServer/abc_log.txt <path-to-eclipse-workspace>/ModelCheckingServer/backupDatabase/abc_log.txt$4

