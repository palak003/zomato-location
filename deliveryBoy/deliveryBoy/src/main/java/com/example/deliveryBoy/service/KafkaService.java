package com.example.deliveryBoy.service;

import com.example.deliveryBoy.config.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    private Logger logger= LoggerFactory.getLogger(KafkaService.class);

    public boolean updateLocation(String location){
        //false location-update api will be called and send msg in topic using kafka template
        //it will be key-value having (topic-name,msg) in kafka server
        this.kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME,location);
        this.logger.info("message produced");
        return true;
    }
}
