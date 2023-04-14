package com.redhat.training;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import com.redhat.training.service.StateService;

@ApplicationScoped
@Liveness
public class LivenessHealthResource implements HealthCheck {

    private final String HEALTH_CHECK_NAME = "Liveness";

    @Inject
    StateService applicationState;

    @Override
    public HealthCheckResponse call() {
        
        return applicationState.isAlive() ? HealthCheckResponse.up(HEALTH_CHECK_NAME)
                : HealthCheckResponse.down(HEALTH_CHECK_NAME);

        // TODO Auto-generated method stub        
        // throw new UnsupportedOperationException("Unimplemented method 'call'");
    }

}
