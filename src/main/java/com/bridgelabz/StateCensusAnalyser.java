package com.bridgelabz;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import javax.swing.*;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {

       private String SAMPLE_CSV_FILE_PATH="";
       public StateCensusAnalyser() {

         }
         public StateCensusAnalyser(String SAMPLE_CSV_FILE_PATH)
         {
             this.SAMPLE_CSV_FILE_PATH=SAMPLE_CSV_FILE_PATH;
         }
         public int readStateRecord() throws IOException, CustomException, RuntimeException {
            int count=0;
            try {
                    Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
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
                throw new CustomException(CustomException.ExceptionType.FILE_NOT_FOUND,"File not found");
            }
            catch(RuntimeException e){
                throw new CustomException(CustomException.ExceptionType.BINDING_BROBLEM_AT_RUNTIME,"delimeter incorrect or Header incorrect or Binding problem at runtime");
            }
            return count;
        }
}
