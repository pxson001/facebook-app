package com.facebook.katana.activity.profilelist;

import android.os.Handler;
import android.os.Message;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: uncroppedDimensions */
public class FriendTimelineWallPostPrivacyFetcher {
    public ImmutableSet<Long> f1244a;
    public final AtomicBoolean f1245b = new AtomicBoolean(false);
    private final Handler f1246c = new C01171(this);

    /* compiled from: uncroppedDimensions */
    class C01171 extends Handler {
        final /* synthetic */ FriendTimelineWallPostPrivacyFetcher f1243a;

        C01171(FriendTimelineWallPostPrivacyFetcher friendTimelineWallPostPrivacyFetcher) {
            this.f1243a = friendTimelineWallPostPrivacyFetcher;
        }

        public void handleMessage(Message message) {
            this.f1243a.f1244a = RegularImmutableSet.a;
            this.f1243a.f1245b.set(false);
        }
    }
}
