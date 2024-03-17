CREATE TABLE IF NOT EXISTS app_user (
                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      USERNAME VARCHAR(255),
                      PASSWORD VARCHAR(255),
                      EMAIL VARCHAR(255),
                      ROLE VARCHAR(255)
);