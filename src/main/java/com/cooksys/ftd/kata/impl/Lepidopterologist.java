package com.cooksys.ftd.kata.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.cooksys.ftd.kata.ILepidopterologist;
import com.cooksys.ftd.kata.model.Sample;
import com.cooksys.ftd.kata.model.Species;

public class Lepidopterologist implements ILepidopterologist {

	Map<Species, List<Sample>> dataMap = new TreeMap<Species, List<Sample>>();
	private Set<Species> speciesList = new TreeSet<Species>();

	@Override
	public boolean registerSpecies(Species species) {
		if (!isSpeciesRegistered(species)) {
			speciesList.add(species);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isSpeciesRegistered(Species species) {
		if (speciesList.contains(species)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Optional<Species> findSpeciesForSample(Sample sample) {

		for (Species s : speciesList) {
			if (s.isMember(sample.getGrowthModel()))
				return Optional.of(s);
		}
		return Optional.empty();
	}

	@Override
	public boolean recordSample(Sample sample) {
		Optional<Species> o = findSpeciesForSample(sample);
		List<Sample> l;
		Species s;

		if (o.isPresent()) {
			s = o.get();
			if (!dataMap.containsKey(s)) {
				l = new ArrayList<Sample>();
				l.add(sample);
				dataMap.put(s, l);
			} else {
				l = dataMap.get(s);
				l.add(sample);
				dataMap.put(s, l);
			}
			return true;
		}
		return false;
	}

	@Override
	public List<Sample> getSamplesForSpecies(Species species) {
		return dataMap.get(species);
	}

	@Override
	public List<Species> getRegisteredSpecies() {
		return new ArrayList<Species>(speciesList);
	}

	@Override
	public Map<Species, List<Sample>> getTaxonomy() {
		List<Sample> l;
		for (Species s : speciesList) {
			l = dataMap.get(s);
			Collections.sort(l);
		}
		return dataMap;
	}

}
