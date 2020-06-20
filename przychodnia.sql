-- phpMyAdmin SQL Dump
-- version 3.5.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Czas wygenerowania: 30 Maj 2018, 22:12
-- Wersja serwera: 5.5.21-log
-- Wersja PHP: 5.4.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Baza danych: `przychodnia`
--
use przychodnia;
Create table Plec(
id int AUTO_INCREMENT primary key,
plec_pacjenta varchar(1) not null
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;


CREATE TABLE  Lekarze (
  id int NOT NULL AUTO_INCREMENT Primary Key,
  imie varchar(30) NOT NULL,
  nazwisko varchar(30) NOT NULL,
  lek_login varchar (15) not null unique,
  lek_password varchar (15) not null
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

Create table Specjalizacje(
id int not null AUTO_INCREMENT Primary Key,
lekid int  ,
Specjalizacja varchar(30) not null
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

/*
create table klucze_spec_lek(
id int AUTO_INCREMENT Primary Key,
lekid int, 
specid int,  
 Foreign key (lekid)  references Lekarze(id),
 Foreign key (specid) references Specjalizacje (id)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;
*/
-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pacjenci`
--

CREATE TABLE  Pacjenci (
  id int not null  primary key AUTO_INCREMENT,
  pesel varchar(11) NOT NULL Unique, 
  imie varchar(30) NOT NULL,
  nazwisko varchar(30) NOT NULL,
  rok varchar(4) NOT NULL,
  adres varchar(50) NOT NULL,
  miasto varchar(30) NOT NULL,
  plecid int,
  foreign key (plecid) references Plec(id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;
--
-- Struktura tabeli dla tabeli `wizyta`
--

create table Wizyta 
(	
	id int not null AUTO_INCREMENT primary key,
	data date  not null unique,
    flgStatus varchar(1) not null,
	pacid int, 
	lekid int,
    foreign key (lekid) references Lekarze(id),
    foreign key (pacid) references Pacjenci(id)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

create table Karta_pac(
id int not null AUTO_INCREMENT primary key references Pacjenci(id),
Imiê varchar(15),
Nazwisko varchar (15),
pesel varchar(11) 
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;



Create table Wpisy(
id int not null AUTO_INCREMENT primary key,
wpis varchar(300),
karta_pacid int, 
lekid int not null, 
Foreign  key (karta_pacid)  references Lekarze(id),
foreign key (lekid) references Karta_pac(id)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

create table klucze_posrednie(
id int not null AUTO_INCREMENT,
specid int ,
lekid int,
 foreign key(specid)references lekarze(id),
 foreign key(lekid)references specjalizacje(id)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;


drop table Plec;
drop table pacjenci;
drop table lekarze;
drop table  wizyta;
drop table  specjalizacje;
drop table Karta_pac;
drop table Wpisy;
drop table klucze_posrednie;

alter table wpisy add choroba varchar (30)