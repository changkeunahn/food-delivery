package food.delivery.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import food.delivery.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import food.delivery.domain.*;

@Service
@Transactional
public class PolicyHandler{
    @Autowired DeliveryRepository deliveryRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Accepted'")
    public void wheneverAccepted_LoadDeliveryInfo(@Payload Accepted accepted){

        Accepted event = accepted;
        System.out.println("\n\n##### listener LoadDeliveryInfo : " + accepted + "\n\n");


        

        // Sample Logic //
        Delivery.loadDeliveryInfo(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Ordered'")
    public void wheneverOrdered_LoadDeliveryInfo(@Payload Ordered ordered){

        Ordered event = ordered;
        System.out.println("\n\n##### listener LoadDeliveryInfo : " + ordered + "\n\n");


        

        // Sample Logic //
        Delivery.loadDeliveryInfo(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='AddressChanged'")
    public void wheneverAddressChanged_LoadDeliveryInfo(@Payload AddressChanged addressChanged){

        AddressChanged event = addressChanged;
        System.out.println("\n\n##### listener LoadDeliveryInfo : " + addressChanged + "\n\n");


        

        // Sample Logic //
        Delivery.loadDeliveryInfo(event);
        

        

    }

}


