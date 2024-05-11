USE vli;
CREATE TABLE IF NOT EXISTS user_table (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    user_role ENUM('USER') NOT NULL,
    is_active BOOLEAN NOT NULL
);

-- Definition for `student_table`
CREATE TABLE IF NOT EXISTS student_table (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    user_role ENUM('STUDENT') NOT NULL,
    name_course VARCHAR(255),
    avarage_mark_by_course DOUBLE,
    is_active BOOLEAN NOT NULL
);

-- Definition for `teacher_table`
CREATE TABLE IF NOT EXISTS teacher_table (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    user_role ENUM('TEACHER') NOT NULL,
    name_course VARCHAR(255),
    is_active BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS course_table (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    time_start VARCHAR(255),
    time_finish VARCHAR(255),
    day_of_week VARCHAR(255) NOT NULL,
    list_student TEXT
);
