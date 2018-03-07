package com.facebook.goodwill.feed.data;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.api.feed.FetchFeedParams.FetchFeedCause;
import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.goodwill.feed.ui.ThrowbackFeedFragment;
import com.facebook.goodwill.feed.ui.ThrowbackFeedFragment.AnonymousClass16;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Objects;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: View already registered with a NativeAd. Auto unregistering and proceeding. */
public class ThrowbackFeedPager implements IHaveUserData {
    public static final Set<String> f21056a = new HashSet(Arrays.asList(new String[]{"missed_memories", "friendversary"}));
    public final FeedUnitCollection f21057b;
    public final TasksManager f21058c;
    public String f21059d;
    public ThrowbackFeedResources f21060e;
    private final HashSet<Integer> f21061f = new HashSet();
    public boolean f21062g = false;
    public ThrowbackFeedPagerProtocol f21063h;
    public AnonymousClass16 f21064i;
    public boolean f21065j;
    public boolean f21066k;
    public boolean f21067l;
    public boolean f21068m;

    /* compiled from: View already registered with a NativeAd. Auto unregistering and proceeding. */
    public class C29981 implements Callable<ListenableFuture> {
        final /* synthetic */ ThrowbackFeedPager f21053a;

        public C29981(ThrowbackFeedPager throwbackFeedPager) {
            this.f21053a = throwbackFeedPager;
        }

        public Object call() {
            return ThrowbackFeedPager.m22030a(this.f21053a, false, null);
        }
    }

    /* compiled from: View already registered with a NativeAd. Auto unregistering and proceeding. */
    class C29992 implements Callable<ListenableFuture> {
        final /* synthetic */ ThrowbackFeedPager f21054a;

        C29992(ThrowbackFeedPager throwbackFeedPager) {
            this.f21054a = throwbackFeedPager;
        }

        public Object call() {
            return ThrowbackFeedPager.m22030a(this.f21054a, true, null);
        }
    }

    /* compiled from: View already registered with a NativeAd. Auto unregistering and proceeding. */
    public class LoadStoriesCallback extends AbstractDisposableFutureCallback<ThrowbackFeedStories> {
        public final /* synthetic */ ThrowbackFeedPager f21055a;

        public LoadStoriesCallback(ThrowbackFeedPager throwbackFeedPager) {
            this.f21055a = throwbackFeedPager;
        }

        protected final void m22028a(Throwable th) {
            ThrowbackFeedPager.m22031a(this.f21055a, false);
            AnonymousClass16 anonymousClass16 = this.f21055a.f21064i;
            if (anonymousClass16.f21185a.mx_() && ThrowbackFeedFragment.aC(anonymousClass16.f21185a).getCount() == 0) {
                ThrowbackFeedFragment throwbackFeedFragment = anonymousClass16.f21185a;
                ((TextView) throwbackFeedFragment.aE.findViewById(2131561899)).setText(2131239671);
                throwbackFeedFragment.aC.f(throwbackFeedFragment.aE);
                throwbackFeedFragment.aE.findViewById(2131561897).setOnClickListener(new OnClickListener(throwbackFeedFragment) {
                    final /* synthetic */ ThrowbackFeedFragment f21186a;

                    {
                        this.f21186a = r1;
                    }

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 2026000285);
                        this.f21186a.aE.setVisibility(8);
                        this.f21186a.aC.f(null);
                        this.f21186a.f21200a.m22034e();
                        Logger.a(2, EntryType.UI_INPUT_END, 404775221, a);
                    }
                });
            }
        }
    }

    /* compiled from: View already registered with a NativeAd. Auto unregistering and proceeding. */
    public enum Task {
        LOAD_INITIAL_FEED,
        LOAD_NEXT_PAGE,
        REFRESH_FEED
    }

    public static ThrowbackFeedPager m22029a(InjectorLike injectorLike) {
        return new ThrowbackFeedPager(TasksManager.b(injectorLike), FeedUnitCollection.b(injectorLike));
    }

    @Inject
    public ThrowbackFeedPager(TasksManager tasksManager, FeedUnitCollection feedUnitCollection) {
        this.f21058c = tasksManager;
        this.f21057b = feedUnitCollection;
    }

    public static ListenableFuture m22030a(ThrowbackFeedPager throwbackFeedPager, boolean z, Map map) {
        String str;
        FetchFeedCause fetchFeedCause;
        m22031a(throwbackFeedPager, true);
        ThrowbackFeedPagerProtocol throwbackFeedPagerProtocol = throwbackFeedPager.f21063h;
        if (z) {
            str = null;
        } else {
            str = throwbackFeedPager.f21057b.r();
        }
        if (throwbackFeedPager.f21067l) {
            fetchFeedCause = FetchFeedCause.PULL_TO_REFRESH;
        } else if (throwbackFeedPager.f21066k) {
            fetchFeedCause = FetchFeedCause.INITIALIZATION;
        } else {
            fetchFeedCause = FetchFeedCause.SCROLLING;
        }
        return throwbackFeedPagerProtocol.m22044a(str, fetchFeedCause, map);
    }

    public static void m22031a(ThrowbackFeedPager throwbackFeedPager, boolean z) {
        AnonymousClass16 anonymousClass16 = throwbackFeedPager.f21064i;
        if (anonymousClass16.f21185a.mx_()) {
            ThrowbackFeedFragment throwbackFeedFragment = anonymousClass16.f21185a;
            ThrowbackFeedFragment.m22138a(z, anonymousClass16.f21185a.aB);
        }
    }

    public final void m22034e() {
        m22032b(false);
    }

    private void m22032b(boolean z) {
        this.f21067l = z;
        this.f21058c.a(Task.REFRESH_FEED, new C29992(this), new LoadStoriesCallback(this));
    }

    public final void m22035f() {
        this.f21068m = true;
        m22032b(false);
    }

    public void clearUserData() {
        m22033k();
    }

    public String toString() {
        return Objects.toStringHelper(ThrowbackFeedPager.class).add("totalStories", this.f21057b.a()).add("freshStories", this.f21057b.u()).add("mHasReachedEndOfFeed", this.f21065j).toString();
    }

    public final void m22036h() {
        m22033k();
    }

    private void m22033k() {
        this.f21058c.c();
        this.f21057b.m();
        this.f21065j = false;
    }
}
