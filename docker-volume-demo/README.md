# Docker Volumes – MySQL Data Persistence

## Objective
Create a MySQL Docker container using a named volume and verify that database data persists after deleting and recreating the container.

## Tools Used
- Docker
- MySQL 8.0
- Git Bash

## Step 1: Create Docker Volume
docker volume create mysql-data

## Step 2: Create MySQL Container
docker run -d --name mysql-demo -e MYSQL_ROOT_PASSWORD=Root@123 -e MYSQL_DATABASE=devopsdb -v mysql-data:/var/lib/mysql -p 3306:3306 mysql:8.0

## Step 3: Connect to MySQL
docker exec -it mysql-demo mysql -uroot -p

## Step 4: Insert Sample Data
USE devopsdb;

CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(100)
);

INSERT INTO employees (name, department)
VALUES
('Rahman', 'DevOps'),
('Amit', 'Cloud'),
('John', 'Linux');

SELECT * FROM employees;

## Step 5: Delete Container
docker stop mysql-demo
docker rm mysql-demo

## Step 6: Recreate Container
docker run -d --name mysql-demo -e MYSQL_ROOT_PASSWORD=Root@123 -e MYSQL_DATABASE=devopsdb -v mysql-data:/var/lib/mysql -p 3306:3306 mysql:8.0

## Step 7: Verify Data Persistence
USE devopsdb;
SELECT * FROM employees;

## Expected Result
1 | Rahman | DevOps
2 | Amit | Cloud
3 | John | Linux

## Conclusion
Docker named volumes preserve database data independently of the container lifecycle.
