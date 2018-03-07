package com.facebook.friendsharing.souvenirs.util;

/* compiled from: RCTSourceCode */
enum SouvenirsLogger$Event {
    PICKER_PREVIEWS_LOADED("magic_stories_kit_previews_loaded"),
    PICKER_PREVIEW_SEEN("magic_stories_kit_preview_seen"),
    PICKER_PREVIEW_TAPPED("magic_stories_kit_preview_tapped"),
    ATTACHED_TO_COMPOSER("magic_stories_kit_attached_to_composer"),
    FULLSCREEN_VIEW("magic_stories_kit_view"),
    ADD_ASSETS("magic_stories_kit_add_assets"),
    REMOVE_ASSETS("magic_stories_kit_hide_asset"),
    EDIT_TITLE("magic_stories_kit_edit_title"),
    PICKER_NUX_SEEN("magic_stories_kit_picker_nux_seen"),
    PICKER_NUX_DISMISSED("magic_stories_kit_picker_nux_dismissed"),
    SWAP_ASSET("magic_stories_kit_swap_asset"),
    PROMPT_CLOSED("magic_stories_feed_prompt_closed"),
    PROMPT_DISPLAYED("magic_stories_feed_prompt_displayed"),
    PROMPT_TAPPED("magic_stories_feed_prompt_tapped");
    
    private final String name;

    private SouvenirsLogger$Event(String str) {
        this.name = str;
    }

    public final String toString() {
        return this.name;
    }
}
