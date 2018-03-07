package com.facebook.video.videohome.views;

import android.app.Activity;
import com.facebook.feed.util.composer.launch.FeedComposerLauncherProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.videohome.logging.VideoHomeLoggingUtils;

/* compiled from: show_pin_nux */
public class VideoHomeComposerOnClickListenerProvider extends AbstractAssistedProvider<VideoHomeComposerOnClickListener> {
    public final VideoHomeComposerOnClickListener m3173a(Activity activity) {
        return new VideoHomeComposerOnClickListener(activity, (FeedComposerLauncherProvider) getOnDemandAssistedProviderForStaticDi(FeedComposerLauncherProvider.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), VideoHomeLoggingUtils.a(this));
    }
}
