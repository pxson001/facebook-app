package com.facebook.feed.ui.fullscreenvideoplayer.plugins;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.feed.util.FeedNetworkConnectivityReceiver;
import com.facebook.inject.FbInjector;
import com.facebook.widget.AnimatedNotificationBanner;
import javax.inject.Inject;

/* compiled from: TimelineLoadCoverPhotoLowRes */
public class FeedFullScreenNetworkBanner extends AnimatedNotificationBanner {
    private final FullScreenNetworkListener f21980c;
    public FbNetworkManager f21981d;

    @SuppressLint({"DeprecatedSuperclass"})
    /* compiled from: TimelineLoadCoverPhotoLowRes */
    class FullScreenNetworkListener extends FeedNetworkConnectivityReceiver {
        final /* synthetic */ FeedFullScreenNetworkBanner f21979a;

        public FullScreenNetworkListener(FeedFullScreenNetworkBanner feedFullScreenNetworkBanner, Context context) {
            this.f21979a = feedFullScreenNetworkBanner;
            super(context);
        }

        public final void m24596a(Context context, Intent intent) {
            this.f21979a.m24602d();
        }
    }

    private static <T extends View> void m24598a(Class<T> cls, T t) {
        m24599a((Object) t, t.getContext());
    }

    private static void m24599a(Object obj, Context context) {
        ((FeedFullScreenNetworkBanner) obj).f21981d = FbNetworkManager.a(FbInjector.get(context));
    }

    public FeedFullScreenNetworkBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24598a(FeedFullScreenNetworkBanner.class, (View) this);
        this.f21980c = new FullScreenNetworkListener(this, context);
    }

    @Inject
    private void m24597a(FbNetworkManager fbNetworkManager) {
        this.f21981d = fbNetworkManager;
    }

    public final void m24600b() {
        this.f21980c.a();
    }

    public final void m24601c() {
        this.f21980c.b();
    }

    public final void m24602d() {
        if (this.f21981d.d()) {
            a();
        } else {
            a(getResources().getString(2131230763), false);
        }
    }
}
