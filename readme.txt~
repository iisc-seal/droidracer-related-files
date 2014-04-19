The files in this folder correspond to the testing runs
by DroidRacer on the following apps done for the paper
"Race Detection for Android Applications", PLDI 2014
apps: Aarddict, Browser, FBReader, K-9 Msil, Messenger,
Music, MyTracks, OpenSudoku, SGTPuzzles, Tomdroid, 
Adobe Reader, Facebook, Flipkart, Remind Me, Twitter

(1) In each of the analysed apps folder (except propreitary apps)
you can find race analysis notes for each of reported race
in file tp-fp-analysis.txt. If an explanation is not found for
a race check for its equivalent in a tp-fp-analysis.old<n>.txt
file and also follow its corresponding trace.

**Please note that for some of the races instead of writing an
explanation in any of the tp-fp-analysis text file I might have
written refer note-book page n ID m...I have not shifted these
notes to txt file due to lack of time. If you need to check its 
validity and are unable to reproduce a true-postive by following
the trace, you could mail me for the same @ pallavi.maiya@csa.iisc.ernet.in

(2) .db, .db-journal, pldi-log.txt and abc_log.txt files indicate the 
DroidRacer generated files for runs leading to the reported racey run
for the app. The number in the file name corresponds to the test run
number (1: first run, 2: second run and so on..)


(3) To reproduce these runs, 
(i) clone droidRacer repository from https://bitbucket.org/hppulse/droidracer 
(ii) Switch to the branch pldi-2014
(iii) Build DroidRacer as per instructions given in readme-droidRacer.txt
(iv) Before running DroidRacer on each of the above apps do initializations 
and follow instructions given in events-<n>.txt inside folder corresponding to
each app.
(v) During the run a few logs get printed on the screen and also stored to 
abc_log.txt. But during race detection stage DroidRacer does not report any 
progress till this is completed. The race detection time can vary anywhere
between a couple of seconds to hours. Do not terminate the emulator in this stage.
(vi) During a DroidRacer run (before Race Detection phase starts) if 
"Application Not Responding" dialog is shown click on the "WAIT" button
so that app is not killed. ANR gets displayed as DroidRacer does file read-write
from main thread in some places.


(4) Only Tomdroid app source has been provided as a sample in sample-app folder.
For the other apps app-version-info.txt contains version of the app used for 
procuring results for "Race Detection for Android Applications" paper.
The corresponding version app may be downloaded from app's home page / Google Play /
some other apk or app code source on the internet. In case the appropriate version
is not available the same can be requested by mailing to pallavi.maiya@csa.iisc.ernet.in
