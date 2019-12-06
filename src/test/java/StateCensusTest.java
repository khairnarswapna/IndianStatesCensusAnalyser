import com.bridgelabz.CustomException;
import com.bridgelabz.StateCensusAnalyser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class StateCensusTest {

    StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
    String FILE_PATH_JSON="/home/admin142/IdeaProjects/IndianStateSensusAnalyser/StateCensusJson.json";
    @Test
    public void when_Read_StateCensusCSVFile_Count_Records_Should_Return_True() throws IOException {
        try {
            Assert.assertEquals(29,stateCensusAnalyser.getStateCensusRecord("/home/admin142/IdeaProjects/IndianStateSensusAnalyser/StateCensusData.csv",""));
        } catch (CustomException e) {
             e.printStackTrace();
        }

    }
    @Test
    public void when_Incorrect_StateCensus_CSVFile_Should_Return_False() throws IOException {
        try {
            Assert.assertEquals(29, stateCensusAnalyser.getStateCensusRecord("/home/admin142/IdeaProjects/IndianStateSensusAnalyser/StateCensusData.csv",""));
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CustomException.ExceptionType.BINDING_BROBLEM_AT_RUNTIME, e.type);
        }
    }
    @Test
    public void when_InCorrectStateCensus_CSVFileType_Should_Return_False() throws IOException {
        try {
            Assert.assertEquals(29, stateCensusAnalyser.getStateCensusRecord("/home/admin142/IdeaProjects/IndianStateSensusAnalyser/StateCensusData.csv",""));
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CustomException.ExceptionType.BINDING_BROBLEM_AT_RUNTIME, e.type);
        }

    }
    @Test
    public void when_CorrectStateCensusCSVFile_But_Delimiter_Incorrect_Should_Return_False() throws IOException {

        try {
            Assert.assertEquals(29, stateCensusAnalyser.getStateCensusRecord("/home/admin142/IdeaProjects/IndianStateSensusAnalyser/StateCensusData.csv",""));
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
    @Test
    public void givenMessage_JasonFile_ForStateName_ShouldReturnAlphabeticOrder() throws IOException, CustomException {
        try {
            Assert.assertEquals(29, stateCensusAnalyser.getStateCensusRecord("/home/admin142/IdeaProjects/IndianStateSensusAnalyser/StateCensusData.csv","getState"));
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CustomException.ExceptionType.BINDING_BROBLEM_AT_RUNTIME, e.type);
        }
    }
    @Test
    public void givenMessage_JasonFile_ForPopulation_ShoulsReturnMostPopulousState() throws IOException, CustomException {
        try {
            Assert.assertEquals(29, stateCensusAnalyser.getStateCensusRecord("/home/admin142/IdeaProjects/IndianStateSensusAnalyser/StateCensusData.csv"," getPopulation"));
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CustomException.ExceptionType.BINDING_BROBLEM_AT_RUNTIME, e.type);
        }
    }
    @Test
    public void givenMessage_JsonFile_ForPopulationDencity_ShoulsReturnPopulationDencity() throws IOException, CustomException {

        try {
            Assert.assertEquals(29, stateCensusAnalyser.getStateCensusRecord("/home/admin142/IdeaProjects/IndianStateSensusAnalyser/StateCensusData.csv","getDensityPerSqKm"));
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CustomException.ExceptionType.BINDING_BROBLEM_AT_RUNTIME, e.type);
        }
    }
    @Test
    public void givenMessage_JasonFile_ForArea_ShoulsReturn_sortedbyStateArea() throws IOException, CustomException {
        try {
            Assert.assertEquals(29, stateCensusAnalyser.getStateCensusRecord("/home/admin142/IdeaProjects/IndianStateSensusAnalyser/StateCensusData.csv","getAreaInSqKm"));
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CustomException.ExceptionType.BINDING_BROBLEM_AT_RUNTIME, e.type);
        }
    }


}