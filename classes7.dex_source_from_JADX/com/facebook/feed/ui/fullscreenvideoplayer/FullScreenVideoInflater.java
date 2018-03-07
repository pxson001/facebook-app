package com.facebook.feed.ui.fullscreenvideoplayer;

import android.app.Activity;
import android.view.ViewGroup;
import com.facebook.base.activity.FbRootViewUtil;
import com.facebook.feed.video.ImmersiveVideoPlayer;
import com.facebook.inject.InjectorLike;

/* compiled from: Today */
public class FullScreenVideoInflater {
    public FeedFullScreenVideoPlayer f21942a;

    public static FullScreenVideoInflater m24541a(InjectorLike injectorLike) {
        return new FullScreenVideoInflater();
    }

    public final ImmersiveVideoPlayer m24542a(Activity activity) {
        if (this.f21942a == null) {
            ViewGroup viewGroup = (ViewGroup) FbRootViewUtil.a(activity);
            this.f21942a = (FeedFullScreenVideoPlayer) activity.getLayoutInflater().inflate(2130904547, viewGroup, false);
            this.f21942a.f21899G = viewGroup;
        }
        return this.f21942a;
    }
}
