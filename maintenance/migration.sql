-- 2016-07-12
mysql> UPDATE restaurant_menu SET restaurant_id = 31 WHERE menu_id = 37;                                        
Query OK, 1 row affected (0.09 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql>

-- 2016-06-18
mysql> INSERT INTO food_type (name) VALUES ('비빔 냉면');
Query OK, 1 row affected (0.00 sec)

mysql> INSERT INTO menu_item (name, price, food_type_id, rating_score) VALUES ('비빔냉면', 8500, 12, 4);
Query OK, 1 row affected (0.03 sec)

mysql> INSERT INTO restaurant_menu VALUES (18, 15);
Query OK, 1 row affected (0.00 sec)

mysql>

-- 2016-06-10 2nd
mysql> INSERT INTO restaurant_landmarks VALUES (9, 6);
Query OK, 1 row affected (0.01 sec)

mysql> INSERT INTO menu_item (name, price, food_type_id, rating_score) VALUES ('참명란비빔밥', 8000, 3, 4);
Query OK, 1 row affected (0.01 sec)

mysql> INSERT INTO restaurant_menu VALUES (9, 5);
Query OK, 1 row affected (0.00 sec)

mysql> UPDATE restaurant SET name = '할머니의 레시피' WHERE id = 10;
Query OK, 1 row affected (0.00 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> INSERT INTO food_type (name) VALUES ('불고기');
Query OK, 1 row affected (0.01 sec)

mysql> INSERT INTO menu_item (name, price, food_type_id, rating_score) VALUES ('바싹불고기', 22000, 5, 4);
Query OK, 1 row affected (0.00 sec)

mysql> INSERT INTO restaurant_menu VALUES (10, 6);
Query OK, 1 row affected (0.03 sec)

mysql>

-- 2016-06-10
mysql> UPDATE restaurant SET rating_score = 4 WHERE id = 1;
Query OK, 1 row affected (0.04 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> UPDATE restaurant SET rating_score = 3 WHERE id = 8;
Query OK, 1 row affected (0.01 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> UPDATE menu_item SET rating_score = 4 WHERE id = 1;
Query OK, 1 row affected (0.00 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> UPDATE menu_item SET rating_score = 3 WHERE id = 2;
Query OK, 1 row affected (0.00 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql>

-- 2016-06-09 2nd
mysql> INSERT INTO food_type (name) VALUES ('돈까스');
Query OK, 1 row affected (0.00 sec)

mysql> INSERT INTO food_type (name) VALUES ('함박 스테이크');
Query OK, 1 row affected (0.01 sec)

mysql> INSERT INTO menu_item (name, price, food_type_id) VALUES ('생등심 돈까스', 7000, 1);
Query OK, 1 row affected (0.00 sec)

mysql> INSERT INTO menu_item (name, price, food_type_id) VALUES ('램버그스테이크', 10000, 2);
Query OK, 1 row affected (0.00 sec)

mysql> INSERT INTO restaurant_menu VALUES (1, 1);
Query OK, 1 row affected (0.02 sec)

mysql> INSERT INTO restaurant_menu VALUES (8, 2);
Query OK, 1 row affected (0.00 sec)

mysql>

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