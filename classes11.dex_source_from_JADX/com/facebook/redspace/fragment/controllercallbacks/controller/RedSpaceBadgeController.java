package com.facebook.redspace.fragment.controllercallbacks.controller;

import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.fragment.FragmentCreateDestroyCallbacks;
import com.facebook.redspace.analytics.logger.RedSpaceLogger;
import com.facebook.redspace.badge.RedSpaceTabUnseenCountFetcher;
import com.facebook.redspace.data.RedSpaceFeedProfileUnreadStoriesHelper;
import com.facebook.redspace.data.RedSpaceFriendsCollection;
import com.facebook.redspace.data.RedSpaceFriendsFetchResult;
import com.facebook.redspace.data.RedSpaceFriendsSection;
import com.facebook.redspace.fragment.controllercallbacks.api.RedSpaceFriendsFetchCallback;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;

/* compiled from: PagesPhotosReactionSurfaceTabFragment */
public class RedSpaceBadgeController extends BaseController implements FragmentCreateDestroyCallbacks, RedSpaceFriendsFetchCallback {
    @Inject
    public RedSpaceTabUnseenCountFetcher f12031a;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<RedSpaceFeedProfileUnreadStoriesHelper> f12032b = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<RedSpaceLogger> f12033c = UltralightRuntime.b;
    public Integer f12034d;
    public long f12035e;

    public final void m12503b() {
    }

    public final void mo343a(RedSpaceFriendsSection redSpaceFriendsSection, RedSpaceFriendsCollection redSpaceFriendsCollection) {
    }

    public final void mo344a(RedSpaceFriendsSection redSpaceFriendsSection, RedSpaceFriendsCollection redSpaceFriendsCollection, RedSpaceFriendsFetchResult redSpaceFriendsFetchResult) {
        if (this.f12034d != null && redSpaceFriendsSection.isTop()) {
            m12500a(this.f12034d.intValue(), this.f12035e, redSpaceFriendsCollection);
            this.f12034d = null;
        }
    }

    private void m12500a(int i, long j, RedSpaceFriendsCollection redSpaceFriendsCollection) {
        Object obj = null;
        int i2 = 0;
        for (int i3 = 0; i3 < redSpaceFriendsCollection.m12222d(); i3++) {
            if (((RedSpaceFeedProfileUnreadStoriesHelper) this.f12032b.get()).m12204a(redSpaceFriendsCollection.m12213a(i3)) > 0) {
                i2++;
            }
        }
        if (i != i2) {
            if (this.f12031a.h() != j) {
                obj = 1;
            }
            HoneyClientEventFast a = ((RedSpaceLogger) this.f12033c.get()).b.a("badge_mismatch", false);
            if (a.a()) {
                a.a("redspace_performance");
                a.a("badge_count", i);
                a.a("friend_count", i2);
                if (obj != null) {
                    a.a("message", "cache_expired");
                }
                a.b();
            }
        }
    }

    public final void a_(Throwable th) {
    }
}
