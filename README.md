### Final Project:
# System "Hospital"
### Task List
1. doctors list
2. add patient 
3. add patient complain
4. assign to doctor 
5. doctor adds healing course (time range)
6. reports patient per doctor (last week/month/now)
7. patient healing result (live or dead)
8. stats per doctor (live/dead)
9. head doctor => all patients per doctor, all doctors, patients without doctors 
10. doctor => my patient (old, current, new)

### Technologies
* Java 11
* Maven
* FlyWay
* Slf4j+Logback
* MariaDB
* DBPool Apache
* Mockito
* JUnit4
* Docker-compose
* Hibernate
* Jetty

### How to run
1. Start scripts:
* `mvn clean package`
* `docker-compose up`
* `mvn compile flyway:migrate`
2. Start servlet container and deploy war-file
