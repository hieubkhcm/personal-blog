package com.henryece.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.henryece.model.Greeting;
//Define an interface named CoffeeRepository extends from CrudRepository to inherit all the need methods (meed to override all to be concrete???)
//This CrudRepository (belong to Spring) provides method to query database <-- no need to exclisive setting for database
@Repository
public interface GreetingRepository extends CrudRepository<Greeting, String>{} //need to inject to Controller so the controller can access to database
//CRUD: Create; Read; Update; Delete are related to SQL queries 
//JpaRepository
//public interface CoffeeRepository extends JpaRepository<Coffee, String>{} //need to inject to Controller so the controller can access to database

//CrudRepository<Type, ID> - the two parameters are first - the type , the second is the ID of each instance created from the interface!!