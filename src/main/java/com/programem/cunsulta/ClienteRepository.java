package com.programem.cunsulta;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
    @Query(
        value = "SELECT * FROM cliente c WHERE c.idade >= :idade", 
        nativeQuery = true)
      Iterable<Cliente> findCliente(@Param("idade") Integer idade);
}