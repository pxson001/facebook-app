package com.facebook.feed.ui.feedprefetch;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.abtest.VideoLivePlaybackConfig;
import com.facebook.video.abtest.VideoPrefetchExperimentHelper;
import com.facebook.video.exoserviceclient.ExoServiceClientMethodAutoProvider;
import com.facebook.video.server.DashVideoPrefetchParserMethodAutoProvider;
import com.facebook.video.server.prefetcher.VideoPrefetchLocation;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;

/* compiled from: offers/detail/view/?offer_view_id=%s&share_id=%s&redirect=%s */
public class VideoPrefetchVisitorProvider extends AbstractAssistedProvider<VideoPrefetchVisitor> {
    public final VideoPrefetchVisitor m16878a(VideoPrefetchLocation videoPrefetchLocation, CallerContext callerContext) {
        return new VideoPrefetchVisitor(videoPrefetchLocation, callerContext, IdBasedSingletonScopeProvider.m1809a(this, 3697), DashVideoPrefetchParserMethodAutoProvider.m26758a(this), Handler_ForNonUiThreadMethodAutoProvider.m5523b(this), FbErrorReporterImpl.m2317a((InjectorLike) this), VideoAutoPlaySettingsChecker.m26868a((InjectorLike) this), VideoPrefetchExperimentHelper.m16698a(this), QeInternalImplMethodAutoProvider.m3744a(this), ExoServiceClientMethodAutoProvider.m14000a(this), VideoLivePlaybackConfig.m14002a(this));
    }
}
