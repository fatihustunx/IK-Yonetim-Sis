package Kodlama.io.Kodlama.io.Devs.business.conceretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageCheckService;
import Kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.UpdateProgrammingLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;
import Kodlama.io.Kodlama.io.Devs.business.responses.GetByIdProgrammingLanguageResponse;
import Kodlama.io.Kodlama.io.Devs.core.utilities.mappers.ModelMapperService;
import Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Kodlama.io.Devs.entities.conceretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;
	private ProgrammingLanguageCheckService programmingLanguageCheckService;

	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllProgrammingLanguagesResponse> getAll() throws Exception {

		List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();

		if (programmingLanguages.isEmpty()) {

			throw new Exception("404 not found !");
		}

		List<GetAllProgrammingLanguagesResponse> programmingLanguagesResponse = programmingLanguages.stream()
				.map(programmingLanguage -> this.modelMapperService.forResponse().map(programmingLanguage,
						GetAllProgrammingLanguagesResponse.class))
				.collect(Collectors.toList());

		return programmingLanguagesResponse;
	}

	@Override
	public GetByIdProgrammingLanguageResponse getById(int id) throws Exception {

		Optional<ProgrammingLanguage> programmingLanguageOptional = programmingLanguageRepository.findById(id);

		if (programmingLanguageOptional.isPresent()) {

			GetByIdProgrammingLanguageResponse programmingLanguageResponse = this.modelMapperService.forResponse()
					.map(programmingLanguageOptional.get(), GetByIdProgrammingLanguageResponse.class);

			return programmingLanguageResponse;

		} else {
			throw new Exception("404 not found !");
		}
	}

	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {

		if (programmingLanguageCheckService.checkCreateProgrammingLanguage(createProgrammingLanguageRequest,
				getAll())) {

			ProgrammingLanguage programmingLanguage = this.modelMapperService.forRequest()
					.map(createProgrammingLanguageRequest, ProgrammingLanguage.class);

			programmingLanguageRepository.save(programmingLanguage);

		} else {
			throw new Exception("Check the programming language you are trying to add !");
		}
	}

	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {

		if (getAll() == null) {
			throw new Exception("Programming languages list is null !");
		}

		for (GetAllProgrammingLanguagesResponse getProgrammingLanguageResponse : getAll()) {

			if (updateProgrammingLanguageRequest.getId() == getProgrammingLanguageResponse.getId()) {

				if (programmingLanguageCheckService.checkUpdateProgrammingLanguage(updateProgrammingLanguageRequest,
						getAll())) {

					ProgrammingLanguage programmingLanguage = this.modelMapperService.forRequest()
							.map(updateProgrammingLanguageRequest, ProgrammingLanguage.class);

					this.programmingLanguageRepository.save(programmingLanguage);

				} else {
					throw new Exception("Check the programming language you are trying to update !");
				}
			} else {
				throw new Exception("Check the programming language's id you are trying to update !");
			}
		}
	}

	@Override
	public void delete(int id) throws Exception {

		Optional<ProgrammingLanguage> optionalProgrammingLanguage = programmingLanguageRepository.findById(id);

		if (optionalProgrammingLanguage.isPresent()) {
			programmingLanguageRepository.deleteById(id);
		} else {
			throw new Exception("404 not found ! | Check the programming language's id you are trying to delete !");
		}
	}

}