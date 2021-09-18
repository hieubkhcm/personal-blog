package com.henryece.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.henryece.model.Post;
//Define an interface named PostRepository extends from CrudRepository to inherit all the need methods (meed to override all to be concrete???)
//This CrudRepository (belong to Spring) provides method to query database <-- no need to exclisive setting for database
@Repository
public interface PostRepository extends CrudRepository<Post, String>{} //need to inject to Controller so the controller can access to database
//CRUD: Create; Read; Update; Delete are related to SQL queries 
//JpaRepository
//public interface PostRepository extends JpaRepository<Post, String>{} //need to inject to Controller so the controller can access to database
