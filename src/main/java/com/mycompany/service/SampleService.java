package com.mycompany.service;

import java.util.List;

import com.mycompany.domain.Criteria;
import com.mycompany.domain.SampleDTO;

public interface SampleService {
	int sampleCnt();
	public void sampleInsert(SampleDTO dto);
	void sampleUpdate(SampleDTO dto);

	List<SampleDTO> sampleList();
	List<SampleDTO> sampleListPaging(Criteria cri);

	SampleDTO sampleRead(SampleDTO dto);
}
