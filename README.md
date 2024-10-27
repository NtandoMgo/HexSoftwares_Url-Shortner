# URL Shortener Service

A simple URL shortening service built with Java and Spring Boot. This application allows users to shorten long URLs and retrieve the original URLs via unique short codes.

## Features

- **URL Shortening**: Convert long URLs into short, easy-to-share links.
- **Redirection**: Automatically redirect users from the short URL to the original URL.
- **In-Memory Database**: Uses H2 Database for storing URL mappings temporarily.
- **RESTful API**: Interact with the service using standard HTTP methods.

## Technologies Used

- **Java 17+**
- **Spring Boot** (v3.3.5)
- **Spring Data JPA**
- **H2 Database**
- **Gradle** for build automation

## Getting Started

### Prerequisites

- Java 17 or higher
- Gradle
- IDE (e.g., IntelliJ IDEA, Eclipse)

### Clone the Repository

```bash
git clone https://github.com/NtandoMgo/HexSoftwares_Url-Shortner.git
cd HexSoftwares_Url-Shortner
```

### Build and Run the Application

1. Navigate to the project directory.
2. Use Gradle to build and run the application:

   ```bash--linux
   ./gradlew bootRun 
   ```

3. The application will start on `http://localhost:8080`.

### API Endpoints

- **Shorten a URL**
  
  - **Request**: `POST http://localhost:8080/api/shorten`
  - **Body** (raw, text):
    ```
    [LONG_URL_HERE]
    ```
  
  - **Response**:
    ```json
    {
      "shortUrl": "[SHORT_URL_HERE]"
    }
    ```

- **Redirect to Original URL**

  - **Request**: `GET http://localhost:8080/[SHORT_URL]`
  
  - **Response**: Redirects to the original URL.

## Testing

You can test the application using tools like Postman or cURL. 

### Example cURL Commands

- Shortening a URL:
  ```bash
  curl -X POST http://localhost:8080/api/shorten -d "https://www.example.com/very/long/url/to/be/shortened"
  ```

- Accessing the shortened URL:
  ```bash
  curl -L http://localhost:8080/[SHORT_URL]
  ```

## Future Enhancements

- **User Authentication**: Allow users to create accounts and manage their shortened URLs.
- **Custom Short URLs**: Enable users to specify custom short URLs.
- **Analytics**: Track the number of clicks for each shortened URL.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Thanks to the Spring Boot community for providing excellent resources and documentation.
