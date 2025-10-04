@echo off
:: -----------------------------------------------------------------------------
:: Gradle startup script for Windows
:: -----------------------------------------------------------------------------
setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.

set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%

set GRADLE_HOME=%APP_HOME%\gradle\wrapper

set CLASSPATH=%GRADLE_HOME%\gradle-wrapper.jar

set JAVA_EXE=java
if defined JAVA_HOME set JAVA_EXE="%JAVA_HOME%\bin\java"

%JAVA_EXE% -classpath "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %*

endlocal