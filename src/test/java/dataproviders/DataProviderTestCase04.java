package dataproviders;

import com.sample.test.demo.constants.CurrencySymbol;
import com.sample.test.demo.constants.PizzaTypes;
import org.testng.annotations.DataProvider;

public class DataProviderTestCase04 {

    @DataProvider(name = "DPTestCase04Details")
    public static Object[][] pizzaDetailsProviderForTestCase04() {
        Object[][] data = new Object[1][3];
        data[0][0] = "John Doe";
        data[0][1] = "johndoe@gmail.com";
        data[0][2] =  "9856985874";
        return data;
    }
}
