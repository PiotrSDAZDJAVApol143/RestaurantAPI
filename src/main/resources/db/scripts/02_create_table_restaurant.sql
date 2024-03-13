CREATE TABLE IF NOT EXISTS restaurant
(
    id                      BIGINT AUTO_INCREMENT PRIMARY KEY,
    restaurant_name         VARCHAR(128) NOT NULL,
    opening_hours           TIME NOT NULL,
    closing_hours           TIME NOT NULL,
    address_id              BIGINT,
    FOREIGN KEY (address_id) REFERENCES address (id)
    );

CREATE TABLE IF NOT EXISTS `RESTAURANT_FOOD_TYPE` (
    restaurant_id           BIGINT NOT NULL,
    FOOD_TYPE ENUM('Italian','Chinese','Mexican','Japanese','Indian','American','French','Thai','Polish','Greek','Spanish','Turkish','Korean','Fastfood') NOT NULL,
    FOREIGN KEY (restaurant_id) REFERENCES restaurant (id)
    );




