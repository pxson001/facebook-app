package com.facebook.ufiservices;

import com.facebook.controller.mutation.util.FeedbackGraphQLGenerator;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import javax.inject.Inject;

/* compiled from: data15 */
public class UFIService {
    public final DefaultBlueServiceOperationFactory f17963a;
    private final FeedbackGraphQLGenerator f17964b;

    @Inject
    public UFIService(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, FeedbackGraphQLGenerator feedbackGraphQLGenerator) {
        this.f17963a = defaultBlueServiceOperationFactory;
        this.f17964b = feedbackGraphQLGenerator;
    }
}
