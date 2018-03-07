package com.facebook.pages.common.surface.fragments.eventsubscribers;

import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.controller.mutation.BaseMutationCallback;
import com.facebook.controller.mutation.StoryMutationHelper;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.ufiservices.event.UfiEvents.SetNotifyMeEvent;
import com.facebook.ufiservices.event.UfiEvents.SetNotifyMeEventSubscriber;
import javax.inject.Inject;

/* compiled from: returnKeyType */
public class StoryMenuNotifyMeEventSubscriber extends SetNotifyMeEventSubscriber {
    public Lazy<FbErrorReporter> f2421a;
    private Lazy<PagesAnalytics> f2422b;
    private StoryMutationHelper f2423c;

    public static StoryMenuNotifyMeEventSubscriber m3360a(InjectorLike injectorLike) {
        return new StoryMenuNotifyMeEventSubscriber(IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedSingletonScopeProvider.b(injectorLike, 8930), StoryMutationHelper.b(injectorLike));
    }

    public final void m3361b(FbEvent fbEvent) {
        final SetNotifyMeEvent setNotifyMeEvent = (SetNotifyMeEvent) fbEvent;
        PagesAnalytics pagesAnalytics = (PagesAnalytics) this.f2422b.get();
        pagesAnalytics.a.a(CommonEventsBuilder.b("timeline_story_notify_me", setNotifyMeEvent.c, String.valueOf(setNotifyMeEvent.h), "native_timeline"));
        this.f2423c.a(setNotifyMeEvent.a, setNotifyMeEvent.h, null, null, new BaseMutationCallback<FeedUnit>(this) {
            final /* synthetic */ StoryMenuNotifyMeEventSubscriber f2420b;

            public final void m3359a(Object obj, ServiceException serviceException) {
                ((AbstractFbErrorReporter) this.f2420b.f2421a.get()).a(getClass().getName(), StringFormatUtil.formatStrLocaleSafe("NotifyMe err: storyId = %s, storyLegacyApiId = %s, feedbackLegacyApiId = %s", setNotifyMeEvent.e, setNotifyMeEvent.b, setNotifyMeEvent.c));
            }
        });
    }

    @Inject
    public StoryMenuNotifyMeEventSubscriber(Lazy<FbErrorReporter> lazy, Lazy<PagesAnalytics> lazy2, StoryMutationHelper storyMutationHelper) {
        this.f2421a = lazy;
        this.f2422b = lazy2;
        this.f2423c = storyMutationHelper;
    }
}
