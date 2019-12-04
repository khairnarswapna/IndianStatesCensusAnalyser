package com.bridgelabz;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.modelmapper.ModelMapper;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.*;

public class StateCensusAnalyser{


    List<StateCensus> CsvCensusDataList = new ArrayList<>();

    public int getStateCensusRecord(String FilePath,String Class) throws CustomException
    {
        int stateCount = 0;
        Reader reader = null;
        try
        {
            reader = Files.newBufferedReader(Paths.get(FilePath));
            CsvToBean<StateCensus> csvToBean = new CsvToBeanBuilder(reader).withType(StateCensus.class)
                    .withIgnoreLeadingWhiteSpace(true).build();
            Iterator<StateCensus> CsvStateIterator = csvToBean.iterator();

            while (CsvStateIterator.hasNext())
            {
                stateCount++;
                StateCensus csvUser = CsvStateIterator.next();
                CsvCensusDataList.add(csvUser);
            }
        }
        catch (IOException e)
        {
            throw new CustomException(CustomException.ExceptionType.BINDING_BROBLEM_AT_RUNTIME, "File Not Found");
        }
        catch (RuntimeException e)
        {
            throw new CustomException(CustomException.ExceptionType.BINDING_BROBLEM_AT_RUNTIME,
                    "Cannot Map CSV Header Or issue With Delimiter");
        }
        return stateCount;
    }

    private static void sortListBasedOnStateName(List<StateCensus> censusList) {
        Comparator<StateCensus> c = (s1, s2) -> s1.getState().compareTo(s2.getState());
        censusList.sort(c);
    }

    private static void sortListBasedOnPopulation(List<StateCensus> censusList)
    {

        Comparator<StateCensus> c = (s1, s2) -> Integer.parseInt(s2.getPopulation()) - Integer.parseInt(s1.getPopulation());
        censusList.sort(c);

    }

    private static void sortListBasedOnDensity(List<StateCensus> censusList)
    {

        Comparator<StateCensus> c = (s1, s2) -> Integer.parseInt(s2.getDensityPerSqKm()) - Integer.parseInt(s1.getDensityPerSqKm());
        censusList.sort(c);

    }
    private static void sortListBasedOnStateArea(List<StateCensus> censusList)
    {

        Comparator<StateCensus> c = (s1, s2) -> Integer.parseInt(s2.getAreaInSqKm()) - Integer.parseInt(s1.getAreaInSqKm());
        censusList.sort(c);

    }
    public Boolean storeDataIntoJSON(String FilePath) throws CustomException
    {

       //sortListBasedOnStateName(CsvCensusDataList);
        //sortListBasedOnPopulation(CsvCensusDataList);
        sortListBasedOnDensity(CsvCensusDataList);
        try
        {
            Gson gson = new Gson();
            String json = gson.toJson(CsvCensusDataList);
            FileWriter writer = null;
            writer = new FileWriter(FilePath);
            writer.write(json);
            writer.close();
            return true;
        }
        catch (IOException e)
        {
            throw new CustomException(CustomException.ExceptionType.BINDING_BROBLEM_AT_RUNTIME, "File Not Found");
        }
    }
}

