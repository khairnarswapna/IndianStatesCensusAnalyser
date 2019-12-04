package com.bridgelabz;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.modelmapper.ModelMapper;
import sun.awt.X11.XConstants;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.*;

public class StateCensusAnalyser<T extends Comparable<T>>{

    List<StateCensus> CsvCensusDataList = new ArrayList<>();
    public int getStateCensusRecord(String FilePath,String methodname) throws CustomException
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
            sortMethod(CsvCensusDataList,methodname);
            storeDataIntoJSON(CsvCensusDataList);
        }

        catch (IOException e)
        {
            throw new CustomException(CustomException.ExceptionType.BINDING_BROBLEM_AT_RUNTIME, "File Not Found");
        }
        catch (RuntimeException | InvocationTargetException | IllegalAccessException | NoSuchMethodException e)
        {
            throw new CustomException(CustomException.ExceptionType.BINDING_BROBLEM_AT_RUNTIME, "Cannot Map CSV Header Or issue With Delimiter...");
        }
        return stateCount;
    }

    public void sortMethod(List<StateCensus> censuses,String methodname) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException
    {
        for(int i=0;i<CsvCensusDataList.size()-1;i++) {
            for (int j = 0; j < CsvCensusDataList.size() - i - 1; j++) {

                Class aClass = CsvCensusDataList.get(j).getClass();
                Method methodcall = aClass.getDeclaredMethod(methodname);
                T CSVvalue1 = (T) methodcall.invoke(CsvCensusDataList.get(j));

                Class aClass1 = CsvCensusDataList.get(j).getClass();
                Method methodcall1 = aClass1.getDeclaredMethod(methodname);
                T CSVvalue2 = (T) methodcall1.invoke(CsvCensusDataList.get(j+1));
                if (CSVvalue1.compareTo(CSVvalue2) < 0) {
                    StateCensus temp = CsvCensusDataList.get(j);
                    CsvCensusDataList.set(j, CsvCensusDataList.get(j + 1));
                    CsvCensusDataList.set(j + 1, temp);
                }
            }

        }
        for(int k=0;k<CsvCensusDataList.size();k++){
            System.out.println(CsvCensusDataList.get(k).getState());
            //System.out.println(CsvCensusDataList.toString());
        }

    }
   public void  storeDataIntoJSON(List<StateCensus> censusList)
   {
       String FilePath="/home/admin142/IdeaProjects/IndianStateSensusAnalyser/StateCensusJson.json";
       Gson gson = new Gson();
       String json = gson.toJson(CsvCensusDataList);
       FileWriter writer = null;
       try {
           writer = new FileWriter(FilePath);
           writer.write(json);
           writer.close();
       }catch(Exception e) {

           e.printStackTrace();
       }

   }
}

