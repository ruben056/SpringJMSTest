springBeanNamesTest
===================

Test spring JMS with apacheMQ

How to use
==========
run: mvn test
Does not really use asserts. Just check the logging. the messagelistener should log the message it receives from the messageSender.
Installing apache MQ 
- download version 5.5.1 from the website.
- start from app home dir (not from within the bin folder but one directory higher): ./bin/activemq start
- then go to : http://localhost:8161/admin
- here you should create queue with the name "test".
