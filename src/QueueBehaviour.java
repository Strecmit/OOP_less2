import Actors.Human;
import Market.*;

import java.util.List;

public interface QueueBehaviour {

    void takeInQueue(Human actor);//войти в очередь

    void giveOrders();// сделать заказ

    void takeOrders(Human actor, List<EProduct> products);// забрать заказы

    void releaseFromQueue(Human actor);// выйти из очереди
    

    
}