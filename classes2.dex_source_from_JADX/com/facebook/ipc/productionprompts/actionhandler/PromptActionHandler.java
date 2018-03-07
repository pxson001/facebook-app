package com.facebook.ipc.productionprompts.actionhandler;

import android.view.View;
import com.facebook.ipc.composer.intent.ComposerPluginConfig;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import javax.annotation.Nullable;

/* compiled from: moments_upsell */
public interface PromptActionHandler<CONTEXT extends PromptActionContext> {
    void mo2620a(View view, InlineComposerPromptSession inlineComposerPromptSession, CONTEXT context);

    void mo2622a(@Nullable ComposerPluginConfig composerPluginConfig, InlineComposerPromptSession inlineComposerPromptSession);

    boolean mo2621b(InlineComposerPromptSession inlineComposerPromptSession);
}
