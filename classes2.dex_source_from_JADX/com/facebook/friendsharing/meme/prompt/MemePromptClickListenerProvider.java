package com.facebook.friendsharing.meme.prompt;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextFactory;
import com.facebook.productionprompts.common.InlineComposerPromptActionHandler;
import com.facebook.productionprompts.model.InlineComposerPromptSession;

/* compiled from: mobile_hipri */
public class MemePromptClickListenerProvider extends AbstractAssistedProvider<MemePromptClickListener> {
    public final MemePromptClickListener m19761a(InlineComposerPromptSession inlineComposerPromptSession) {
        return new MemePromptClickListener(inlineComposerPromptSession, InlineComposerPromptActionHandler.m19641b((InjectorLike) this), PromptActionContextFactory.m19725b(this));
    }
}
