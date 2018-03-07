package com.facebook.feed.fragment.controllercallbacks;

import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.fragment.ResumePauseCallbacks;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.adapter.api.HasMultiRow;
import com.facebook.feed.rows.controllercallbacks.AdapterCreatedCallback;
import com.facebook.feed.rows.prefetch.MultiRowImagePrefetcherWrapper;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.listview.controllercallbacks.ScrollCallback;

/* compiled from: omnistore_subscribe_collection */
public class ImagePrefetcherController extends BaseController implements ResumePauseCallbacks, AdapterCreatedCallback, ScrollCallback {
    private final MultiRowImagePrefetcherWrapper f11203a;
    private final OnScrollListener f11204b;
    private ScrollingViewProxy f11205c;
    private boolean f11206d;

    public ImagePrefetcherController(MultiRowImagePrefetcherWrapper multiRowImagePrefetcherWrapper) {
        this.f11203a = multiRowImagePrefetcherWrapper;
        this.f11204b = multiRowImagePrefetcherWrapper.mo1998a();
    }

    public final void mo1889a(HasMultiRow hasMultiRow, ScrollingViewProxy scrollingViewProxy, FeedEnvironment feedEnvironment) {
        this.f11205c = scrollingViewProxy;
        this.f11203a.mo1999a(hasMultiRow.mo2513f());
    }

    public final void kF_() {
        this.f11205c = null;
    }

    public final void mo1264c() {
        this.f11203a.mo2001a(this.f11205c);
        this.f11206d = true;
    }

    public final void mo1265d() {
        this.f11203a.mo2002b();
        this.f11206d = false;
    }

    public final void mo1262a(ScrollingViewProxy scrollingViewProxy, int i) {
        if (this.f11206d) {
            this.f11204b.mo1262a(scrollingViewProxy, i);
        }
    }

    public final void mo1263a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
        if (this.f11206d) {
            this.f11204b.mo1263a(scrollingViewProxy, i, i2, i3);
        }
    }
}
