package food.delivery.domain;

import food.delivery.domain.Ordered;
import food.delivery.domain.OrderCanceled;
import food.delivery.domain.AddressChanged;
import food.delivery.HungerApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Order_table")
@Data

public class Order  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String foodid;
    
    
    
    
    
    private String options;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private String customerid;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){


        Ordered ordered = new Ordered(this);
        ordered.publishAfterCommit();



        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();



        AddressChanged addressChanged = new AddressChanged(this);
        addressChanged.publishAfterCommit();

    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = HungerApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }




    public static void updateState(CookFinished cookFinished){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookFinished.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void updateState(CookStrated cookStrated){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookStrated.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }


}
