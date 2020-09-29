package ru.kafkasample.consumer.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;
import ru.kafkasample.consumer.dto.MeteoStationDto;
import ru.kafkasample.consumer.service.MeteocenterService;

@Service
@Slf4j
public class MeteocenterServiceImpl implements MeteocenterService {

    @Override
    @KafkaListener(id = "MeteoСenter", topics = {
            "meteodata"}, containerFactory = "kafkaListenerContainerFactory")
    public void consume(ConsumerRecord<String, MeteoStationDto> record) {
        logMessage("*ROSGIDROMET*", record);
    }

    @Override
    @KafkaListener(topicPartitions = @TopicPartition(
            topic = "${spring.kafka.topic.name}",
            partitionOffsets = {
                    @PartitionOffset(partition = "10",
                            initialOffset = "0")}),
            containerFactory = "kafkaListenerContainerFactory")
    public void consume_partition10(ConsumerRecord<String, MeteoStationDto> record) {
        logMessage("*NORTH_EXPLORATION*", record);
    }

    private void logMessage(String consumerName, ConsumerRecord<String, MeteoStationDto> record) {
        log.info("{} -> received data [topic: {}, partition: {}, offset: {}, key: {}, value: {}]  ",
                consumerName, record.topic(), record.partition(), record.offset(), record.key(),
                record.value());
    }

}
