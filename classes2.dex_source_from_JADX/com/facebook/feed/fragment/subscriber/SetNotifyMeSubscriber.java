package com.facebook.feed.fragment.subscriber;

import android.content.res.Resources;
import com.facebook.api.feed.data.LegacyFeedUnitUpdater;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.content.event.FbEvent;
import com.facebook.controller.mutation.StoryMutationHelper;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.inject.InjectorLike;
import com.facebook.ufiservices.event.UfiEvents$SetNotifyMeEvent;
import com.facebook.ufiservices.event.UfiEvents$SetNotifyMeEventSubscriber;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.ui.errordialog.ErrorMessageGenerator;
import com.facebook.ui.toaster.Toaster;
import javax.inject.Inject;

/* compiled from: pma_android_admin_feeds_in_more_tab */
public class SetNotifyMeSubscriber extends UfiEvents$SetNotifyMeEventSubscriber {
    public static final String f9520a = SetNotifyMeSubscriber.class.getSimpleName();
    public final AbstractFbErrorReporter f9521b;
    public final ErrorMessageGenerator f9522c;
    public final Resources f9523d;
    public final Toaster f9524e;
    public final ErrorDialogs f9525f;
    public final FeedEventBus f9526g;
    private final StoryMutationHelper f9527h;
    public boolean f9528i;
    public LegacyFeedUnitUpdater f9529j;

    public static SetNotifyMeSubscriber m14511a(InjectorLike injectorLike) {
        return new SetNotifyMeSubscriber(FeedEventBus.m4573a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), ErrorMessageGenerator.m14518b(injectorLike), ResourcesMethodAutoProvider.m6510a(injectorLike), ErrorDialogs.m14522a(injectorLike), Toaster.m6454b(injectorLike), StoryMutationHelper.m14528b(injectorLike));
    }

    public final void mo650b(FbEvent fbEvent) {
        UfiEvents$SetNotifyMeEvent ufiEvents$SetNotifyMeEvent = (UfiEvents$SetNotifyMeEvent) fbEvent;
        this.f9527h.m14530a(ufiEvents$SetNotifyMeEvent.f11633a, ufiEvents$SetNotifyMeEvent.f11640h, "newsfeed_story_notify_me", "native_newsfeed", new 1(this));
    }

    @Inject
    public SetNotifyMeSubscriber(FeedEventBus feedEventBus, AbstractFbErrorReporter abstractFbErrorReporter, ErrorMessageGenerator errorMessageGenerator, Resources resources, ErrorDialogs errorDialogs, Toaster toaster, StoryMutationHelper storyMutationHelper) {
        this.f9521b = abstractFbErrorReporter;
        this.f9522c = errorMessageGenerator;
        this.f9523d = resources;
        this.f9524e = toaster;
        this.f9525f = errorDialogs;
        this.f9526g = feedEventBus;
        this.f9527h = storyMutationHelper;
    }

    public final void m14512a(LegacyFeedUnitUpdater legacyFeedUnitUpdater) {
        this.f9529j = legacyFeedUnitUpdater;
    }
}
