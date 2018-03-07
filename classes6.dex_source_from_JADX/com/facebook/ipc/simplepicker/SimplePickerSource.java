package com.facebook.ipc.simplepicker;

/* compiled from: last_upload_attempt_timestamp */
public enum SimplePickerSource {
    FEED("feed"),
    TIMELINE("native_timeline"),
    EVENT("native_event"),
    PAGE("native_page"),
    PAGE_PHOTO_ONLY("page_photo_only"),
    PAGE_VIDEO_ONLY("page_video_only"),
    PAGE_PROFILE_PIC("page_profile_pic"),
    PAGE_SHOP_INVOICE_MANUAL_RECEIPT("page_shop_invoice_manual_receipt"),
    PAGE_COVER_PHOTO("page_cover_photo"),
    PAGE_MSG_SAVED_REPLY("page_msg_saved_reply"),
    PHOTOSTAB("photos_tab"),
    ALBUMSTAB("albums_tab"),
    ALBUM("album"),
    PROFILEPIC("profile_pic"),
    PROFILEPIC_NUX("profile_pic_nux"),
    COVERPHOTO("cover_photo"),
    FAVORITE_PHOTOS("favorite_photos"),
    ADD_FEATURED_CONTAINER_NULL_STATE("afc_null_state"),
    FACEWEB("face_web"),
    COMPOSER_ADD_MORE_MEDIA("composer_add_more"),
    PHOTO_COMMENT("photo_comment"),
    MEDIA_COMMENT("media_comment"),
    GROUP("group"),
    SAMPLE_APP("sample_app"),
    TEST("test"),
    HOLIDAY_CARDS("holiday_cards"),
    PLACE_PROFILE_PIC_SUGGESTS("place_profile_pic_suggests"),
    PLACES_HOME("places_home"),
    WIDGET("widget"),
    SUGGEST_EDITS("suggest_edits"),
    SEARCH("search"),
    PLACE_CREATION("place_creation"),
    PHOTOS_BY_CATEGORY("photos_by_category"),
    MEDIA_GALLERY("media_gallery"),
    PHOTO_MENU_UPLOAD("photo_menu_upload"),
    REACTION("reaction"),
    PHOTO_REMINDER_MORE_PHOTOS("photo_reminder_more_photos"),
    GOODWILL_COMPOSER("goodwill_composer"),
    SOUVENIR("souvenir"),
    CREATIVECAM("creativecam"),
    PAGE_SERVICE("page_service"),
    MARKETPLACE("marketplace"),
    COMPOST("compost"),
    SLIDESHOW_EDIT("slideshow_edit"),
    VIDEO_HOME("video_home");
    
    private final String analyticsName;

    private SimplePickerSource(String str) {
        this.analyticsName = str;
    }

    public final String toString() {
        return this.analyticsName;
    }
}
