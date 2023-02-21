package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class CookStrated extends AbstractEvent {

    private Long id;
    private String status;
    private String orderid;
}


