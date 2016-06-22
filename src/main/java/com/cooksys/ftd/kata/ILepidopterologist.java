package com.cooksys.ftd.kata;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.cooksys.ftd.kata.model.Sample;
import com.cooksys.ftd.kata.model.Species;

public interface ILepidopterologist {

	/**
	 * Registers the given species with this lepidopterologist, permanently
	 * adding it to his or her collection
	 * 
	 * @param species
	 * @return false if the species was already registered, true otherwise
	 */
	boolean registerSpecies(Species species);

	/**
	 * Checks whether the given species is registered with this
	 * lepidopterologist or not.
	 * 
	 * @param species
	 * @return true if the species has been registered, false otherwise
	 */
	boolean isSpeciesRegistered(Species species);

	/**
	 * Finds a species registered with this lepidopterologist for the given
	 * sample.
	 * 
	 * @param sample
	 * @return Optional.of the species found for the sample, Optional.empty
	 *         otherwise
	 */
	Optional<Species> findSpeciesForSample(Sample sample);

	/**
	 * Records a sample to this lepidopterologist's collection, as long as this
	 * lepidopterologist has a species registered that matches the given sample.
	 * 
	 * @param sample
	 * @return true if the sample added successfully, false otherwise.
	 */
	boolean recordSample(Sample sample);

	/**
	 * Retrieves a sorted list of all samples recorded for a given species. If
	 * the species is not registered with this lepidopterologist, this method
	 * should return an empty list.
	 * 
	 * @param species
	 * @return if the given species is registered with this lepidopterologist, a
	 *         sorted list of all samples that match the given species,
	 *         otherwise an empty list.
	 */
	List<Sample> getSamplesForSpecies(Species species);

	/**
	 * 
	 * @return a sorted list of all species registered with this
	 *         lepidopterologist.
	 */
	List<Species> getRegisteredSpecies();

	/**
	 * 
	 * @return a map of species to sorted lists of samples.
	 */
	Map<Species, List<Sample>> getTaxonomy();

}