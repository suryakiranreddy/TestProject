@echo off
cls
echo "Test suite is starting"
set root=C:\Users\ein0043\Desktop\TraineeCalender-2\TestProject
CD /D %root%
call mvn clean test -U
echo Test Suite run has completed... 
echo Please Press anything to exit :D
Pause>Nul