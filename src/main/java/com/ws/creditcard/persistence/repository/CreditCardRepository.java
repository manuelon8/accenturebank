package com.ws.creditcard.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ws.creditcard.model.Creditcard;

@Repository
public interface CreditCardRepository extends JpaRepository<Creditcard, Long>{

}
