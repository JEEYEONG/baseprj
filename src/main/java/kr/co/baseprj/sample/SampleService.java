package kr.co.baseprj.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleService {

    @Autowired
    SampleDao sampleDao;

    List<SampleVO> getSampleList() {
        return sampleDao.getSampleList();
    }
}
