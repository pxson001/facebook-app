package com.facebook.productionprompts.logging;

/* compiled from: start_time_video_call */
public enum ProductionPromptsLogger$EventAction {
    OPEN_SELECTING_CONTENT("open_selecting_content"),
    OPEN_SUGGESTING_CONTENT("open_suggesting_content"),
    CLOSE_SUGGESTION("close_suggestion"),
    SELECT_SUGGESTION("select_suggestion"),
    CANCEL_COMPOSER("cancel_composer"),
    POST_WITH_PROMPT("post_prompt"),
    POST_WITHOUT_PROMPT("post_without_prompt"),
    IMPRESSION("impression"),
    HIDE_FLYOUT("hide_suggestion"),
    SHOW_FLYOUT("show_suggestion");
    
    private final String name;

    private ProductionPromptsLogger$EventAction(String str) {
        this.name = str;
    }

    public final String getName() {
        return this.name;
    }
}
