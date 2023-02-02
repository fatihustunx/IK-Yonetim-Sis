package Kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;

@RestController // annotation
@RequestMapping("/api/programmingLanguages")
public class ProgrammingLanguagesController {

	private ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}

	@GetMapping("/getall")
	public List<GetAllProgrammingLanguagesResponse> getAll() {

		return programmingLanguageService.getAll();
	}
	
	@PostMapping("/add")
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		this.programmingLanguageService.add(createProgrammingLanguageRequest);
	}
	/**
	@PutMapping("/update")
	public void update(GetAllProgrammingLanguagesResponse getProgrammingLanguageResponse,
			CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		this.programmingLanguageService.update(getProgrammingLanguageResponse, createProgrammingLanguageRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(GetAllProgrammingLanguagesResponse getProgrammingLanguageResponse) throws Exception {
		this.programmingLanguageService.delete(getProgrammingLanguageResponse);
	}
	**/
	@GetMapping("/getwithid")
	public GetAllProgrammingLanguagesResponse getWithId(int id) throws Exception {
		return programmingLanguageService.getWithId(id);
	}
}
