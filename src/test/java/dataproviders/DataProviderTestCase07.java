package dataproviders;

import com.sample.test.demo.constants.CurrencySymbol;
import com.sample.test.demo.constants.PizzaTypes;
import org.testng.annotations.DataProvider;

public class DataProviderTestCase07 {

    @DataProvider(name = "DPTestCase07Details")
    public static Object[][] pizzaDetailsProviderForTestCase07() {
        Object[][] data = new Object[1][5];
        data[0][0] = PizzaTypes.SMALL_NOTOPPINGS.getDisplayName()+" "+ CurrencySymbol.Dollar.getDisplayName()+ PizzaTypes.SMALL_NOTOPPINGS.getCost();
        data[0][1] = 1;
        data[0][2] = "John Doe";
        data[0][3] = "johndoe@gmail.com";
        data[0][4] =  "9856985874";
        return data;
    }
}
