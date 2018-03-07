package com.facebook.feed.loader;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: send pause-optimization broadcast */
public class EndOfFeedState {
    public final Clock f5673a;
    public boolean f5674b = false;
    public long f5675c = 0;

    public static EndOfFeedState m9787b(InjectorLike injectorLike) {
        return new EndOfFeedState(SystemClockMethodAutoProvider.m1498a(injectorLike));
    }

    @Inject
    public EndOfFeedState(Clock clock) {
        this.f5673a = clock;
    }

    public final void m9788a() {
        if (!this.f5674b) {
            this.f5675c = this.f5673a.mo211a();
            this.f5674b = true;
        }
    }

    public final boolean m9789c() {
        return this.f5674b;
    }

    public final void m9790d() {
        this.f5675c = 0;
        this.f5674b = false;
    }
}
