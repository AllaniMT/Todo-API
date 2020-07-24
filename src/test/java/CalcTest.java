import com.allanimt.springboot.Calc;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class CalcTest {
    @Test
    public void testGiveTwoNumberAndReturnTheirSum(){
        Calc myNewCalcObj = new Calc();
        assertThat(myNewCalcObj.calcSum(1,2)).isEqualTo(3);
    }
    @Test
    public void testGiveTwoNumberAndReturnTheirSub(){
        Calc myNewCalcObj = new Calc();
        assertThat(myNewCalcObj.calcSub(4,2)).isEqualTo(2);
    }
}
