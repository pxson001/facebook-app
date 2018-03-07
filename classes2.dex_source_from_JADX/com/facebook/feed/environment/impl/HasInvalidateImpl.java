package com.facebook.feed.environment.impl;

import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.inject.Assisted;
import com.facebook.multirow.api.DirtyListener;
import com.facebook.multirow.api.DirtyUnitObserver;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: new_like_count */
public class HasInvalidateImpl implements HasInvalidate, DirtyUnitObserver {
    private final Runnable f12308a;
    @Nullable
    private DirtyListener f12309b;
    private boolean f12310c;

    @Inject
    public HasInvalidateImpl(@Assisted Runnable runnable) {
        this.f12308a = runnable;
    }

    public final void hL_() {
        this.f12308a.run();
    }

    public final void mo2438a(Object... objArr) {
        if (this.f12309b != null) {
            for (Object a : objArr) {
                this.f12309b.mo2532a(a);
            }
            if (this.f12310c) {
                hL_();
            }
        }
    }

    public final void mo2437a(FeedProps... feedPropsArr) {
        Object[] objArr = new Object[feedPropsArr.length];
        for (int i = 0; i < feedPropsArr.length; i++) {
            Flattenable b = feedPropsArr[i].m19806b();
            if (b == null) {
                b = feedPropsArr[i].f13444a;
            }
            objArr[i] = b;
        }
        mo2438a(objArr);
    }

    public final void mo2435a(@Nullable DirtyListener dirtyListener) {
        this.f12309b = dirtyListener;
    }

    public final void a_(boolean z) {
        this.f12310c = z;
    }
}
