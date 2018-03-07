package com.facebook.feed.fragment.controllercallbacks;

import android.support.v4.util.SimpleArrayMap;
import com.facebook.common.viewport.ViewportEventListener;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.fragment.OnUserVisibleHintCallback;
import com.facebook.controllercallbacks.fragment.ResumePauseCallbacks;
import com.facebook.feed.logging.viewport.FeedLoggingViewportEventListener;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Inject;
import com.facebook.widget.listview.ScrollingViewProxy;
import javax.annotation.Nullable;

/* compiled from: photo_reminders/ */
public class FeedLoggingViewportController extends BaseController implements ViewportEventListener, OnUserVisibleHintCallback, ResumePauseCallbacks {
    @Inject
    public FeedLoggingViewportEventListener f10035a;
    public String f10036b;

    public static FeedLoggingViewportController m15085b(InjectorLike injectorLike) {
        FeedLoggingViewportController feedLoggingViewportController = new FeedLoggingViewportController();
        feedLoggingViewportController.f10035a = FeedLoggingViewportEventListener.m15105a(injectorLike);
        return feedLoggingViewportController;
    }

    public final void mo1948a(boolean z) {
        if (z) {
            this.f10035a.m15114a(this.f10036b);
        }
    }

    public static FeedLoggingViewportController m15084a(InjectorLike injectorLike) {
        return m15085b(injectorLike);
    }

    public final void mo1264c() {
        this.f10035a.m15114a(this.f10036b);
    }

    public final void mo1265d() {
    }

    public final void mo1968a(ScrollingViewProxy scrollingViewProxy, Object obj, int i) {
        this.f10035a.mo1968a(scrollingViewProxy, obj, i);
    }

    public final void mo1970a(Object obj) {
        this.f10035a.mo1970a(obj);
    }

    public final void mo1969a(ScrollingViewProxy scrollingViewProxy, @Nullable Object obj, int i, int i2) {
        this.f10035a.mo1969a(scrollingViewProxy, obj, i, i2);
    }

    public final void mo1973b(Object obj) {
        this.f10035a.mo1973b(obj);
    }

    public final void mo1972b(ScrollingViewProxy scrollingViewProxy, @Nullable Object obj, int i) {
        this.f10035a.mo1972b(scrollingViewProxy, obj, i);
    }

    public final void mo1967a(ScrollingViewProxy scrollingViewProxy) {
        this.f10035a.mo1967a(scrollingViewProxy);
    }

    public final void mo1971b(ScrollingViewProxy scrollingViewProxy) {
        this.f10035a.mo1971b(scrollingViewProxy);
    }

    public final void mo1966a(SimpleArrayMap<Object, Object> simpleArrayMap) {
        this.f10035a.mo1966a((SimpleArrayMap) simpleArrayMap);
    }
}
