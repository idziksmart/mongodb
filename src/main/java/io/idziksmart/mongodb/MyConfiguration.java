package io.idziksmart.mongodb;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.secretsmanager.caching.SecretCache;
import com.amazonaws.secretsmanager.caching.SecretCacheConfiguration;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
    @Bean
    public AWSSecretsManager awsSecretsManager() {
        return AWSSecretsManagerClientBuilder.defaultClient();
    }

//    @Bean
    public SecretCache secretCache(AWSSecretsManager awsSecretsManager) {
        SecretCacheConfiguration secretCacheConfiguration =
                new SecretCacheConfiguration()
                        .withCacheItemTTL(0)
                        .withClient(awsSecretsManager);
        return new SecretCache(secretCacheConfiguration);
    }

    public SecretCache buildSecretCache() {
        AWSSecretsManager awsSecretsManager = AWSSecretsManagerClientBuilder
                .standard()
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .build();

        return new SecretCache(new SecretCacheConfiguration().withClient(awsSecretsManager));
    }
}
