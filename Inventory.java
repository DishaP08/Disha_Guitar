package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	 private List<Instrument> instruments;

	    public Inventory() {
	        instruments = new ArrayList<>();
	    }

	    public void addInstrument(String serialNumber, double price, InstrumentSpec spec) {
	        Instrument instrument = new Instrument(serialNumber, price, spec);
	        instruments.add(instrument);
	    }

	   
	    public List<Instrument> search(InstrumentSpec searchSpec) {
	        List<Instrument> matchingInstruments = new ArrayList<>();
	        for (Instrument instrument : instruments) {
	            if (instrument.getSpec().matches(searchSpec)) {
	                matchingInstruments.add(instrument);
	            }
	        }
	        return matchingInstruments;
	    }


	    public List<Instrument> getAllInstruments() {
	        return instruments;
	    }

	    
	    public boolean removeInstrument(String serialNumber) {
	        return instruments.removeIf(instrument ->
	            instrument.getSerialNumber().equalsIgnoreCase(serialNumber));
	    }
	}