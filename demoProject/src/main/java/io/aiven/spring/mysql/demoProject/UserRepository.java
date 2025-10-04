package io.aiven.spring.mysql.demoProject;

import org.springframework.data.repository.CrudRepository;

import io.aiven.spring.mysql.demoProject.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    // this is where application stores all the users
}
