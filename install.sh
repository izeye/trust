#!/bin/bash

git pull
webpack
./gradlew clean bootRepackage -Penv=production
