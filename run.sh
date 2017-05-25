#!/usr/bin/env bash

#install bower components
DIR=`pwd`
cd ./src/main/resources/public/
bower install --allow-root
cd $DIR

#run maven
mvn clean install -DskipTests

#configure app properties
cp ./src/main/resources/application.properties ./target/
sed -i 's|src/test/resources/openvpn-status.log|/etc/openvpn/openvpn-status.log|' ./target/application.properties

#run application
cd ./target/
kill `ps -C "java -jar ./otho-1.0-SNAPSHOT.jar" -o pid=`
nohup java -jar ./otho-1.0-SNAPSHOT.jar &