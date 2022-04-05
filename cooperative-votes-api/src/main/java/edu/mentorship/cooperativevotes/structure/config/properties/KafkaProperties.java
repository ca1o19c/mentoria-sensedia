package edu.mentorship.cooperativevotes.structure.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotBlank;

@Data
@ConfigurationProperties(prefix="cooperative-votes-api.configurations.kafka.producer")
public class KafkaProperties {
    @NotBlank(message="bootstrap server Kafka is required.")
    private String bootstrapServerHost;
    @NotBlank(message="kafka topic is required.")
    private String topic;
}