package com.facebook.controller.mutation;

import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.graphql.model.FeedUnit;

/* compiled from: tap_outside */
class StoryMutationHelper$5 extends OperationResultFutureCallback {
    final /* synthetic */ MutationCallback f2300a;
    final /* synthetic */ FeedUnit f2301b;
    final /* synthetic */ FeedProps f2302c;
    final /* synthetic */ String f2303d;
    final /* synthetic */ String f2304e;
    final /* synthetic */ String f2305f;
    final /* synthetic */ boolean f2306g;
    final /* synthetic */ StoryMutationHelper f2307h;

    StoryMutationHelper$5(StoryMutationHelper storyMutationHelper, MutationCallback mutationCallback, FeedUnit feedUnit, FeedProps feedProps, String str, String str2, String str3, boolean z) {
        this.f2307h = storyMutationHelper;
        this.f2300a = mutationCallback;
        this.f2301b = feedUnit;
        this.f2302c = feedProps;
        this.f2303d = str;
        this.f2304e = str2;
        this.f2305f = str3;
        this.f2306g = z;
    }

    protected final void m2236a(Object obj) {
        this.f2300a.b(this.f2301b);
    }

    protected final void m2235a(ServiceException serviceException) {
        this.f2300a.a(StoryProps.f(this.f2302c), serviceException);
        if (this.f2303d != null && this.f2304e != null) {
            AnalyticsLogger analyticsLogger = this.f2307h.d;
            CommonEventsBuilder commonEventsBuilder = this.f2307h.e;
            analyticsLogger.a(CommonEventsBuilder.b(this.f2303d + "_fail", this.f2305f, String.valueOf(this.f2306g), this.f2304e));
        }
    }
}
