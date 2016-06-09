-- 2016-06-09
mysql> INSERT INTO landmark (name) VALUES ('오리역');
Query OK, 1 row affected (0.00 sec)

mysql> INSERT INTO landmark (name) VALUES ('그린팩토리');
Query OK, 1 row affected (0.00 sec)

mysql> INSERT INTO landmark (name) VALUES ('정자역');
Query OK, 1 row affected (0.00 sec)

mysql> INSERT INTO restaurant_landmarks VALUES (1, 1);
Query OK, 1 row affected (0.00 sec)

mysql> INSERT INTO restaurant_landmarks VALUES (8, 2);
Query OK, 1 row affected (0.01 sec)

mysql> INSERT INTO restaurant_landmarks VALUES (8, 3);
Query OK, 1 row affected (0.00 sec)

mysql>

-- 2016-06-04
mysql> INSERT INTO message(body) (SELECT name FROM restaurant WHERE id != 1);
Query OK, 6 rows affected (0.17 sec)
Records: 6  Duplicates: 0  Warnings: 0

mysql> DELETE FROM restaurant WHERE id != 1;
Query OK, 6 rows affected (0.06 sec)

mysql>