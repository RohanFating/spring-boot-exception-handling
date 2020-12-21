package com.myspace.demo.repository;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myspace.demo.models.User;


public interface UserRepository extends JpaRepository<User, Id> {

}
