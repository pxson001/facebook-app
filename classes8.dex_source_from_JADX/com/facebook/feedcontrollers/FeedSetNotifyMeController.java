package com.facebook.feedcontrollers;

import com.facebook.api.feed.data.LegacyFeedUnitUpdater;
import com.facebook.content.event.FbEvent;
import com.facebook.controller.mutation.BaseMutationCallback;
import com.facebook.controller.mutation.StoryMutationHelper;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.loader.FeedOnDataChangeListener;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.inject.InjectorLike;
import com.facebook.ufiservices.event.UfiEvents.SetNotifyMeEvent;
import com.facebook.ufiservices.event.UfiEvents.SetNotifyMeEventSubscriber;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: group_banned_members */
public class FeedSetNotifyMeController {
    private final FeedEventBus f11961a;
    public final StoryMutationHelper f11962b;
    private SetNotifyMeSubscriber f11963c;
    public LegacyFeedUnitUpdater f11964d;
    public FeedOnDataChangeListener f11965e;

    /* compiled from: group_banned_members */
    class SetNotifyMeSubscriber extends SetNotifyMeEventSubscriber {
        final /* synthetic */ FeedSetNotifyMeController f11960a;

        /* compiled from: group_banned_members */
        class C12841 extends BaseMutationCallback<FeedUnit> {
            final /* synthetic */ SetNotifyMeSubscriber f11959a;

            C12841(SetNotifyMeSubscriber setNotifyMeSubscriber) {
                this.f11959a = setNotifyMeSubscriber;
            }

            public final void m14043a(Object obj) {
                this.f11959a.f11960a.f11964d.a((FeedUnit) obj);
                if (this.f11959a.f11960a.f11965e != null) {
                    this.f11959a.f11960a.f11965e.c();
                }
            }

            public final void m14044a(Object obj, ServiceException serviceException) {
                this.f11959a.f11960a.f11964d.a((FeedUnit) obj);
                if (this.f11959a.f11960a.f11965e != null) {
                    this.f11959a.f11960a.f11965e.c();
                }
            }
        }

        public SetNotifyMeSubscriber(FeedSetNotifyMeController feedSetNotifyMeController) {
            this.f11960a = feedSetNotifyMeController;
        }

        public final void m14045b(FbEvent fbEvent) {
            SetNotifyMeEvent setNotifyMeEvent = (SetNotifyMeEvent) fbEvent;
            this.f11960a.f11962b.a(setNotifyMeEvent.a, setNotifyMeEvent.h, null, null, new C12841(this));
        }
    }

    public static FeedSetNotifyMeController m14047b(InjectorLike injectorLike) {
        return new FeedSetNotifyMeController(FeedEventBus.a(injectorLike), StoryMutationHelper.b(injectorLike));
    }

    @Inject
    public FeedSetNotifyMeController(FeedEventBus feedEventBus, StoryMutationHelper storyMutationHelper) {
        this.f11961a = feedEventBus;
        this.f11962b = storyMutationHelper;
    }

    public final void m14049a(LegacyFeedUnitUpdater legacyFeedUnitUpdater, @Nullable FeedOnDataChangeListener feedOnDataChangeListener) {
        this.f11963c = new SetNotifyMeSubscriber(this);
        this.f11961a.a(this.f11963c);
        this.f11964d = legacyFeedUnitUpdater;
        this.f11965e = feedOnDataChangeListener;
    }

    public static FeedSetNotifyMeController m14046a(InjectorLike injectorLike) {
        return m14047b(injectorLike);
    }

    public final void m14048a() {
        if (this.f11963c != null) {
            this.f11961a.b(this.f11963c);
        }
    }
}
