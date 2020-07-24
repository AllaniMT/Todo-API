import com.allanimt.springboot.Calc;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class CalcTest {
    @Test
    public void testGiveTwoNumberAndReturnTheirSum(){
        Calc myNewCalcObj = new Calc();
        assertThat(myNewCalcObj.calcSum(1,2)).isEqualTo(3);
    }
}
