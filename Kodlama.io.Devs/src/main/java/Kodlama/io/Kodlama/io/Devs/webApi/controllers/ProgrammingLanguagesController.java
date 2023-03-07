package Kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import javax.validation.Valid;

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

import Kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.UpdateProgrammingLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;
import Kodlama.io.Kodlama.io.Devs.business.responses.GetByIdProgrammingLanguageResponse;
import lombok.AllArgsConstructor;

@RestController // annotation
@RequestMapping("/api/programmingLanguages")
@AllArgsConstructor
public class ProgrammingLanguagesController {

	private ProgrammingLanguageService programmingLanguageService;

	@GetMapping
	public ResponseEntity<List<GetAllProgrammingLanguagesResponse>> getAll() throws Exception {

		return ResponseEntity.ok(this.programmingLanguageService.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<GetByIdProgrammingLanguageResponse> getById(@PathVariable int id) throws Exception {
		return ResponseEntity.ok(this.programmingLanguageService.getById(id));
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateProgrammingLanguageRequest createProgrammingLanguageRequest)
			throws Exception {
		this.programmingLanguageService.add(createProgrammingLanguageRequest);
	}

	@PutMapping
	public void update(@RequestBody @Valid UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest)
			throws Exception {
		this.programmingLanguageService.update(updateProgrammingLanguageRequest);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) throws Exception {
		this.programmingLanguageService.delete(id);
	}

}
