package springinaction.tacocloud.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

import javax.sql.DataSource;

@TestConfiguration
public class PostgreSqlContainerConfig {

    private static final String IMAGE_VERSION = "postgres:12-alpine";
    private static final String DB_NAME = "taco";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "password";
    private static final String JDBC_URL_FORMAT = "jdbc:postgresql://%s:%s/%s";

    public static final PostgreSQLContainer POSTGRES = new PostgreSQLContainer<>(getDockerImageName())
            .withDatabaseName(DB_NAME)
            .withUsername(USERNAME)
            .withPassword(PASSWORD);


    static {
        POSTGRES.start();

        System.setProperty("spring.datasource.url", POSTGRES.getJdbcUrl());
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setDriverClassName(POSTGRES.getDriverClassName());
        datasource.setUrl(String.format(JDBC_URL_FORMAT,
                POSTGRES.getContainerIpAddress(),
                POSTGRES.getMappedPort(PostgreSQLContainer.POSTGRESQL_PORT),
                POSTGRES.getDatabaseName()));
        datasource.setUsername(POSTGRES.getUsername());
        datasource.setPassword(POSTGRES.getPassword());
        return datasource;
    }

    private static DockerImageName getDockerImageName() {
        return DockerImageName.parse(IMAGE_VERSION).asCompatibleSubstituteFor("postgres");
    }
}
