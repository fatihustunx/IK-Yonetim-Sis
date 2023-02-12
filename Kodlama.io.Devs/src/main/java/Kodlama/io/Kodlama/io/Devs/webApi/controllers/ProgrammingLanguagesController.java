package Kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.UpdateProgrammingLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;

@RestController // annotation
@RequestMapping("/api/programmingLanguages")
public class ProgrammingLanguagesController {

	private ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}

	@PostMapping("/add")
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		this.programmingLanguageService.add(createProgrammingLanguageRequest);
	}

	@PutMapping("/update")
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
		this.programmingLanguageService.update(updateProgrammingLanguageRequest);
	}

	@DeleteMapping("/delete")
	public void delete(int id) throws Exception {
		this.programmingLanguageService.delete(id);
	}

	@GetMapping("/getwithid")
	public ResponseEntity<GetAllProgrammingLanguagesResponse> getWithId(int id){
		return programmingLanguageService.getWithId(id);
	}

	@GetMapping("/getall")
	public ResponseEntity<List<GetAllProgrammingLanguagesResponse>> getAll() {

		return programmingLanguageService.getAll();
	}

}
