package DesignPrinciple;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class CensusAnalyzerStateCodeTest 
{
	private static final String INDIA_CENSUS_CSV_PATH = "C:\\Users\\susha\\Desktop\\DesignPrinciple\\lib\\src\\test\\resources\\IndiaStateCode.csv";
	private static final String INDIA_STATE_CSV_WRONG_FILETYPE = "C:\\Users\\susha\\Desktop\\DesignPrinciple\\lib\\src\\test\\resources\\IndiaStateCode.pdf";
	private static final String INDIA_STATE_CSV_PATH_DELIMETER = "C:\\\\Users\\susha\\Desktop\\DesignPrinciple\\lib\\src\\test\\resources\\IndiaStateCode.csv";
	@Test
    public void givenIndianCensusCSVFileReturnsCorrectRecords() {
        CensusAnalySer censusAnalyzer = new CensusAnalySer();
        try {
            int numOfRecord = censusAnalyzer.loadIndiaCensusData(INDIA_CENSUS_CSV_PATH);
            Assert.assertEquals(37, numOfRecord);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIndianStateCSVFileReturnsInCorrectRecords() {
        CensusAnalySer censusAnalyzer = new CensusAnalySer();
        try {
            int numOfRecord = censusAnalyzer.loadIndiaCensusData(INDIA_CENSUS_CSV_PATH);
            Assert.assertEquals(40, numOfRecord);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIndianStateCSVFileReturnsInCorrecFileType_But_PathShouldBeCorrect() {
        CensusAnalySer censusAnalyzer = new CensusAnalySer();
        try {
            int numOfRecord = censusAnalyzer.loadIndiaCensusData(INDIA_STATE_CSV_WRONG_FILETYPE);
            Assert.assertEquals(29, numOfRecord);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIndianStateCSVFileReturnsIncorrectDelimeter() {
        CensusAnalySer censusAnalyzer = new CensusAnalySer();
        try {
            censusAnalyzer.loadIndiaCensusData(INDIA_STATE_CSV_PATH_DELIMETER);
            Assert.assertTrue("Wrong delimiter", true);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }

}
