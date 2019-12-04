use mysql;
create database expense;
show databases;
use expense;

create user 'hcl'@'localhost' identified by 'hcl';
select User,Host,password from user;
grant all privileges on expense.* to 'hcl'@'localhost';
use expense;

show tables;
create table project(projectId int auto_increment primary key,projectName varchar(25),startDate datetime);

create table usertype(userType enum('U','M') not null unique key,userTypeName varchar(20));

create table user(userId int primary key auto_increment,userName varchar(30) not null,dob date not null,userType enum('U','M') references usertype(userType),password varchar(30));

create table expense(eid int primary key auto_increment,uid int references user(userId),pid int references project(projectId),expense double not null,expenseDate date);

select * from project;

insert into project(projectName,startDate) values('project1',now());

insert into project(projectName,startDate) values('project2',now());

insert into project(projectName,startDate) values('project3',now());

insert into project(projectName,startDate) values('project4',now());

SELECT * FROM project p;

delete from project;

insert into usertype (userType,userTypeName) values('U','User');

insert into usertype (userType,userTypeName) values('M','Manager');


select * from usertype;


insert into user (userName,dob,userType,password) values('Mohan','1923-04-23','U','passwd123');
insert into user (userName,dob,userType,password) values('Kiran','1923-04-23','U','passwd123');
insert into user (userName,dob,userType,password) values('Ravi','1923-04-23','M','passwd123');
insert into user (userName,dob,userType,password) values('Yadhu','1923-04-23','M','passwd123');

select * from user;

insert into expense(uid,pid,expense,expenseDate) values(1,1,100,'2010-06-12');
insert into expense(uid,pid,expense,expenseDate) values(2,1,200,'2010-06-12');
insert into expense(uid,pid,expense,expenseDate) values(5,1,50,'2010-06-12');




-----HSQL db queries
CREATE SEQUENCE project_seq START WITH 1;
create table project(projectId int primary key,projectName varchar(25),startDate datetime);
create table usertype(userType char(1) primary key,userTypeName varchar(20));
create table user(userId int primary key,userName varchar(30) not null,dob date not null,userType char(1) references usertype(userType),password varchar(30));
create table expense(eid int primary key ,uid int references user(userId),pid int references project(projectId),expense double not null,expenseDate date);

insert into project(projectid,projectName,startDate) values(100,'project1',now());
insert into project(projectid,projectName,startDate) values(200,'project2',now());
insert into project(projectid,projectName,startDate) values(300,'project3',now());
insert into project(projectid,projectName,startDate) values(400,'project4',now());

insert into usertype (userType,userTypeName) values('U','User');
insert into usertype (userType,userTypeName) values('M','Manager');

select * from usertype;

insert into user (userId,userName,dob,userType,password) values(101,'Mohan','1923-04-23','U','passwd123');
insert into user (userId,userName,dob,userType,password) values(102,'Kiran','1923-04-23','U','passwd123');
insert into user (userId,userName,dob,userType,password) values(103,'Ravi','1923-04-23','M','passwd123');
insert into user (userId,userName,dob,userType,password) values(104,'Yadhu','1923-04-23','M','passwd123');
select * from user;
insert into expense(eid,uid,pid,expense,expenseDate) values(100,101,100,100,now());
insert into expense(eid,uid,pid,expense,expenseDate) values(101,102,100,200,'2010-06-12');
insert into expense(eid,uid,pid,expense,expenseDate) values(102,104,100,50,'2010-06-12');
select * from expense;

--view project expense
select distinct p.projectid,p.projectname from project p inner join expense e on p.projectid=e.pid inner join user u on u.userId = e.uid; 

--search projects

--add expense