package DesignPrinciple;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CensusAnalySer 
{ 
	public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyserException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBeanBuilder<IndianCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IndianCensusCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndianCensusCSV> csvToBean = csvToBeanBuilder.build();
            Iterator<IndianCensusCSV> censusCSVIterator = csvToBean.iterator();;
            int namOfEateries = 0;
            while (censusCSVIterator.hasNext()) {
                namOfEateries++;
                IndianCensusCSV censusData = censusCSVIterator.next();
            }
            return namOfEateries;
        } catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }

	  //generic method
    private <E> Iterator getCSVIterator(Reader reader, Class csvClass) {
        CsvToBeanBuilder<E> csvCsvToBeanBuilder = new CsvToBeanBuilder<>(reader);
        csvCsvToBeanBuilder.withType(csvClass);
        csvCsvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
        CsvToBean<E> csvToBean = csvCsvToBeanBuilder.build();
        return csvToBean.iterator();
    }

    //generic method for count entries
    private <E> int getCount(Iterator<E> censusCSVIterator) {
        Iterable<E> csvIterator = () -> censusCSVIterator;
        int numOfEntries = (int) StreamSupport.stream(csvIterator.spliterator(), true).count();
        return numOfEntries;
    }

}
