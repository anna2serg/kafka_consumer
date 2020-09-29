package ru.kafkasample.consumer.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class MeteoStationDto {

    private String sn;
    private String model;
    private String coordinates;
    private List<MeteodataDto> data;
}
