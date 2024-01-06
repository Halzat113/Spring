package com.example.repository;

import com.example.entity.Account;
import com.example.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account,Long> {
    //list all accounts with a specific country or state
    List<Account> findAllByCountryOrState(String country,String state) ;
    //list all accounts with age lower than or equal to a specific value
    List<Account> findAllByAgeLessThanEqual(Integer age);
    //list all accounts with specific role
    List<Account> findAllByRole(UserRole role);
    //list all accounts between a range of ages
    List<Account> findAllByAgeBetween(Integer start,Integer end);
    //fist all accounts where the beginning of the address contains the keyword
    List<Account> findAllByAddressStartingWith(String keyWord);
    //sort the list of accounts with age;
    List<Account> findAllByOrderByAgeDesc();

    //  ---------------------------JPQL QUERIES---------------------------
    //query that returns all accounts
    @Query("SELECT a from Account a")
    List<Account> listAllAccounts();

    //list all admin accounts
    @Query("SELECT a from Account a where a.role='ADMIN'")
    List<Account> listALlAdminAccounts();

    //sort all accounts with age
    @Query("SELECT a from Account a order by a.age")
    List<Account> listAllAccountsOrderByAge();

    //  ---------------------------Native QUERIES---------------------------

    //real all accounts with an age lower than a specific value
    @Query(value = "SELECT * from account_details where age < ?1",nativeQuery = true)
    List<Account> listAccountsWithAnAgeLowerThan(Integer age);

    // read all accounts that a specific value can be containable in the name,address, country, state city
    @Query(value = "SELECT * from account_details where name ILIKE concat('%','?1','%') OR"+
            "address ILIKE concat('%','?1','%') OR",nativeQuery = true)
    List<Account> listAllBySearchCriteria(String placeName);


}
