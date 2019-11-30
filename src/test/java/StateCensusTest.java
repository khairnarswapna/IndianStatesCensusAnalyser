import com.bridgelabz.CustomException;
import com.bridgelabz.StateCensusAnalyser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class StateCensusTest {

    @Test
    public void toCheckNumberOfRecords() throws IOException, CustomException {
        StateCensusAnalyser analyser = new StateCensusAnalyser();
        Assert.assertEquals(37, analyser.readStateRecord());
    }

    @Test
    public void toTestFilePresentOrNot() {
        StateCensusAnalyser analyser = new StateCensusAnalyser();
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
    public void FileTyeisIncorrect_shouldReturnfalse() throws IOException, CustomException {

        StateCensusAnalyser analyser = new StateCensusAnalyser();
        try {
            Assert.assertEquals(37, analyser.readStateRecord());
        } catch (CustomException e) {
            e.printStackTrace();
            Assert.assertEquals("Incorrect File_Type", e.getMessage());
        }
    }

    @Test
    public void givenTheState_CSVFileWhencorrect_ButDelimiterIncorrect_ReturnsCustomException() {
        StateCensusAnalyser s1 = new StateCensusAnalyser();
        try {
            Assert.assertEquals(37, s1.readStateRecord());
        } catch (IOException | CustomException e) {
            e.printStackTrace();
            Assert.assertEquals("Delimeter not found", e.getMessage());

        }
    }
}