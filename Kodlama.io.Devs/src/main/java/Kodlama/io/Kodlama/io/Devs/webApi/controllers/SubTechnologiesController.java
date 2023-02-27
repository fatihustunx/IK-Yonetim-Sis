package Kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.SubTechnologyService;
import Kodlama.io.Kodlama.io.Devs.business.requests.CreateSubTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.UpdateSubTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.GetSubTechnologyResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/subTechnologies")
@AllArgsConstructor
public class SubTechnologiesController {

	private SubTechnologyService subTechnologyService;

	@PostMapping("/add")
	void add(@RequestBody CreateSubTechnologyRequest createSubTechnologyRequest) throws Exception {
		this.subTechnologyService.add(createSubTechnologyRequest);
	}

	@PutMapping("/update")
	void update(UpdateSubTechnologyRequest updateSubTechnologyRequest) throws Exception {
		this.subTechnologyService.update(updateSubTechnologyRequest);
	}

	@DeleteMapping("/delete/{id}")
	void delete(@PathVariable int id) throws Exception {
		this.subTechnologyService.delete(id);
	}

	@GetMapping("/getwithid")
	ResponseEntity<GetSubTechnologyResponse> getWithId(int id) {
		return subTechnologyService.getWithId(id);
	}

	@GetMapping("/getall")
	ResponseEntity<List<GetSubTechnologyResponse>> getAll() {
		return subTechnologyService.getAll();
	}
}
