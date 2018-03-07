package com.facebook.groupcommerce.protocol;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEvent;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLStory;
import com.google.common.collect.ImmutableList;

/* compiled from: reaction_unit_user_settings */
class ProductItemUpdateAvailabilityHelper$1 extends AbstractDisposableFutureCallback<GraphQLResult> {
    final /* synthetic */ GraphQLStory f5490a;
    final /* synthetic */ boolean f5491b;
    final /* synthetic */ ProductItemUpdateAvailabilityHelper f5492c;

    ProductItemUpdateAvailabilityHelper$1(ProductItemUpdateAvailabilityHelper productItemUpdateAvailabilityHelper, GraphQLStory graphQLStory, boolean z) {
        this.f5492c = productItemUpdateAvailabilityHelper;
        this.f5490a = graphQLStory;
        this.f5491b = z;
    }

    protected final void m6177a(Object obj) {
        if (this.f5492c.h.b()) {
            ProductItemUpdateAvailabilityHelper productItemUpdateAvailabilityHelper = this.f5492c;
            String c = this.f5490a.c();
            boolean z = this.f5491b;
            productItemUpdateAvailabilityHelper.c.a(c, z);
            ImmutableList c2 = productItemUpdateAvailabilityHelper.d.c(c);
            int size = c2.size();
            for (int i = 0; i < size; i++) {
                productItemUpdateAvailabilityHelper.d.a((String) c2.get(i), z);
            }
        }
    }

    protected final void m6178a(Throwable th) {
        if (this.f5492c.h.b()) {
            this.f5492c.e.a(new FeedUnitMutatedEvent(this.f5490a));
        }
    }
}
