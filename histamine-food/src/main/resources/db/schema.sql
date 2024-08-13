CREATE TABLE IF NOT EXISTS food_histamine_levels
(
    id               INT AUTO_INCREMENT PRIMARY KEY,
    compatibility    INT,
    histamine_score  CHAR(2),
    amines           CHAR(2),
    liberators       CHAR(2),
    blockers         CHAR(2),
    food_item        VARCHAR(255),
    notes            TEXT,
    food_subcategory VARCHAR(255),
    food_category    VARCHAR(255)
);

