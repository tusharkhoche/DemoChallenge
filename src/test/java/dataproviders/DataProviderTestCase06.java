package dataproviders;

import com.sample.test.demo.constants.CurrencySymbol;
import com.sample.test.demo.constants.PizzaTypes;
import org.testng.annotations.DataProvider;

public class DataProviderTestCase06 {

    @DataProvider(name = "DPTestCase06Details")
    public static Object[][] pizzaDetailsProviderForTestCase06() {
        Object[][] data = new Object[1][2];
        data[0][0] = PizzaTypes.SMALL_NOTOPPINGS.getDisplayName()+" "+ CurrencySymbol.Dollar.getDisplayName()+ PizzaTypes.SMALL_NOTOPPINGS.getCost();
        data[0][1] = 1;
        return data;
    }
}
