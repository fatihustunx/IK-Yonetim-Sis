package Kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Kodlama.io.Devs.business.requests.CreateSubTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.GetSubTechnologyResponse;

public interface SubTechnologyService {

	void add(CreateSubTechnologyRequest createSubTechnologyRequest);
	void delete(GetSubTechnologyResponse getSubTechnologyResponse);
	void update();
	List<GetSubTechnologyResponse> getAll();
	GetSubTechnologyResponse getWithId(int id);
}
