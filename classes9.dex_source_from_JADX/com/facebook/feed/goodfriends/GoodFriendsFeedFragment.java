package com.facebook.feed.goodfriends;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.api.feedtype.FeedType;
import com.facebook.base.fragment.FbFragment;
import com.facebook.debug.log.BLog;
import com.facebook.feed.fragment.NewsFeedFragment;
import com.facebook.feed.fragment.NewsFeedFragment.Builder;
import com.facebook.feed.goodfriends.nux.NoFriendPlaceholderFragment;
import com.facebook.goodfriends.analytics.GoodFriendsAnalyticsLogger;
import com.facebook.goodfriends.analytics.GoodFriendsAnalyticsLogger.Event;
import com.facebook.goodfriends.data.FriendData;
import com.facebook.goodfriends.data.FriendStateFetcher;
import com.facebook.goodfriends.data.FriendStateFetcher.Callback;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: TYPE_BYTES */
public class GoodFriendsFeedFragment extends FbFragment implements AnalyticsFragment {
    public static final String f24476c = GoodFriendsFeedFragment.class.getSimpleName();
    private static final String f24477d = GoodFriendsFeedFragment.class.getSimpleName();
    @Inject
    public GoodFriendsAnalyticsLogger f24478a;
    @Inject
    public FriendStateFetcher f24479b;
    public NoFriendPlaceholderFragment f24480e;
    public NewsFeedFragment f24481f;
    private boolean f24482g = false;
    public boolean f24483h = false;

    /* compiled from: TYPE_BYTES */
    public class C29371 implements Callback {
        final /* synthetic */ GoodFriendsFeedFragment f24475a;

        public C29371(GoodFriendsFeedFragment goodFriendsFeedFragment) {
            this.f24475a = goodFriendsFeedFragment;
        }

        public final void m26373a(ImmutableList<FriendData> immutableList, int i, ImmutableList<FriendData> immutableList2) {
            boolean z = true;
            if (this.f24475a.y) {
                GoodFriendsFeedFragment goodFriendsFeedFragment = this.f24475a;
                if (i <= 0) {
                    z = false;
                }
                GoodFriendsFeedFragment.m26375a(goodFriendsFeedFragment, z);
                this.f24475a.f24483h = false;
                return;
            }
            this.f24475a.f24483h = true;
        }

        public final void m26374a(Throwable th) {
            BLog.b(GoodFriendsFeedFragment.f24476c, "Fail to retrieve good friends", th);
        }
    }

    public static void m26376a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        GoodFriendsFeedFragment goodFriendsFeedFragment = (GoodFriendsFeedFragment) obj;
        GoodFriendsAnalyticsLogger a = GoodFriendsAnalyticsLogger.a(fbInjector);
        FriendStateFetcher b = FriendStateFetcher.b(fbInjector);
        goodFriendsFeedFragment.f24478a = a;
        goodFriendsFeedFragment.f24479b = b;
    }

    public final void m26383c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = GoodFriendsFeedFragment.class;
        m26376a((Object) this, getContext());
    }

    public final View m26381a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 229339589);
        this.f24479b.a(this.f24483h, new C29371(this), 1);
        View inflate = layoutInflater.inflate(2130904600, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1286716990, a);
        return inflate;
    }

    public final void m26380G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1541870262);
        super.G();
        if (this.f24483h) {
            m26375a(this, this.f24482g);
            this.f24483h = false;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1123368820, a);
    }

    public final void m26384g(boolean z) {
        super.g(z);
        if (this.f24478a == null) {
            return;
        }
        if (z) {
            this.f24478a.a(Event.ENTRY);
        } else {
            this.f24478a.a(Event.EXIT);
        }
    }

    public final String am_() {
        return "good_friends_feed";
    }

    public static void m26375a(GoodFriendsFeedFragment goodFriendsFeedFragment, boolean z) {
        if (goodFriendsFeedFragment.s().a(f24477d) == null) {
            goodFriendsFeedFragment.m26377b(z);
        } else {
            goodFriendsFeedFragment.m26378h(z);
        }
    }

    private void m26377b(boolean z) {
        FragmentTransaction a = s().a();
        a.a(2131562559, m26379i(z), f24477d);
        a.b();
    }

    private void m26378h(boolean z) {
        FragmentTransaction a = s().a();
        a.b(2131562559, m26379i(z), f24477d);
        a.b();
    }

    private FbFragment m26379i(boolean z) {
        if (z) {
            if (this.f24481f == null) {
                Builder builder = new Builder();
                builder.a = FeedType.e;
                this.f24481f = builder.d();
            }
            return this.f24481f;
        }
        if (this.f24480e == null) {
            this.f24480e = new NoFriendPlaceholderFragment();
        }
        return this.f24480e;
    }

    public final void m26382a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i != 1756 || this.f24481f == null) {
            if (i == 101) {
                if (i2 == -1) {
                    this.f24482g = intent.getBooleanExtra("has_good_friends", false);
                    this.f24483h = true;
                } else {
                    BLog.b(f24476c, "Can't handle activity result, result code=%d", new Object[]{Integer.valueOf(i)});
                }
            }
            Fragment a = s().a(f24477d);
            if (a != null) {
                a.a(i, i2, intent);
                return;
            }
            return;
        }
        this.f24481f.a(i, i2, intent);
    }
}
