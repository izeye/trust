-- 2016-06-04
mysql> INSERT INTO message(body) (SELECT name FROM restaurant WHERE id != 1);
Query OK, 6 rows affected (0.17 sec)
Records: 6  Duplicates: 0  Warnings: 0

mysql> DELETE FROM restaurant WHERE id != 1;
Query OK, 6 rows affected (0.06 sec)

mysql>