package com.example.springbootjpa.service;

import com.example.springbootjpa.domain.dto.HospitalResponse;
import com.example.springbootjpa.domain.entity.Hospital;
import com.example.springbootjpa.repository.HospitalRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }
    public List<HospitalResponse> getHospitals(Pageable pageable){
        Page<Hospital> hospitals=hospitalRepository.findAll(pageable);
        List<HospitalResponse> hospitalResponses=hospitals.stream()
                .map(hospital->HospitalResponse.of(hospital)).collect(Collectors.toList());
        return hospitalResponses;
    }
    public HospitalResponse getHospital(Integer id){
        Optional<Hospital> optionalHospital=hospitalRepository.findById(id);
        HospitalResponse hospitalResponse=HospitalResponse.of(optionalHospital.get());
        return hospitalResponse;
    }
}
