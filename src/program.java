import Actors.*;
import Market.*;
import java.util.List;

public class program {

    public static void main(String[] args) {

        Human bisquit = new Human("Коржик");
        Human candy = new Human("Карамелька");
        Human compote = new Human("Компот");
        Human sweetie = new Human("Лапочка");
        Human smoked = new Human("Сажик");
        Human loony = new Human("Гоня");
        Human tedious = new Human("Нудик");
        Human screwy = new Human("Шуруп");


        Market threeCat = new Market();

        threeCat.acceptToMarket(List.of(bisquit, candy, compote, sweetie, smoked, loony, tedious, screwy));

        threeCat.takeOrders(bisquit, List.of(EProduct.ICECREAM, EProduct.PIE, EProduct.BAKED, EProduct.JUICE, EProduct.TEA));
        threeCat.takeOrders(candy, List.of(EProduct.APPLE, EProduct.CHOCO, EProduct.MARSHMALLOW));
        threeCat.takeOrders(compote, List.of(EProduct.APPLE, EProduct.BAKED, EProduct.JUICE, EProduct.BANANA));
        threeCat.giveOrder(sweetie, EProduct.APPLE);

        threeCat.update();

        threeCat.releaseFromMarket(candy);
        threeCat.releaseFromMarket(compote);

        threeCat.acceptToMarket(tedious);
        threeCat.giveOrder(tedious, EProduct.TEA);

        threeCat.update();

        threeCat.releaseFromMarket();

        threeCat.update();
        
    }
}