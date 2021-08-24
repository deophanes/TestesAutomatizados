package com.devsuperior.bds02.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.repository.CityRepository;

@Service
public class CityService {

	@Autowired
	CityRepository repository;

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public Optional<City> findById(Long id) {
		return repository.findById(id);
	}

	public List<CityDTO> findAll() {
		List<City> list = repository.findAll(Sort.by("name"));
		return list.stream().map(x -> new CityDTO(x)).collect(Collectors.toList());

	}

}
