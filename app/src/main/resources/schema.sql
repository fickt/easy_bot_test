DROP TABLE IF EXISTS MANUFACTURER_TABLE CASCADE;
DROP TABLE IF EXISTS CAPACITY_TYPE_TABLE CASCADE;
DROP TABLE IF EXISTS COMPUTER_TYPE_TABLE CASCADE;
DROP TABLE IF EXISTS SCREEN_SIZE_TABLE CASCADE;
DROP TABLE IF EXISTS INCH_TYPE_TABLE CASCADE;
DROP TABLE IF EXISTS COMPUTER_TABLE CASCADE;
DROP TABLE IF EXISTS LAPTOP_TABLE CASCADE;
DROP TABLE IF EXISTS MONITOR_TABLE CASCADE;
DROP TABLE IF EXISTS HARD_DRIVE_TABLE CASCADE;

CREATE TABLE MANUFACTURER_TABLE
(
    NAME VARCHAR(124) UNIQUE PRIMARY KEY
);

CREATE TABLE CAPACITY_TYPE_TABLE
(
    ID       BIGINT UNIQUE PRIMARY KEY,
    CAPACITY BIGINT
);

CREATE TABLE COMPUTER_TYPE_TABLE
(
    ID   BIGINT UNIQUE PRIMARY KEY,
    NAME VARCHAR(124)
);

CREATE TABLE SCREEN_SIZE_TABLE
(
    ID   BIGINT UNIQUE PRIMARY KEY,
    SIZE BIGINT
);

CREATE TABLE INCH_TYPE_TABLE
(
    ID   BIGINT UNIQUE PRIMARY KEY,
    INCHES BIGINT
);


CREATE TABLE COMPUTER_TABLE
(
    SERIAL_NUMBER       VARCHAR(124) UNIQUE PRIMARY KEY,
    PRICE               DECIMAL(38, 2),
    FK_COMPUTER_TYPE_ID BIGINT,
    FK_MANUFACTURER_ID  VARCHAR(124),
    QUANTITY            BIGINT,
    FOREIGN KEY (FK_COMPUTER_TYPE_ID) REFERENCES COMPUTER_TYPE_TABLE (ID) ON DELETE CASCADE,
    FOREIGN KEY (FK_MANUFACTURER_ID) REFERENCES MANUFACTURER_TABLE (NAME) ON DELETE CASCADE
);

CREATE TABLE LAPTOP_TABLE
(
    SERIAL_NUMBER      VARCHAR(124) UNIQUE PRIMARY KEY,
    PRICE              DECIMAL(38, 2),
    FK_INCH_TYPE_ID  BIGINT,
    FK_MANUFACTURER_ID VARCHAR(124),
    QUANTITY           BIGINT,
    FOREIGN KEY (FK_INCH_TYPE_ID) REFERENCES SCREEN_SIZE_TABLE (ID) ON DELETE CASCADE,
    FOREIGN KEY (FK_MANUFACTURER_ID) REFERENCES MANUFACTURER_TABLE (NAME) ON DELETE CASCADE
);

CREATE TABLE MONITOR_TABLE
(
    SERIAL_NUMBER      VARCHAR(124) UNIQUE PRIMARY KEY,
    PRICE              DECIMAL(38, 2),
    FK_SCREEN_SIZE_ID BIGINT,
    FK_MANUFACTURER_ID VARCHAR(124),
    QUANTITY           BIGINT,
    FOREIGN KEY (FK_SCREEN_SIZE_ID) REFERENCES INCH_TYPE_TABLE (ID) ON DELETE CASCADE,
    FOREIGN KEY (FK_MANUFACTURER_ID) REFERENCES MANUFACTURER_TABLE (NAME) ON DELETE CASCADE
);

CREATE TABLE HARD_DRIVE_TABLE
(
    SERIAL_NUMBER       VARCHAR(124) UNIQUE PRIMARY KEY,
    PRICE               DECIMAL(38, 2),
    FK_CAPACITY_TYPE_ID BIGINT,
    FK_MANUFACTURER_ID  VARCHAR(124),
    QUANTITY            BIGINT,
    FOREIGN KEY (FK_CAPACITY_TYPE_ID) REFERENCES CAPACITY_TYPE_TABLE (ID) ON DELETE CASCADE,
    FOREIGN KEY (FK_MANUFACTURER_ID) REFERENCES MANUFACTURER_TABLE (NAME) ON DELETE CASCADE
)