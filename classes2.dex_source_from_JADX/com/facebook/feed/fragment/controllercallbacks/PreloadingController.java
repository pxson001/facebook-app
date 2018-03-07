package com.facebook.feed.fragment.controllercallbacks;

import android.content.res.Configuration;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.fragment.ConfigurationChangedCallback;
import com.facebook.controllercallbacks.fragment.FragmentCreateDestroyCallbacks;
import com.facebook.controllercallbacks.fragment.ResumePauseCallbacks;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.adapter.api.HasMultiRow;
import com.facebook.feed.rows.controllercallbacks.AdapterCreatedCallback;
import com.facebook.feed.ui.feedprefetch.VideoPrepareViewPreloaderProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Inject;
import com.facebook.video.abtest.VideoExoplayerConfig;
import com.facebook.video.server.VideoPrefetchModelMethodAutoProvider;
import com.facebook.video.server.prefetcher.VideoPrefetchList;
import com.facebook.video.server.prefetcher.VideoPrefetchModel;
import com.facebook.widget.listview.BasicAdapter;
import com.facebook.widget.listview.ListViewPreloader;
import com.facebook.widget.listview.ScrollingViewProxy;

/* compiled from: place_tips */
public class PreloadingController extends BaseController implements ConfigurationChangedCallback, FragmentCreateDestroyCallbacks, ResumePauseCallbacks, AdapterCreatedCallback {
    public final VideoExoplayerConfig f9783a;
    public final VideoPrepareViewPreloaderProvider f9784b;
    public final VideoPrefetchModel f9785c;
    private ListViewPreloader f9786d;
    private ListViewPreloader f9787e;
    public VideoPrefetchList f9788f;

    public static PreloadingController m14802a(InjectorLike injectorLike) {
        return new PreloadingController(VideoExoplayerConfig.m11519b(injectorLike), (VideoPrepareViewPreloaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoPrepareViewPreloaderProvider.class), VideoPrefetchModelMethodAutoProvider.m14810a(injectorLike));
    }

    @Inject
    public PreloadingController(VideoExoplayerConfig videoExoplayerConfig, VideoPrepareViewPreloaderProvider videoPrepareViewPreloaderProvider, VideoPrefetchModel videoPrefetchModel) {
        this.f9783a = videoExoplayerConfig;
        this.f9784b = videoPrepareViewPreloaderProvider;
        this.f9785c = videoPrefetchModel;
    }

    public final void mo1889a(HasMultiRow hasMultiRow, ScrollingViewProxy scrollingViewProxy, FeedEnvironment feedEnvironment) {
        BasicAdapter basicAdapter = (BasicAdapter) hasMultiRow;
        if (this.f9783a.f6935v || this.f9783a.f6936w) {
            this.f9786d = this.f9784b.m14809a(scrollingViewProxy, basicAdapter);
        }
    }

    public final void mo1264c() {
        this.f9788f.mo2174a(true);
    }

    public final void mo1947a(Configuration configuration) {
    }

    public final void mo1265d() {
        this.f9788f.mo2174a(false);
    }

    public final void kF_() {
        if (this.f9786d != null) {
            this.f9786d.m20186a();
            this.f9786d = null;
        }
        if (this.f9787e != null) {
            this.f9787e.m20186a();
            this.f9787e = null;
        }
    }

    public final void mo1949b() {
        this.f9788f.mo2177b();
        this.f9788f = null;
    }
}
