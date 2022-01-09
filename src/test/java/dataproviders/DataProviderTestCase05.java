package dataproviders;

import com.sample.test.demo.constants.CurrencySymbol;
import com.sample.test.demo.constants.PizzaTypes;
import org.testng.annotations.DataProvider;

public class DataProviderTestCase05 {

    @DataProvider(name = "DPTestCase05Details")
    public static Object[][] pizzaDetailsProviderForTestCase05() {
        Object[][] data = new Object[2][5];
        data[0][0] = PizzaTypes.SMALL_NOTOPPINGS.getDisplayName()+" "+ CurrencySymbol.Dollar.getDisplayName()+ PizzaTypes.SMALL_NOTOPPINGS.getCost();
        data[0][1] = 0;
        data[0][2] = "John Doe";
        data[0][3] = "johndoe@gmail.com";
        data[0][4] =  "9856985874";

        data[1][0] = PizzaTypes.LARGE_THREETOPPINGS.getDisplayName()+" "+ CurrencySymbol.Dollar.getDisplayName()+ PizzaTypes.LARGE_THREETOPPINGS.getCost();
        data[1][1] = -1;
        data[1][2] = "John Doe";
        data[1][3] = "johndoe@gmail.com";
        data[1][4] =  "9856985874";
        return data;
    }
}
