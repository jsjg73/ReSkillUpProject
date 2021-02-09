package com.mycompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.domain.Criteria;
import com.mycompany.domain.SampleDTO;
import com.mycompany.persistence.SampleDAO;
@Service
public class SampleServiceImpl implements SampleService {

	@Autowired
	SampleDAO sampdao;
	
	@Override
	public int sampleCnt() {
		return sampdao.sampleCnt();
	}

	@Override
	public void sampleInsert(SampleDTO dto) {
		sampdao.sampleInsert(dto);
	}

	@Override
	public void sampleUpdate(SampleDTO dto) {
		sampdao.sampleUpdate(dto);
	}

	@Override
	public List<SampleDTO> sampleList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SampleDTO> sampleListPaging(Criteria cri) {
		// TODO Auto-generated method stub
		return sampdao.sampleListPaging(cri);
	}

	@Override
	public SampleDTO sampleRead(String samp_id) {
		return sampdao.sampleRead(samp_id);
	}

}
