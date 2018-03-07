package com.facebook.messaging.analytics.base;

/* compiled from: onTouchEnd */
public class MessagingAnalyticsConstants {

    /* compiled from: onTouchEnd */
    public enum MessageSendTrigger {
        COMPOSER_AUDIO_CLIP_TAB("composer_audio_clip_tab"),
        COMPOSER_EVENT_TAB("composer_event_tab"),
        COMPOSER_LOCATION_TAB("composer_location_tab"),
        COMPOSER_MEDIA_TRAY_TAB("composer_media_tray_tab"),
        COMPOSER_PAYMENT_TAB("composer_payment_tab"),
        COMPOSER_QUICK_CAM_TAB("composer_quick_cam_tab"),
        COMPOSER_STICKER_TAB("composer_sticker_tab"),
        COMPOSER_TEXT_TAB("composer_text_tab"),
        COMPOSER_CONTENT_SEARCH("composer_content_search"),
        COMPOSER_HOT_LIKE("composer_hot_like"),
        COMPOSER_SAMPLE_CONTENT_PAGE("composer_sample_content_page"),
        ACTION_LINK("action_link"),
        FORWARD("forward"),
        NEW_MESSAGE("new_message"),
        GROUP_EVENT_CREATE("group_event_create"),
        NUX("nux"),
        PLATFORM_APP("platform_app"),
        PLATFORM_POSTBACK("platform_postback"),
        PHOTO_REMINDER("photo_reminder"),
        PIC_HEAD("pic_head"),
        QUICK_REPLY("quick_reply"),
        RTC_VOICEMAIL("rtc_voicemail"),
        RTC_VOIP_QUICKRESPONSE("rtc_voip_quickresponse"),
        SHARE("share"),
        TRUSTED_APP_INTENT("trusted_app_intent"),
        UNKNOWN("unknown");
        
        private String mValue;

        private MessageSendTrigger(String str) {
            this.mValue = str;
        }

        public final String toString() {
            return this.mValue;
        }
    }
}
