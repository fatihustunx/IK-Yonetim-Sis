package Kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.SubTechnologyService;
import Kodlama.io.Kodlama.io.Devs.business.requests.CreateSubTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.UpdateSubTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.GetAllSubTechnologiesResponse;
import Kodlama.io.Kodlama.io.Devs.business.responses.GetByIdSubTechnologyResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/subTechnologies")
@AllArgsConstructor
public class SubTechnologiesController {

	private SubTechnologyService subTechnologyService;

	@GetMapping
	ResponseEntity<List<GetAllSubTechnologiesResponse>> getAll() {
		return ResponseEntity.ok(subTechnologyService.getAll());
	}

	@GetMapping("/{id}")
	ResponseEntity<GetByIdSubTechnologyResponse> getWithId(@PathVariable int id) {
		return ResponseEntity.ok(subTechnologyService.getById(id));
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	void add(@RequestBody CreateSubTechnologyRequest createSubTechnologyRequest) {
		this.subTechnologyService.add(createSubTechnologyRequest);
	}

	@PutMapping
	void update(@RequestBody UpdateSubTechnologyRequest updateSubTechnologyRequest) {
		this.subTechnologyService.update(updateSubTechnologyRequest);
	}

	@DeleteMapping("/{id}")
	void delete(@PathVariable int id) {
		this.subTechnologyService.delete(id);
	}
}
