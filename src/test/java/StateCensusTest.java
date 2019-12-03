import com.bridgelabz.CustomException;
import com.bridgelabz.StateCensusAnalyser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.io.IOException;
public class StateCensusTest {

    StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
    @Test
    public void when_ReadCSVFile_Count_Records_Should_Return_True() {
        try {
            Assert.assertEquals(37, stateCensusAnalyser.getCountStateRecords("/home/admin142/IdeaProjects/IndianStateSensusAnalyser/StateCode.csv","com.bridgelabz.State"));
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CustomException.ExceptionType.FILE_NOT_FOUND, e.type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void when_IncorrectCSVFile_Should_Return_False() throws IOException {
        try {
            Assert.assertEquals(37, stateCensusAnalyser.getCountStateRecords("/home/admin142/IdeaProjects/IndianStateSensusAnalyser/StateCode34.csv","com.bridgelabz.State"));
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CustomException.ExceptionType.NO_SUCH_FILE, e.type);
        }

    }

    @Test
    public void when_InCorrectCSV_FileType_Should_Return_False() throws IOException {
        try {
            Assert.assertEquals(37, stateCensusAnalyser.getCountStateRecords("/home/admin142/IdeaProjects/IndianStateSensusAnalyser/StateCode.csv","com.bridgelabz.State"));
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CustomException.ExceptionType.BINDING_BROBLEM_AT_RUNTIME, e.type);
        }

    }

    @Test
    public void when_CorrectCSVFile_But_Delimiter_Incorrect_Should_Return1_False() throws IOException {
        try {
            Assert.assertEquals(37, stateCensusAnalyser.getCountStateRecords("/home/admin142/IdeaProjects/IndianStateSensusAnalyser/StateCode.csv","com.bridgelabz.State"));
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CustomException.ExceptionType.BINDING_BROBLEM_AT_RUNTIME, e.type);
        }

    }

    @Test
    public void when_CorrectCSVFile_But_Header_Incorrect_Should_Return_False() throws IOException {
        try {
            Assert.assertEquals(37, stateCensusAnalyser.getCountStateRecords("/home/admin142/IdeaProjects/IndianStateSensusAnalyser/StateCode.csv","com.bridgelabz.State"));
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CustomException.ExceptionType.BINDING_BROBLEM_AT_RUNTIME, e.type);
        }

    }
    // ------------------------------------------------------------------------------------------------------------
    @Test
    public void when_Read_StateCensusCSVFile_Count_Records_Should_Return_True() throws IOException {
        try {
            Assert.assertEquals(29,stateCensusAnalyser.getStateCensusRecord("/home/admin142/IdeaProjects/IndianStateSensusAnalyser/StateCensusData.csv","com.bridgelabz.StateCensus"));
        } catch (CustomException e) {
            Assert.assertEquals(CustomException.ExceptionType.BINDING_BROBLEM_AT_RUNTIME, e.type);
        }

    }

    @Test
    public void when_Incorrect_StateCensusCSVFile_Should_Return_False() throws IOException {
        try {
            Assert.assertEquals(29, stateCensusAnalyser.getStateCensusRecord("/home/admin142/IdeaProjects/IndianStateSensusAnalyser/StateCensusData.csv","com.bridgelabz.StateCensus"));
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CustomException.ExceptionType.BINDING_BROBLEM_AT_RUNTIME, e.type);
        }

    }
    @Test
    public void when_InCorrectStateCensusCSVFileType_Should_Return_False() throws IOException {
        try {
            Assert.assertEquals(29, stateCensusAnalyser.getStateCensusRecord("/home/admin142/IdeaProjects/IndianStateSensusAnalyser/StateCensusData.csv","com.bridgelabz.StateCensus"));
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CustomException.ExceptionType.BINDING_BROBLEM_AT_RUNTIME, e.type);
        }

    }
    @Test
    public void when_CorrectStateCensusCSVFile_But_Delimiter_Incorrect_Should_Return_False() throws IOException {

        try {
            Assert.assertEquals(29, stateCensusAnalyser.getStateCensusRecord("/home/admin142/IdeaProjects/IndianStateSensusAnalyser/StateCensusData.csv","com.bridgelabz.StateCensus"));
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CustomException.ExceptionType.BINDING_BROBLEM_AT_RUNTIME, e.type);
        }

    }
    @Test
    public void when_CorrectStateCensusCSVFile_But_Header_Incorrect_Should_Return_False() throws IOException {
          try {
            Assert.assertEquals(29, stateCensusAnalyser.getStateCensusRecord("/home/admin142/IdeaProjects/IndianStateSensusAnalyser/StateCensusData.csv","com.bridgelabz.StateCensus"));
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CustomException.ExceptionType.BINDING_BROBLEM_AT_RUNTIME, e.type);
        }

    }

}