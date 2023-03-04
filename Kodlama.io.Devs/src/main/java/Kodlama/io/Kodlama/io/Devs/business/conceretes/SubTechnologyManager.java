package Kodlama.io.Kodlama.io.Devs.business.conceretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.SubTechnologyService;
import Kodlama.io.Kodlama.io.Devs.business.requests.CreateSubTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.UpdateSubTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.GetAllSubTechnologiesResponse;
import Kodlama.io.Kodlama.io.Devs.business.responses.GetByIdSubTechnologyResponse;
import Kodlama.io.Kodlama.io.Devs.core.utilities.mappers.ModelMapperService;
import Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.SubTechnologyRepository;
import Kodlama.io.Kodlama.io.Devs.entities.conceretes.SubTechnology;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubTechnologyManager implements SubTechnologyService {

	private SubTechnologyRepository subTechnologyRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllSubTechnologiesResponse> getAll() {

		List<SubTechnology> subTechnologies = this.subTechnologyRepository.findAll();

		List<GetAllSubTechnologiesResponse> subTechnologiesResponse = subTechnologies.stream()
				.map(subTechnology -> this.modelMapperService.forResponse().map(subTechnology,
						GetAllSubTechnologiesResponse.class))
				.collect(Collectors.toList());

		return subTechnologiesResponse;
	}

	@Override
	public GetByIdSubTechnologyResponse getById(int id) {

		SubTechnology subTechnology = this.subTechnologyRepository.findById(id).orElseThrow();

		GetByIdSubTechnologyResponse subTechnologyResponse = this.modelMapperService.forResponse().map(subTechnology,
				GetByIdSubTechnologyResponse.class);

		return subTechnologyResponse;
	}

	@Override
	public void add(CreateSubTechnologyRequest createSubTechnologyRequest) {

		SubTechnology subTechnology = this.modelMapperService.forRequest().map(createSubTechnologyRequest,
				SubTechnology.class);

		// createRequest.getProgrammingLanguageId == subTechnology.getId; !!!!

		// responseEntity only controller !!

		// Validation & Exception !!!

		// modelMapper !

		subTechnology.setId(0); //

		this.subTechnologyRepository.save(subTechnology);
	}

	@Override
	public void update(UpdateSubTechnologyRequest updateSubTechnologyRequest) {

		SubTechnology subTechnology = this.modelMapperService.forRequest().map(updateSubTechnologyRequest,
				SubTechnology.class);

		this.subTechnologyRepository.save(subTechnology);
	}

	@Override
	public void delete(int id) {

		this.subTechnologyRepository.deleteById(id);
	}

}