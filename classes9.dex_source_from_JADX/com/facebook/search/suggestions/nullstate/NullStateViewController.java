package com.facebook.search.suggestions.nullstate;

import android.view.View;
import android.widget.ProgressBar;
import com.facebook.inject.Assisted;
import com.facebook.search.api.NullStateStatus;
import com.facebook.widget.LazyView;
import com.facebook.widget.listview.ScrollingViewProxy;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: website_url_key */
public class NullStateViewController {
    public LazyView<ProgressBar> f197a;
    public View f198b;
    public ScrollingViewProxy f199c;

    /* compiled from: website_url_key */
    /* synthetic */ class C00261 {
        static final /* synthetic */ int[] f196a = new int[NullStateStatus.values().length];

        static {
            try {
                f196a[NullStateStatus.NOT_READY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f196a[NullStateStatus.PARTIAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f196a[NullStateStatus.READY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Inject
    public NullStateViewController(@Assisted LazyView<ProgressBar> lazyView, @Assisted ScrollingViewProxy scrollingViewProxy, @Nullable @Assisted View view) {
        this.f197a = lazyView;
        this.f199c = scrollingViewProxy;
        this.f198b = view;
    }

    public final void m329a(NullStateStatus nullStateStatus, boolean z) {
        switch (C00261.f196a[nullStateStatus.ordinal()]) {
            case 1:
                ((ProgressBar) this.f197a.a()).setVisibility(0);
                this.f199c.a(8);
                return;
            case 2:
            case 3:
                int i = 0;
                if (!(this.f199c == null || this.f197a == null)) {
                    if (this.f198b != null) {
                        this.f198b.setVisibility(z ? 0 : 8);
                        ScrollingViewProxy scrollingViewProxy = this.f199c;
                        if (z) {
                            i = 8;
                        }
                        scrollingViewProxy.a(i);
                    } else {
                        this.f199c.a(0);
                    }
                    if (nullStateStatus == NullStateStatus.READY && this.f197a.b()) {
                        ((ProgressBar) this.f197a.a()).setVisibility(8);
                    }
                }
                return;
            default:
                m328a();
                throw new IllegalStateException();
        }
    }

    public final void m328a() {
        this.f197a = null;
        this.f199c = null;
    }
}
