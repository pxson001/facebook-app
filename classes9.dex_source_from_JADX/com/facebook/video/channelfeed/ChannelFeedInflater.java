package com.facebook.video.channelfeed;

import android.app.Activity;
import android.view.ViewGroup;
import com.facebook.base.activity.FbRootViewUtil;
import com.facebook.feed.video.ImmersiveVideoPlayer;
import com.facebook.inject.InjectorLike;

/* compiled from: t_%s/pin */
public class ChannelFeedInflater {
    private ChannelFeedRootView f2349a;

    public static ChannelFeedInflater m2306a(InjectorLike injectorLike) {
        return new ChannelFeedInflater();
    }

    public final ImmersiveVideoPlayer m2307a(Activity activity) {
        if (this.f2349a == null) {
            ViewGroup viewGroup = (ViewGroup) FbRootViewUtil.a(activity);
            this.f2349a = new ChannelFeedRootView(activity);
            this.f2349a.af = viewGroup;
        }
        return this.f2349a;
    }

    public final void m2308a() {
        this.f2349a = null;
    }
}
