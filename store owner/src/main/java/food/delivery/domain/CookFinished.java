package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class CookFinished extends AbstractEvent {

    private Long id;
    private String status;
    private String orderid;

    public CookFinished(Cooking aggregate){
        super(aggregate);
    }
    public CookFinished(){
        super();
    }
}
