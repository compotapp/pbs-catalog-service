# Соответствие команд Gradle → Maven:
|                    Gradle | 	      Maven                                              | 
|--------------------------:|:----------------------------------------------------------|
|         ./gradlew bootRun | ./mvnw spring-boot:run                                    |
|          ./gradlew build	 | ./mvnw package                                            |
|           ./gradlew test	 | ./mvnw test                                               |
|          ./gradlew clean	 | ./mvnw clean                                              |
|        ./gradlew bootJar	 | ./mvnw package (Spring Boot Maven плагин создает fat JAR) |
Что такое ./mvnw?
Это Maven Wrapper — аналог Gradle Wrapper. Позволяет запускать Maven без его установки, используя версию, указанную в проекте.

Если в проекте нет mvnw (файла-обертки), используй просто mvn spring-boot:run (при условии, что Maven установлен).