package com.facebook.timeline.actionbar;

import android.content.Context;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.actionbar.seefirst.FollowSwitcherPopupWindowProvider;
import com.facebook.timeline.delegate.ProfileControllerDelegate;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.header.menus.TimelineFriendingClient;
import com.facebook.timeline.logging.TimelineAnalyticsLogger;

/* compiled from: groups/pendingposts/{%s} */
public class TimelineActionBarControllerImplProvider extends AbstractAssistedProvider<TimelineActionBarControllerImpl> {
    public final TimelineActionBarControllerImpl m10427a(Context context, TimelineAnalyticsLogger timelineAnalyticsLogger, TimelineContext timelineContext, TimelineFriendingClient timelineFriendingClient, TimelineHeaderUserData timelineHeaderUserData, String str) {
        return new TimelineActionBarControllerImpl(context, timelineAnalyticsLogger, timelineContext, timelineFriendingClient, timelineHeaderUserData, str, IdBasedSingletonScopeProvider.a(this, 6687), IdBasedSingletonScopeProvider.a(this, 11216), IdBasedSingletonScopeProvider.a(this, 137), IdBasedSingletonScopeProvider.a(this, 3863), IdBasedSingletonScopeProvider.a(this, 2347), IdBasedSingletonScopeProvider.a(this, 11388), IdBasedSingletonScopeProvider.a(this, 11370), IdBasedSingletonScopeProvider.a(this, 11366), IdBasedSingletonScopeProvider.a(this, 616), IdBasedLazy.a(this, 568), IdBasedSingletonScopeProvider.a(this, 968), (FollowSwitcherPopupWindowProvider) getOnDemandAssistedProviderForStaticDi(FollowSwitcherPopupWindowProvider.class), IdBasedSingletonScopeProvider.a(this, 11155), (SecureContextHelper) DefaultSecureContextHelper.a(this), IdBasedLazy.a(this, 11282), IdBasedSingletonScopeProvider.b(this, 494), ProfileControllerDelegate.m10751a((InjectorLike) this), IdBasedLazy.a(this, 6667), (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}
