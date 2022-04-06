package edu.mentorship.cooperativevotes.structure.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Validated
@ConfigurationProperties(prefix="cooperative-votes-api.configurations.redis")
public class RedisProperties {
    @NotBlank(message="host is required.")
    private String host;
    @NotBlank(message="port is required.")
    private String port;
}
