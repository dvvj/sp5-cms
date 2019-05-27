FROM openjdk:8-jre

ENTRYPOINT ["java", "-jar", "/usr/share/mysvc/mysvc.jar"]

#ADD target/lib  /usr/share/mysvc/lib

ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/mysvc/mysvc.jar
