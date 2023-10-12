package com.airlineSystem.airline.Repositories;

import com.airlineSystem.airline.Entities.Customer;
import com.airlineSystem.airline.Entities.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByCustomerName(String customerName);

    Customer findByCustomerNameLike(String customerName);

    Customer findByCustomerStatus(String customerStatus);

    Customer findByTotalCustomerMileage(Integer totalCustomerMileage);

    List<Customer> findCustomerByCustomerName(String name);

    List<Customer> findCustomerByCustomerStatus(CustomerStatus status);


    //I keep this codes for training typing.
//    Customer findByCustomerStatusAndTotalCustomerMileage(String customerStatus, Integer totalCustomerMileage);
//    Customer findByCustomerNameAndCustomerStatus(String customerName, String customerStatus);
//    Customer findByCustomerNameAndCustomerStatusAndTotalCustomerMileage(String customerName, String customerStatus, Integer totalCustomerMileage);
//    Customer findByCustomerNameAndCustomerStatusAndTotalCustomerMileage(String customerName, String customerStatus, Integer totalCustomerMileage, Integer customerId);
//    Customer findByCustomerNameAndCustomerStatusAndTotalCustomerMileage(String customerName, String customerStatus, Integer totalCustomerMileage, Integer customerId, Integer customerId1);
//

}
