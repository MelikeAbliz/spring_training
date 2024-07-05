package com.cydeo.repository;

import com.cydeo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state
    List<Account> findAccountByCountryOrState(String country,String state);


    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<Account> findByAgeLessThanEqual(int age);


    //Write a derived query to list all accounts with a specific role
    List<Account> findByRoleContaining(String role);

    //Write a derived query to list all accounts between a range of ages
    List<Account> findByAgeBetween(int age1,int age2);

    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<Account> findByAddressStartingWith(String keyword);

    //Write a derived query to sort the list of accounts with age
    List<Account> findByAgeOrderByAge(int age);


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts
    @Query("SELECT a FROM Account a")
    List<Account> retrieveAllAccounts();


    //Write a JPQL query to list all admin accounts
    @Query("SELECT a FROM Account a where a.role='admin'")
    List<Account> retrieveAdminAccounts(String role);


    //Write a JPQL query to sort all accounts with age
    @Query("SELECT a FROM Account a order by a.age")
    List<Account> retrieveAccountsWithAge();


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "SELECT * FROM account_details WHERE age < ?1",nativeQuery = true)
    List<Account> filterAccountByAgeLessThan(Integer age);


    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city
    @Query(value = "SELECT * FROM account_details WHERE name ilike concat('%',?1,'%') or address ilike concat('%',?1,'%')" +
            "or country ilike concat('%',?1,'%') or state ilike concat('%',?1,'%') or city ilike concat('%',?1,'%')",nativeQuery = true)
    List<Account> retrieveAllSearchCriteria(String pattern);

    //Write a native query to read all accounts with an age higher than a specific value
    @Query(value = "SELECT * FROM account_details WHERE age > ?1",nativeQuery = true)
    List<Account> filterAccountByAgeGreaterThan(Integer age);
    @Query(value = "SELECT * FROM account_details WHERE age > :age",nativeQuery = true)
    List<Account> filterAccountByAgeGreaterThan2(@Param("age") Integer age);

}