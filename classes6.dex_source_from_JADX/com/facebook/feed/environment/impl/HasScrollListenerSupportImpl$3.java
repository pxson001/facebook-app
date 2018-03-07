package com.facebook.feed.environment.impl;

import android.widget.AbsListView;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.widget.listview.BaseOnScrollListener;
import com.facebook.widget.listview.BetterListView;
import java.lang.ref.WeakReference;

/* compiled from: multi_photo_publish_target */
final class HasScrollListenerSupportImpl$3 implements Delegate {
    final /* synthetic */ WeakReference f10155a;

    HasScrollListenerSupportImpl$3(WeakReference weakReference) {
        this.f10155a = weakReference;
    }

    public final void m15837a(final HasScrollListenerSupportImpl hasScrollListenerSupportImpl) {
        BetterListView betterListView = (BetterListView) this.f10155a.get();
        if (betterListView != null) {
            betterListView.a(new BaseOnScrollListener(this) {
                final /* synthetic */ HasScrollListenerSupportImpl$3 f10154b;

                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    hasScrollListenerSupportImpl.b();
                }
            });
        }
    }
}
