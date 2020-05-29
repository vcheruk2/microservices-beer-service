package com.ravi.microservicesbeerservice.repositories;

import com.ravi.microservicesbeerservice.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

/* Created by: Venkata Ravichandra Cherukuri
   Created on: 5/28/2020 */
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
