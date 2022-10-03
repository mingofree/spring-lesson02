CREATE TABLE task_type (
  id int NOT NULL,
  type varchar(20) NOT NULL,
  comment varchar(50) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE task (
  id int NOT NULL AUTO_INCREMENT,
  user_id int NOT NULL,
  type_id int NOT NULL,
  title varchar(50) NOT NULL,
  detail text,
  deadline datetime NOT NULL,
  PRIMARY KEY (id)
) ;

CREATE TABLE `user` (
  id int NOT NULL AUTO_INCREMENT,
  username varchar(50) NOT NULL,
  email varchar(70) NOT NULL,
  password varchar(60) NOT NULL,
  enabled tinyint NOT NULL,
  authority varchar(50) NOT NULL,
  tempkey varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);