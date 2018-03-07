package com.facebook.productionprompts.model;

import com.google.common.base.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: mobile */
public final class InlineComposerPromptSession {
    public final PromptObject f13409a;
    public final PromptInfo f13410b;
    public final PromptViewState f13411c;

    public InlineComposerPromptSession(PromptObject promptObject, PromptInfo promptInfo, PromptViewState promptViewState) {
        this.f13409a = promptObject;
        this.f13410b = promptInfo;
        this.f13411c = promptViewState;
    }

    @Nullable
    public static PromptObject m19774a(InlineComposerPromptSession inlineComposerPromptSession) {
        return inlineComposerPromptSession == null ? null : inlineComposerPromptSession.f13409a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InlineComposerPromptSession)) {
            return false;
        }
        InlineComposerPromptSession inlineComposerPromptSession = (InlineComposerPromptSession) obj;
        if (Objects.equal(this.f13409a, inlineComposerPromptSession.f13409a) && Objects.equal(this.f13410b, inlineComposerPromptSession.f13410b) && Objects.equal(this.f13411c, inlineComposerPromptSession.f13411c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int i = 0;
        if (this.f13409a != null) {
            hashCode = this.f13409a.hashCode();
        } else {
            hashCode = 0;
        }
        int i2 = hashCode * 31;
        if (this.f13410b != null) {
            hashCode = this.f13410b.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (hashCode + i2) * 31;
        if (this.f13411c != null) {
            i = this.f13411c.hashCode();
        }
        return hashCode + i;
    }
}
