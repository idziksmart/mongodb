package io.idziksmart.mongodb;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.GetParameterRequest;
import software.amazon.awssdk.services.ssm.model.GetParameterResponse;

public class GetParameter {
    public static String getValue(String name, boolean secret) {
        Region region = Region.US_EAST_1;
        SsmClient ssmClient = SsmClient.builder()
                .region(region)
                .build();

            GetParameterRequest parameterRequest = GetParameterRequest.builder()
                    .name(name)
                    .withDecryption(secret)
                    .build();

            GetParameterResponse parameterResponse = ssmClient.getParameter(parameterRequest);
            return parameterResponse.parameter().value();
    }
}
