package com.facebook.feed.inlinecomposer.multirow.common;

import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.productionprompts.model.InlineComposerPromptSession;

/* compiled from: android.permission.RECORD_AUDIO */
final class InlineComposerPersistentStateHelper$1 implements ContextStateKey<String, PromptPersitentState> {
    final /* synthetic */ InlineComposerPromptSession f19275a;

    InlineComposerPersistentStateHelper$1(InlineComposerPromptSession inlineComposerPromptSession) {
        this.f19275a = inlineComposerPromptSession;
    }

    public final Object m22767a() {
        return PromptPersitentState.c;
    }

    public final Object m22768b() {
        return this.f19275a.a.b();
    }
}
