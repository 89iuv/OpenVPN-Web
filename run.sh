#!/usr/bin/env bash

mvn clean install
cp ./src/main/resources/application.properties ./target/
sed 's|src/test/resources/openvpn-status.log|/etc/openvpn/openvpn-status.log|' ./target/application.properties
nohup java -jar ./target/otho-1.0-SNAPSHOT.jar &