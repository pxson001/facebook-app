package com.facebook.feed.autoplay;

import android.view.View;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: is_pymm_hidden */
public class VideoDisplayedCoordinatorProvider extends AbstractAssistedProvider<VideoDisplayedCoordinator> {
    public final <V extends View> VideoDisplayedCoordinator<V> m26579a(VideoDisplayedSelector videoDisplayedSelector, boolean z) {
        return new VideoDisplayedCoordinator(videoDisplayedSelector, z, VideoAutoplayVisibilityDecider.m26575a((InjectorLike) this), Handler_ForUiThreadMethodAutoProvider.m1701b(this), QeInternalImplMethodAutoProvider.m3744a(this), GatekeeperStoreImplMethodAutoProvider.m2131a(this), FeedAutoplayActivityListener.m13076a(this));
    }
}
