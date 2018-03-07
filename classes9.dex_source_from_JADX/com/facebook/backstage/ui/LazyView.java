package com.facebook.backstage.ui;

import android.view.View;
import android.view.ViewStub;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: search_terms */
public class LazyView<V extends View> {
    @Nullable
    private ViewStub f5481a;
    @Nullable
    private OnInflateRunner<V> f5482b;
    @GuardedBy("this")
    @Nullable
    private V f5483c;

    /* compiled from: search_terms */
    public interface OnInflateRunner<V extends View> {
        void mo137a(V v);
    }

    public LazyView(@Nonnull ViewStub viewStub) {
        this.f5481a = (ViewStub) Preconditions.checkNotNull(viewStub);
    }

    public LazyView(@Nonnull ViewStub viewStub, @Nonnull OnInflateRunner<V> onInflateRunner) {
        this.f5481a = (ViewStub) Preconditions.checkNotNull(viewStub);
        this.f5482b = (OnInflateRunner) Preconditions.checkNotNull(onInflateRunner);
    }

    @Nonnull
    public final synchronized V m5715a() {
        if (this.f5483c == null) {
            View inflate = this.f5481a.inflate();
            if (this.f5482b != null) {
                this.f5482b.mo137a(inflate);
            }
            this.f5483c = inflate;
            this.f5482b = null;
            this.f5481a = null;
        }
        return this.f5483c;
    }

    public final synchronized boolean m5716b() {
        return this.f5483c != null;
    }

    public final synchronized void m5717c() {
        if (this.f5483c != null) {
            this.f5483c.setVisibility(8);
        }
    }
}
