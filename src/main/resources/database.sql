CREATE database IF NOT EXISTS car_rental_db;
use car_rental_db;
CREATE TABLE IF NOT EXISTS `car_tbl`(
    `carId` INT UNSIGNED AUTO_INCREMENT,
    `carType` VARCHAR(100) NOT NULL,
    `carPrice` DOUBLE NOT NULL ,
    `rentFlag` BOOLEAN NOT NULL,
    PRIMARY KEY (`carId`)
    )ENGINE=InnoDB;
CREATE TABLE IF NOT EXISTS `contract_tbl`(
    `contractId` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `begindate` VARCHAR(100) NOT NULL,
    `returndate`  VARCHAR(100) NOT NULL,
    `carId` INT UNSIGNED NOT NULL,
    `customerInfo` VARCHAR(100) NOT NULL ,
    FOREIGN KEY fk_car(carId)
    REFERENCES car_tbl(carId)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
    )ENGINE=InnoDB;
INSERT INTO car_tbl
(carType, carPrice, rentFlag) values
("Toyota Camry",100,false);
INSERT INTO car_tbl
(carType, carPrice, rentFlag) values
("Toyota Camry",100,false);
INSERT INTO car_tbl
(carType, carPrice, rentFlag) values
("BMW 650",200,false);
INSERT INTO car_tbl
(carType, carPrice, rentFlag) values
("BMW 650",200,false);

