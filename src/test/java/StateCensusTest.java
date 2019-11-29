import com.bridgelabz.CensusException;
import com.bridgelabz.StateCensusAnalyser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class StateCensusTest {

    @Test
    public void toCheckNumberOfRecords() throws IOException, CensusException {
        StateCensusAnalyser analyser = new StateCensusAnalyser();
        Assert.assertEquals(37, analyser.readStateData());
    }

    @Test
    public void toTestFilePresentOrNot() {
        StateCensusAnalyser analyser = new StateCensusAnalyser();
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusException.class);
            analyser.readStateData();
        } catch (CensusException |IOException  e) {
            e.printStackTrace();
            Assert.assertEquals("File not found",e.getMessage());
        }
    }

}
