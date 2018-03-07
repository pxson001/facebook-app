package com.facebook.ipc.productionprompts.manager;

/* compiled from: TEST_NON_SPLITTABLE */
public enum PromptViewStateUpdater$TapSource {
    XOUT("footer_close_button"),
    ICON("prompt_icon"),
    IMPLICIT("implicit_action");
    
    private final String name;

    private PromptViewStateUpdater$TapSource(String str) {
        this.name = str;
    }

    public final String getName() {
        return this.name;
    }
}
