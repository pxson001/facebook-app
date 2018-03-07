package com.facebook.video.watchandbrowse;

import android.app.Activity;
import android.view.ViewGroup;
import com.facebook.base.activity.FbRootViewUtil;
import com.facebook.feed.video.ImmersiveVideoPlayer;
import com.facebook.inject.InjectorLike;

/* compiled from: should_support_tricky_bin */
public class VideoWatchAndBrowseInflator {
    public VideoWatchAndBrowseRootView f3377a;

    public static VideoWatchAndBrowseInflator m3211a(InjectorLike injectorLike) {
        return new VideoWatchAndBrowseInflator();
    }

    public final ImmersiveVideoPlayer m3212a(Activity activity) {
        if (this.f3377a == null) {
            ViewGroup viewGroup = (ViewGroup) FbRootViewUtil.a(activity);
            this.f3377a = new VideoWatchAndBrowseRootView(activity);
            this.f3377a.f3409h = viewGroup;
        }
        return this.f3377a;
    }
}
