package com.facebook.widget.listview;

import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;

/* compiled from: offers_use_now */
public class ScrollDirectionTrackingListener implements OnScrollListener {
    private ScrollDirection f11537a = ScrollDirection.NOT_SCROLLING;
    private ScrollDirection f11538b = ScrollDirection.NOT_SCROLLING;
    private int f11539c = 0;
    private int f11540d = 0;

    /* compiled from: offers_use_now */
    public enum ScrollDirection {
        NOT_SCROLLING,
        SCROLLING_DOWN,
        SCROLLING_UP
    }

    public void mo1262a(ScrollingViewProxy scrollingViewProxy, int i) {
    }

    public void mo1263a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
        ScrollDirection scrollDirection = this.f11537a;
        if (i > this.f11540d) {
            scrollDirection = ScrollDirection.SCROLLING_DOWN;
        } else if (i < this.f11540d) {
            scrollDirection = ScrollDirection.SCROLLING_UP;
        }
        this.f11540d = i;
        if (scrollDirection == this.f11538b) {
            this.f11539c++;
        } else {
            this.f11539c = 1;
        }
        this.f11538b = scrollDirection;
        if (this.f11539c >= 2) {
            this.f11537a = scrollDirection;
        }
    }

    public final ScrollDirection m16858b() {
        return this.f11537a;
    }
}
