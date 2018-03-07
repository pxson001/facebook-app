package com.facebook.api.negative_feedback;

import com.facebook.api.negative_feedback.NegativeFeedbackMessageActionMethod.Params;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: video_captions */
public class NegativeFeedbackMessageActionHandler implements BlueServiceHandler {
    private final Provider<SingleMethodRunner> f601a;
    private final NegativeFeedbackMessageActionMethod f602b;

    @Inject
    public NegativeFeedbackMessageActionHandler(Provider<SingleMethodRunner> provider, NegativeFeedbackMessageActionMethod negativeFeedbackMessageActionMethod) {
        this.f601a = provider;
        this.f602b = negativeFeedbackMessageActionMethod;
    }

    public final OperationResult m704a(OperationParams operationParams) {
        ((AbstractSingleMethodRunner) this.f601a.get()).a(this.f602b, (Params) operationParams.c.getParcelable("negativeFeedbackMessageActionParams"), CallerContext.a(getClass()));
        return OperationResult.a;
    }
}
