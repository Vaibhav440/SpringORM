# SpringORM

This project demonstrates a basic CRUD (Create, Read, Update, Delete) operation using Spring ORM, Hibernate, and MySQL with XML-based configuration.

🔧 Technologies Used
Java 17

Spring Framework 5.3.24

Spring ORM

Hibernate 5.6.14

HikariCP (Connection Pool)

MySQL 8.0.33

Maven

XML Configuration (No Java-based or Annotation-only config)

🗂️ Project Structure
![image](https://github.com/user-attachments/assets/4a03c927-5f3c-4cdc-88cb-e41128fde294)


⚙️ Configuration

applicationContext.xml

<!-- HikariCP DataSource -->
<bean id="hkDs" class="com.zaxxer.hikari.HikariDataSource">
  <property name="driverClassName" value="com.mysql.cj.jdbc.Driver" />
  <property name="jdbcUrl" value="jdbc:mysql://<host>:<port>/<db>" />
  <property name="username" value="root" />
  <property name="password" value="root" />
</bean>

<!-- SessionFactory with Hibernate -->
<bean id="localSesFact" class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
  <property name="dataSource" ref="hkDs" />
  <property name="annotatedClasses">
    <list>
      <value>com.nt.entity.Employee</value>
    </list>
  </property>
  <property name="hibernateProperties">
    <props>
      <prop key="hibernate.dialect">org.hibernate.dialect.MySQL5Dialect</prop>
      <prop key="hibernate.hbm2ddl.auto">update</prop>
      <prop key="hibernate.show_sql">true</prop>
    </props>
  </property>
</bean>

<!-- HibernateTemplate -->
<bean id="ht" class="org.springframework.orm.hibernate5.HibernateTemplate">
  <property name="sessionFactory" ref="localSesFact" />
</bean>

<!-- Transaction Manager -->
<bean id="hbTxMgmr" class="org.springframework.orm.hibernate5.HibernateTransactionManager">
  <property name="sessionFactory" ref="localSesFact" />
</bean>

<context:component-scan base-package="com.nt" />
<tx:annotation-driven transaction-manager="hbTxMgmr" />

🧾 Maven Dependencies (pom.xml)
Includes key dependencies for:

Spring Context, ORM

Hibernate Core

HikariCP for efficient pooling

Lombok (Optional)

MySQL Connector

📌 See full pom.xml in the project root.

🏃 How to Run
Set up the MySQL database:

Create a database (e.g., application)

Update credentials and URL in applicationContext.xml

Build the project:

bash
Copy
Edit
mvn clean install
Run the test or main class:

bash
Copy
Edit
java -cp target/ORMProj01-CURDOperations-0.0.1-SNAPSHOT.jar com.nt.test.YourTestClass

🧪 Example Entity
java
Copy
Edit
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer empId;
  
  private String name;
  private String role;
  private Double salary;
}

✨ Features
XML-based Spring configuration

Hibernate with annotation-based entities

HikariCP for high-performance DB connections

Basic CRUD: Add, Retrieve, Update, Delete

Lightweight and modular structure

📌 Notes
Lombok annotations require Lombok plugin in your IDE.

Hibernate hbm2ddl.auto=update is useful for dev/testing. For production, consider managing schema manually.

🧑‍💻 Author
Vaibhav Shete
Associate Software Developer
LinkedIn | GitHub
