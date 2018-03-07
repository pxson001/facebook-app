package com.facebook.ipc.composer.model;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringLocaleUtil;

@Deprecated
/* compiled from: TIRE_DEALER */
public enum ComposerSourceType {
    AGGREGATED_STORY_ACTION_BUTTON("aggregated_story_action_button"),
    ALBUM("album"),
    ARTICLE_CHAINING("article_chaining"),
    CHECKIN_STORY("checkin_story"),
    COMPOST("compost"),
    EVENT("native_event"),
    EVENT_ALBUM("native_event_album"),
    EVENT_DASHBOARD_CELEBRATIONS("event_dashboard_celebrations"),
    EXTERNAL("external"),
    FACEWEB("faceweb"),
    FEED("feed"),
    FEED_INLINE("feed_inline"),
    FEED_UNIT_CELEBRATIONS("feed_unit_celebrations"),
    FRAMES_CTA("frames_cta"),
    FRAMES_PROMPT("frames_prompt"),
    FRIENDS_TAB("friends_tab"),
    FUNDRAISER_PAGE("fundraiser_page"),
    GREETING_CARD("greeting_card"),
    GROUP("group"),
    GROUPS_TAB("groups_tab"),
    INSTANT_ARTICLE("instant_article"),
    KEYWORD_SEARCH("keyword_search"),
    MARKETPLACE("marketplace"),
    MINUTIAE_PREFILLED("minutiae"),
    NOTIFICATION("notification"),
    OFFERS_SPACE("offers_space"),
    ON_THIS_DAY_BIRTHDAY_CARD("on_this_day_birthday_card"),
    ON_THIS_DAY_FEED("on_this_day_feed"),
    ON_THIS_DAY_FRIENDVERSARY_CARD("on_this_day_friendversary_card"),
    ON_THIS_DAY_PROMO("on_this_day_promo"),
    PAGE("native_page"),
    PAGE_SERVICE("page_service"),
    PERMALINK("native_permalink"),
    PHOTOS_FEED("photos_feed"),
    PHOTOS_GRID_VIEW("photos_grid"),
    PHOTOSTAB("photos_tab"),
    PLACE_REVIEW_FEED_UNIT("place_review_feed_unit"),
    PLATFORM("platform"),
    PREFILLED("prefilled"),
    PRODUCT_DETAILS("product_details"),
    REACTION("reaction"),
    REDSPACE_FRIEND_INLINE("redspace_friend_inline"),
    REDSPACE_GRID("redspace_grid"),
    REDSPACE_SELF_INLINE("redspace_self_inline"),
    REDSPACE_SELF_PROMPT("redspace_self_prompt"),
    REVIEWS_LIST("reviews_list"),
    RIDGE_WIDGET("ridge_widget"),
    SAHELI_FEED_UNIT("saheli_feed_unit"),
    SAVED_DASHBOARD("saved_dashboard"),
    SEARCH("search"),
    SOUVENIR("souvenir"),
    STICKER_MEDIA_GALLERY_PROMOTION("sticker_media_gallery_promotion"),
    STORY_CALL_TO_ACTION("story_call_to_action"),
    TIMELINE("native_timeline"),
    URI_HANDLER("uri_handler"),
    USER_REVIEWS_LIST("user_reviews_list"),
    VIDEO_CHANNEL("video_channel"),
    VIDEO_HOME("video_home"),
    WEB_VIEW("web_view"),
    WIDGET("widget"),
    WORK_TOP_GROUPS_COMPOSER("work_top_groups_composer"),
    GOOD_FRIENDS_COMPOSER("good_friends_composer"),
    UNKNOWN("unknown");
    
    public final String analyticsName;

    private ComposerSourceType(String str) {
        this.analyticsName = str;
    }

    public final String toString() {
        return this.analyticsName;
    }

    public static ComposerSourceType fromString(String str) {
        String a = StringLocaleUtil.a(str);
        for (ComposerSourceType composerSourceType : values()) {
            if (composerSourceType.analyticsName.equals(a)) {
                return composerSourceType;
            }
        }
        throw new IllegalArgumentException(StringFormatUtil.formatStrLocaleSafe("Unknown ComposerSourceType value: '%s'", a));
    }

    public static ComposerSourceType fromString(String str, ComposerSourceType composerSourceType) {
        try {
            composerSourceType = fromString(str);
        } catch (IllegalArgumentException e) {
        }
        return composerSourceType;
    }
}
