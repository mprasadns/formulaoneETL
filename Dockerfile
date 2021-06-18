FROM openjdk:14
COPY target/classes /var/www/java
WORKDIR /var/www/java
ENTRYPOINT ["java","FormulaOneETL"]
