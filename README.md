# Enterprise Apps - Mohamed Lamouri

---

## Project Uitvoeren

### 1. Vereisten
- **IDE** zoals IntelliJ IDEA 
- **Java 17+**
- **MySQL**
- **Spring 3.2.5**
- **Maven 3.9.16**

### 2. Aanmaken Database
Zorg ervoor dat de MySQL actief is en maak een database aan. Als voorbeeld kunt u kiezen voor:

```sql
CREATE DATABASE ngo_anderlecht;
```

### 3. Configuratie aanpassen
Pas in src/main/resources/application.properties` de volgende gegevens aan naar uw eigen instellingen. In dit voorbeeld wordt gewerkt met
localhost, poort 3306 en ngo_anderlecht als naam:

```properties
spring.application.name=Enterprise_Application
spring.datasource.url=jdbc:mysql://localhost:3306/ngo_anderlecht
spring.datasource.username=JOUW_GEBRUIKERSNAAM
spring.datasource.password=JOUW_WACHTWOORD

# SMTP configuratie
spring.mail.host=JOUW_MAILSERVER
spring.mail.port=0
spring.mail.username=JOUW_EMAILADRES
spring.mail.password=JOUW_EMAILWACHTWOORD
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true 
```
Wijzig de naam of poort indien u andere gegevens heeft van uw database. Dit doet u ook voor uw database gebruikersnaam en wachtwoord

### 4. Applicatie Starten

Start de applicatie via uw IDE zoals IntelliJ IDEA. 
De applicatie start op: *http://localhost:8080/*

### 5. Nieuwe locaties toevoegen
De applicatie voorziet bij het opstarten automatisch locatie seeding.
Indien je zelf een nieuwe locatie wilt toevoegen, moet je die in de database aanmaken in de tabel `locatie`.

Vul daarbij volgende velden in:
- Naam voor de locatie
- Adres van de locatie
- Capaciteit van de locatie

Het ID wordt automatisch gegenereerd.

Voorbeeld: 

```sql
INSERT INTO locatie (naam, adres, capaciteit)
VALUES ('Nieuwe locatie', 'Voorbeeldstraat 1', 150);
```

## Gebruikte Technologieën & Frameworks

Verkrijgbaar in de `pom.xml`

Gebruikte technologieën en frameworks:
  - Java 17
  - Spring 3.2.5
  - Maven 3.9.16
  - Spring Data JPA
  - Spring Mail
  - Spring Web
  - Spring Validation
  - Thymeleaff
  - MySQL database driver

## Hulpmiddelen

### Externe Bronnen
- Ehb Enterprise Application cursus 
- [Spring MVC Form Validation](https://spring.io/guides/gs/validating-form-input/)
- [Thymeleaf Documentation](https://www.thymeleaf.org/documentation.html)
- [Spring Data JPA Reference](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
- [Bootstrap 5 Docs](https://getbootstrap.com/docs/5.3/)
- [Mailtrap SMTP Docs](https://mailtrap.io/blog/spring-send-email/)

### Geschiedenis AI chats

ChatGPT: 

- Seeding en dummy tekst voorzien bij frontend
- Een deel van de layout opgesteld
- findTop10By() in de EventRepository als oplossing gegeven voor overzicht

Copilot:

- String id converten naar een locatie object bij `LocatieConverter`
- Duplicatie locatie voorkomen met findByNaam

---

