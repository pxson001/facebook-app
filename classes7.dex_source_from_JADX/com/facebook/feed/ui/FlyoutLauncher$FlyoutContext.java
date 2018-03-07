package com.facebook.feed.ui;

/* compiled from: Trying to manageChildren view with tag  */
public enum FlyoutLauncher$FlyoutContext {
    STICKER_SELECT("newsfeed_ufi", false, true, false, "tap_footer_comment"),
    STICKER_KEYBOARD_SELECT("newsfeed_ufi", false, true, true, "tap_footer_comment"),
    FOOTER("newsfeed_ufi", true, "tap_footer_comment"),
    BLINGBAR("newsfeed_blingbar", false, "tap_bling_bar_comment"),
    MESSAGE("story_message_flyout", false, "tap_message_comment"),
    INLINE_COMMENT_PREVIEW("feed_inline_comments", false, "tap_feed_inline_comment"),
    INLINE_VIEW_ALL_COMMENTS_LINK("feed_inline_comments", false, "tap_feed_inline_comment"),
    INLINE_COMMENT_COMPOSER("feed_inline_comments", true, "tap_feed_inline_comment"),
    PHOTOS_FEED_FOOTER("photos_feed_ufi", false, "tap_photos_feed_footer_comment"),
    PHOTOS_FEED_BLINGBAR("photos_feed_blingbar", false, "tap_photos_feed_bling_bar_comment");
    
    public final String navigationTapPoint;
    public final String nectarModule;
    public final boolean scrollToBottomOnFirstLoad;
    public final boolean showKeyboardOnFirstLoad;
    public final boolean showStickerKeyboardOnFirstLoad;

    private FlyoutLauncher$FlyoutContext(String str, boolean z, String str2) {
        this(r9, r10, str, z, false, false, str2);
    }

    private FlyoutLauncher$FlyoutContext(String str, boolean z, boolean z2, boolean z3, String str2) {
        this.nectarModule = str;
        this.showKeyboardOnFirstLoad = z;
        this.scrollToBottomOnFirstLoad = z2;
        this.showStickerKeyboardOnFirstLoad = z3;
        this.navigationTapPoint = str2;
    }
}
