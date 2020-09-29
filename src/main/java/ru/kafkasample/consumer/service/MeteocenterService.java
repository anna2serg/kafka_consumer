package ru.kafkasample.consumer.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import ru.kafkasample.consumer.dto.MeteoStationDto;

public interface MeteocenterService {

    void consume(ConsumerRecord<String, MeteoStationDto> record);

    void consume_partition10(ConsumerRecord<String, MeteoStationDto> record);

}
