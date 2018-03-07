package com.facebook.productionprompts;

import android.content.Context;
import com.facebook.feed.inlinecomposer.v2attachment.V2PromptUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextFactory;
import com.facebook.ipc.productionprompts.ui.v2.PromptViewBindingObject;
import com.facebook.productionprompts.abtest.PromptsExperimentHelper;
import com.facebook.productionprompts.common.InlineComposerPromptActionHandler;
import com.facebook.productionprompts.model.ClipboardPromptObject;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.ProductionPromptObject;
import javax.inject.Inject;

/* compiled from: mobile_country_code */
public class ClipboardPromptsPromptViewController extends EditorialPromptsPromptViewController {
    private final ClipboardV2PromptProvider f13408a;

    @Inject
    public ClipboardPromptsPromptViewController(InlineComposerPromptActionHandler inlineComposerPromptActionHandler, PromptActionContextFactory promptActionContextFactory, ProductionPromptV2PromptProvider productionPromptV2PromptProvider, ClipboardV2PromptProvider clipboardV2PromptProvider) {
        super(inlineComposerPromptActionHandler, promptActionContextFactory, productionPromptV2PromptProvider);
        this.f13408a = clipboardV2PromptProvider;
    }

    public final boolean mo2616e(InlineComposerPromptSession inlineComposerPromptSession) {
        return InlineComposerPromptSession.m19774a(inlineComposerPromptSession) instanceof ClipboardPromptObject;
    }

    public final PromptViewBindingObject mo2617a(InlineComposerPromptSession inlineComposerPromptSession, Context context) {
        InjectorLike injectorLike = this.f13408a;
        return EditorialPromptsPromptViewController.m19729a(new ClipboardV2Prompt(((ProductionPromptObject) inlineComposerPromptSession.f13409a).f12765a, (Context) injectorLike.getInstance(Context.class), V2PromptUtil.m18713b(injectorLike), PromptsExperimentHelper.m15312b(injectorLike)));
    }
}
