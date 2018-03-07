package com.facebook.productionprompts;

import com.facebook.feed.util.composer.launch.FeedComposerLauncher.ComposerConfigCustomizer;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.productionprompts.composer.ProductionPromptComposerUtil;
import com.facebook.productionprompts.model.ProductionPrompt;

/* compiled from: resend_contactpoint_code */
class EditorialPromptsPromptActionHandler$1 implements ComposerConfigCustomizer {
    final /* synthetic */ ProductionPrompt f4499a;
    final /* synthetic */ EditorialPromptsPromptActionHandler f4500b;

    EditorialPromptsPromptActionHandler$1(EditorialPromptsPromptActionHandler editorialPromptsPromptActionHandler, ProductionPrompt productionPrompt) {
        this.f4500b = editorialPromptsPromptActionHandler;
        this.f4499a = productionPrompt;
    }

    public final void m4357a(Builder builder) {
        ProductionPromptComposerUtil.m4382a(builder, this.f4499a);
    }
}
