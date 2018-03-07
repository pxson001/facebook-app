package com.facebook.widget;

import android.view.View;
import android.view.ViewStub;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: report_nas_action */
public class LazyView<V extends View> {
    @Nullable
    private ViewStub f7489a;
    @Nullable
    private OnInflateRunner<V> f7490b;
    @GuardedBy("this")
    @Nullable
    private V f7491c;

    /* compiled from: report_nas_action */
    public interface OnInflateRunner<V extends View> {
        void mo1672a(V v);
    }

    public LazyView(@Nonnull ViewStub viewStub) {
        this.f7489a = (ViewStub) Preconditions.checkNotNull(viewStub);
    }

    public LazyView(@Nonnull ViewStub viewStub, @Nonnull OnInflateRunner<V> onInflateRunner) {
        this.f7489a = (ViewStub) Preconditions.checkNotNull(viewStub);
        this.f7490b = (OnInflateRunner) Preconditions.checkNotNull(onInflateRunner);
    }

    public final void m12096a(int i) {
        if (this.f7489a != null) {
            this.f7489a.setLayoutResource(i);
        }
    }

    @Nonnull
    public final synchronized V m12095a() {
        if (this.f7491c == null) {
            View inflate = this.f7489a.inflate();
            if (this.f7490b != null) {
                this.f7490b.mo1672a(inflate);
            }
            this.f7491c = inflate;
            this.f7490b = null;
            this.f7489a = null;
        }
        return this.f7491c;
    }

    public final synchronized boolean m12097b() {
        return this.f7491c != null;
    }

    public final synchronized void m12098c() {
        if (this.f7491c != null) {
            this.f7491c.setVisibility(8);
        }
    }
}
