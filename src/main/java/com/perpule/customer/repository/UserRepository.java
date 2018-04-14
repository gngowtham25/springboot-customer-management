package com.perpule.customer.repository;

import com.perpule.customer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Gowtham on 14/04/18.
 */
public interface UserRepository extends JpaRepository<User, String> {


}
