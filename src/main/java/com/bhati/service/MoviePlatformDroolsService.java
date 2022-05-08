package com.bhati.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhati.model.shared.BookingResSharedModel;

@Service
public class MoviePlatformDroolsService {
	private final KieContainer kieContainer;

	@Autowired
	public MoviePlatformDroolsService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}

	public BookingResSharedModel getMovieDecision(BookingResSharedModel product) {
		//get the stateful session
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.insert(product);
		kieSession.setGlobal("MoviePlatformDroolsService", this);
		kieSession.fireAllRules();
		kieSession.dispose();
		return product;
	}
	
	public void printMsg() {
		System.out.println("testing");
	}


}
	
