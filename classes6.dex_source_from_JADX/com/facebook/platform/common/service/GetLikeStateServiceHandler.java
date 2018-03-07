package com.facebook.platform.common.service;

import android.os.Message;
import com.facebook.debug.log.BLog;
import com.facebook.platform.common.PlatformAppResults;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: story_feedback_flyout */
public class GetLikeStateServiceHandler extends AbstractPlatformServiceHandler<GetLikeStateServiceRequest> {
    private static final Class<?> f4079b = GetLikeStateServiceHandler.class;

    @Inject
    public GetLikeStateServiceHandler(Provider<GetLikeStateServiceRequest> provider) {
        super(provider, 65542);
    }

    protected final void mo295b(Message message, PlatformServiceRequest platformServiceRequest) {
        Message b = GetLikeStateServiceRequest.m5990b(message);
        b.setData(PlatformAppResults.m5893a(null, "PermissionDenied", "Cannot retrieve like status for the provided object id"));
        try {
            message.replyTo.send(b);
        } catch (Throwable e) {
            BLog.a(f4079b, "Unable to respond to like state request", e);
        }
    }
}
