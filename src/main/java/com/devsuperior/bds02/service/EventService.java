package com.devsuperior.bds02.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.repository.CityRepository;
import com.devsuperior.bds02.repository.EventRepository;

@Service
public class EventService {

	@Autowired
	EventRepository repository;

	@Autowired
	CityRepository cityRepository;

	@Transactional
	public EventDTO update(Long id, EventDTO dto) {
		Event entity = repository.getOne(id);
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new EventDTO(entity);
	}

	public Optional<Event> findById(Long id) {
		return repository.findById(id);
	}

	private void copyDtoToEntity(EventDTO dto, Event entity) {
		entity.setName(dto.getName());
		entity.setDate(dto.getDate());
		entity.setDate(dto.getDate());
		entity.setUrl(dto.getUrl());

		City city = cityRepository.getOne(dto.getCityId());
		entity.setCity(city);
	}
}
