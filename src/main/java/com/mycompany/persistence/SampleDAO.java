package com.mycompany.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mycompany.domain.Criteria;
import com.mycompany.domain.SampleDTO;

public interface SampleDAO {
	SampleDTO sampleRead(String samp_id);
	int sampleCnt();
	public void sampleInsert(SampleDTO dto);
	void sampleUpdate(SampleDTO dto);

	List<SampleDTO> sampleListPaging(Criteria cri);
	int sampleSearchCnt(Criteria cri);
	List<SampleDTO> sampleListPagingSearch(Criteria cri);
}