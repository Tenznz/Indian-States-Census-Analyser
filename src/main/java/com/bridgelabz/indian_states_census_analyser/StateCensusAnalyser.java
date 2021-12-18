package com.bridgelabz.indian_states_census_analyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int loadIndiaCensusData(String csvFilepath) throws IOException {

		Reader reader = Files.newBufferedReader(Paths.get(csvFilepath));
		CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder(reader).withType(CSVStateCensus.class)
				.withIgnoreLeadingWhiteSpace(true).build();
		Iterator<CSVStateCensus> censusCsvIterator = csvToBean.iterator();
		int numOfEntries = 0;
		System.out.println("----------Indian States Census Analyser----------");
		System.out.println("[ State, Population, AreaInSqKm, DensityPerSqKm ]");
		while (censusCsvIterator.hasNext()) {
			numOfEntries++;
			CSVStateCensus data = censusCsvIterator.next();
			System.out.print(numOfEntries + ".[ ");
			System.out.print(data.getState());
			System.out.print(", " + data.getPopulation());
			System.out.print(", " + data.getAreaInSqKm());
			System.out.print(", " + data.getDensityPerSqKm());
			System.out.println(" ]");
		}
		return numOfEntries;
	}
}
