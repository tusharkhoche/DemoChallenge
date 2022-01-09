package dataproviders;

import com.sample.test.demo.constants.CurrencySymbol;
import com.sample.test.demo.constants.PizzaTypes;
import org.testng.annotations.DataProvider;

public class DataProviderTestCase08 {

    @DataProvider(name = "DPTestCase08Details")
    public static Object[][] pizzaDetailsProviderForTestCase08() {
        Object[][] data = new Object[1][5];
        data[0][0] = PizzaTypes.SMALL_NOTOPPINGS.getDisplayName()+" "+ CurrencySymbol.Dollar.getDisplayName()+ PizzaTypes.SMALL_NOTOPPINGS.getCost();
        data[0][1] = 1;
        data[0][2] = "123456789";
        data[0][3] = "Invalid Email";
        data[0][4] =  "Invalid Phone";
        return data;
    }
}
