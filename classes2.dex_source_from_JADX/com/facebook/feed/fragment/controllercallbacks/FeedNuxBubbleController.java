package com.facebook.feed.fragment.controllercallbacks;

import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.fragment.ConfigurationChangedCallback;
import com.facebook.controllercallbacks.fragment.OnUserVisibleHintCallback;
import com.facebook.controllercallbacks.fragment.ViewCreatedDestroyedCallbacks;
import com.facebook.feed.nux.FeedNuxBubbleManager;
import com.facebook.feed.nux.FeedNuxBubbleManager.BlockingCause;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.controllercallbacks.ScrollCallback;
import javax.inject.Inject;

/* compiled from: placetips_android_serp_devonly */
public class FeedNuxBubbleController extends BaseController implements ConfigurationChangedCallback, OnUserVisibleHintCallback, ViewCreatedDestroyedCallbacks, ScrollCallback {
    public final FeedNuxBubbleManager f9751a;
    private ViewGroup f9752b;

    public static FeedNuxBubbleController m14757a(InjectorLike injectorLike) {
        return new FeedNuxBubbleController(FeedNuxBubbleManager.m14765a(injectorLike));
    }

    @Inject
    public FeedNuxBubbleController(FeedNuxBubbleManager feedNuxBubbleManager) {
        this.f9751a = feedNuxBubbleManager;
    }

    public final void mo1947a(Configuration configuration) {
        this.f9751a.m14782a(false);
    }

    public final void mo1948a(boolean z) {
        if (z) {
            this.f9751a.m14779a(this.f9752b, new InterstitialTrigger(Action.FEED_STORY_LOADED));
        }
    }

    public final void mo1886a(View view) {
        this.f9751a.m14779a(this.f9752b, new InterstitialTrigger(Action.FEED_STORY_LOADED));
    }

    public final void kG_() {
        this.f9751a.m14778a(this.f9752b);
    }

    public final void mo1262a(ScrollingViewProxy scrollingViewProxy, int i) {
        if (i == 0) {
            this.f9751a.m14784b(BlockingCause.IS_SCROLLING);
        } else {
            this.f9751a.m14780a(BlockingCause.IS_SCROLLING);
        }
    }

    public final void mo1263a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
        this.f9751a.m14783b();
    }
}
