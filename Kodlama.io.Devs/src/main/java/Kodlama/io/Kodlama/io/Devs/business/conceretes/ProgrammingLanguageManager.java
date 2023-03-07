package Kodlama.io.Kodlama.io.Devs.business.conceretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.UpdateProgrammingLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;
import Kodlama.io.Kodlama.io.Devs.business.responses.GetByIdProgrammingLanguageResponse;
import Kodlama.io.Kodlama.io.Devs.business.rules.ProgrammingLanguageBusinessRules;
import Kodlama.io.Kodlama.io.Devs.core.utilities.mappers.ModelMapperService;
import Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Kodlama.io.Devs.entities.conceretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;
	private ProgrammingLanguageBusinessRules programmingLanguageBusinessRules;

	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllProgrammingLanguagesResponse> getAll() {

		this.programmingLanguageBusinessRules.checkIfProgrammingLanguagesListExists();

		List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();

		List<GetAllProgrammingLanguagesResponse> programmingLanguagesResponse = programmingLanguages.stream()
				.map(programmingLanguage -> this.modelMapperService.forResponse().map(programmingLanguage,
						GetAllProgrammingLanguagesResponse.class))
				.collect(Collectors.toList());

		return programmingLanguagesResponse;
	}

	@Override
	public GetByIdProgrammingLanguageResponse getById(int id) {

		this.programmingLanguageBusinessRules.checkIfProgrammingLanguageIdExistsNot(id);

		ProgrammingLanguage programmingLanguageOptional = programmingLanguageRepository.findById(id).orElseThrow();

		GetByIdProgrammingLanguageResponse programmingLanguageResponse = this.modelMapperService.forResponse()
				.map(programmingLanguageOptional, GetByIdProgrammingLanguageResponse.class);

		return programmingLanguageResponse;
	}

	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {

		this.programmingLanguageBusinessRules
				.checkIfProgrammingLanguageNameExists(createProgrammingLanguageRequest.getName());

		ProgrammingLanguage programmingLanguage = this.modelMapperService.forRequest()
				.map(createProgrammingLanguageRequest, ProgrammingLanguage.class);

		this.programmingLanguageRepository.save(programmingLanguage);
	}

	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {

		this.programmingLanguageBusinessRules.checkIfProgrammingLanguagesListExists();

		this.programmingLanguageBusinessRules
				.checkIfProgrammingLanguageIdExistsNot(updateProgrammingLanguageRequest.getId());

		this.programmingLanguageBusinessRules
				.checkIfProgrammingLanguageNameExists(updateProgrammingLanguageRequest.getName());

		ProgrammingLanguage programmingLanguage = this.modelMapperService.forRequest()
				.map(updateProgrammingLanguageRequest, ProgrammingLanguage.class);

		this.programmingLanguageRepository.save(programmingLanguage);
	}

	@Override
	public void delete(int id) {

		this.programmingLanguageBusinessRules.checkIfProgrammingLanguageIdExistsNot(id);

		this.programmingLanguageRepository.deleteById(id);
	}

}