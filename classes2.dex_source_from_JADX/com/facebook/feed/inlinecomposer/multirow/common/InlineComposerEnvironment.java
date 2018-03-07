package com.facebook.feed.inlinecomposer.multirow.common;

import android.content.Context;
import com.facebook.feed.environment.impl.BaseFeedEnvironment;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.inlinecomposer.multirow.InlineComposerExposedTopGetterPartDefinition.SettableTopGetter;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.RowKey;
import com.facebook.feed.rows.core.parts.EnvironmentController;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.util.composer.launch.FeedComposerLauncher$ComposerConfigCustomizer;
import com.facebook.feed.util.composer.launch.FeedComposerLauncher$LauncherContext;
import com.facebook.inject.Assisted;
import com.facebook.ipc.productionprompts.manager.PromptViewStateUpdater;
import com.facebook.ipc.productionprompts.manager.PromptViewStateUpdater.TapSource;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: neko_android_screenshot_logging */
public class InlineComposerEnvironment extends BaseFeedEnvironment implements PromptViewStateUpdater, AnyEnvironment {
    private final Controller f12847m = new Controller();
    public final FeedComposerLauncher$ComposerConfigCustomizer f12848n;
    private final FeedComposerLauncher$LauncherContext f12849o;
    private final FeedComposerLauncher$LauncherContext f12850p;
    @Nullable
    private final PromptViewStateUpdater f12851q;
    @Nullable
    public SettableTopGetter f12852r;
    public boolean f12853s;
    public boolean f12854t;

    /* compiled from: neko_android_screenshot_logging */
    class Controller implements EnvironmentController<InlineComposerEnvironment> {
        public final /* bridge */ /* synthetic */ void mo2462a(AnyEnvironment anyEnvironment) {
        }

        public final void mo2463a(AnyEnvironment anyEnvironment, @Nullable MultiRowSinglePartDefinition multiRowSinglePartDefinition, @Nullable MultiRowSinglePartDefinition multiRowSinglePartDefinition2, @Nullable MultiRowSinglePartDefinition multiRowSinglePartDefinition3, @Nullable Object obj, @Nullable Object obj2, @Nullable RowKey rowKey, boolean z) {
            boolean z2;
            InlineComposerEnvironment inlineComposerEnvironment = (InlineComposerEnvironment) anyEnvironment;
            boolean z3 = true;
            if (multiRowSinglePartDefinition != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            inlineComposerEnvironment.f12854t = z2;
            if (multiRowSinglePartDefinition3 == null) {
                z3 = false;
            }
            inlineComposerEnvironment.f12853s = z3;
        }
    }

    public final FeedListType mo2446c() {
        return InlineComposerFeedListType.f12927a;
    }

    @Inject
    public InlineComposerEnvironment(@Nullable @Assisted Runnable runnable, @Assisted FeedComposerLauncher$LauncherContext feedComposerLauncher$LauncherContext, @Assisted FeedComposerLauncher$ComposerConfigCustomizer feedComposerLauncher$ComposerConfigCustomizer, @Assisted FeedComposerLauncher$LauncherContext feedComposerLauncher$LauncherContext2, @Assisted Context context, @Assisted Delegate delegate, @Nullable @Assisted PromptViewStateUpdater promptViewStateUpdater) {
        super(context, runnable, delegate);
        this.f12849o = feedComposerLauncher$LauncherContext;
        this.f12848n = feedComposerLauncher$ComposerConfigCustomizer;
        this.f12850p = feedComposerLauncher$LauncherContext2;
        this.f12851q = promptViewStateUpdater;
    }

    public final EnvironmentController mo2441b() {
        return this.f12847m;
    }

    public final BaseFeedStoryMenuHelper mo2448e() {
        return null;
    }

    public final FeedComposerLauncher$LauncherContext m18900a(boolean z) {
        return z ? this.f12850p : this.f12849o;
    }

    public final void mo2486a(InlineComposerPromptSession inlineComposerPromptSession, TapSource tapSource) {
        if (this.f12851q != null) {
            this.f12851q.mo2486a(inlineComposerPromptSession, tapSource);
        }
    }

    public final void mo2487b(InlineComposerPromptSession inlineComposerPromptSession, TapSource tapSource) {
        if (this.f12851q != null) {
            this.f12851q.mo2487b(inlineComposerPromptSession, tapSource);
        }
    }
}
