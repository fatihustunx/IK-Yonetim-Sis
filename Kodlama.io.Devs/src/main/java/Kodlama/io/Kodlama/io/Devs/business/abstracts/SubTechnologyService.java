package Kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Kodlama.io.Devs.business.requests.CreateSubTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.UpdateSubTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.GetAllSubTechnologiesResponse;
import Kodlama.io.Kodlama.io.Devs.business.responses.GetByIdSubTechnologyResponse;

public interface SubTechnologyService {

	List<GetAllSubTechnologiesResponse> getAll();

	GetByIdSubTechnologyResponse getById(int id);

	void add(CreateSubTechnologyRequest createSubTechnologyRequest);

	void update(UpdateSubTechnologyRequest updateSubTechnologyRequest);

	void delete(int id);
}
