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

public class StateCensusAnalyser<T>{


    private String SAMPLE_CSV_FILE_PATH=" ";
    public static <T> CsvToBean OpenCSVBuilder(String filename, String classname) {
        CsvToBean<T> csvToBean;
        try {

            Class class1 = Class.forName(classname);
            Reader reader = Files.newBufferedReader(Paths.get(filename));

            csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Class.forName(classname))
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getCountStateRecords(String SAMPLE_CSV_FILE_PATH, String classname) throws CustomException, IOException, NoSuchFileException {
        int count = 0;
        try {
            CsvToBean<State> csvToBean=OpenCSVBuilder(SAMPLE_CSV_FILE_PATH, classname);
            Iterator<State> myUserIterator = csvToBean.iterator();
            while (myUserIterator.hasNext()) {
                State state = myUserIterator.next();
                count++;
            }
        } catch (RuntimeException e) {
            throw new CustomException(CustomException.ExceptionType.BINDING_BROBLEM_AT_RUNTIME, "ERROR IN FILE TYPE OR IN FILE DELIMITER OR IN FILE HEADER");
        }
        System.out.println(count);
        return count;
    }

    public static int getStateCensusRecord(String SAMPLE_CSV_FILE_PATH, String classname) throws CustomException, NoSuchFileException, IOException {
        int count1=0;
        try {
            CsvToBean<StateCensus> csvToBean=OpenCSVBuilder(SAMPLE_CSV_FILE_PATH, classname);
            Iterator<StateCensus> myUserIterator = csvToBean.iterator();
            while (myUserIterator.hasNext()) {
                StateCensus state1 = myUserIterator.next();
                count1++;
            }
        } catch(RuntimeException e){
            throw new CustomException(CustomException.ExceptionType.BINDING_BROBLEM_AT_RUNTIME, "ERROR IN FILE TYPE OR IN FILE DELIMITER OR IN FILE HEADER");
        }
        System.out.println(count1);
        return count1;
    }


}
