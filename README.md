# Allergy-Friendly-Meals -> IN PROGRESS
## General
* An app for creating meals from allergy-friendly food ingredients. When the user creates a meal, each ingredient will be checked for histamine content (high content causes allergic reactions).
* In the further development of the application, it is planned to add functionalities that will support the creation of meals (AI-Assistant-ms) and the management of food products available in the refrigerator and the home in general.
* To visualize the retrieved data through microservices, it is planned to connect to Angular framework and deploy the backend on a Kubernetes cluster.
## Application development plan
### Configserver-ms
#### Features:
* Provides necessary configurations for proper operation of microservices.
### User-ms
#### Features:
* User management (registration, login, profiles)
* Storage of users allergy preferences
#### Technologies
* Java 21
* Maven
* Spring Boot 3.3
* Lombok
* MySQL
### Hista-Food-ms
#### Features:
* Database of ingredients containing histamine (about 1000 records)
* Ingredient search
* API for checking histamine levels in ingredients
#### Technologies
* Java 21
* Maven
* Spring Boot 3.3
* Lombok
* MySql
### Ingredient-Management-ms
#### Features:
* CRUD for ingredients and products
* Integration with Hista-Food-Service for histamine checking
#### Technologies
* Java 21
* Maven
* Spring Boot 3.3
* Lombok
* MongoDB
### Meal-Management-ms
#### Features:
* CRUD for meals
* Calculation of nutritional values and histamine levels for meals
#### Technologies
* Java 21
* Maven
* Spring Boot 3.3
* Lombok
* MySql
### AI-Assistant-ms
#### Features:
* Culinary consulting
* Recognizing ingredients from photos
* Analysis of receipts
#### Technologies
* Java 21
* Maven
* Spring Boot 3.3
* Spring AI
* Lombok
* OCR Tesseract
### Pantry-Food-ms
#### Features:
* Product management in the user's home
* Track expiration dates
#### Technologies
* Java 21
* Maven
* Spring Boot 3.3
* Lombok
* Redis?
### Notification-ms
#### Features:
* Sending notifications about running out of products
* Alerts about high histamine levels in meals
#### Technologies
* Java 21
* Maven
* Spring Boot 3.3
* Lombok
* Apache Kafka
### Analytics-ms
#### Features:
* Analysis of user's nutritional trends
* Generating reports and statistics
#### Technologies
* Java 21
* Maven
* Spring Boot 3.3
* Lombok
* MySql
