#!/bin/bash

date > <path-to-eclipse-workspace>/ModelCheckingServer/abcError.log
echo "" >> <path-to-eclipse-workspace>/ModelCheckingServer/abcError.log
<path-to-adb-tool>/adb -s emulator-$2 shell am start -a android.intent.action.MAIN -n $1
