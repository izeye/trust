CREATE DATABASE db_trust CHARACTER SET utf8;

GRANT ALL PRIVILEGES ON db_trust.* TO 'trust'@'%' IDENTIFIED BY 'secret';
GRANT ALL PRIVILEGES ON db_trust.* TO 'trust'@'localhost' IDENTIFIED BY 'secret';

FLUSH PRIVILEGES;
