package com.facebook.feed.ui.fullscreenvideoplayer.commentwithvideo;

import android.app.Activity;
import android.content.Context;
import com.facebook.base.activity.FbRootViewUtil;
import com.facebook.base.fragment.FragmentManagerHost;
import com.facebook.common.util.ContextUtils;
import com.facebook.ufiservices.flyout.FeedbackParams;
import com.facebook.ufiservices.flyout.FeedbackParams.Builder;
import com.google.common.base.Preconditions;

/* compiled from: TimelineLoadHeader */
public class VideoFeedbackPopoverLauncher {
    public static VideoFeedbackFragment m24595a(Context context, VideoFeedbackParams videoFeedbackParams) {
        String str = videoFeedbackParams.f21973a;
        Builder builder = new Builder();
        builder.d = str;
        FeedbackParams a = builder.a();
        VideoFeedbackFragment videoFeedbackFragment = new VideoFeedbackFragment();
        videoFeedbackFragment.g(a.v());
        VideoFeedbackFragment videoFeedbackFragment2 = videoFeedbackFragment;
        videoFeedbackFragment2.aK = videoFeedbackParams;
        FragmentManagerHost fragmentManagerHost = (FragmentManagerHost) ContextUtils.a(context, FragmentManagerHost.class);
        Activity activity = (Activity) ContextUtils.a(context, Activity.class);
        Preconditions.checkNotNull(fragmentManagerHost);
        Preconditions.checkNotNull(activity);
        VideoFeedbackPopoverFragment videoFeedbackPopoverFragment = new VideoFeedbackPopoverFragment();
        videoFeedbackPopoverFragment.ap = videoFeedbackFragment2;
        videoFeedbackPopoverFragment.a(fragmentManagerHost.kO_(), activity.getWindow(), FbRootViewUtil.a(context));
        videoFeedbackPopoverFragment.am = videoFeedbackFragment2;
        return videoFeedbackFragment2;
    }
}
