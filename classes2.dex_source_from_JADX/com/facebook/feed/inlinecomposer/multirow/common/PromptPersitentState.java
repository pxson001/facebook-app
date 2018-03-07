package com.facebook.feed.inlinecomposer.multirow.common;

import com.facebook.productionprompts.model.PromptViewState$Visibility;

/* compiled from: message_ignore_requests */
public class PromptPersitentState {
    public static final PromptPersitentState f14327c = new PromptPersitentState(null, false);
    public PromptViewState$Visibility f14328a;
    public boolean f14329b;

    private PromptPersitentState(PromptViewState$Visibility promptViewState$Visibility, boolean z) {
        this.f14328a = promptViewState$Visibility;
        this.f14329b = z;
    }

    public static PromptPersitentState m20698a() {
        return new PromptPersitentState(PromptViewState$Visibility.MINIMIZED, false);
    }
}
