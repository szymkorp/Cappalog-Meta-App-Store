-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema CappalogDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `CappalogDB` DEFAULT CHARACTER SET utf8 ;
USE `CappalogDB` ;

-- -----------------------------------------------------
-- Dropping Tables if Exists
-- -----------------------------------------------------
DROP TABLE IF EXISTS submittedApps;
DROP TABLE IF EXISTS appTable;
DROP TABLE IF EXISTS users;

-- -----------------------------------------------------
-- Creating Tables
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CappalogDB`.`appTable` (
  `appID` INT NOT NULL,
  `Name` VARCHAR(45) NULL,
  `Developer` VARCHAR(45) NULL,
  `Link` VARCHAR(300) NULL,
  `Description` VARCHAR(280) NULL,
  `Platform` VARCHAR(45) NULL,
  `Price` FLOAT NULL,
  PRIMARY KEY (`appID`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS submittedApps (
	submitAppID INT NOT NULL ,
    appID INT NOT NULL,
    Name VARCHAR(45) NULL,
    Developer VARCHAR(45) NULL,
    Link VARCHAR(300) NULL,
    Description VARCHAR(280) NULL,
    Platform VARCHAR(45) NULL,
    Price FLOAT NULL,
    IsAdded CHAR NULL,
    PRIMARY KEY(submitAppID),
    FOREIGN KEY(appID)
		REFERENCES appTable(appID)
)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS users (
	userID INT NOT NULL auto_increment,
    userName VARCHAR(50) NOT NULL,
    userPassword VARCHAR(50) NOT NULL,
    PRIMARY KEY (userID)
)
ENGINE = InnoDB; 
    
-- -----------------------------------------------------
-- Populating Tables
-- -----------------------------------------------------
insert into apptable(appID, Name, Developer, Link, Description, Platform, Price) values
('2','CNN', 'Turner Broadcasting System', 'www.cnn.com', 'News in US and the world', 'Cable News Network','20.00'),
('3','Fox News', '21st Century Fox', 'www.foxnews.com', 'Conservative U.S. News', 'Fox News Network LLC', '53.00'),
('4','ESPN', 'Disney Entertainment', 'www.espn.com', 'World Wide Leader in Sports', 'Entertainment Sports', '5.00');

insert into submittedApps(submitAppID, appID, Name, Developer, Link, Description, Platform, Price, IsAdded) values
('100', '2','CNN', 'Turner Broadcasting System', 'www.cnn.com', 'News in US and the world', 'Cable News Network','20.00', 'Y'),
('101', '3','Fox News', '21st Century Fox', 'www.foxnews.com', 'Conservative U.S. News', 'Fox News Network LLC', '53.00', 'Y'),
('102', '4','ESPN', 'Disney Entertainment', 'www.espn.com', 'World Wide Leader in Sports', 'Entertainment Sports', '5.00', 'Y'),
('103', '5','Bleacher Report', 'B/R', 'www.bleacherreport.com', 'Sports News', 'Entertainment Sports', '17.00', 'N');

INSERT INTO users(userName, userPassword) values
('romerta', 'fakepassword1');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
