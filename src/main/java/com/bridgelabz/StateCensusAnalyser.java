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
         public int readStateRecord() throws CustomException, IOException {
            int count=0;
            try (Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));)
            {
                CsvToBean<State> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(State.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .withThrowExceptions(false)
                        .build();
                Iterator<State> csvUserIterator = csvToBean.iterator();
                while (csvUserIterator.hasNext()) {
                    State state = csvUserIterator.next();
                    System.out.println("SrNo : " + state.getSrNo());
                    System.out.println("StateName : " + state.getStateName());
                    System.out.println("TIN : " + state.getTIN());
                    System.out.println("StateCode : " + state.getStateCode());
                    System.out.println("==========================");
                  //  System.out.println(" count : "+count);
                        count++;
                    if(state.getSrNo() == null || state.getStateName() == null || state.getTIN() == null
                            || state.getStateCode() == null){
                        throw new CustomException(CustomException.ExceptionType.BINDING_BROBLEM_AT_RUNTIME,"delimeter incorrect or Header incorrect or Binding problem at runtime");
                    }
                }
            } catch (NoSuchFileException e) {
                throw new CustomException(CustomException.ExceptionType.FILE_NOT_FOUND,"File not found");
            } catch(RuntimeException e) {
                throw new CustomException(CustomException.ExceptionType.BINDING_BROBLEM_AT_RUNTIME, "delimeter incorrect or Header incorrect or Binding problem at runtime");
            } catch (IOException e) {
                e.printStackTrace();
            }
             return count;
        }

        /*--------------------------------------------------------------------------*/
    public int getStateCensusRecord() throws CustomException {
        int count1=0;
        try (Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));)
        {
            CsvToBean<StateCensusData> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(StateCensusData.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withThrowExceptions(false)
                    .build();
            Iterator<StateCensusData> csvUserIterator = csvToBean.iterator();
            while (csvUserIterator.hasNext()) {
                StateCensusData state1 = csvUserIterator.next();
                count1++;
            }
        } catch (NoSuchFileException e) {
            throw new CustomException(CustomException.ExceptionType.FILE_NOT_FOUND,"File not found");
        }
        catch(RuntimeException e){
            throw new CustomException(CustomException.ExceptionType.BINDING_BROBLEM_AT_RUNTIME,"delimeter incorrect or Header incorrect or Binding problem at runtime");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count1;
    }

}
