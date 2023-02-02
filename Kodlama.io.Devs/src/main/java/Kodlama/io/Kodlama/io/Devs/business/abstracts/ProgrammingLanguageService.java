package Kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;

public interface ProgrammingLanguageService {

	void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;

	void update(GetAllProgrammingLanguagesResponse getProgrammingLanguageResponse,
			CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;

	void delete(GetAllProgrammingLanguagesResponse gtAllProgrammingLanguagesResponse) throws Exception;

	List<GetAllProgrammingLanguagesResponse> getAll();

	GetAllProgrammingLanguagesResponse getWithId(int id) throws Exception;
}
