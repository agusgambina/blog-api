# noinspection SqlNoDataSourceInspectionForFile
# DROP DATABASE IF EXISTS blog_db;
# CREATE DATABASE blog_db DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
# USE blog_db;

# --- !Ups

CREATE TABLE IF NOT EXISTS posts(
  id int(11) NOT NULL auto_increment,
  title varchar(50) NOT NULL UNIQUE,
  body varchar(8000) NOT NULL,
  is_deleted boolean NOT NULL DEFAULT FALSE,
  creation_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  last_modification_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY  (id)
);

# --- !Downs

DROP TABLE posts;
