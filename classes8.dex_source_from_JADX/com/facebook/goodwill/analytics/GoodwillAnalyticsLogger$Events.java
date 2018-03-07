package com.facebook.goodwill.analytics;

/* compiled from: {rule} */
public enum GoodwillAnalyticsLogger$Events {
    THROWBACK_PERMALINK_VIEW("goodwill_throwback_permalink_view"),
    THROWBACK_PERMALINK_VIEW_MORE("goodwill_throwback_permalink_view_more"),
    THROWBACK_CHANGED_NOTIFICATION_SUBSCRIPTION("goodwill_throwback_notification_subscription_change"),
    THROWBACK_NOTIFICATION_MEGAPHONE_DISMISSED("goodwill_throwback_nux_megaphone_dismiss"),
    GOODWILL_COMPOSER_LAUNCH("goodwill_campaign_viewed_preview"),
    GOODWILL_COMPOSER_CANCEL("goodwill_campaign_dismissed_preview"),
    GOODWILL_COMPOSER_FINAL_STEP("goodwill_campaign_final_step_composer"),
    GOODWILL_COMPOSER_POST_SUBMITTING("goodwill_campaign_post_submitting"),
    GOODWILL_COMPOSER_POST_SUBMITTED("goodwill_campaign_post_submitted"),
    GOODWILL_COMPOSER_POST_FAILED("goodwill_campaign_post_failed"),
    GOODWILL_DAILY_DIALOGUE_GOOD_MORNING_DISMISS("goodwill_dailydialogue_goodmorning_dismiss"),
    GOODWILL_THROWBACK_SHARE_COMPOSER_OPEN("goodwill_throwback_share_composer_open"),
    GOODWILL_THROWBACK_SHARE_COMPOSER_POST("goodwill_throwback_share_composer_post"),
    GOODWILL_THROWBACK_SHARE_MESSAGE_OPEN("goodwill_throwback_share_message_open"),
    GOODWILL_THROWBACK_ADD_PROFILE_FRAME_CLICK("goodwill_throwback_add_profile_frame_click"),
    GOODWILL_VIDEO_SHARE_COMPOSER_OPENED("goodwill_video_share_composer_opened"),
    GOODWILL_THROWBACK_RESHARE_PROMOTION_SEE_ORIGINAL_POST("goodwill_throwback_reshare_original_post_link_click"),
    DAILYDIALOGUE_LIGHTWEIGHT_HEADER_TAPPED("goodwill_dailydialogue_lightweight_header_tapped");
    
    public final String name;

    private GoodwillAnalyticsLogger$Events(String str) {
        this.name = str;
    }
}
