#!/bin/bash

date > /home/pallavi/eclipse_workspace/ModelCheckingServer/abcError.log
echo "" >> /home/pallavi/eclipse_workspace/ModelCheckingServer/abcError.log
/home/pallavi/adt-bundle-linux-x86_64-20130911/sdk/platform-tools/adb -s emulator-5554 shell am start -a android.intent.action.MAIN -n $1
