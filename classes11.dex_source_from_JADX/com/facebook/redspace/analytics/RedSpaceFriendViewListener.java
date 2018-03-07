package com.facebook.redspace.analytics;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.Assisted;
import com.facebook.redspace.adapter.RedSpaceUserCollectionAdapter;
import com.facebook.redspace.adapter.RedSpaceUserMultiAdapter;
import com.facebook.redspace.adapter.RedSpaceUserSectionAdapter;
import com.facebook.redspace.analytics.logger.RedSpaceLogger;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.ultralight.Inject;

/* compiled from: Provided COLLECTION but no VIEW_NAME */
public class RedSpaceFriendViewListener implements OnPageChangeListener {
    @Inject
    public RedSpaceLogger f11751a;
    @Inject
    @LoggedInUserId
    public String f11752b;
    private final RedSpaceUserMultiAdapter f11753c;
    private final String f11754d;

    @Inject
    public RedSpaceFriendViewListener(@Assisted RedSpaceUserMultiAdapter redSpaceUserMultiAdapter, @Assisted String str) {
        this.f11753c = redSpaceUserMultiAdapter;
        this.f11754d = str;
    }

    public final void m12189a(int i, float f, int i2) {
    }

    public final void e_(int i) {
        m12188a(i, "swipe");
    }

    public final void m12190b(int i) {
    }

    public final void m12191c(int i) {
        m12188a(i, this.f11754d);
    }

    private void m12188a(int i, String str) {
        String redSpaceFriendsSection;
        RedSpaceUserMultiAdapter redSpaceUserMultiAdapter = this.f11753c;
        redSpaceUserMultiAdapter.f11747a.m12176a(i);
        RedSpaceUserCollectionAdapter a = redSpaceUserMultiAdapter.f11747a.m12175a();
        RedSpaceFeedProfileFragmentModel g = this.f11753c.m12186g(i);
        if (a instanceof RedSpaceUserSectionAdapter) {
            redSpaceFriendsSection = ((RedSpaceUserSectionAdapter) a).f11749a.toString();
        } else {
            redSpaceFriendsSection = null;
        }
        HoneyClientEventFast a2;
        if (StringUtil.a(this.f11752b, g.k())) {
            a2 = this.f11751a.b.a("open_self_view", false);
            if (a2.a()) {
                a2.a("redspace");
                a2.a("source", str);
                a2.b();
                return;
            }
            return;
        }
        RedSpaceLogger redSpaceLogger = this.f11751a;
        String k = g.k();
        a2 = redSpaceLogger.b.a("open_friend_view", false);
        if (a2.a()) {
            a2.a("redspace");
            a2.a("source", str);
            a2.a("position", i);
            a2.a("person_id", k);
            a2.a("section", redSpaceFriendsSection);
            a2.b();
        }
    }
}
