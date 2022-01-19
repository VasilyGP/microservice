package com.example.mymicroservice.service;

import com.example.mymicroservice.domain.Difficulty;
import com.example.mymicroservice.domain.Region;
import com.example.mymicroservice.domain.Tour;
import com.example.mymicroservice.domain.TourPackage;
import com.example.mymicroservice.repository.TourPackageRepository;
import com.example.mymicroservice.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourService {

    @Autowired
    TourRepository tourRepository;

    @Autowired
    TourPackageRepository tourPackageRepository;

    public Tour createTour(String title,
                           String description,
                           String blurb,
                           Integer price,
                           String duration,
                           String bullets,
                           String keywords,
                           String tourPackageName,
                           Difficulty difficulty,
                           Region region) {
        TourPackage tourPackage = tourPackageRepository
                .findByName(tourPackageName)
                .orElseThrow(
                        () -> new RuntimeException("Tour Package does not exist " + tourPackageName)
                );
        return tourRepository.save(
                new Tour(title, description, blurb, price, duration,
                        bullets, keywords, tourPackage, difficulty, region));
    }

    public long getTourCount() {
        return tourRepository.count();
    }

}
