# Use Tomcat 8 with JDK8 as base
FROM tomcat:8-jdk8

USER root

# Install wget and unzip (if needed for other steps)
RUN apt-get update && \
    apt-get install -y wget unzip

# Create user and set permissions
RUN useradd -ms /bin/bash robin && \
    chown -R robin:robin /usr/local/tomcat

# Switch to user robin
USER robin

# Copy WAR, SQL, and H2 JAR
COPY onlineshopping/target/onlineshopping.war /usr/local/tomcat/webapps/onlineshopping.war
COPY shoppingbackend/databaseQueries.sql /tmp/databaseQueries.sql
COPY onlineshopping/target/h2-1.4.200.jar /opt/h2-1.4.200.jar

# Expose ports
EXPOSE 8080 9092 8082

# Start H2 TCP server, run SQL, then start Tomcat
CMD ["bash", "-c", "java -cp /opt/h2-1.4.200.jar org.h2.tools.Server -tcp -tcpAllowOthers -web -webAllowOthers -ifNotExists & sleep 5 && java -cp /opt/h2-1.4.200.jar org.h2.tools.RunScript -url 'jdbc:h2:tcp://localhost/~/test' -user sa -script /tmp/databaseQueries.sql && catalina.sh run"]
