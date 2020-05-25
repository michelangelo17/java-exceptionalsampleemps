# Java Sample Employee Modeling Data

## Introduction

This project is used to introduce Java Spring REST API CRUD applications. As such it is a small application showing just the code that is needed to explain the topic.

## Database layout

The table layouts are as follows:

- Employee is the driving table
- Email has a Many-To-One relationship with Employee. Each employee has many emails. Each email has only one employee
- Jobtitles has a Many-To-Many relationship with Employee
- EmployeeTitles is the join table to represent the Many-To_Many relationship between Employee and JobTitles

![Image of Database Layout](sampleemps-db.png)

When you first run the application, in the console window you will see something like the following due to a try..catch failing to read an environment variable.

```TEXT
No Such Environment Variable
No Such Environment Variable
```

When you first run the application, in the console window you will see something like the following due to validation errors in the seed data. Expand to see the output

<details>
<summary>Console Output</summary>

```TEXT
Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
2020-05-24 12:43:30.646 ERROR 2018 --- [  restartedMain] o.s.boot.SpringApplication               : Application run failed

java.lang.IllegalStateException: Failed to execute CommandLineRunner
    at org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:787) ~[spring-boot-2.2.2.RELEASE.jar:2.2.2.RELEASE]
    at org.springframework.boot.SpringApplication.callRunners(SpringApplication.java:768) ~[spring-boot-2.2.2.RELEASE.jar:2.2.2.RELEASE]
    at org.springframework.boot.SpringApplication.run(SpringApplication.java:322) ~[spring-boot-2.2.2.RELEASE.jar:2.2.2.RELEASE]
    at org.springframework.boot.SpringApplication.run(SpringApplication.java:1226) ~[spring-boot-2.2.2.RELEASE.jar:2.2.2.RELEASE]
    at org.springframework.boot.SpringApplication.run(SpringApplication.java:1215) ~[spring-boot-2.2.2.RELEASE.jar:2.2.2.RELEASE]
    at com.lambdaschool.sampleemps.SampleempsApplication.main(SampleempsApplication.java:21) ~[classes/:na]
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:na]
    at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
    at java.base/java.lang.reflect.Method.invoke(Method.java:566) ~[na:na]
    at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:49) ~[spring-boot-devtools-2.2.2.RELEASE.jar:2.2.2.RELEASE]
Caused by: org.springframework.transaction.TransactionSystemException: Could not commit JPA transaction; nested exception is javax.persistence.RollbackException: Error while committing the transaction
    at org.springframework.orm.jpa.JpaTransactionManager.doCommit(JpaTransactionManager.java:543) ~[spring-orm-5.2.2.RELEASE.jar:5.2.2.RELEASE]
    at org.springframework.transaction.support.AbstractPlatformTransactionManager.processCommit(AbstractPlatformTransactionManager.java:744) ~[spring-tx-5.2.2.RELEASE.jar:5.2.2.RELEASE]
    at org.springframework.transaction.support.AbstractPlatformTransactionManager.commit(AbstractPlatformTransactionManager.java:712) ~[spring-tx-5.2.2.RELEASE.jar:5.2.2.RELEASE]
    at org.springframework.transaction.interceptor.TransactionAspectSupport.commitTransactionAfterReturning(TransactionAspectSupport.java:631) ~[spring-tx-5.2.2.RELEASE.jar:5.2.2.RELEASE]
    at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:385) ~[spring-tx-5.2.2.RELEASE.jar:5.2.2.RELEASE]
    at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:99) ~[spring-tx-5.2.2.RELEASE.jar:5.2.2.RELEASE]
    at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186) ~[spring-aop-5.2.2.RELEASE.jar:5.2.2.RELEASE]
    at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747) ~[spring-aop-5.2.2.RELEASE.jar:5.2.2.RELEASE]
    at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:689) ~[spring-aop-5.2.2.RELEASE.jar:5.2.2.RELEASE]
    at com.lambdaschool.sampleemps.SeedData$$EnhancerBySpringCGLIB$$7bf41b9d.run(<generated>) ~[classes/:na]
    at org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:784) ~[spring-boot-2.2.2.RELEASE.jar:2.2.2.RELEASE]
    ... 10 common frames omitted
Caused by: javax.persistence.RollbackException: Error while committing the transaction
    at org.hibernate.internal.ExceptionConverterImpl.convertCommitException(ExceptionConverterImpl.java:81) ~[hibernate-core-5.4.9.Final.jar:5.4.9.Final]
    at org.hibernate.engine.transaction.internal.TransactionImpl.commit(TransactionImpl.java:104) ~[hibernate-core-5.4.9.Final.jar:5.4.9.Final]
    at org.springframework.orm.jpa.JpaTransactionManager.doCommit(JpaTransactionManager.java:534) ~[spring-orm-5.2.2.RELEASE.jar:5.2.2.RELEASE]
    ... 20 common frames omitted
Caused by: javax.validation.ConstraintViolationException: Validation failed for classes [com.lambdaschool.sampleemps.models.Employee] during persist time for groups [javax.validation.groups.Default, ]
List of constraint violations:[
    ConstraintViolationImpl{interpolatedMessage='must be greater than or equal to 100000.0', propertyPath=salary, rootBeanClass=class com.lambdaschool.sampleemps.models.Employee, messageTemplate='{javax.validation.constraints.DecimalMin.message}'}
]
    at org.hibernate.cfg.beanvalidation.BeanValidationEventListener.validate(BeanValidationEventListener.java:140) ~[hibernate-core-5.4.9.Final.jar:5.4.9.Final]
    at org.hibernate.cfg.beanvalidation.BeanValidationEventListener.onPreInsert(BeanValidationEventListener.java:80) ~[hibernate-core-5.4.9.Final.jar:5.4.9.Final]
    at org.hibernate.action.internal.EntityInsertAction.preInsert(EntityInsertAction.java:211) ~[hibernate-core-5.4.9.Final.jar:5.4.9.Final]
    at org.hibernate.action.internal.EntityInsertAction.execute(EntityInsertAction.java:84) ~[hibernate-core-5.4.9.Final.jar:5.4.9.Final]
    at org.hibernate.engine.spi.ActionQueue.executeActions(ActionQueue.java:604) ~[hibernate-core-5.4.9.Final.jar:5.4.9.Final]
    at org.hibernate.engine.spi.ActionQueue.lambda$executeActions$1(ActionQueue.java:478) ~[hibernate-core-5.4.9.Final.jar:5.4.9.Final]
    at java.base/java.util.LinkedHashMap.forEach(LinkedHashMap.java:684) ~[na:na]
    at org.hibernate.engine.spi.ActionQueue.executeActions(ActionQueue.java:475) ~[hibernate-core-5.4.9.Final.jar:5.4.9.Final]
    at org.hibernate.event.internal.AbstractFlushingEventListener.performExecutions(AbstractFlushingEventListener.java:348) ~[hibernate-core-5.4.9.Final.jar:5.4.9.Final]
    at org.hibernate.event.internal.DefaultFlushEventListener.onFlush(DefaultFlushEventListener.java:40) ~[hibernate-core-5.4.9.Final.jar:5.4.9.Final]
    at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:108) ~[hibernate-core-5.4.9.Final.jar:5.4.9.Final]
    at org.hibernate.internal.SessionImpl.doFlush(SessionImpl.java:1344) ~[hibernate-core-5.4.9.Final.jar:5.4.9.Final]
    at org.hibernate.internal.SessionImpl.managedFlush(SessionImpl.java:435) ~[hibernate-core-5.4.9.Final.jar:5.4.9.Final]
    at org.hibernate.internal.SessionImpl.flushBeforeTransactionCompletion(SessionImpl.java:3221) ~[hibernate-core-5.4.9.Final.jar:5.4.9.Final]
    at org.hibernate.internal.SessionImpl.beforeTransactionCompletion(SessionImpl.java:2389) ~[hibernate-core-5.4.9.Final.jar:5.4.9.Final]
    at org.hibernate.engine.jdbc.internal.JdbcCoordinatorImpl.beforeTransactionCompletion(JdbcCoordinatorImpl.java:447) ~[hibernate-core-5.4.9.Final.jar:5.4.9.Final]
    at org.hibernate.resource.transaction.backend.jdbc.internal.JdbcResourceLocalTransactionCoordinatorImpl.beforeCompletionCallback(JdbcResourceLocalTransactionCoordinatorImpl.java:183) ~[hibernate-core-5.4.9.Final.jar:5.4.9.Final]
    at org.hibernate.resource.transaction.backend.jdbc.internal.JdbcResourceLocalTransactionCoordinatorImpl.access$300(JdbcResourceLocalTransactionCoordinatorImpl.java:40) ~[hibernate-core-5.4.9.Final.jar:5.4.9.Final]
    at org.hibernate.resource.transaction.backend.jdbc.internal.JdbcResourceLocalTransactionCoordinatorImpl$TransactionDriverControlImpl.commit(JdbcResourceLocalTransactionCoordinatorImpl.java:281) ~[hibernate-core-5.4.9.Final.jar:5.4.9.Final]
    at org.hibernate.engine.transaction.internal.TransactionImpl.commit(TransactionImpl.java:101) ~[hibernate-core-5.4.9.Final.jar:5.4.9.Final]
    ... 21 common frames omitted
```

</details>

The following routes generate some of the custom exceptions we have added to this application

Resource Not Found: http://localhost:2019/employees/employee/9999

```JSON
{
    "title": "Resource Not Found",
    "status": 404,
    "detail": "Error from a Lambda School Application Employee id 9999 not found",
    "timestamp": "2020-05-24 13:24:48",
    "developerMessage": "com.lambdaschool.sampleemps.exceptions.ResourceNotFoundException",
    "errors": []
}
```

Wrong Data Type for Path Variable: http://localhost:2019/employees/employee/lambda

```JSON
{
    "title": "Rest Internal Exception",
    "status": 400,
    "detail": "Failed to convert value of type 'java.lang.String' to required type 'long'; nested exception is java.lang.NumberFormatException: For input string: \"lambda\"",
    "timestamp": "2020-05-24 13:23:37",
    "developerMessage": "org.springframework.web.method.annotation.MethodArgumentTypeMismatchException",
    "errors": []
}
```

Invalid Endpoint: http://localhost:2019/employees/turtles

```JSON
{
    "title": "Not Found",
    "status": 404,
    "detail": "No message available",
    "timestamp": "2020-05-24 13:25:57",
    "developerMessage": "path: /employees/turtles",
    "errors": []
}
```
