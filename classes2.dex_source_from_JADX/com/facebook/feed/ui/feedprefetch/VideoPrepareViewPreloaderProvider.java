package com.facebook.feed.ui.feedprefetch;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.abtest.VideoExoplayerConfig;
import com.facebook.video.engine.NativePlayerPool;
import com.facebook.video.engine.VideoPlayerManager;
import com.facebook.widget.listview.BasicAdapter;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.throttling.ThrottledOnScrollListenerFactory;

/* compiled from: place_star_survey */
public class VideoPrepareViewPreloaderProvider extends AbstractAssistedProvider<VideoPrepareViewPreloader> {
    public final VideoPrepareViewPreloader m14809a(ScrollingViewProxy scrollingViewProxy, BasicAdapter basicAdapter) {
        return new VideoPrepareViewPreloader(scrollingViewProxy, basicAdapter, NativePlayerPool.m20190a((InjectorLike) this), DefaultAndroidThreadUtil.m1646b((InjectorLike) this), VideoPlayerManager.m13903a((InjectorLike) this), QeInternalImplMethodAutoProvider.m3744a(this), ThrottledOnScrollListenerFactory.m14478a(this), VideoExoplayerConfig.m11519b(this));
    }
}
