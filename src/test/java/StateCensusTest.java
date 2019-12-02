import com.bridgelabz.CustomException;
import com.bridgelabz.StateCensusAnalyser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.io.IOException;
public class StateCensusTest {


    @Test
    public void when_Read_CSV_File_Count_Records_Should_Return_True() throws IOException, CustomException {
        StateCensusAnalyser analyser = new StateCensusAnalyser("/home/admin142/IdeaProjects/IndianStateSensusAnalyser/StateCode.csv");
        System.out.println("No of Records in StateCSV: "+analyser.readStateRecord());
        Assert.assertEquals(37, analyser.readStateRecord());
    }

    @Test
    public void when_Incorrect_CSV_File_Should_Return_False() throws IOException {
        StateCensusAnalyser analyser = new StateCensusAnalyser("/home/admin142/IdeaProjects/IndianStateSensusAnalyser/StateCode2.csv");
        ExpectedException exceptionRule = ExpectedException.none();
        exceptionRule.expect(CustomException.class);
        try {
            Assert.assertEquals(CustomException.ExceptionType.FILE_NOT_FOUND, analyser.readStateRecord());
        } catch (CustomException e) {
            System.out.println("correct error caught!");
        }
    }
    @Test
    public void whenFileTyeisIncorrect_shouldReturnfalse() throws IOException, CustomException {
        StateCensusAnalyser analyser = new StateCensusAnalyser("/home/admin142/IdeaProjects/IndianStateSensusAnalyser/StateCensusData.csv");
        try {
            Assert.assertEquals(37, analyser.readStateRecord());
        } catch (CustomException e) {
            e.printStackTrace();
            Assert.assertEquals("Incorrect File_Type", e.getMessage());
        }
    }
    @Test
    public void givenTheState_CSVFileWhencorrect_ButDelimiterIncorrect_ReturnsCustomException() throws IOException {
        StateCensusAnalyser s1 = new StateCensusAnalyser("/home/admin142/IdeaProjects/IndianStateSensusAnalyser/StateCode.csv");
        try {
             s1.readStateRecord();
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            Assert.assertEquals(CustomException.ExceptionType.BINDING_BROBLEM_AT_RUNTIME, e.type);
        }
    }
    @Test
    public void givenTheStateCSVFile_CorrectCsvHeader_Incorrect_ReturnCustomException() throws IOException {

        StateCensusAnalyser s1 = new StateCensusAnalyser("/home/admin142/IdeaProjects/IndianStateSensusAnalyser/StateCode.csv");
        try {
            Assert.assertEquals(37, s1.readStateRecord());
        } catch ( CustomException e) {
            e.printStackTrace();
            Assert.assertEquals(CustomException.ExceptionType.BINDING_BROBLEM_AT_RUNTIME,e.type);
        }

    }
    /*-----------------------------------------------------------------------------------*/
    @Test
    public void when_ReadstateCensusCSV_File_Count_Records_Should_Return_True() throws IOException, CustomException {
        StateCensusAnalyser analyser = new StateCensusAnalyser("/home/admin142/IdeaProjects/IndianStateSensusAnalyser/StateCensusData.csv");
        System.out.println("No of Records in StateCSV: "+analyser.getStateCensusRecord());
        Assert.assertEquals(29, analyser.getStateCensusRecord());
    }

    @Test
    public void whenReadFileTyeisIncorrect_shouldReturnfalse() throws IOException, CustomException {
        StateCensusAnalyser analyser = new StateCensusAnalyser("/home/admin142/IdeaProjects/IndianStateSensusAnalyser/src/main/resources/StateCode2.csv");
        try {
             analyser.getStateCensusRecord();
        } catch (CustomException e) {
            e.printStackTrace();
            Assert.assertEquals("Incorrect File_Type", e.getMessage());
        }
    }
    @Test
    public void givenTheState_StateCensusCSVFile_Whencorrect_ButDelimiterIncorrect_ReturnsCustomException() throws IOException {
        StateCensusAnalyser s2 = new StateCensusAnalyser("/home/admin142/IdeaProjects/IndianStateSensusAnalyser/StateCensusData.csv");
        try {
            s2.getStateCensusRecord();
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            Assert.assertEquals(CustomException.ExceptionType.BINDING_BROBLEM_AT_RUNTIME, e.type);
        }
    }


}