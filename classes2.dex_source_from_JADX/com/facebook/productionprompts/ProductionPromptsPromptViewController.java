package com.facebook.productionprompts;

import com.facebook.ipc.productionprompts.ui.v2.DelegatingPromptViewController;
import com.facebook.ipc.productionprompts.ui.v2.PromptViewController;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.ProductionPromptObject;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mobile_power_stats */
public class ProductionPromptsPromptViewController extends DelegatingPromptViewController {
    private final EditorialPromptsPromptViewController f13387b;

    @Inject
    public ProductionPromptsPromptViewController(Set<PromptViewController> set, EditorialPromptsPromptViewController editorialPromptsPromptViewController) {
        super(set);
        this.f13387b = editorialPromptsPromptViewController;
    }

    public final boolean mo2616e(InlineComposerPromptSession inlineComposerPromptSession) {
        return InlineComposerPromptSession.m19774a(inlineComposerPromptSession) instanceof ProductionPromptObject;
    }

    @Nullable
    protected final PromptViewController mo2624d(InlineComposerPromptSession inlineComposerPromptSession) {
        PromptViewController d = super.mo2624d(inlineComposerPromptSession);
        return d == null ? this.f13387b : d;
    }
}
