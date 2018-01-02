# E-Book Reader

This is a nice e-book reader base on `epub.js` `React` support both PC and mobile.

The whole reader system with 3 part, React front end application, JAVA backend services with mysql database and a python search engine.

1. [Reader Frontend Page](https://github.com/ZQPlantSoftware/epub-reader) React base front end application

2. [Java Reader Backend Services](https://github.com/ZQPlantSoftware/epub-reader-services) We use Spring Boot and MySQL

3. [Reader Search Engine](https://github.com/ZQPlantSoftware/ebook-reader-search-engine) Python whoosh

** It's a e-book reader only for EPUB now, we may support other format of ebook later **

## Back End Services Part

This project build base on Spring Boot 1.3.0.RELEASE + Mybatis3.3.0

First, you need to create mysql database with sql file `20161214.sql`

Secondly, you need change configuration in `src/main/resources/application.yml`

### Configuration

- port: Just port
- decompPath: EPUB book decompression path, It should be a dictionary within a server. The best choose is the server with front end file.
- webServerPath: We need to know in the path above, which part is within web path.
- datasource: The mysql database config

## License

MIT
