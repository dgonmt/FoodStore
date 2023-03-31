DROP DATABASE IF EXISTS `Foodstore`;


CREATE DATABASE `Foodstore`;

USE `Foodstore`;




CREATE TABLE `product`
(
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `category` VARCHAR(255),
    `weight` DOUBLE NOT NULL,
    `price_per_kg` DOUBLE NOT NULL,
     PRIMARY KEY (`id`)
);

CREATE TABLE `customer`
(
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
     PRIMARY KEY (`id`)
);

CREATE TABLE `admin`
(
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
     PRIMARY KEY (`id`)
);



INSERT INTO `product` (`name`, `category`, `weight`, `price_per_kg`) VALUES ('Apples', 'Fruits', 110.0, 1.99);
INSERT INTO `product` (`name`, `category`, `weight`, `price_per_kg`) VALUES ('Bananas', 'Fruits', 80.0, 0.99);
INSERT INTO `product` (`name`, `category`, `weight`, `price_per_kg`) VALUES ('Oranges', 'Fruits', 130.0, 2.49);
INSERT INTO `product` (`name`, `category`, `weight`, `price_per_kg`) VALUES ('Pineapples', 'Fruits', 240.0, 3.99);
INSERT INTO `product` (`name`, `category`, `weight`, `price_per_kg`) VALUES ('Mangoes', 'Fruits', 170.0, 2.99);
INSERT INTO `product` (`name`, `category`, `weight`, `price_per_kg`) VALUES ('Carrots', 'Vegetables', 120.0, 1.49);
INSERT INTO `product` (`name`, `category`, `weight`, `price_per_kg`) VALUES ('Broccoli', 'Vegetables', 150.0, 2.99);
INSERT INTO `product` (`name`, `category`, `weight`, `price_per_kg`) VALUES ('Cucumbers', 'Vegetables', 100.0, 1.29);
INSERT INTO `product` (`name`, `category`, `weight`, `price_per_kg`) VALUES ('Spinach', 'Vegetables', 90.0, 0.99);
INSERT INTO `product` (`name`, `category`, `weight`, `price_per_kg`) VALUES ('Cauliflower', 'Vegetables', 200.0, 3.49);
INSERT INTO `product` (`name`, `category`, `weight`, `price_per_kg`) VALUES ('Chicken Breast', 'Meats', 200.0, 5.99);
INSERT INTO `product` (`name`, `category`, `weight`, `price_per_kg`) VALUES ('Ground Beef', 'Meats', 220.0, 7.99);
INSERT INTO `product` (`name`, `category`, `weight`, `price_per_kg`) VALUES ('Pork Chops', 'Meats', 190.0, 6.49);
INSERT INTO `product` (`name`, `category`, `weight`, `price_per_kg`) VALUES ('Salmon Fillet', 'Meats', 180.0, 8.99);
INSERT INTO `product` (`name`, `category`, `weight`, `price_per_kg`) VALUES ('Tilapia Fillet', 'Meats', 150.0, 4.99);
INSERT INTO `product` (`name`, `category`, `weight`, `price_per_kg`) VALUES ('Brown Rice', 'Grains', 190.0, 2.99);
INSERT INTO `product` (`name`, `category`, `weight`, `price_per_kg`) VALUES ('Quinoa', 'Grains', 100.0, 4.49);
INSERT INTO `product` (`name`, `category`, `weight`, `price_per_kg`) VALUES ('Whole Wheat Bread', 'Grains', 120.0, 2.49);
INSERT INTO `product` (`name`, `category`, `weight`, `price_per_kg`) VALUES ('Oatmeal', 'Grains', 80.0, 1.99);
INSERT INTO `product` (`name`, `category`, `weight`, `price_per_kg`) VALUES ('Whole Grain Pasta', 'Grains', 150.0, 3.49);

INSERT INTO `customer` (`username`, `password`) VALUES ('foodeater', 'secret');
INSERT INTO `customer` (`username`, `password`) VALUES ('meatgrinder', 'secret');

INSERT INTO `admin` (`username`, `password`) VALUES ('boss', 'secret');
INSERT INTO `admin` (`username`, `password`) VALUES ('king', 'secret');
