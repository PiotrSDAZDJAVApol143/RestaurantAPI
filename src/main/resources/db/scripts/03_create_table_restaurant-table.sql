CREATE TABLE IF NOT EXISTS restaurant_table
(
    id                      BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    restaurant_id           BIGINT,
    NUMBER_OF_TABLES        INT NOT NULL,
    KEY fk_restaurant_table (restaurant_id),
    CONSTRAINT fk_restaurant_table FOREIGN KEY (restaurant_id) REFERENCES RESTAURANT (id) ON DELETE CASCADE


);
