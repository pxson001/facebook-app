package com.facebook.api.negative_feedback;

import com.facebook.api.negative_feedback.NegativeFeedbackActionMethod.Params;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: video_creative_tool_filters */
public class NegativeFeedbackActionHandler implements BlueServiceHandler {
    private final Provider<SingleMethodRunner> f597a;
    private final NegativeFeedbackActionMethod f598b;

    @Inject
    public NegativeFeedbackActionHandler(Provider<SingleMethodRunner> provider, NegativeFeedbackActionMethod negativeFeedbackActionMethod) {
        this.f597a = provider;
        this.f598b = negativeFeedbackActionMethod;
    }

    public final OperationResult m701a(OperationParams operationParams) {
        ((AbstractSingleMethodRunner) this.f597a.get()).a(this.f598b, (Params) operationParams.c.getParcelable("negativeFeedbackActionParams"), CallerContext.a(getClass()));
        return OperationResult.a;
    }
}
