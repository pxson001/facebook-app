package com.facebook.analytics;

/* compiled from: title_text */
public enum CurationMechanism {
    ACTIONBAR_BUTTON("ACTIONBAR_BUTTON"),
    ADD_BUTTON("ADD_BUTTON"),
    ARCHIVE_BUTTON("ARCHIVE_BUTTON"),
    BACK_BUTTON("BACK_BUTTON"),
    CARET_NUX("CARET_NUX"),
    CANCEL_BUTTON("CANCEL_BUTTON"),
    CARET_MENU("CARET_MENU"),
    DELETE_BUTTON("DELETE_BUTTON"),
    EDIT_BUTTON("EDIT_BUTTON"),
    EDIT_MENU("EDIT_MENU"),
    FILTER_BAR("FILTER_BAR"),
    INLINE_RATING("INLINE_RATING"),
    INLINE_REVIEW("INLINE_REVIEW"),
    LONG_CLICK("LONG_CLICK"),
    MORE_BUTTON("MORE_BUTTON"),
    NETEGO_RATE("NETEGO_RATE"),
    NETEGO_RECOMMENDATIONS("NETEGO_RECOMMENDATIONS"),
    OVERLAY_TOGGLE_BUTTON("OVERLAY_TOGGLE_BUTTON"),
    OFFLINE_TOGGLE_BUTTON("OFFLINE_TOGGLE_BUTTON"),
    REVIEW_BUTTON("REVIEW_BUTTON"),
    REVIEW_NEEDY_PLACE_CARD("REVIEW_NEEDY_PLACE_CARD"),
    SAVED_ADD("SAVED_ADD"),
    SHARE_BUTTON("SHARE_BUTTON"),
    TOGGLE_BUTTON("TOGGLE_BUTTON"),
    UNARCHIVE_BUTTON("UNARCHIVE_BUTTON"),
    UNDO_BUTTON("UNDO_BUTTON"),
    VIEW_POST_BUTTON("VIEW_POST_BUTTON"),
    VIDEO_DOWNLOAD_BUTTON("VIDEO_DOWNLOAD_BUTTON"),
    VIDEO_PAUSE_RESUME_DOWNLOAD_BUTTON("VIDEO_PAUSE_RESUME_DOWNLOAD_BUTTON"),
    CONTEXT_ITEM("CONTEXT_ITEM"),
    OFFLINE_TOAST("OFFLINE_TOAST");
    
    private final String mMechanism;

    private CurationMechanism(String str) {
        this.mMechanism = str;
    }

    public final String toString() {
        return this.mMechanism;
    }
}