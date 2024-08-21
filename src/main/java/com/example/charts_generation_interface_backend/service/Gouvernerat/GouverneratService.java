package com.example.charts_generation_interface_backend.service.Gouvernerat;

import com.example.charts_generation_interface_backend.entity.Gouvernerat;
import com.example.charts_generation_interface_backend.repository.GouverneratRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Builder
@Service
@AllArgsConstructor
public class GouverneratService implements IGouverneratService{
    @Autowired
    GouverneratRepository gouverneratRepository;


    @Override
    public List<Gouvernerat> getAllgouv() {
        return gouverneratRepository.findAll();
    }
}
