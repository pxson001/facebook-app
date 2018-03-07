package com.facebook.feed.inlinecomposer.multirow.common;

import android.content.Context;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.util.composer.launch.FeedComposerLauncher$ComposerConfigCustomizer;
import com.facebook.feed.util.composer.launch.FeedComposerLauncher$LauncherContext;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.productionprompts.manager.PromptViewStateUpdater;

/* compiled from: percent_time_gc */
public class InlineComposerEnvironmentProvider extends AbstractAssistedProvider<InlineComposerEnvironment> {
    public static InlineComposerEnvironment m15306a(Runnable runnable, FeedComposerLauncher$LauncherContext feedComposerLauncher$LauncherContext, FeedComposerLauncher$ComposerConfigCustomizer feedComposerLauncher$ComposerConfigCustomizer, FeedComposerLauncher$LauncherContext feedComposerLauncher$LauncherContext2, Context context, Delegate delegate, PromptViewStateUpdater promptViewStateUpdater) {
        return new InlineComposerEnvironment(runnable, feedComposerLauncher$LauncherContext, feedComposerLauncher$ComposerConfigCustomizer, feedComposerLauncher$LauncherContext2, context, delegate, promptViewStateUpdater);
    }
}
