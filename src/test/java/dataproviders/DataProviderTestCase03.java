package dataproviders;

import com.sample.test.demo.constants.CurrencySymbol;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import org.testng.annotations.DataProvider;

public class DataProviderTestCase03 {

    @DataProvider(name = "DPTestCase03Details")
    public static Object[][] pizzaDetailsProviderForTestCase03() {
        Object[][] data = new Object[5][8];
        data[0][0] = PizzaTypes.SMALL_NOTOPPINGS.getDisplayName()+" "+ CurrencySymbol.Dollar.getDisplayName()+ PizzaTypes.SMALL_NOTOPPINGS.getCost();
        data[0][1] = PizzaToppings.EXTRACHEESE.getDisplayName();
        data[0][2] = PizzaToppings.MANGOS.getDisplayName();
        data[0][3] = 1;
        data[0][4] = PizzaTypes.SMALL_NOTOPPINGS.getCost();
        data[0][5] = "John Doe";
        data[0][6] = "johndoe@gmail.com";
        data[0][7] =  "9856985874";

        data[1][0] = PizzaTypes.SMALL_ONETOPPINGS.getDisplayName()+" "+ CurrencySymbol.Dollar.getDisplayName()+ PizzaTypes.SMALL_ONETOPPINGS.getCost();
        data[1][1] = PizzaToppings.MOZZARELLA.getDisplayName();
        data[1][2] = PizzaToppings.EXTRACHEESE.getDisplayName();
        data[1][3] = 2;
        data[1][4] = PizzaTypes.SMALL_ONETOPPINGS.getCost();
        data[1][5] = "John Doe";
        data[1][6] = "johndoe@gmail.com";
        data[1][7] =  "9856985874";

        data[2][0] = PizzaTypes.MEDIUM_TWOTOPPINGS.getDisplayName()+" "+ CurrencySymbol.Dollar.getDisplayName()+ PizzaTypes.MEDIUM_TWOTOPPINGS.getCost();
        data[2][1] = PizzaToppings.MUSHROOMS.getDisplayName();
        data[2][2] = PizzaToppings.MANGOS.getDisplayName();
        data[2][3] = 3;
        data[2][4] = PizzaTypes.MEDIUM_TWOTOPPINGS.getCost();
        data[2][5] = "John Doe";
        data[2][6] = "johndoe@gmail.com";
        data[2][7] =  "9856985874";

        data[3][0] = PizzaTypes.LARGE_NOTOPPINGS.getDisplayName()+" "+ CurrencySymbol.Dollar.getDisplayName()+ PizzaTypes.LARGE_NOTOPPINGS.getCost();
        data[3][1] = PizzaToppings.ONIONS.getDisplayName();
        data[3][2] = PizzaToppings.EXTRACHEESE.getDisplayName();
        data[3][3] = 4;
        data[3][4] = PizzaTypes.LARGE_NOTOPPINGS.getCost();
        data[3][5] = "John Doe";
        data[3][6] = "johndoe@gmail.com";
        data[3][7] =  "9856985874";

        data[4][0] = PizzaTypes.LARGE_THREETOPPINGS.getDisplayName()+" "+ CurrencySymbol.Dollar.getDisplayName()+ PizzaTypes.LARGE_THREETOPPINGS.getCost();
        data[4][1] = PizzaToppings.MUSHROOMS.getDisplayName();
        data[4][2] = PizzaToppings.ITALIANHAM.getDisplayName();
        data[4][3] = 5;
        data[4][4] = PizzaTypes.LARGE_THREETOPPINGS.getCost();
        data[4][5] = "John Doe";
        data[4][6] = "johndoe@gmail.com";
        data[4][7] =  "9856985874";
        return data;
    }
}
