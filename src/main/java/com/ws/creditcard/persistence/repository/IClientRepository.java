package com.ws.creditcard.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ws.creditcard.model.Cliente;

@Repository
public interface IClientRepository extends JpaRepository<Cliente, Long>{

}
