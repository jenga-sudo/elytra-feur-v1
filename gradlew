#!/usr/bin/env sh
##############################################################################
# Gradle startup script for UN*X
##############################################################################

APP_NAME="Gradle"
APP_BASE_NAME=$(basename "$0")

DIRNAME=$(dirname "$0")
APP_HOME=$(cd "$DIRNAME" && pwd)

CLASSPATH="$APP_HOME/gradle/wrapper/gradle-wrapper.jar"

JAVA_CMD="java"
if [ -n "$JAVA_HOME" ]; then
    JAVA_CMD="$JAVA_HOME/bin/java"
fi

exec "$JAVA_CMD" -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"