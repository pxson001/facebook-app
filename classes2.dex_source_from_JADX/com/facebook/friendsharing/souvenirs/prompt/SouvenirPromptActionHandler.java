package com.facebook.friendsharing.souvenirs.prompt;

import android.app.Activity;
import android.view.View;
import com.facebook.common.util.ContextUtils;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.friendsharing.souvenirs.manager.SouvenirPromptManager;
import com.facebook.friendsharing.souvenirs.mediaitems.SouvenirsMediaItemsHelper;
import com.facebook.friendsharing.souvenirs.models.SouvenirModel;
import com.facebook.friendsharing.souvenirs.persistence.SouvenirPromptPrefKeys;
import com.facebook.friendsharing.souvenirs.prompt.composer.SouvenirPromptPluginConfig;
import com.facebook.friendsharing.souvenirs.prompt.model.SouvenirPromptObject;
import com.facebook.friendsharing.souvenirs.util.SouvenirsLogger;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerPluginConfig;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.intent.JsonPluginConfigSerializer;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextImpl;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextInterfaces.HasComposerSessionId;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextInterfaces.HasPromptSessionId;
import com.facebook.ipc.productionprompts.actionhandler.PromptActionContext;
import com.facebook.ipc.productionprompts.actionhandler.PromptActionHandler;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.PromptObject;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: module_name */
public class SouvenirPromptActionHandler<CONTEXT extends PromptActionContext & HasComposerSessionId & HasPromptSessionId> implements PromptActionHandler<CONTEXT> {
    private final SouvenirsLogger f13356a;
    private final JsonPluginConfigSerializer f13357b;
    private final Lazy<ComposerLauncher> f13358c;
    private final Lazy<SouvenirsMediaItemsHelper> f13359d;
    private final Lazy<SouvenirPromptManager> f13360e;

    @Inject
    public SouvenirPromptActionHandler(SouvenirsLogger souvenirsLogger, JsonPluginConfigSerializer jsonPluginConfigSerializer, Lazy<ComposerLauncher> lazy, Lazy<SouvenirsMediaItemsHelper> lazy2, Lazy<SouvenirPromptManager> lazy3) {
        this.f13356a = souvenirsLogger;
        this.f13357b = jsonPluginConfigSerializer;
        this.f13358c = lazy;
        this.f13359d = lazy2;
        this.f13360e = lazy3;
    }

    public final boolean mo2621b(InlineComposerPromptSession inlineComposerPromptSession) {
        return InlineComposerPromptSession.m19774a(inlineComposerPromptSession) instanceof SouvenirPromptObject;
    }

    public final void mo2620a(View view, InlineComposerPromptSession inlineComposerPromptSession, CONTEXT context) {
        SouvenirPromptObject souvenirPromptObject = (SouvenirPromptObject) InlineComposerPromptSession.m19774a(inlineComposerPromptSession);
        m19678a(view, context, souvenirPromptObject.a, PromptAnalytics.a(souvenirPromptObject.b(), inlineComposerPromptSession.f13410b.f15099c, ((PromptActionContextImpl) context).a, (String) ((PromptActionContextImpl) context).j.orNull(), inlineComposerPromptSession.f13410b.f15098b, inlineComposerPromptSession.f13411c.a.getName()));
        this.f13356a.m19625c(souvenirPromptObject);
    }

    private void m19678a(View view, CONTEXT context, SouvenirModel souvenirModel, PromptAnalytics promptAnalytics) {
        Activity activity = (Activity) ContextUtils.m2500a(view.getContext(), Activity.class);
        ((ComposerLauncher) this.f13358c.get()).mo1955a((String) ((PromptActionContextImpl) context).j.orNull(), ComposerConfigurationFactory.m26256a(ComposerSourceSurface.NEWSFEED, "souvenirPrompt").setIsFireAndForget(true).setInitialAttachments(ComposerAttachment.a(((SouvenirsMediaItemsHelper) this.f13359d.get()).a(souvenirModel))).setInitialTargetData(ComposerTargetData.a).setPluginConfig(this.f13357b.mo2485a(SouvenirPromptPluginConfig.a(promptAnalytics))).a(), 1756, activity);
    }

    public final void mo2622a(@Nullable ComposerPluginConfig composerPluginConfig, InlineComposerPromptSession inlineComposerPromptSession) {
        PromptObject a = InlineComposerPromptSession.m19774a(inlineComposerPromptSession);
        Preconditions.checkArgument(a instanceof SouvenirPromptObject, "Didn't get a souvenir prompt object");
        SouvenirPromptManager souvenirPromptManager = (SouvenirPromptManager) this.f13360e.get();
        souvenirPromptManager.f13324c.edit().mo1275a(SouvenirPromptPrefKeys.b, souvenirPromptManager.f13325d.mo211a()).commit();
        this.f13356a.m19620a((SouvenirPromptObject) a);
    }
}
