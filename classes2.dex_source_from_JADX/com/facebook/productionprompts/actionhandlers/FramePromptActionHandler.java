package com.facebook.productionprompts.actionhandlers;

import android.app.Activity;
import android.view.View;
import com.facebook.common.util.ContextUtils;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerPluginConfig;
import com.facebook.ipc.composer.intent.JsonPluginConfigSerializer;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.creativecam.CreativeCamLaunchConfig;
import com.facebook.ipc.creativecam.CreativeCamLauncher;
import com.facebook.ipc.media.SupportedMediaType;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextImpl;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextInterfaces.HasComposerSessionId;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextInterfaces.HasPromptSessionId;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextInterfaces.HasSelectedFrameId;
import com.facebook.ipc.productionprompts.actionhandler.PromptActionContext;
import com.facebook.ipc.productionprompts.actionhandler.PromptActionHandler;
import com.facebook.photos.creativecam.activity.CreativeCamLauncherImpl;
import com.facebook.productionprompts.composer.ProductionPromptComposerUtil;
import com.facebook.productionprompts.composer.ProductionPromptsPluginConfig;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.ProductionPrompt;
import com.facebook.productionprompts.model.ProductionPromptObject;
import com.facebook.productionprompts.model.PromptObject;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: mobile_zero_upsell_get_promos_graphql_api */
public class FramePromptActionHandler<CONTEXT extends PromptActionContext & HasComposerSessionId & HasPromptSessionId & HasSelectedFrameId> implements PromptActionHandler<CONTEXT> {
    @Inject
    public volatile Provider<JsonPluginConfigSerializer> f13374a = UltralightRuntime.f367a;
    private final CreativeCamLauncher f13375b;

    public static FramePromptActionHandler m19705b(InjectorLike injectorLike) {
        FramePromptActionHandler framePromptActionHandler = new FramePromptActionHandler(CreativeCamLauncherImpl.m19535a(injectorLike));
        framePromptActionHandler.f13374a = IdBasedProvider.m1811a(injectorLike, 2370);
        return framePromptActionHandler;
    }

    @Inject
    private FramePromptActionHandler(CreativeCamLauncher creativeCamLauncher) {
        this.f13375b = creativeCamLauncher;
    }

    public final boolean mo2621b(InlineComposerPromptSession inlineComposerPromptSession) {
        return m19704a(inlineComposerPromptSession).m() != null;
    }

    public final void mo2620a(View view, InlineComposerPromptSession inlineComposerPromptSession, CONTEXT context) {
        Activity activity = (Activity) ContextUtils.m2500a(view.getContext(), Activity.class);
        String str = (String) ((PromptActionContextImpl) context).j.get();
        ProductionPrompt a = m19704a(inlineComposerPromptSession);
        Builder pluginConfig = ComposerConfigurationFactory.m26256a(ComposerSourceSurface.NEWSFEED, "framesPrompt").setPluginConfig(((JsonPluginConfigSerializer) this.f13374a.get()).mo2485a(ProductionPromptsPluginConfig.a(a, PromptAnalytics.a(inlineComposerPromptSession.f13409a.mo2493b(), inlineComposerPromptSession.f13410b.f15099c, ((PromptActionContextImpl) context).b(), (String) ((PromptActionContextImpl) context).a().orNull(), inlineComposerPromptSession.f13410b.f15098b, inlineComposerPromptSession.f13411c.a.getName()), true)));
        ProductionPromptComposerUtil.a(pluginConfig, a);
        CreativeCamLauncher creativeCamLauncher = this.f13375b;
        CreativeCamLaunchConfig.Builder builder = new CreativeCamLaunchConfig.Builder();
        builder.b = true;
        builder = builder;
        builder.f = SupportedMediaType.PHOTO_ONLY;
        builder = builder;
        builder.h = ImmutableList.of(m19704a(inlineComposerPromptSession).m());
        CreativeCamLaunchConfig.Builder builder2 = builder;
        builder2.i = ((PromptActionContextImpl) context).i();
        builder = builder2;
        builder.k = pluginConfig.a();
        creativeCamLauncher.mo2610a(activity, 8372, builder.a(), str, PromptAnalytics.a(inlineComposerPromptSession.f13409a.mo2493b(), inlineComposerPromptSession.f13410b.f15099c, ((PromptActionContextImpl) context).b(), (String) ((PromptActionContextImpl) context).a().orNull(), inlineComposerPromptSession.f13410b.f15098b, inlineComposerPromptSession.f13411c.a.getName()));
    }

    private static ProductionPrompt m19704a(InlineComposerPromptSession inlineComposerPromptSession) {
        PromptObject a = InlineComposerPromptSession.m19774a(inlineComposerPromptSession);
        Preconditions.checkArgument(a instanceof ProductionPromptObject);
        return ((ProductionPromptObject) a).f12765a;
    }

    public final void mo2622a(@Nullable ComposerPluginConfig composerPluginConfig, InlineComposerPromptSession inlineComposerPromptSession) {
    }
}
