Drop TABLE if exists user_roles;
drop table if exists Messages;
drop table if exists Requests;
DROP TABLE if exists users;
Drop TABLE if exists data_user;
drop table if exists roles;
drop table if exists type_subject;
drop table if exists Organizational_form;
drop table if exists databasechangelog;
drop table if exists databasechangeloglock;

create table Type_subject(
    Id_type_subject INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100) NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table Organizational_form(
                             Id_organizational_form INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                             Name VARCHAR(100) NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table Data_user(
                          Id_data_user BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          INN VARCHAR(12) NOT NULL,
                          Type_subject_id INT default null,
                          CONSTRAINT FK_Data_user_Type_subject FOREIGN KEY (Type_subject_id) REFERENCES Type_subject (Id_type_subject)
                              ON delete set null on update restrict,
                          Organizational_form_id INT default null,
                          CONSTRAINT FK_Data_user_Organizational_form FOREIGN KEY (Organizational_form_id) REFERENCES Organizational_form (Id_organizational_form)
                              ON delete set null on update restrict,
                          Full_name_company VARCHAR(256) NULL,
                          Short_name_company VARCHAR(256) NULL,
                          Name_director VARCHAR(100) NULL,
                          Patronymic_director VARCHAR(100) NULL,
                          Family_name_director VARCHAR(100) null,
                          FIO_responsiblePerson VARCHAR(256) null,
                          Telefone VARCHAR(12) null
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table Users(
                      Id_user BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                      User_name VARCHAR(50) NOT NULL,
                      Password VARCHAR(1000) NOT NULL,
                      Word_coder VARCHAR(50) NULL,
                      Status VARCHAR(25),
                      Email VARCHAR(256) not null,
                      First_name VARCHAR(100) NULL,
                      Last_name VARCHAR(100) NULL,
                      Created_date DateTime NOT NULL,
                      Updated_date DateTime NULL,
                      Data_user_id BIGINT default null,
                      CONSTRAINT FK_Users_Data_user FOREIGN KEY (Data_user_id) REFERENCES Data_user (Id_data_user)
                          ON delete set null on update restrict
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table Roles(
                      Id_role INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                      Name VARCHAR(100) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table User_roles(
                           Id_user_role BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                           User_id BIGINT NOT NULL,
                           CONSTRAINT FK_User_roles_Users FOREIGN KEY (User_id) REFERENCES Users (Id_user)
                               ON DELETE CASCADE,
                           Role_id INT NOT NULL,
                           CONSTRAINT FK_User_roles_Roles FOREIGN KEY (Role_id) REFERENCES Roles (Id_role)
                               ON DELETE CASCADE,
                           UNIQUE(User_id, Role_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table Requests(
                           Id_request INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                           User_id_request BIGINT NULL,
                           CONSTRAINT FK_Requests_Users FOREIGN KEY (User_id_request) REFERENCES Users (Id_user)
                               ON delete set null on update restrict,
                           Request_text VARCHAR(500) NULL,
                           Created_date_request DateTime NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table Messages(
                         Id_message BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         Id_request INT NULL,
                         CONSTRAINT FK_Messages_Requests FOREIGN KEY (Id_request) REFERENCES Requests (Id_request)
                             ON delete set null on update restrict,
                         User_id_response BIGINT NOT NULL,
                         CONSTRAINT FK_Messages_Users FOREIGN KEY (User_id_response) REFERENCES Users (Id_user)
                             ON DELETE CASCADE,
                         Response_text VARCHAR(500) NULL,
                         Created_date_response DateTime NULL,
                         Updated_date_response DateTime NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO Users (Id_User, User_name, Password, Word_coder, Status, email, First_name, Last_name, Created_date, Updated_date) VALUES (1,'vldmr','42f846961c6718e804bcdd0f04d32a9d44fa3a4a51d4983026bd8b31525af5b5',
                                                                                                                          'vldmr','ACTION','vldmr@gmail.com','Vladimir','S','2020.10.25','2020.10.25');
INSERT INTO Roles VALUES (1,'ADMIN');
INSERT INTO Roles VALUES (2,'USER');
INSERT INTO User_roles VALUES (1,1,1);
