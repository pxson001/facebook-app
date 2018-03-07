package com.facebook.productionprompts.model;

/* compiled from: message_ids */
public enum PromptViewState$Visibility {
    MAXIMIZED("maximized"),
    MINIMIZED("minimized"),
    DISMISSED("dismissed");
    
    private final String mName;

    private PromptViewState$Visibility(String str) {
        this.mName = str;
    }

    public final String getName() {
        return this.mName;
    }
}
