package com.foodmood.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.foodmood.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

	

}
