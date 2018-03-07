package com.facebook.feed.fragment.controllercallbacks;

import com.facebook.api.feed.FetchFeedParams.FetchFeedCause;
import com.facebook.api.feed.data.LegacyFeedUnitUpdater;
import com.facebook.api.feedtype.FeedType;
import com.facebook.common.executors.NamedRunnable;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;

/* compiled from: group_remove_member */
public class GoodFriendsCustomizationHeaderController$1 extends NamedRunnable {
    final /* synthetic */ GoodFriendsCustomizationHeaderController f11882c;

    public GoodFriendsCustomizationHeaderController$1(GoodFriendsCustomizationHeaderController goodFriendsCustomizationHeaderController, Class cls, String str) {
        this.f11882c = goodFriendsCustomizationHeaderController;
        super(cls, str);
    }

    public void run() {
        this.f11882c.b.a(FeedType.e);
        ExecutorDetour.a(this.f11882c.c, new NamedRunnable(this, getClass(), "refresh-goodfriends-feed") {
            final /* synthetic */ GoodFriendsCustomizationHeaderController$1 f11881c;

            public void run() {
                ((LegacyFeedUnitUpdater) this.f11881c.f11882c.h.a).a();
                this.f11881c.f11882c.g.a(FetchFeedCause.PULL_TO_REFRESH);
            }
        }, -1955273930);
    }
}
