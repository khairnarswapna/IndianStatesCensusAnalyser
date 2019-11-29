import com.bridgelabz.StateCensusAnalyser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class StateCensusTest {

    @Test
    public void toCheckNumberOfRecords() throws IOException{
        StateCensusAnalyser analyser = new StateCensusAnalyser();
        Assert.assertEquals(37, analyser.readStateData());
    }

}
