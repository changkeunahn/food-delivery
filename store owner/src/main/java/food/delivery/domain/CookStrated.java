package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class CookStrated extends AbstractEvent {

    private Long id;
    private String status;
    private String orderid;

    public CookStrated(Cooking aggregate){
        super(aggregate);
    }
    public CookStrated(){
        super();
    }
}
