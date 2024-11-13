package com.ct5106.StockManagementSystem.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource(exported = false)
public interface AppUserRepository extends CrudRepository<AppUser, Long>
{
// just adding a query to find user by username
Optional<AppUser> findByUsername(String username);


}


