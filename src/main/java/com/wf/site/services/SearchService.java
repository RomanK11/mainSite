package com.wf.site.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.site.models.Baker;
import com.wf.site.models.Salat;
import com.wf.site.models.Second;
import com.wf.site.models.Soap;
import com.wf.site.repositories.BakerRepository;
import com.wf.site.repositories.SalatRepository;
import com.wf.site.repositories.SoapRepository;
import com.wf.site.repositories.SecondRepository;

@Service
public class SearchService {
    @Autowired
    private SalatRepository salatRepository;

    @Autowired
    private SoapRepository soapRepository;

    @Autowired
    private BakerRepository bakerRepository;

    @Autowired
    private SecondRepository secondRepository;

    public Iterable<Salat> searchSalats(String title) {
        return salatRepository.searchSalats(title);
    }
        public Iterable<Second> searchSeconds(String title) {
        return secondRepository.searchSeconds(title);
    }
        public Iterable<Soap> searchSoaps(String title) {
        return soapRepository.searchSoaps(title);
    }
        public Iterable<Baker> searchBakers(String title) {
        return bakerRepository.searchBakers(title);
    }
}
