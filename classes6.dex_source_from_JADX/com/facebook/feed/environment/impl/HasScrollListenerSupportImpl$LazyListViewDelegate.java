package com.facebook.feed.environment.impl;

import android.widget.AbsListView;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.widget.listview.BaseOnScrollListener;
import com.facebook.widget.listview.BetterListView;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* compiled from: multi_photo_publish_target */
public class HasScrollListenerSupportImpl$LazyListViewDelegate implements Delegate {
    @Nullable
    private WeakReference<BetterListView> f10158a;

    public final void m15839a(BetterListView betterListView) {
        this.f10158a = new WeakReference(betterListView);
    }

    public final void m15838a(final HasScrollListenerSupportImpl hasScrollListenerSupportImpl) {
        if (this.f10158a == null) {
            throw new IllegalStateException("List view must be set beforeregisterScrollListener is called.");
        }
        BetterListView betterListView = (BetterListView) this.f10158a.get();
        if (betterListView != null) {
            betterListView.a(new BaseOnScrollListener(this) {
                final /* synthetic */ HasScrollListenerSupportImpl$LazyListViewDelegate f10157b;

                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    hasScrollListenerSupportImpl.b();
                }
            });
        }
    }
}
