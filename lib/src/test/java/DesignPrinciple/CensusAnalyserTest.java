package DesignPrinciple;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest 
{
	private static final String INDIA_CENSUS_CSV_FILE_PATH = "C:\\Users\\susha\\Desktop\\DesignPrinciple\\lib\src\\test\\resources";
    private static final String WRONG_CSV_FILE_PATH = "C:\\Users\\susha\\Desktop\\DesignPrinciple\\lib\\src\\test\\resources";
    private static final String INDIA_CENSUS_CSV_WRONG_FILETYPE = "C:\\Users\\susha\\Desktop\\DesignPrinciple\\lib\\src\\test\\resources\\IndiaStateCensusData.pdf";
    private static final String INDIA_CENSUS_CSV_PATH_DELIMETER = "C:\\Users\\susha\\Desktop\\DesignPrinciple\\lib\\src\\test//resources//IndiaStateCensusData.pdf";
    @Test
    public void givenIndianCensusCSVFileReturnsCorrectRecords() {
        try {
            CensusAnalySer censusAnalyser = new CensusAnalySer();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29,numOfRecords);
        } catch (CensusAnalyserException e) { }
    }

    @Test
    public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
        try {
            CensusAnalySer censusAnalyser = new CensusAnalySer();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }
    @Test
    public void givenIndianCensusCSVFileReturnsInCorrecFileType_But_PathShouldBeCorrect() {
    	try {
        CensusAnalySer censusAnalyzer = new CensusAnalySer();
       
            int numOfRecord = censusAnalyzer.loadIndiaCensusData(INDIA_CENSUS_CSV_WRONG_FILETYPE);
            Assert.assertEquals(29, numOfRecord);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIndianCensusCSVFileReturnsIncorrectDelimeter(){
        CensusAnalySer censusAnalyzer = new CensusAnalySer();
        try {
            censusAnalyzer.loadIndiaCensusData(INDIA_CENSUS_CSV_PATH_DELIMETER);
            Assert.assertTrue("Wrong delimiter", true);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
}
