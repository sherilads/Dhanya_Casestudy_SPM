package com.example.SimplepoolicyManagement;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PolicyRepository extends CrudRepository<Policy,Integer> {

}
