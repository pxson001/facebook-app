package com.facebook.photos.base.analytics.constants;

/* compiled from: input count= */
public class ConsumptionLoggingConstants {

    /* compiled from: input count= */
    public enum ContentViewingSurface {
        FEED("feed"),
        TIMELINE("timeline"),
        SNOWFLAKE("snowflake"),
        FULL_SCREEN_GALLERY("full_screen_gallery"),
        PERMALINK("permalink"),
        TAB_VIEW("tab_view");
        
        public final String value;

        private ContentViewingSurface(String str) {
            this.value = str;
        }
    }

    /* compiled from: input count= */
    public enum Referrer {
        OTHER("other"),
        SYNC("shoebox"),
        PHOTOS_TAB("photos_tab"),
        PHOTOS_OF_("photos_of_"),
        PHOTOS_BY_CATEGORY("photos_by_category"),
        PAGE_PROFILE_PHOTO("page_profile_photo"),
        PAGE_COVER_PHOTO("page_cover_photo"),
        PAGE_PHOTO_MENUS("page_photo_menus"),
        FOOD_PHOTOS("food_photos"),
        PANDORA_BENNY_PHOTOS_OF_LARGE_THUMBNAIL_SPECIAL_CARD("pandora_benny_photos_of_large_thumbnail_special_card"),
        PANDORA_BENNY_PHOTOS_OF_SMALL_THUMBNAIL_SPECIAL_CARD("pandora_benny_photos_of_small_thumbnail_special_card"),
        PANDORA_BENNY_PHOTOS_OF_LARGE_THUMBNAIL_ALL_PHOTOS("pandora_benny_photos_of_large_thumbnail_all_photos"),
        PANDORA_BENNY_PHOTOS_OF_SMALL_THUMBNAIL_ALL_PHOTOS("pandora_benny_photos_of_small_thumbnail_all_photos"),
        PANDORA_BENNY_PHOTOS_OF_LARGE_THUMBNAIL_TARGET_AND_MUTUAL_FRIENDS("pandora_benny_photos_of_large_thumbnail_target_and_mutual_friends"),
        PANDORA_BENNY_PHOTOS_OF_SMALL_THUMBNAIL_TARGET_AND_MUTUAL_FRIENDS("pandora_benny_photos_of_small_thumbnail_target_and_mutual_friends"),
        NOT_TAGGED_TAB("not_tagged_tab"),
        YOUR_PHOTOS("your_photos"),
        SEARCH_EYEWITNESS_MODULE("search_eyewitness_module"),
        SEARCH_TOP_PHOTOS_MODULE("search_top_photos_module"),
        SEARCH_PHOTOS_GRID_MODULE("search_photos_grid_module"),
        SEARCH_PHOTO_RESULTS_PAGE("search_photo_results_page"),
        TIMELINE_PROFILE_PHOTO("timeline_profile_photo"),
        TIMELINE_COVER_PHOTO("timeline_cover_photo"),
        TIMELINE_PHOTO_WIDGET("timeline_photo_widget"),
        TIMELINE_INTRO_CARD_FAV_PHOTO("timeline_intro_card_fav_photo"),
        GROUPS_COVER_PHOTO("groups_cover_photo"),
        GROUPS_INFO_PAGE_PHOTO("groups_info_page_photo"),
        FEED("feed"),
        TIMELINE("timeline"),
        ALBUM("albums_tab"),
        ALBUM_PERMALINK("album_permalink"),
        PHOTO_COMMENT("photo_comment"),
        FULL_SCREEN_GALLERY("full_screen_gallery"),
        PAGE_GRID_PHOTO_CARD("page_grid_photo_card"),
        PAGE_PHOTOS_TAB("page_photos_tab"),
        PHOTOS_FEED("photos_feed"),
        SNOWFLAKE("snowflake"),
        FACEWEB("faceweb"),
        SOUVENIRS("souvenirs"),
        PROMOTION_CAMPAIGN_PHOTOS("promotion_campaign"),
        INTENT("intent"),
        NEARBYPLACES("nearbyplaces"),
        FUNDRAISER_COVER_PHOTO("fundraiser_cover_photo");
        
        public final String value;

        private Referrer(String str) {
            this.value = str;
        }
    }

    /* compiled from: input count= */
    public enum UserAction {
        SWIPE("swipe"),
        SCROLL("scroll"),
        LOAD("load"),
        CLICK("click"),
        LONGPRESS("longpress"),
        HARDWARE_CLICK("hardware_click");
        
        public final String value;

        private UserAction(String str) {
            this.value = str;
        }
    }
}
