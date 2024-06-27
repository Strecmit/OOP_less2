import Actors.*;
import Market.EProduct;

import java.util.ArrayList;
import java.util.List;

// Реализовать класс Market и
// все методы, которые он
// обязан реализовывать.
// Методы из интерфейса
// QueueBehaviour, имитируют
// работу очереди,
// MarketBehaviour – помещает и
// удаляет человека из очереди,
// метод update – обновляет
// состояние магазина
// (принимает и отдает заказы)

public class Market implements MarketBehaviour, QueueBehaviour {

    private List<Human> actors = new ArrayList<Human>();

    private List<Human> actorsAtMarket = new ArrayList<Human>();

    public void acceptToMarket(Human actor) {// входит в магазин
        if (!actors.contains(actor)) {
            actors.add(actor);
            System.out.printf("%s вошёл в магазин.\n", actor.getName());
        }else{
            System.out.printf("%s уже в магазине.\n", actor.getName());
        }
    }

    public void acceptToMarket(List<Human> grup) {// группа входит в магазин
        for (Human actor : grup) {
            actors.add(actor);
        }
        System.out.println("Группа покупателей вошла в магазин.");
    }

    @Override
    public void releaseFromMarket(Human actor) {// выходит из магазина
        int namActor = actors.indexOf(actor);
        actors.remove(namActor);
        System.out.printf("%s вышел из магазина.\n", actor.getName());
    }

    public void releaseFromMarket() {// выходит из магазина
        List<Human> temp = new ArrayList<>();
        for (Human human : actors) {
            if (human.isTakeOrder()) {
                System.out.printf("%s вышел из магазина, получив заказ.\n", human.getName());
                temp.add(human);
            } else if(!human.isMakeOrder()){
                System.out.printf("%s вышел из магазина, не сделав заказ.\n", human.getName());
                temp.add(human);
            }
        }
        actors.removeAll(temp);
    }

    @Override
    public void update() {
        int i = 0;
        for (Human human : actors) {
            if (human.isMakeOrder() & !human.isTakeOrder()) {
                takeInQueue(human);
            }
        }
        while (actorsAtMarket.size() > 0) {
            while (actorsAtMarket.size() > 0) {
                giveOrders();
                i++;
            }
        }
        System.out.printf("STATUS: %d заказов выдано, в магазине осталось %d посетителей.\n", i, actors.size());
    }

    @Override
    public void takeOrders(Human actor, List<EProduct> products) { // сделать заказ/добавить список продуктов
        if (actor.isMakeOrder()) {
            System.out.printf("%s дополнил заказ.\n", actor.getName());
        }else{
            System.out.printf("%s сделал заказ.\n", actor.getName());
        }
        int namActor = actors.indexOf(actor);
        Human tempActor = actors.remove(namActor);
        tempActor.saveOrder(products);
        actors.add(tempActor);
    }

    public void giveOrder(Human actor, EProduct product) { // сделать заказ/добавить продукт
        if (actor.isMakeOrder()) {
            System.out.printf("%s дополнил заказ.\n", actor.getName());
        }else{
            System.out.printf("%s сделал заказ.\n", actor.getName());
        }
        int namActor = actors.indexOf(actor);
        Human tempActor = actors.remove(namActor);
        tempActor.saveOrder(product);
        actors.add(tempActor);
    }

    @Override
    public void releaseFromQueue(Human actor) {// выход из очереди
        System.out.printf("%s вышел из очереди, не получив заказ.\n", actor.getName());
        int namActor = actors.indexOf(actor);
        actorsAtMarket.remove(namActor);
    }

    public void releaseFromQueue() {// выход из очереди
        System.out.printf("%s вышел из очереди, не получив заказ.\n", actors.get(0).getName());
        actorsAtMarket.remove(0);
        
    }

    @Override
    public void takeInQueue(Human actor) {// вход в очередь
        System.out.printf("%s встал в очередь за заказом.\n", actor.getName());
        if (actor.isMakeOrder()) {
            actorsAtMarket.add(actor);
        }

    }

    @Override
    public void giveOrders() {// берём первый заказ из списка и удалить его
        Human actorWithOrder = actorsAtMarket.remove(0);
        System.out.printf("%s получил заказ и вышел из очереди.\n", actorWithOrder.getName());
        actorWithOrder.setTakeOrder(true);
    }

    public int countActors(){ // кол-во покупателей в магазине
        return actors.size();
    }
}