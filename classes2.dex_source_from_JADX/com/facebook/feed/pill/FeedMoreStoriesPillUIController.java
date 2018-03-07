package com.facebook.feed.pill;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.feed.fragment.NewsFeedFragment.C05634;
import com.facebook.inject.InjectorLike;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;

/* compiled from: poll_voters_count */
public class FeedMoreStoriesPillUIController {
    @VisibleForTesting
    public MoreStoriesScrollingListener f9496a;
    public View f9497b;
    public ScrollingViewProxy f9498c;
    public boolean f9499d;
    public C05634 f9500e;
    public final Rect f9501f = new Rect();
    public final int[] f9502g = new int[]{0, 0};

    /* compiled from: poll_voters_count */
    public class MoreStoriesScrollingListener implements OnScrollListener {
        final /* synthetic */ FeedMoreStoriesPillUIController f13823a;

        public MoreStoriesScrollingListener(FeedMoreStoriesPillUIController feedMoreStoriesPillUIController) {
            this.f13823a = feedMoreStoriesPillUIController;
        }

        public final void mo1262a(ScrollingViewProxy scrollingViewProxy, int i) {
            if (i == 0 && this.f13823a.f9499d) {
                this.f13823a.m14486c();
            }
        }

        public final void mo1263a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
        }
    }

    /* compiled from: poll_voters_count */
    public class C05661 implements OnTouchListener {
        final /* synthetic */ FeedMoreStoriesPillUIController f13824a;

        public C05661(FeedMoreStoriesPillUIController feedMoreStoriesPillUIController) {
            this.f13824a = feedMoreStoriesPillUIController;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            FeedMoreStoriesPillUIController feedMoreStoriesPillUIController = this.f13824a;
            feedMoreStoriesPillUIController.f9497b.getLocationOnScreen(feedMoreStoriesPillUIController.f9502g);
            int i = feedMoreStoriesPillUIController.f9502g[0];
            int i2 = feedMoreStoriesPillUIController.f9502g[1];
            feedMoreStoriesPillUIController.f9501f.set(i, i2, feedMoreStoriesPillUIController.f9497b.getWidth() + i, feedMoreStoriesPillUIController.f9497b.getHeight() + i2);
            boolean contains = feedMoreStoriesPillUIController.f9501f.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            switch (motionEvent.getAction()) {
                case 0:
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    feedMoreStoriesPillUIController.f9497b.setPressed(contains);
                    break;
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    if (contains) {
                        view.performClick();
                        break;
                    }
                    break;
                case 3:
                    break;
            }
            feedMoreStoriesPillUIController.f9497b.setPressed(false);
            return true;
        }
    }

    public static FeedMoreStoriesPillUIController m14485a(InjectorLike injectorLike) {
        return new FeedMoreStoriesPillUIController();
    }

    public final void m14486c() {
        if (this.f9499d) {
            this.f9497b.setVisibility(8);
            this.f9499d = false;
            if (this.f9500e != null) {
                this.f9500e.f13807a.bF.m16833a("fresh_feed_new_story_pill_hidden");
            }
        }
    }

    public final void m14487d() {
        if (!(this.f9498c == null || this.f9496a == null)) {
            this.f9498c.mo2374c(this.f9496a);
        }
        this.f9500e = null;
    }
}
