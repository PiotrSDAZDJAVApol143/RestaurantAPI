CREATE TABLE IF NOT EXISTS restaurant_table
(
    id                      BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    restaurant_id           BIGINT NOT NULL,
    TABLE_NUMBER            INT NOT NULL,
    CAPACITY_OF_TABLE       INT NOT NULL,
    RESERVATION_CHECK       BOOLEAN,
    KEY fk_restaurant_table (restaurant_id),
    CONSTRAINT fk_restaurant_table FOREIGN KEY (restaurant_id) REFERENCES RESTAURANT (id) ON DELETE CASCADE


);
