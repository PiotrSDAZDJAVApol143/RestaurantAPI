CREATE TABLE IF NOT EXISTS reservation (
    id                  BIGINT PRIMARY KEY AUTO_INCREMENT,
    RESERVATION_DATE    TIMESTAMP NOT NULL,
    NUMBER_OF_PEOPLE    INT NOT NULL,
    table_id            BIGINT,
    user_id             BIGINT,
    FOREIGN KEY (table_id) REFERENCES RESTAURANT_TABLE(id),
    FOREIGN KEY (user_id) REFERENCES app_user(id)
);