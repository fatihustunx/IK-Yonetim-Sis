package Kodlama.io.Kodlama.io.Devs.business.conceretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageCheckService;
import Kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.UpdateProgrammingLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;
import Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Kodlama.io.Devs.entities.conceretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;
	private ProgrammingLanguageCheckService programmingLanguageCheckService;

	private ModelMapper modelMapper;

	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {

		if (programmingLanguageCheckService.checkProgrammingLanguage(createProgrammingLanguageRequest, getAll())) {
			/*
			 * ProgrammingLanguage programmingLanguage=new ProgrammingLanguage();
			 * programmingLanguage.setName(createProgrammingLanguageRequest.getName());
			 * programmingLanguageRepository.save(programmingLanguage);
			 */
			programmingLanguageRepository
					.save(modelMapper.map(createProgrammingLanguageRequest, ProgrammingLanguage.class));

		} else {
			throw new Exception("Check the programming language you are trying to add !");
		}
	}

	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {

		if (getAll().getBody() == null) {
			throw new Exception("Programming languages list is null !");
		}

		for (GetAllProgrammingLanguagesResponse getProgrammingLanguageResponse2 : getAll().getBody()) {
			if (updateProgrammingLanguageRequest.getId() == getProgrammingLanguageResponse2.getId()) {

				ResponseEntity<List<GetAllProgrammingLanguagesResponse>> temp = getAll();
				temp.getBody().remove(getProgrammingLanguageResponse2);

				CreateProgrammingLanguageRequest createProgrammingLanguageRequest = modelMapper
						.map(updateProgrammingLanguageRequest, CreateProgrammingLanguageRequest.class);

				if (programmingLanguageCheckService.checkProgrammingLanguage(createProgrammingLanguageRequest, temp)) {

					programmingLanguageRepository
							.save(modelMapper.map(updateProgrammingLanguageRequest, ProgrammingLanguage.class));
					/*
					 * ProgrammingLanguage programmingLanguage = programmingLanguageRepository
					 * .getReferenceById(getProgrammingLanguageResponse.getId());
					 * programmingLanguage.setName(createProgrammingLanguageRequest.getName());
					 * programmingLanguageRepository.save(programmingLanguage);
					 */
				} else {
					throw new Exception("Check the new programming language you are trying to update !");
				}
			} else {
				throw new Exception("Check the old programming language you are trying to update !");
			}
		}
	}

	@Override
	public void delete(int id) throws Exception {

		Optional<ProgrammingLanguage> optionalProgrammingLanguage = programmingLanguageRepository.findById(id);

		if (optionalProgrammingLanguage.isPresent()) {
			programmingLanguageRepository.deleteById(id);
		} else {
			throw new Exception("404 not found !");
		}
	}

	@Override
	public ResponseEntity<GetAllProgrammingLanguagesResponse> getWithId(int id) {

		Optional<ProgrammingLanguage> programmingLanguageOptional = programmingLanguageRepository.findById(id);

		if (programmingLanguageOptional.isPresent()) {
			/*
			 * GetAllProgrammingLanguagesResponse getProgrammingLanguageResponse = new
			 * GetAllProgrammingLanguagesResponse();
			 * 
			 * getProgrammingLanguageResponse.setId(programmingLanguageOptional.get().getId(
			 * )); getProgrammingLanguageResponse.setName(programmingLanguageOptional.get().
			 * getName());
			 * 
			 * return getProgrammingLanguageResponse;
			 */
			return ResponseEntity
					.ok(modelMapper.map(programmingLanguageOptional.get(), GetAllProgrammingLanguagesResponse.class));

		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	public ResponseEntity<List<GetAllProgrammingLanguagesResponse>> getAll() {

		List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();

		if (programmingLanguages.isEmpty()) {

			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(programmingLanguages.stream()
				.map(source -> modelMapper.map(source, GetAllProgrammingLanguagesResponse.class))
				.collect(Collectors.toList()));

		/*
		 * List<ProgrammingLanguage> programmingLanguages =
		 * programmingLanguageRepository.findAll();
		 * List<GetAllProgrammingLanguagesResponse> programmingLanguagesResponses = new
		 * ArrayList<GetAllProgrammingLanguagesResponse>();
		 * 
		 * for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
		 * GetAllProgrammingLanguagesResponse responseItem = new
		 * GetAllProgrammingLanguagesResponse();
		 * responseItem.setId(programmingLanguage.getId());
		 * responseItem.setName(programmingLanguage.getName());
		 * programmingLanguagesResponses.add(responseItem); }
		 * 
		 * return programmingLanguagesResponses;
		 */
	}

}
