package io.idziksmart.mongodb;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("subscriptions")
@Data
public class Subscription {
    @Id
    private String id;

    private String subscriptionId;

}
