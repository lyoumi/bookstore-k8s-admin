package com.k8s.bookstore.adminapp.repository;

import com.k8s.bookstore.adminapp.data.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {

}
