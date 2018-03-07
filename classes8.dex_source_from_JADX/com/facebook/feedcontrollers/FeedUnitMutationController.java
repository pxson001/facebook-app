package com.facebook.feedcontrollers;

import com.facebook.api.feed.data.LegacyFeedUnitUpdater;
import com.facebook.content.event.FbEvent;
import com.facebook.feed.loader.FeedOnDataChangeListener;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEvent;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: group_approve_pending_story */
public class FeedUnitMutationController {
    private final FeedEventBus f11975a;
    private final FeedUnitMutatedEventSubscriber f11976b = new FeedUnitMutatedEventSubscriber(this);
    public LegacyFeedUnitUpdater f11977c;
    public FeedOnDataChangeListener f11978d;

    /* compiled from: group_approve_pending_story */
    class FeedUnitMutatedEventSubscriber extends com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEventSubscriber {
        final /* synthetic */ FeedUnitMutationController f11974a;

        public FeedUnitMutatedEventSubscriber(FeedUnitMutationController feedUnitMutationController) {
            this.f11974a = feedUnitMutationController;
        }

        public final void m14057b(FbEvent fbEvent) {
            FeedUnitMutatedEvent feedUnitMutatedEvent = (FeedUnitMutatedEvent) fbEvent;
            if (this.f11974a.f11977c != null && this.f11974a.f11978d != null && feedUnitMutatedEvent.a != null) {
                this.f11974a.f11977c.a(feedUnitMutatedEvent.a);
                this.f11974a.f11978d.c();
            }
        }
    }

    public static FeedUnitMutationController m14059b(InjectorLike injectorLike) {
        return new FeedUnitMutationController(FeedEventBus.a(injectorLike));
    }

    @Inject
    public FeedUnitMutationController(FeedEventBus feedEventBus) {
        this.f11975a = feedEventBus;
    }

    public final void m14061a(LegacyFeedUnitUpdater legacyFeedUnitUpdater, FeedOnDataChangeListener feedOnDataChangeListener) {
        this.f11977c = legacyFeedUnitUpdater;
        this.f11978d = feedOnDataChangeListener;
        this.f11975a.a(this.f11976b);
    }

    public final void m14060a() {
        this.f11975a.b(this.f11976b);
    }

    public static FeedUnitMutationController m14058a(InjectorLike injectorLike) {
        return m14059b(injectorLike);
    }
}
