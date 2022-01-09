package dataproviders;

import com.sample.test.demo.constants.CurrencySymbol;
import com.sample.test.demo.constants.PizzaTypes;
import org.testng.annotations.DataProvider;

public class DataProviderTestCase01 {

    @DataProvider(name = "DPTestCase01Details")
    public static Object[][] pizzaDetailsProviderForTestCase01() {
        Object[][] data = new Object[5][6];
        data[0][0] = PizzaTypes.SMALL_NOTOPPINGS.getDisplayName()+" "+ CurrencySymbol.Dollar.getDisplayName()+ PizzaTypes.SMALL_NOTOPPINGS.getCost();
        data[0][1] = 1;
        data[0][2] = PizzaTypes.SMALL_NOTOPPINGS.getCost();
        data[0][3] = "John Doe";
        data[0][4] = "johndoe@gmail.com";
        data[0][5] =  "9856985874";

        data[1][0] = PizzaTypes.SMALL_ONETOPPINGS.getDisplayName()+" "+ CurrencySymbol.Dollar.getDisplayName()+ PizzaTypes.SMALL_ONETOPPINGS.getCost();
        data[1][1] = 2;
        data[1][2] = PizzaTypes.SMALL_ONETOPPINGS.getCost();
        data[1][3] = "John Doe";
        data[1][4] = "johndoe@gmail.com";
        data[1][5] =  "9856985874";

        data[2][0] = PizzaTypes.MEDIUM_TWOTOPPINGS.getDisplayName()+" "+ CurrencySymbol.Dollar.getDisplayName()+ PizzaTypes.MEDIUM_TWOTOPPINGS.getCost();
        data[2][1] = 3;
        data[2][2] = PizzaTypes.MEDIUM_TWOTOPPINGS.getCost();
        data[2][3] = "John Doe";
        data[2][4] = "johndoe@gmail.com";
        data[2][5] =  "9856985874";

        data[3][0] = PizzaTypes.LARGE_NOTOPPINGS.getDisplayName()+" "+ CurrencySymbol.Dollar.getDisplayName()+ PizzaTypes.LARGE_NOTOPPINGS.getCost();
        data[3][1] = 4;
        data[3][2] = PizzaTypes.LARGE_NOTOPPINGS.getCost();
        data[3][3] = "John Doe";
        data[3][4] = "johndoe@gmail.com";
        data[3][5] =  "9856985874";

        data[4][0] = PizzaTypes.LARGE_THREETOPPINGS.getDisplayName()+" "+ CurrencySymbol.Dollar.getDisplayName()+ PizzaTypes.LARGE_THREETOPPINGS.getCost();
        data[4][1] = 5;
        data[4][2] = PizzaTypes.LARGE_THREETOPPINGS.getCost();
        data[4][3] = "John Doe";
        data[4][4] = "johndoe@gmail.com";
        data[4][5] =  "9856985874";
        return data;
    }


}
