package com.mycompany.persistence;

import com.mycompany.domain.SampleDTO;

public interface SampleDAO {
	SampleDTO sampleRead(String samp_id);
}