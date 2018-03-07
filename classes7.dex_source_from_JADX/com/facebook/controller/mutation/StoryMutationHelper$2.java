package com.facebook.controller.mutation;

import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: tap_outside */
class StoryMutationHelper$2 extends AbstractDisposableFutureCallback<OperationResult> {
    final /* synthetic */ MutationCallback f2287a;
    final /* synthetic */ GraphQLStory f2288b;
    final /* synthetic */ String f2289c;
    final /* synthetic */ GraphQLPage f2290d;
    final /* synthetic */ String f2291e;
    final /* synthetic */ StoryMutationHelper f2292f;

    StoryMutationHelper$2(StoryMutationHelper storyMutationHelper, MutationCallback mutationCallback, GraphQLStory graphQLStory, String str, GraphQLPage graphQLPage, String str2) {
        this.f2292f = storyMutationHelper;
        this.f2287a = mutationCallback;
        this.f2288b = graphQLStory;
        this.f2289c = str;
        this.f2290d = graphQLPage;
        this.f2291e = str2;
    }

    protected final void m2232a(Throwable th) {
        if (this.f2287a != null) {
            this.f2287a.a(this.f2288b, ServiceException.a(th));
        }
        if (this.f2289c != null) {
            AnalyticsLogger analyticsLogger = this.f2292f.d;
            CommonEventsBuilder commonEventsBuilder = this.f2292f.e;
            analyticsLogger.a(CommonEventsBuilder.a(this.f2289c + "_fail", this.f2290d.ae(), String.valueOf(this.f2290d.O()), this.f2291e));
        }
    }
}
