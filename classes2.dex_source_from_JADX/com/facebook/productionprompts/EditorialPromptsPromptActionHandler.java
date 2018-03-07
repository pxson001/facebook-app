package com.facebook.productionprompts;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.facebook.common.util.ContextUtils;
import com.facebook.feed.util.composer.launch.DefaultNewsfeedComposerConfigCustomizer;
import com.facebook.feed.util.composer.launch.FeedComposerLauncher;
import com.facebook.feed.util.composer.launch.FeedComposerLauncher$LauncherContext;
import com.facebook.feed.util.composer.launch.FeedComposerLauncherProvider;
import com.facebook.feed.util.composer.launch.NewsfeedLauncherContext;
import com.facebook.ipc.composer.intent.ComposerPluginConfig;
import com.facebook.ipc.composer.intent.JsonPluginConfigSerializer;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextImpl;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextInterfaces.HasComposerSessionId;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextInterfaces.HasPromptSessionId;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextInterfaces.TapOnV1SecondaryAction;
import com.facebook.ipc.productionprompts.actionhandler.PromptActionContext;
import com.facebook.ipc.productionprompts.actionhandler.PromptActionHandler;
import com.facebook.productionprompts.composer.ProductionPromptsPluginConfig;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.ProductionPrompt;
import com.facebook.productionprompts.model.ProductionPromptObject;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: module */
public class EditorialPromptsPromptActionHandler<CONTEXT extends PromptActionContext & HasPromptSessionId & HasComposerSessionId & TapOnV1SecondaryAction> implements PromptActionHandler<CONTEXT> {
    private static final FeedComposerLauncher$LauncherContext f13363a = new NewsfeedLauncherContext("editorialPrompts");
    private final FeedComposerLauncherProvider f13364b;
    private final JsonPluginConfigSerializer<ProductionPromptsPluginConfig> f13365c;

    @Inject
    public EditorialPromptsPromptActionHandler(FeedComposerLauncherProvider feedComposerLauncherProvider, JsonPluginConfigSerializer jsonPluginConfigSerializer) {
        this.f13364b = feedComposerLauncherProvider;
        this.f13365c = jsonPluginConfigSerializer;
    }

    public final boolean mo2621b(InlineComposerPromptSession inlineComposerPromptSession) {
        return true;
    }

    public final void mo2620a(View view, InlineComposerPromptSession inlineComposerPromptSession, CONTEXT context) {
        if (((PromptActionContextImpl) context).e()) {
            m19687c(view, inlineComposerPromptSession, context);
        } else {
            m19686b(view, inlineComposerPromptSession, context);
        }
    }

    public final void mo2622a(@Nullable ComposerPluginConfig composerPluginConfig, InlineComposerPromptSession inlineComposerPromptSession) {
    }

    private void m19686b(View view, InlineComposerPromptSession inlineComposerPromptSession, CONTEXT context) {
        Preconditions.checkArgument(((PromptActionContextImpl) context).j.isPresent());
        Preconditions.checkArgument(inlineComposerPromptSession.f13409a instanceof ProductionPromptObject);
        ProductionPrompt productionPrompt = ((ProductionPromptObject) InlineComposerPromptSession.m19774a(inlineComposerPromptSession)).f12765a;
        1 1 = new 1(this, productionPrompt);
        m19685a(view.getContext(), this.f13364b.m15515a(f13363a, 1), PromptAnalytics.a(inlineComposerPromptSession.f13409a.mo2493b(), inlineComposerPromptSession.f13409a.mo2494c(), ((PromptActionContextImpl) context).a, (String) ((PromptActionContextImpl) context).j.orNull(), inlineComposerPromptSession.f13410b.f15098b, inlineComposerPromptSession.f13411c.a.getName()), productionPrompt, true);
    }

    private void m19687c(View view, InlineComposerPromptSession inlineComposerPromptSession, CONTEXT context) {
        Preconditions.checkArgument(((PromptActionContextImpl) context).j.isPresent());
        Preconditions.checkArgument(inlineComposerPromptSession.f13409a instanceof ProductionPromptObject);
        ProductionPrompt productionPrompt = ((ProductionPromptObject) InlineComposerPromptSession.m19774a(inlineComposerPromptSession)).f12765a;
        m19685a(view.getContext(), this.f13364b.m15515a(f13363a, new DefaultNewsfeedComposerConfigCustomizer()), PromptAnalytics.a(inlineComposerPromptSession.f13409a.mo2493b(), inlineComposerPromptSession.f13409a.mo2494c(), ((PromptActionContextImpl) context).a, (String) ((PromptActionContextImpl) context).j.orNull(), inlineComposerPromptSession.f13410b.f15098b, inlineComposerPromptSession.f13411c.a.getName()), productionPrompt, false);
    }

    private void m19685a(Context context, FeedComposerLauncher feedComposerLauncher, PromptAnalytics promptAnalytics, ProductionPrompt productionPrompt, boolean z) {
        feedComposerLauncher.a(Optional.fromNullable(promptAnalytics.composerSessionId), ProductionPromptsPluginConfig.a(productionPrompt, promptAnalytics, z), this.f13365c, (Activity) ContextUtils.m2500a(context, Activity.class));
    }
}
