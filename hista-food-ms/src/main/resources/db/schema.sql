CREATE TABLE IF NOT EXISTS histamine_foods
(
    id               INT AUTO_INCREMENT PRIMARY KEY,
    compatibility    CHAR(2),
    level            CHAR(2),
    other_amines     CHAR(2),
    liberator        CHAR(2),
    blocker          CHAR(2),
    ingredient       VARCHAR(255),
    remarks          TEXT,
    subcategory      VARCHAR(255),
    category         VARCHAR(255)
);

