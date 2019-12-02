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
    public void when_Incorrect_CSV_File_Should_Return_False() throws IOException{
        StateCensusAnalyser analyser = new StateCensusAnalyser("/home/admin142/IdeaProjects/IndianStateSensusAnalyser/StateCode2.csv");
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CustomException.class);
            analyser.readStateRecord();
        } catch (CustomException | IOException e) {
            e.printStackTrace();
            Assert.assertEquals("File not found", e.getMessage());
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
    public void givenTheState_CSVFileWhencorrect_ButDelimiterIncorrect_ReturnsCustomException()
    {
        StateCensusAnalyser s1 = new StateCensusAnalyser("/home/admin142/IdeaProjects/IndianStateSensusAnalyser/StateCode.csv");
        try {
             s1.readStateRecord();
        } catch (CustomException e) {

            System.out.println(e.getMessage());
            e.printStackTrace();
            Assert.assertEquals(CustomException.ExceptionType.BINDING_BROBLEM_AT_RUNTIME, e.type);;

        } catch (IOException e) {
            e.printStackTrace();
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

}