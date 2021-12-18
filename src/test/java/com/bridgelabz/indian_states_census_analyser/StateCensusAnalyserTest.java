package com.bridgelabz.indian_states_census_analyser;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class StateCensusAnalyserTest {
	public static final String CSV_FILE_PATH = "D:\\project\\Learning_Path\\RFP\\indian-states-census-analyser\\data\\IndiaStateCensusData.csv";
	StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();

	@Test
	public void givenFilePathShouldReturnNumberOfRecords() throws IOException {
		StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
		int numOfRecords = censusAnalyser.loadIndiaCensusData(CSV_FILE_PATH);
		Assert.assertEquals(29, numOfRecords);
	}
}
