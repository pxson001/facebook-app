package com.facebook.pages.common.eventbus.subscribers;

import com.facebook.content.event.FbEvent;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.common.eventbus.PageEventBus;
import com.facebook.pages.common.eventbus.PageEvents.UpdatePageDataEvent;
import com.facebook.pages.common.eventbus.PageEvents.UpdatePageDataEvent.C02211;
import com.facebook.reviews.event.ReviewEvents.PageOverallRatingUpdatedEventSubscriber;
import javax.inject.Inject;

/* compiled from: shareable_ */
public class OverallStarRatingUpdatedSubscriber extends PageOverallRatingUpdatedEventSubscriber {
    private final PageEventBus f1619a;

    public static OverallStarRatingUpdatedSubscriber m2441a(InjectorLike injectorLike) {
        return new OverallStarRatingUpdatedSubscriber(PageEventBus.m2423a(injectorLike));
    }

    @Inject
    public OverallStarRatingUpdatedSubscriber(PageEventBus pageEventBus) {
        this.f1619a = pageEventBus;
    }

    public final void m2442b(FbEvent fbEvent) {
        this.f1619a.a(new UpdatePageDataEvent(new C02211()));
    }
}
