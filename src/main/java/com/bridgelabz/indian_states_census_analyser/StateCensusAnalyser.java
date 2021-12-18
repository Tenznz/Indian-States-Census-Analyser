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
	public int loadIndiaCensusData(String csvFilepath) throws IOException, CensusAnalyserException {
		int numOfEntries = 0;
		try {
			Reader reader = Files.newBufferedReader(Paths.get(csvFilepath));
			CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder(reader).withType(CSVStateCensus.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			Iterator<CSVStateCensus> censusCsvIterator = csvToBean.iterator();

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
		} catch (IOException e) {
			throw new CensusAnalyserException("Wrong file path",
					CensusAnalyserException.ExceptionType.WRONG_CSV_FILE_PATH);
		}
	}
}
