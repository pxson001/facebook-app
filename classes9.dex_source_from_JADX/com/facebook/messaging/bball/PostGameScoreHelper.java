package com.facebook.messaging.bball;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import javax.inject.Inject;

/* compiled from: one_column */
public class PostGameScoreHelper {
    public static final CallerContext f8239a = CallerContext.a(PostGameScoreHelper.class);
    public final DefaultBlueServiceOperationFactory f8240b;

    @Inject
    public PostGameScoreHelper(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory) {
        this.f8240b = defaultBlueServiceOperationFactory;
    }
}
