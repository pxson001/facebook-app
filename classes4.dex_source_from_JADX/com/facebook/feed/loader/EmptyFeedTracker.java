package com.facebook.feed.loader;

import com.facebook.api.feed.data.FetchFeedDirection;
import com.facebook.inject.InjectorLike;

/* compiled from: wear_app_paired */
public class EmptyFeedTracker {
    private boolean f170a = false;
    private boolean f171b = false;
    private boolean f172c = true;

    public static EmptyFeedTracker m200a(InjectorLike injectorLike) {
        return new EmptyFeedTracker();
    }

    public final void m201a() {
        this.f172c = false;
    }

    public final void m202a(FetchFeedDirection fetchFeedDirection) {
        if (!this.f172c) {
            return;
        }
        if (fetchFeedDirection != FetchFeedDirection.BEFORE || !this.f170a) {
            if (fetchFeedDirection != FetchFeedDirection.AFTER || !this.f171b) {
                if (fetchFeedDirection == FetchFeedDirection.BEFORE) {
                    this.f170a = true;
                }
                if (fetchFeedDirection == FetchFeedDirection.AFTER) {
                    this.f171b = true;
                }
            }
        }
    }

    public final boolean m203b() {
        return this.f170a && this.f171b;
    }
}
