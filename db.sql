CREATE TABLE students (
    student_id      INTEGER(10)     PRIMARY KEY,
    registration    VARCHAR(10)     UNIQUE NOT NULL,
    name            VARCHAR(255)    NOT NULL,
    cpf             VARCHAR(14)     UNIQUE NOT NULL,
    address         VARCHAR(255)    NOT NULL
);

CREATE TABLE courses (
    course_id       INTEGER(10)     PRIMARY KEY,
    code            VARCHAR(8)      NOT NULL,
    name            VARCHAR(255)    NOT NULL,
    course_class    INTEGER(3)      NOT NULL,
    schedule        VARCHAR(2)      NOT NULL,

    UNIQUE(code, course_class)
);

CREATE TABLE students_courses (
    student_id  INTEGER(10) REFERENCES students(student_id),
    course_id   INTEGER(10) REFERENCES courses(course_id),

    PRIMARY KEY(student_id, course_id)
);

CREATE TABLE users (
    user_id     SERIAL          PRIMARY KEY,
    name        VARCHAR(255)    NOT NULL,
    email       VARCHAR(255)    UNIQUE NOT NULL,
    password    VARCHAR(255)    NOT NULL
);