package com.facebook.feed.ui;

import android.view.View;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.animation.AnimationCallback;
import com.facebook.feed.fragment.NewsFeedFragment.C05634;
import com.facebook.feed.pill.FeedMoreStoriesPillUIController;
import com.facebook.feed.pill.FeedMoreStoriesPillUIController.C05661;
import com.facebook.feed.pill.FeedMoreStoriesPillUIController.MoreStoriesScrollingListener;
import com.facebook.feed.pill.FeedPillUIController;
import com.facebook.feed.pill.FeedPillUIController.AnimationSpringListener;
import com.facebook.feed.pill.FeedPillUIController.AnimationState;
import com.facebook.feed.pill.FeedPillUIController.C05641;
import com.facebook.feed.pill.FeedPillUIController.C05652;
import com.facebook.widget.listview.ScrollingViewProxy;
import javax.annotation.Nullable;

/* compiled from: messenger_rain_money */
public class NewsFeedListViewAnimations {
    private final FeedPillUIController f13803a;
    private final FeedMoreStoriesPillUIController f13804b;
    private boolean f13805c;
    public AnimationCallback f13806d;

    public NewsFeedListViewAnimations(ScrollingViewProxy scrollingViewProxy, View view, FeedPillUIController feedPillUIController, @Nullable View view2, @Nullable FeedMoreStoriesPillUIController feedMoreStoriesPillUIController, @Nullable C05634 c05634) {
        this.f13805c = false;
        this.f13803a = feedPillUIController;
        FeedPillUIController feedPillUIController2 = this.f13803a;
        boolean z = true;
        feedPillUIController2.f9475g = view;
        feedPillUIController2.f9479k = scrollingViewProxy;
        if (feedPillUIController2.f9473e.mo596a(ExperimentsForNewsFeedAbTestModule.f5093T, true)) {
            feedPillUIController2.f9483o = feedPillUIController2.f9473e.mo596a(ExperimentsForNewsFeedAbTestModule.f5123x, false);
            if (feedPillUIController2.f9483o) {
                z = false;
            }
            feedPillUIController2.f9480l = new C05641(feedPillUIController2, feedPillUIController2.f9479k, z);
            feedPillUIController2.f9481m = feedPillUIController2.f9474f.m14481b(feedPillUIController2.f9480l);
            scrollingViewProxy.mo2369b(feedPillUIController2.f9481m);
        }
        feedPillUIController2.f9477i = new AnimationSpringListener(feedPillUIController2);
        feedPillUIController2.f9476h = feedPillUIController2.f9470b.m7838a().m7813a(0.0d).m7815a(feedPillUIController2.f9477i).m7814a(FeedPillUIController.f9469a);
        feedPillUIController2.f9475g.setOnTouchListener(new C05652(feedPillUIController2));
        feedPillUIController2.f9478j = AnimationState.HIDDEN;
        if (view2 == null || feedMoreStoriesPillUIController == null) {
            this.f13804b = null;
            return;
        }
        this.f13804b = feedMoreStoriesPillUIController;
        FeedMoreStoriesPillUIController feedMoreStoriesPillUIController2 = this.f13804b;
        feedMoreStoriesPillUIController2.f9499d = false;
        feedMoreStoriesPillUIController2.f9497b = view2;
        feedMoreStoriesPillUIController2.f9498c = scrollingViewProxy;
        feedMoreStoriesPillUIController2.f9496a = new MoreStoriesScrollingListener(feedMoreStoriesPillUIController2);
        feedMoreStoriesPillUIController2.f9497b.setOnTouchListener(new C05661(feedMoreStoriesPillUIController2));
        feedMoreStoriesPillUIController2.f9498c.mo2369b(feedMoreStoriesPillUIController2.f9496a);
        feedMoreStoriesPillUIController2.f9500e = c05634;
    }

    public NewsFeedListViewAnimations(ScrollingViewProxy scrollingViewProxy, View view, FeedPillUIController feedPillUIController) {
        this(scrollingViewProxy, view, feedPillUIController, null, null, null);
    }

    public final boolean m20216a(boolean z) {
        if (!z) {
            return this.f13803a.m14476d();
        }
        if (this.f13805c) {
            return false;
        }
        this.f13806d.mo1899b(this.f13803a.f9475g);
        FeedPillUIController feedPillUIController = this.f13803a;
        feedPillUIController.f9482n = true;
        return FeedPillUIController.m14471h(feedPillUIController);
    }

    public final void m20217b(boolean z) {
        if (this.f13804b == null) {
            return;
        }
        if (z) {
            this.f13806d.mo1899b(this.f13804b.f9497b);
            FeedMoreStoriesPillUIController feedMoreStoriesPillUIController = this.f13804b;
            if (!feedMoreStoriesPillUIController.f9499d) {
                feedMoreStoriesPillUIController.f9499d = true;
                feedMoreStoriesPillUIController.f9497b.setVisibility(0);
                return;
            }
            return;
        }
        this.f13804b.m14486c();
    }
}
