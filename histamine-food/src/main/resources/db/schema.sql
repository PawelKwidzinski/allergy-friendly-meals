CREATE TABLE IF NOT EXISTS food_histamine_levels
(
    id               INT AUTO_INCREMENT PRIMARY KEY,
    compatibility    INT,
    histamine        CHAR(2),
    other_amines     CHAR(2),
    liberator        CHAR(2),
    blocker          CHAR(2),
    ingredient       VARCHAR(255),
    remarks          TEXT,
    food_subcategory VARCHAR(255),
    food_category    VARCHAR(255)
);

