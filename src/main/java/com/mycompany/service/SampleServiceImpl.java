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
	SampleDAO samdao;
	
	@Override
	public int sampleCnt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void sampleInsert(SampleDTO dto) {
		samdao.sampleInsert(dto);
	}

	@Override
	public void sampleUpdate(SampleDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SampleDTO> sampleList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SampleDTO> sampleListPaging(Criteria cri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SampleDTO sampleRead(SampleDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
