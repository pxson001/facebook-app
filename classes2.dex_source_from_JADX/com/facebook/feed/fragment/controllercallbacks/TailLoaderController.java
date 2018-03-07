package com.facebook.feed.fragment.controllercallbacks;

import android.content.Context;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.api.ControllerCallback;
import com.facebook.feed.data.FeedDataLoadedCallbacks;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorAdapter;
import com.google.common.annotations.VisibleForTesting;

/* compiled from: privacy_changed */
public class TailLoaderController<Dispatcher extends Callback> extends BaseController implements FeedDataLoadedCallbacks {
    @VisibleForTesting
    public LoadingIndicatorAdapter f10385a = new LoadingIndicatorAdapter(2130904313);
    public final RetryClickedListener f10386b = new C04421(this);
    public Dispatcher f10387c;
    public Context f10388d;

    @ControllerCallback
    /* compiled from: privacy_changed */
    public interface Callback {
        void aw();
    }

    /* compiled from: privacy_changed */
    class C04421 implements RetryClickedListener {
        final /* synthetic */ TailLoaderController f10389a;

        C04421(TailLoaderController tailLoaderController) {
            this.f10389a = tailLoaderController;
        }

        public final void mo1996a() {
            this.f10389a.f10387c.aw();
        }
    }

    public static TailLoaderController m15476a(InjectorLike injectorLike) {
        return new TailLoaderController();
    }

    public final FbBaseAdapter m15477c() {
        return this.f10385a;
    }
}
