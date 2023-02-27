package Kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import Kodlama.io.Kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.UpdateProgrammingLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;

public interface ProgrammingLanguageService {

	void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;

	void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception;

	void delete(int id) throws Exception;

	ResponseEntity<GetAllProgrammingLanguagesResponse> getWithId(int id);

	ResponseEntity<List<GetAllProgrammingLanguagesResponse>> getAll();
}
