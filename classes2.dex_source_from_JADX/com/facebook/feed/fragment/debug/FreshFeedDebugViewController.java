package com.facebook.feed.fragment.debug;

import android.content.Context;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.base.fragment.FbFragment;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.api.Holder;
import com.facebook.controllercallbacks.fragment.ResumePauseCallbacks;
import com.facebook.debug.pref.DebugLoggingPrefKeys;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.freshfeed.FreshFeedStoryCollectionStatus;
import com.facebook.feed.rows.adapter.api.HasMultiRow;
import com.facebook.feed.rows.controllercallbacks.AdapterCreatedCallback;
import com.facebook.feed.ui.NewsFeedRecyclerViewAdapterWrapper;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.ultralight.Inject;
import com.facebook.widget.listview.ScrollingViewProxy;
import java.util.Timer;

/* compiled from: platform_add_pending_media_upload */
public class FreshFeedDebugViewController extends BaseController implements ResumePauseCallbacks, AdapterCreatedCallback {
    public final FbSharedPreferences f9735a;
    public final FreshFeedStoryCollectionStatus f9736b;
    public Holder<FbFragment> f9737c;
    public Timer f9738d;
    public FreshFeedView f9739e;
    public ScrollingViewProxy f9740f;
    public NewsFeedRecyclerViewAdapterWrapper f9741g;
    private boolean f9742h = false;

    public static FreshFeedDebugViewController m14746b(InjectorLike injectorLike) {
        return new FreshFeedDebugViewController(FbSharedPreferencesImpl.m1826a(injectorLike));
    }

    public static FreshFeedDebugViewController m14743a(InjectorLike injectorLike) {
        return m14746b(injectorLike);
    }

    @Inject
    private FreshFeedDebugViewController(FbSharedPreferences fbSharedPreferences) {
        this.f9735a = fbSharedPreferences;
        this.f9736b = FreshFeedStoryCollectionStatus.f5862a;
    }

    public final void mo1265d() {
        if (this.f9742h) {
            this.f9742h = false;
            this.f9738d.cancel();
            this.f9738d = null;
            this.f9736b.f5866e = false;
        }
    }

    public final void mo1264c() {
        Context ao = ((FbFragment) this.f9737c.f10429a).ao();
        if (this.f9739e == null && this.f9735a.mo286a(DebugLoggingPrefKeys.f2811i, false)) {
            this.f9739e = new FreshFeedView(ao);
            ao.getWindow().addContentView(this.f9739e, new LayoutParams(700, 30, 5));
        }
        if (!this.f9742h && this.f9739e != null) {
            this.f9742h = true;
            this.f9736b.f5866e = true;
            this.f9738d = new Timer();
            this.f9738d.scheduleAtFixedRate(new 1(this), 0, 1000);
        }
    }

    public final void mo1889a(HasMultiRow hasMultiRow, ScrollingViewProxy scrollingViewProxy, FeedEnvironment feedEnvironment) {
        this.f9740f = scrollingViewProxy;
        this.f9741g = (NewsFeedRecyclerViewAdapterWrapper) hasMultiRow;
    }

    public final void kF_() {
        this.f9740f = null;
        this.f9741g = null;
    }

    private void m14744a(int i, int i2, int i3, int i4, int i5) {
        this.f9739e.post(new 2(this, i, i2, i3, i4, i5));
    }
}
