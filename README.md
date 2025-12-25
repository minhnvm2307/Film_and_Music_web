
# Netify | Spotiflix | MINH_FILM

## Content

- Web app project code based on JAVA Spring boot + Thymeleaf.
- Film and Music platform.
- **Totally run locally**, just for learning (frontend + backend + database)
- TechStack: Frontend(html-css-js) | Backend (Java+Springboot framework) | Database (MySQL)

## Admin modules

- Management dashboard: music, singer, film
- Action: add, edit, remove

## User modules

### Login

- Login by username and password

### Features

- FILM: play-video, comment, rating, filter-by-category
- MUSIC: play-music, comment, create-albums

## Setup

```bash
# Dependencies
java-openjdk21
springboot (pom.xml) + maven
mysql-server

# Install
cd Film_and_Music_web/
mvn clean install

# Database
mysql create-user 'your-username'
mysql -u 'your-username'
query: CREATE DATABASE cinemalmodels;
// import .sql file into database (.sql file in database/ folder)
// change config in .properties file

# Build project
java -jar target/demo.jar

# Open web
```
 
