package com.bridgelabz;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {

    private static final String SAMPLE_CSV_FILE_PATH = "/home/admin142/IdeaProjects/IndianStateSensusAnalyser/StateCode2.csv";

       public int readStateData() throws IOException, CensusException {
            int count=0;
            try (
                    Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            ) {
                CsvToBean<State> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(State.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                Iterator<State> csvUserIterator = csvToBean.iterator();

                while (csvUserIterator.hasNext()) {
                    State state = csvUserIterator.next();
                        count++;

                }
            } catch (NoSuchFileException e) {
                throw new CensusException(CensusException.ExceptionType.FILE_NOT_FOUND,"File not found");
            }
            return count;
        }


}
