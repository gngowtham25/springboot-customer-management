package com.perpule.customer.repository;

import com.perpule.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Gowtham on 13/04/18.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{


}
