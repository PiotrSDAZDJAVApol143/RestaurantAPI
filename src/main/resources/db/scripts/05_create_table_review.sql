CREATE TABLE IF NOT EXISTS review
(
    id                      BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    user_id                 BIGINT NOT NULL,
    restaurant_id           BIGINT NOT NULL,
    RATING                  int NOT NULL,
    REVIEW_TEXT             varchar(1000),

    FOREIGN KEY (restaurant_id) REFERENCES RESTAURANT (id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES app_user(id)

    );