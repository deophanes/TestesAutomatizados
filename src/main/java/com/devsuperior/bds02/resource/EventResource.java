package com.devsuperior.bds02.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.repository.CityRepository;
import com.devsuperior.bds02.service.EventService;

@RestController
@RequestMapping("/events")
public class EventResource {

	@Autowired
	EventService service;

	@Autowired
	CityRepository cityRepository;

	@PutMapping(value = "/{id}")
	public ResponseEntity<EventDTO> update(@PathVariable Long id, @RequestBody EventDTO eventDTO) {

		return service.findById(id).map(x -> {
			x.setName(eventDTO.getName());
			x.setDate(eventDTO.getDate());
			x.setUrl(eventDTO.getUrl());

			City city = cityRepository.getOne(eventDTO.getCityId());
			x.setCity(city);

			EventDTO updated = service.update(id, eventDTO);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

}
