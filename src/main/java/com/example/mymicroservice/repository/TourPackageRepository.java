package com.example.mymicroservice.repository;

import com.example.mymicroservice.domain.TourPackage;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TourPackageRepository extends CrudRepository<TourPackage, String> {
    Optional<TourPackage> findByName(String name);
}
