package com.facebook.productionprompts;

import com.facebook.feed.util.composer.launch.FeedComposerLauncherProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.ipc.composer.intent.JsonPluginConfigSerializer;
import com.facebook.ipc.productionprompts.actionhandler.C0537xc87e0bdd;
import com.facebook.ipc.productionprompts.actionhandler.DelegatingPromptActionHandler;
import com.facebook.ipc.productionprompts.actionhandler.PromptActionHandler;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.ProductionPromptObject;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: moduleAnalyticsTag */
public class ProductionPromptsPromptActionHandler extends DelegatingPromptActionHandler {
    private final EditorialPromptsPromptActionHandler f13361b;

    public static ProductionPromptsPromptActionHandler m19682b(InjectorLike injectorLike) {
        return new ProductionPromptsPromptActionHandler(new MultiBinderSet(injectorLike.getScopeAwareInjector(), new C0537xc87e0bdd(injectorLike)), new EditorialPromptsPromptActionHandler((FeedComposerLauncherProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedComposerLauncherProvider.class), JsonPluginConfigSerializer.m18629b(injectorLike)));
    }

    @Inject
    public ProductionPromptsPromptActionHandler(Set<PromptActionHandler> set, EditorialPromptsPromptActionHandler editorialPromptsPromptActionHandler) {
        super(set);
        this.f13361b = editorialPromptsPromptActionHandler;
    }

    public final boolean mo2621b(InlineComposerPromptSession inlineComposerPromptSession) {
        return InlineComposerPromptSession.m19774a(inlineComposerPromptSession) instanceof ProductionPromptObject;
    }

    @Nullable
    protected final PromptActionHandler mo2623a(InlineComposerPromptSession inlineComposerPromptSession) {
        PromptActionHandler a = super.mo2623a(inlineComposerPromptSession);
        return a == null ? this.f13361b : a;
    }
}
