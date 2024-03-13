CREATE TABLE IF NOT EXISTS image_entity
(
    id                      BIGINT AUTO_INCREMENT PRIMARY KEY,
    image                   BLOB,
    restaurant_id           BIGINT,
    KEY fk_table_image (restaurant_id),
    CONSTRAINT fk_table_image FOREIGN KEY (restaurant_id) REFERENCES RESTAURANT (id) ON DELETE CASCADE
    );