package com.facebook.productionprompts.model;

import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: src_small_webp */
public final class PromptViewState {
    public static final PromptViewState f4261c = new PromptViewState(Visibility.MAXIMIZED, true);
    public final Visibility f4262a;
    public final boolean f4263b;

    public PromptViewState(Visibility visibility, boolean z) {
        this.f4262a = visibility;
        this.f4263b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PromptViewState promptViewState = (PromptViewState) obj;
        if (this.f4262a.equals(promptViewState.f4262a) && this.f4263b == promptViewState.f4263b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.f4263b ? 1 : 0) + (this.f4262a.hashCode() * 31);
    }
}
