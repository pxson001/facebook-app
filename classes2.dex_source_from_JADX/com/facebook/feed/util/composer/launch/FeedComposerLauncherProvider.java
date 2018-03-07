package com.facebook.feed.util.composer.launch;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.NavigationLogger;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.JsonPluginConfigSerializer;
import com.facebook.ipc.composer.launch.ComposerIntentLauncher;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: pages_messaging */
public class FeedComposerLauncherProvider extends AbstractAssistedProvider<FeedComposerLauncher> {
    public final FeedComposerLauncher m15515a(FeedComposerLauncher$LauncherContext feedComposerLauncher$LauncherContext, FeedComposerLauncher$ComposerConfigCustomizer feedComposerLauncher$ComposerConfigCustomizer) {
        return new FeedComposerLauncher(AnalyticsLoggerMethodAutoProvider.m3509a(this), ComposerIntentLauncher.m19715b((InjectorLike) this), NavigationLogger.m5475a((InjectorLike) this), IdBasedSingletonScopeProvider.m1810b(this, 2997), IdBasedProvider.m1811a(this, 9527), IdBasedSingletonScopeProvider.m1810b(this, 968), ComposerLauncherImpl.m14892a(this), QeInternalImplMethodAutoProvider.m3744a(this), JsonPluginConfigSerializer.m18629b(this), feedComposerLauncher$LauncherContext, feedComposerLauncher$ComposerConfigCustomizer);
    }
}
