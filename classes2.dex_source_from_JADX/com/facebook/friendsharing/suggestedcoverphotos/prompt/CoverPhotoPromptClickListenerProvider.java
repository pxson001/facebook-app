package com.facebook.friendsharing.suggestedcoverphotos.prompt;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextFactory;
import com.facebook.productionprompts.common.InlineComposerPromptActionHandler;
import com.facebook.productionprompts.model.InlineComposerPromptSession;

/* compiled from: mobile_device_bytes_sent_since_boot */
public class CoverPhotoPromptClickListenerProvider extends AbstractAssistedProvider<CoverPhotoPromptClickListener> {
    public final CoverPhotoPromptClickListener m19766a(InlineComposerPromptSession inlineComposerPromptSession) {
        return new CoverPhotoPromptClickListener(inlineComposerPromptSession, InlineComposerPromptActionHandler.m19641b((InjectorLike) this), PromptActionContextFactory.m19725b(this));
    }
}
