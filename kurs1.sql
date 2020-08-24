Use Theater_Performances;

CREATE TABLE IF NOT EXISTS Director(
director_id int primary key auto_increment,
lastname varchar(45) not null,
firstname varchar(45) not null,
surname varchar(45),
phone varchar(20) not null unique);

CREATE TABLE IF NOT EXISTS Play(
play_id int primary key auto_increment,
play_name varchar(200) not null,
author varchar(50) not null,
date_of_creation DATE not null);

CREATE TABLE IF NOT EXISTS Awards(
awards_id int primary key auto_increment,
awards_type varchar(30) not null);

CREATE TABLE IF NOT EXISTS Role_type(
role_type_id int primary key auto_increment,
role_type varchar(14) not null);

CREATE TABLE IF NOT EXISTS Version_performance(
version_id int primary key auto_increment,
version varchar(14) not null);

CREATE TABLE IF NOT EXISTS Actors(
actors_id int primary key auto_increment,
lastname varchar(45) not null,
firstname varchar(45) not null,
surname varchar(45),
age int check(age > 18 and age < 80) not null,
sex varchar(3) not null,
category varchar (30) not null);

CREATE TABLE IF NOT EXISTS Performance_type(
performance_type_id int primary key auto_increment,
performance_type varchar(14) not null);

CREATE TABLE IF NOT EXISTS Production(
production_id int primary key auto_increment,
production_name varchar(200) not null,
director_id int,
play_id int,
foreign key (play_id) references Play(play_id) on delete restrict on update restrict,
foreign key (director_id) references Director(director_id) on delete restrict on update cascade);

CREATE TABLE IF NOT EXISTS Role_in_the_play(
role_in_the_play_id int primary key auto_increment,
role_name varchar(60) not null,
category varchar(60) not null,
play_id int,
role_type_id int,
foreign key (play_id) references Play(play_id) on delete restrict on update restrict,
foreign key (role_type_id) references Role_type(role_type_id) on delete restrict on update restrict);


CREATE TABLE IF NOT EXISTS Actor_awards(
actor_awards_id int primary key auto_increment,
actor_id int,
awards_id int,
foreign key (actor_id) references Actors(actors_id) on delete restrict on update restrict,
foreign key (awards_id) references Awards(awards_id) on delete restrict on update restrict);

CREATE TABLE IF NOT EXISTS Roles(
role_id int primary key auto_increment,
role_name varchar(60) not null,
production_id int,
role_in_the_play_id int,
actor_id int,
foreign key (production_id) references Production(production_id) on delete restrict on update restrict,
foreign key (role_in_the_play_id) references Role_in_the_play(role_in_the_play_id) on delete restrict on update restrict,
foreign key (actor_id) references Actors(actors_id) on delete restrict on update restrict);

CREATE TABLE IF NOT EXISTS Performance(
performance_id int primary key auto_increment,
performance_name varchar(200) not null,
production_id int,
date_perfomance date not null,
start_time time not null,
performance_type_id int,
foreign key (production_id) references Production(production_id) on delete restrict on update restrict,
foreign key (performance_type_id) references Performance_type(performance_type_id)on delete restrict on update restrict);

CREATE TABLE IF NOT EXISTS Team_performance(
team_id int primary key auto_increment,
performance_id int,
role_id int,
version_id int,
foreign key (performance_id) references Performance(performance_id) on delete restrict on update restrict,
foreign key (role_id) references Roles(role_id) on delete restrict on update restrict,
foreign key (version_id) references Version_performance(version_id) on delete restrict on update restrict);

CREATE TABLE IF NOT EXISTS Contract(
contract_id int primary key auto_increment,
assignment_date date not null,
salary int check(salary>5000) not null,
actor_signature varchar(45) not null,
role_id int,
actor_id int,
foreign key (role_id) references Roles(role_id) on delete restrict on update restrict,
foreign key (actor_id) references Actors(actors_id) on delete restrict on update restrict);
