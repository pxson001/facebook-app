package com.facebook.feed.util.composer.launch;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.composer.minutiae.music.MusicMetadataHelper;
import com.facebook.feed.util.composer.sprout.SproutAnalyticsLogger.SproutSource;
import com.facebook.feed.util.composer.sprout.SproutAnalyticsLoggerProvider;
import com.facebook.feed.util.composer.sprout.header.InlineComposerHeaderControllerProvider;
import com.facebook.friendsharing.listeningto.nux.ListeningToNuxController;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.platformattribution.PlatformAttributionLaunchHelper;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: ms */
public class SproutLauncherProvider extends AbstractAssistedProvider<SproutLauncher> {
    public final SproutLauncher m19488a(SproutSource sproutSource, FeedComposerLauncher feedComposerLauncher, FragmentManager fragmentManager, Activity activity) {
        return new SproutLauncher(QeInternalImplMethodAutoProvider.m3744a(this), ResourcesMethodAutoProvider.m6510a(this), PlatformAttributionLaunchHelper.a(this), MusicMetadataHelper.b(this), (SproutAnalyticsLoggerProvider) getOnDemandAssistedProviderForStaticDi(SproutAnalyticsLoggerProvider.class), ListeningToNuxController.b(this), (InlineComposerHeaderControllerProvider) getOnDemandAssistedProviderForStaticDi(InlineComposerHeaderControllerProvider.class), IdBasedLazy.m1808a(this, 5199), sproutSource, feedComposerLauncher, fragmentManager, activity);
    }
}
