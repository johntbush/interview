# interview

This project represents a developers first pass at implementing a bulk user import backend service.
The requirements are to import user records into a MySQL database in bulk in Java.
The schema for the table follows.

A junior engineer has submitted this work for review.
Your job it to code review this work, provide feedback on the approach taken and offer suggestions.

Pay attention to tests, frameworks selected, logging, and look for security and or performance considerations.

# Schema

```sql
     CREATE TABLE `Registration` (
       `id` int NOT NULL,
       `first` varchar(255) DEFAULT NULL,
       `last` varchar(255) DEFAULT NULL,
       `age` int DEFAULT NULL,
       PRIMARY KEY (`id`)
      ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```