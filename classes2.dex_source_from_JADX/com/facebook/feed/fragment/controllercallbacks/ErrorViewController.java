package com.facebook.feed.fragment.controllercallbacks;

import android.view.View;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.api.ControllerCallback;
import com.facebook.controllercallbacks.fragment.ViewCreatedDestroyedCallbacks;
import com.facebook.feed.data.FeedDataLoadedCallbacks;
import com.facebook.feed.util.ConnectivityChangedCallback;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Inject;

/* compiled from: privacy_editing */
public class ErrorViewController<Dispatcher extends Callback> extends BaseController implements ViewCreatedDestroyedCallbacks, FeedDataLoadedCallbacks, ConnectivityChangedCallback {
    public final FbNetworkManager f9911a;
    public View f9912b;
    public View f9913c;
    public View f9914d;
    public Dispatcher f9915e;

    @ControllerCallback
    /* compiled from: privacy_editing */
    public interface Callback {
        void au();
    }

    public static ErrorViewController m14944a(InjectorLike injectorLike) {
        return new ErrorViewController(FbNetworkManager.m3811a(injectorLike));
    }

    @Inject
    public ErrorViewController(FbNetworkManager fbNetworkManager) {
        this.f9911a = fbNetworkManager;
    }

    public final void mo1886a(View view) {
        this.f9913c = view;
    }

    public final void kG_() {
        if (this.f9912b != null) {
            this.f9914d.setOnClickListener(null);
            this.f9914d = null;
            this.f9912b = null;
            this.f9913c = null;
        }
    }

    public final void mo1900b(boolean z) {
        if (z && this.f9912b != null) {
            this.f9912b.setVisibility(8);
        }
    }
}
