FROM openjdk:17
EXPOSE 8089
ADD target/MyTravelBuddyFlights-0.0.1-SNAPSHOT.war MyTravelBuddyFlights-0.0.1-SNAPSHOT.war
ENTRYPOINT [ "java", "-jar", "/MyTravelBuddyFlights-0.0.1-SNAPSHOT.war" ]