package Kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import Kodlama.io.Kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;

public interface ProgrammingLanguageCheckService {

	boolean checkProgrammingLanguage(CreateProgrammingLanguageRequest createProgrammingLanguageRequest,
			ResponseEntity<List<GetAllProgrammingLanguagesResponse>> getAllProgrammingLanguagesResponses);
}
