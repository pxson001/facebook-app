package com.facebook.controller.mutation;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.graphql.model.FeedUnit;

/* compiled from: tap_outside */
class StoryMutationHelper$4 extends AbstractDisposableFutureCallback<OperationResult> {
    final /* synthetic */ MutationCallback f2295a;
    final /* synthetic */ FeedUnit f2296b;
    final /* synthetic */ FeedProps f2297c;
    final /* synthetic */ boolean f2298d;
    final /* synthetic */ StoryMutationHelper f2299e;

    StoryMutationHelper$4(StoryMutationHelper storyMutationHelper, MutationCallback mutationCallback, FeedUnit feedUnit, FeedProps feedProps, boolean z) {
        this.f2299e = storyMutationHelper;
        this.f2295a = mutationCallback;
        this.f2296b = feedUnit;
        this.f2297c = feedProps;
        this.f2298d = z;
    }

    public final void m2233a(Object obj) {
        if (this.f2295a != null) {
            this.f2295a.b(this.f2296b);
        }
    }

    protected final void m2234a(Throwable th) {
        FeedUnit f = StoryProps.f(this.f2299e.b.a(this.f2297c, this.f2299e.c.a(), !this.f2298d));
        if (f == null) {
            this.f2299e.i.b(StoryMutationHelper.a, "Feedbackable should either be a FeedUnit or it's root should be a FeedUnit");
        } else if (this.f2295a != null) {
            this.f2295a.a(f, ServiceException.a(th));
        }
    }
}
