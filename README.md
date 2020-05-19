# Java Exceptional Sample Employee Data

## Introduction

This project is used to introduce custom exception handling to Java Spring REST API CRUD applications. As such it is a small application showing just the code that is needed to explain the topic.

## Database layout

The table layouts are as follows:

- Employee is the driving table
- Email has a Many-To-One relationship with Employee. Each employee has many emails. Each email has only one employee.
- Jobtitles has a Many-To-Many relationship with Employee

![Image of Database Layout](sampleemps-db.png)

Two different applications exist

- exceptionalsampleemps-initial - a starting which uses default custom handling
- exceptionalsampleemps - adds custom exception handling to the initial application
