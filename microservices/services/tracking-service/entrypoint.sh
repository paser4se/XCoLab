#!/bin/sh

# Stop execution if any command returns nonzero exit
set -e

JAVA_OPTS="-Dserver.port=18094 -Xmx1G -Xms256M -XX:-OmitStackTraceInFastThrow"

exec java -jar $JAVA_OPTS /tracking-service-1.0-SNAPSHOT.jar
