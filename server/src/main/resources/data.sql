DROP TABLE IF EXISTS PRODUCT;

CREATE TABLE PRODUCT (
  ID NUMBER AUTO_INCREMENT  PRIMARY KEY,
  NAME VARCHAR(250) NOT NULL,
  TYPE VARCHAR(250)
);

INSERT INTO PRODUCT (NAME, TYPE) VALUES
  ('Penguin-ears', 'RARE'),
  ('Horseshoe', '');

DROP TABLE IF EXISTS CARTON;

CREATE TABLE CARTON (
    ID NUMBER AUTO_INCREMENT PRIMARY KEY,
    PRODUCT_ID NUMBER NOT NULL,
    UNITS_PER_CARTON NUMBER NOT NULL,
    PRICE NUMBER NOT NULL
);

INSERT INTO CARTON (PRODUCT_ID, UNITS_PER_CARTON, PRICE) VALUES
    ( SELECT ID FROM PRODUCT WHERE NAME = 'Penguin-ears', 20, 175.00 ),
    ( SELECT ID FROM PRODUCT WHERE NAME = 'Horseshoe', 5, 825.00 );