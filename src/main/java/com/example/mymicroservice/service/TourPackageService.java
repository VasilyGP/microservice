package com.example.mymicroservice.service;

import com.example.mymicroservice.domain.TourPackage;
import com.example.mymicroservice.repository.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourPackageService {

    @Autowired
    private TourPackageRepository tourPackageRepository;

    public TourPackage createTourPackage(String code, String name) {
        return tourPackageRepository.findById(code).orElse(
                tourPackageRepository.save(new TourPackage(code, name))
        );
    }

    public Iterable<TourPackage> getAllTourPackages() {
        return tourPackageRepository.findAll();
    }

    public long getPackageCount() {
        return tourPackageRepository.count();
    }
}
