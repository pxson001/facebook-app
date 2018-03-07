package com.facebook.productionprompts.model;

import com.google.common.base.Preconditions;

/* compiled from: startService / auto retry */
public class InlineComposerPromptSession$Builder {
    private PromptObject f4230a;
    private PromptInfo f4231b;
    private PromptViewState f4232c;

    public InlineComposerPromptSession$Builder(InlineComposerPromptSession inlineComposerPromptSession) {
        this.f4230a = inlineComposerPromptSession.a;
        this.f4231b = inlineComposerPromptSession.b;
        this.f4232c = inlineComposerPromptSession.c;
    }

    public final InlineComposerPromptSession$Builder m6275a(PromptObject promptObject) {
        this.f4230a = (PromptObject) Preconditions.checkNotNull(promptObject);
        return this;
    }

    public final InlineComposerPromptSession$Builder m6274a(PromptInfo promptInfo) {
        this.f4231b = (PromptInfo) Preconditions.checkNotNull(promptInfo);
        return this;
    }

    public final InlineComposerPromptSession$Builder m6276a(PromptViewState promptViewState) {
        this.f4232c = (PromptViewState) Preconditions.checkNotNull(promptViewState);
        return this;
    }

    public final InlineComposerPromptSession m6277a() {
        return new InlineComposerPromptSession((PromptObject) Preconditions.checkNotNull(this.f4230a), (PromptInfo) Preconditions.checkNotNull(this.f4231b), this.f4232c == null ? PromptViewState.f4261c : this.f4232c);
    }
}
