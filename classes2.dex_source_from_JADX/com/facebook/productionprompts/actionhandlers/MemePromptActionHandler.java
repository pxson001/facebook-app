package com.facebook.productionprompts.actionhandlers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.facebook.common.util.ContextUtils;
import com.facebook.friendsharing.meme.activity.MemePickerActivity;
import com.facebook.friendsharing.meme.activity.MemePickerAnalyticsLogger;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerPluginConfig;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.intent.JsonPluginConfigSerializer;
import com.facebook.ipc.composer.launch.ComposerIntentLauncher;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextImpl;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextInterfaces.HasComposerSessionId;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextInterfaces.HasPromptSessionId;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextInterfaces.HasSelectedMemeUrl;
import com.facebook.ipc.productionprompts.actionhandler.PromptActionContext;
import com.facebook.ipc.productionprompts.actionhandler.PromptActionHandler;
import com.facebook.productionprompts.composer.ProductionPromptComposerUtil;
import com.facebook.productionprompts.composer.ProductionPromptsPluginConfig;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.ProductionPrompt;
import com.facebook.productionprompts.model.ProductionPromptObject;
import com.facebook.productionprompts.model.PromptObject;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mobile_zero_show_use_data_or_stay_free_screen */
public class MemePromptActionHandler<CONTEXT extends PromptActionContext & HasComposerSessionId & HasPromptSessionId & HasSelectedMemeUrl> implements PromptActionHandler<CONTEXT> {
    private final ComposerIntentLauncher f13376a;
    private final JsonPluginConfigSerializer f13377b;
    private final MemePickerAnalyticsLogger f13378c;

    @Inject
    public MemePromptActionHandler(ComposerIntentLauncher composerIntentLauncher, JsonPluginConfigSerializer jsonPluginConfigSerializer, MemePickerAnalyticsLogger memePickerAnalyticsLogger) {
        this.f13376a = composerIntentLauncher;
        this.f13377b = jsonPluginConfigSerializer;
        this.f13378c = memePickerAnalyticsLogger;
    }

    public final boolean mo2621b(InlineComposerPromptSession inlineComposerPromptSession) {
        return m19710a(inlineComposerPromptSession).r() != null;
    }

    public final void mo2620a(View view, InlineComposerPromptSession inlineComposerPromptSession, CONTEXT context) {
        Activity activity = (Activity) ContextUtils.m2500a(view.getContext(), Activity.class);
        String str = (String) ((PromptActionContextImpl) context).j.orNull();
        String str2 = str;
        Context context2 = activity;
        this.f13376a.m19716a(m19709a(str2, context2, PromptAnalytics.a(inlineComposerPromptSession.f13409a.mo2493b(), inlineComposerPromptSession.f13410b.f15099c, ((PromptActionContextImpl) context).a, (String) ((PromptActionContextImpl) context).j.orNull(), inlineComposerPromptSession.f13410b.f15098b, inlineComposerPromptSession.f13411c.a.getName()), inlineComposerPromptSession, ((PromptActionContextImpl) context).g), 1756, activity);
        this.f13378c.f13382a.mo526a(MemePickerAnalyticsLogger.m19718b("tap_meme_prompt", str));
    }

    public final void mo2622a(@Nullable ComposerPluginConfig composerPluginConfig, InlineComposerPromptSession inlineComposerPromptSession) {
    }

    private Intent m19709a(String str, Context context, PromptAnalytics promptAnalytics, InlineComposerPromptSession inlineComposerPromptSession, String str2) {
        ProductionPrompt a = m19710a(inlineComposerPromptSession);
        Builder useOptimisticPosting = ComposerConfigurationFactory.m26256a(ComposerSourceSurface.NEWSFEED, "memePrompt").setInitialTargetData(ComposerTargetData.a).setPluginConfig(this.f13377b.mo2485a(ProductionPromptsPluginConfig.a(a, promptAnalytics, true))).setUseOptimisticPosting(true);
        ProductionPromptComposerUtil.a(useOptimisticPosting, a);
        return MemePickerActivity.a(str, context, useOptimisticPosting.a(), a.r(), promptAnalytics, str2);
    }

    private static ProductionPrompt m19710a(InlineComposerPromptSession inlineComposerPromptSession) {
        PromptObject a = InlineComposerPromptSession.m19774a(inlineComposerPromptSession);
        Preconditions.checkArgument(a instanceof ProductionPromptObject);
        return ((ProductionPromptObject) a).f12765a;
    }
}
