create table User_Profile (
	id varchar(36) not null,
	creation_date timestamp,
	email varchar(255),
	last_login timestamp,
	password varchar(255),
	status int not null,
	update_date timestamp,
	username varchar(255),
	login_token varchar(36),
	failed_login_attempts int not null,
	recover_token varchar(36),
	recover_date timestamp,
	primary key (id)
) engine=InnoDB;


create table User_Status(
	id int not null,
	name varchar(10),
	primary key(id)
) engine=InnoDB;

create table User_Detail (
	id varchar(36) not null,
	first_name varchar(255),
	middle_name varchar(255),
	last_name varchar(255),
	gender varchar(255),
	home_phone_number varchar(255),
	mobile_phone_number varchar(255),
	primary_phone varchar(255),
	work_phone_number varchar(255),
	fax varchar(255),
	uniquie_id varchar(255),
	user_id varchar(36),
	primary key (id)
) engine=InnoDB;

create table User_Meta (
	id varchar(36) not null,
	name varchar(255),
	value varchar(255),
	user_id varchar(36),
	primary key (id)
) engine=InnoDB;

create table User_Recover (
	id varchar(36) not null,
	password_hint_answer varchar(255),
	password_hint_question varchar(255),
	user_id varchar(36),
	primary key (id)
) engine=InnoDB;



create table User_Detail_Geo (
	id varchar(36) not null,
	user_detail_id varchar(36) not null,
	user_geo_id varchar(36) not null,
	geo_type int,
	primary key (id)
) engine=InnoDB;

create table Geo_Type(
	id int not null,
	name varchar(10),
	primary key(id)
) engine=InnoDB;

create table User_Geo (
	id varchar(36) not null,
	city varchar(255),
	country varchar(255),
	latitude varchar(255), 
	longtitude varchar(255),
	postalCode varchar(255),
	state varchar(255),
	streetAdress varchar(255),
	primary key (id)
) engine=InnoDB;

create table Role(
  id varchar(36) not null,
  name varchar(255) not null,
  description varchar(255),
  primary key (id)
) engine=InnoDB;

create table Permission(
  id varchar(36) not null,
  name varchar(255) not null,
  action_code varchar(255),
  description varchar(255),
  primary key (id)
) engine=InnoDB;

create table Role_Permission(
  role_id varchar(36) not null,
  permission_id varchar(36) not null,
  primary key (role_id, permission_id)
) engine=InnoDB;

create table Role_User(
  role_id varchar(36) not null,
  user_id varchar(36) not null,
  primary key (role_id, user_id)
) engine=InnoDB;


alter table User_Detail_Geo
	add constraint User_Detail_Geo_Type_FK
	foreign key (geo_type) references Geo_Type(id);
	
	
insert into Geo_Type(id, name) values(0,'HOME'); 
insert into Geo_Type(id, name) values(1,'MAIL');
insert into Geo_Type(id, name) values(2,'WORK');	

alter table User_Profile
	add constraint User_Profile_Status_FK
	foreign key (status) references User_Status(id);

insert into User_Status(id, name) values(0,'NEW'); 
insert into User_Status(id, name) values(1,'ACTIVE');
insert into User_Status(id, name) values(2,'EXPIRED');
insert into User_Status(id, name) values(3,'LOCKED');
insert into User_Status(id, name) values(4,'DELETED');

alter table User_Detail 
	add constraint User_Detail_User_FK
	foreign key (user_id) references User_Profile(id);

alter table User_Meta 
	add constraint User_Meta_User_FK
	foreign key (user_id) references User_Profile(id);
	
alter table User_Recover
	add constraint User_Recoder_User_FK
	foreign key (user_id) references User_Profile(id);
	
alter table User_Detail_Geo
	add constraint User_Detail_Geo_Detail_FK
	foreign key (user_detail_id) references User_Detail(id);
	
alter table User_Detail_Geo
	add constraint User_Detail_Geo_Geo_FK
	foreign key (user_geo_id) references User_Geo(id);
	
alter table Role_Permission
	add constraint Role_Permission_Role_FK
	foreign key (role_id) references Role(id) on delete cascade;	
	
alter table Role_Permission
	add constraint Role_Permission_Permission_FK
	foreign key (permission_id) references Permission(id) on delete cascade;
	
alter table Role_User
	add constraint Role_User_Role_FK
	foreign key (role_id) references Role(id)  on delete cascade;	

alter table Role_User
	add constraint Role_User_User_FK
	foreign key (user_id) references User_Profile(id)  on delete cascade;	

insert into Permission(id, name, action_code, description) values('54e4d629-1e4d-4d7d-8554-6e46fc7b6fa5', 'createUser', 'createUser', 'Ability to create user');
insert into Permission(id, name, action_code, description) values('5849486e-b168-4486-8604-5d6002091bd5', 'deleteUser', 'deleteUser', 'Ability to delete themselves');
insert into Permission(id, name, action_code, description) values('10ace085-1531-43bd-8054-56df145d26ac', 'deleteUserAll', 'deleteUserAll', 'Ability to delete any user');
insert into Permission(id, name, action_code, description) values('eebfd0d6-828d-414e-91fa-87d25108d82c', 'updateUser', 'updateUser', 'Ability to update themselves');
insert into Permission(id, name, action_code, description) values('0897112f-ad8f-4a0b-9fd2-3a864da380bc', 'updateUserAll', 'updateUserAll', 'Ability to update any user');
insert into Permission(id, name, action_code, description) values('23ee06ce-6f39-42a1-8413-3f438c4e3650', 'getUser', 'getUser', 'Ability to get own data');
insert into Permission(id, name, action_code, description) values('964e164d-1f49-4a58-80ac-dfadc3d706b9', 'getUserAll', 'getUserAll', 'Ability to get any user data');
insert into Permission(id, name, action_code, description) values('8b9286ab-4de9-4798-8f55-615a8b49c509', 'getUsers', 'getUsers', 'Ability to get all users');
insert into Permission(id, name, action_code, description) values('675b4592-5dab-482f-8fdc-0694f7ec7c89', 'updateUserPassword', 'updateUserPassword', 'Ability to update own password');
insert into Permission(id, name, action_code, description) values('73d1af4e-2d5d-4c7d-8302-2bba59f3bfe2', 'updateUserPasswordAll', 'updateUserPasswordAll', 'Ability to update any user password');
insert into Permission(id, name, action_code, description) values('707be6ba-7bc1-4345-a3e7-6c59183eb62d', 'searchUsers', 'searchUsers', 'Ability to search users');
insert into Permission(id, name, action_code, description) values('903abf81-d595-4e33-82c2-8589222e9484', 'exportAllUsers', 'exportAllUsers', 'Ability to export all users');
insert into Permission(id, name, action_code, description) values('6d81d9ad-7c81-4e41-b2cc-29dd9ace7e68', 'searchUsersForExport', 'searchUsersForExport', 'Ability to search users for export');
insert into Permission(id, name, action_code, description) values('eaddd12c-ca67-4931-b9cc-de69564ccf06', 'importUsers', 'importUsers', 'Ability to import users');
	