package food.delivery.domain;

import food.delivery.domain.Accepted;
import food.delivery.domain.Rejected;
import food.delivery.domain.CookStrated;
import food.delivery.domain.CookFinished;
import food.delivery.StoreOwnerApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Cooking_table")
@Data

public class Cooking  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private String orderid;

    @PostPersist
    public void onPostPersist(){


        Accepted accepted = new Accepted(this);
        accepted.publishAfterCommit();



        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();



        CookStrated cookStrated = new CookStrated(this);
        cookStrated.publishAfterCommit();



        CookFinished cookFinished = new CookFinished(this);
        cookFinished.publishAfterCommit();

    }

    public static CookingRepository repository(){
        CookingRepository cookingRepository = StoreOwnerApplication.applicationContext.getBean(CookingRepository.class);
        return cookingRepository;
    }



    public void acceptOrReject(AcceptOrRejectCommand acceptOrRejectCommand){
    }
    public void finish(){
    }
    public void start(){
    }

    public static void loadOrderInfo(Ordered ordered){

        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);

        */

        /** Example 2:  finding and process
        
        repository().findById(ordered.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);


         });
        */

        
    }


}
