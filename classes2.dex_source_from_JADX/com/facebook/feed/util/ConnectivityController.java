package com.facebook.feed.util;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.fragment.FragmentCreateDestroyCallbacks;
import com.facebook.controllercallbacks.fragment.ViewCreatedDestroyedCallbacks;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Inject;
import com.google.common.annotations.VisibleForTesting;

/* compiled from: photoset_token */
public class ConnectivityController<Dispatcher extends ConnectivityChangedCallback> extends BaseController implements FragmentCreateDestroyCallbacks, ViewCreatedDestroyedCallbacks {
    @VisibleForTesting
    FeedNetworkConnectivityReceiver f9889a;
    public final FbNetworkManager f9890b;
    public Dispatcher f9891c;

    public static ConnectivityController m14923a(InjectorLike injectorLike) {
        return new ConnectivityController(FbNetworkManager.m3811a(injectorLike));
    }

    @Inject
    public ConnectivityController(FbNetworkManager fbNetworkManager) {
        this.f9890b = fbNetworkManager;
    }

    public final void mo1886a(View view) {
        if (this.f9889a == null) {
            this.f9889a = new FeedNetworkConnectivityReceiver(this, view.getContext()) {
                final /* synthetic */ ConnectivityController f12250a;

                public final void mo1730a(Context context, Intent intent) {
                    this.f12250a.f9891c.mo1900b(this.f12250a.f9890b.m3828d());
                }
            };
        } else {
            this.f9889a.m12857a();
        }
    }

    public final void kG_() {
        this.f9889a.mo1933b();
    }

    public final void mo1949b() {
        this.f9889a = null;
    }
}
