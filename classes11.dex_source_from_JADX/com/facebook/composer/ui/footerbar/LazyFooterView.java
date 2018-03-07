package com.facebook.composer.ui.footerbar;

import android.view.View;
import android.view.ViewStub;
import com.facebook.widget.LazyView;
import com.facebook.widget.LazyView.OnInflateRunner;
import javax.annotation.Nullable;

/* compiled from: fbLoggedOutWebViewIsErrorPage */
public class LazyFooterView<V extends View> {
    public final int f7129a;
    private final LazyView<V> f7130b;

    public LazyFooterView(ViewStub viewStub, int i) {
        this(viewStub, i, null);
    }

    public LazyFooterView(ViewStub viewStub, int i, @Nullable final OnInflateRunner<V> onInflateRunner) {
        this.f7129a = i;
        this.f7130b = new LazyView(viewStub, new OnInflateRunner<V>(this) {
            final /* synthetic */ LazyFooterView f7128b;

            public final void m8351a(V v) {
                v.setMinimumWidth(this.f7128b.f7129a);
                if (onInflateRunner != null) {
                    onInflateRunner.a(v);
                }
            }
        });
    }

    public final V m8352a() {
        return this.f7130b.a();
    }

    public final void m8353b() {
        if (this.f7130b.b()) {
            this.f7130b.a().setVisibility(8);
        }
    }
}
