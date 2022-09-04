FROM amazoncorretto:17

#Make sure to install maven before running
RUN mvn install

# Add application dependencies
ADD ./application.properties application.properties

# Add the build jar file
ADD target/pruthviraj-youtube-assignment.jar pruthviraj-youtube-assignment.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/pruthviraj-youtube-assignment.jar"]