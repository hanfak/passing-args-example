#!/usr/bin/env bash

mvn package

java -cp target/executable-jar-example-1.0-SNAPSHOT.jar Runner $1 "$2"