CREATE TABLE IF NOT EXISTS address
(
    id                  BIGINT AUTO_INCREMENT PRIMARY KEY,
    name                VARCHAR(128),
    street              VARCHAR(128) NOT NULL,
    building_number     VARCHAR(128) NOT NULL,
    local_number   VARCHAR(128),
    city                VARCHAR(128) NOT NULL,
    zip_code         VARCHAR(128) NOT NULL,
    country             VARCHAR(128) NOT NULL
    );