package com.facebook.zero.sdk.common;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: size_of_queue */
public enum ZeroFeatureKey {
    UNKNOWN(""),
    ZERO_INDICATOR("promo_banner"),
    FB4A_INDICATOR("zero_state"),
    EXTERNAL_URLS_INTERSTITIAL("url_interstitial"),
    IMAGE_SEARCH_INTERSTITIAL("image_search_interstitial"),
    VIEW_TIMELINE_INTERSTITIAL("timeline_interstitial"),
    VIEW_MAP_INTERSTITIAL("map_interstitial"),
    VOIP_CALL_INTERSTITIAL("voip_interstitial"),
    VOIP_INCOMING_CALL_INTERSTITIAL("voip_incoming_interstitial"),
    LOCATION_SERVICES_INTERSTITIAL("location_interstitial"),
    NATIVE_OPTIN_INTERSTITIAL("native_optin_interstitial"),
    NATIVE_UPSELL_INTERSTITIAL("native_url_interstitial"),
    LEAVING_APP_INTERSTITIAL("dialog_when_leaving_app"),
    CHECKIN_INTERSTITIAL("checkin_interstitial"),
    BUY_CONFIRM_INTERSTITIAL("buy_confirm_interstitial"),
    OPTIN_GROUP_INTERSTITIAL("optin_group_interstitial"),
    UPSELL_USE_DATA_OR_STAY_FREE_SCREEN("upsell_use_data_or_stay_free_screen"),
    VIDEO_UPLOAD_INTERSTITIAL("upload_video_interstitial"),
    VIDEO_PLAY_INTERSTITIAL("play_video_interstitial"),
    AUDIO_UPLOAD_INTERSTITIAL("upload_audio_interstitial"),
    AUDIO_PLAY_INTERSTITIAL("play_audio_interstitial"),
    ATTACHMENT_UPLOAD_INTERSTITIAL("upload_attachment_interstitial"),
    ATTACHMENT_DOWNLOAD_INTERSTITIAL("download_attachment_interstitial"),
    CARRIER_MANAGER("carrier_manager"),
    ZERO_RATED_INTERSTITIAL("zero_rated_interstitial"),
    DIALTONE_OPTIN("dialtone_optin"),
    DIALTONE_PHOTO("photo_dialtone"),
    DIALTONE_FACEWEB("dialtone_faceweb_interstitial"),
    DIALTONE_PHOTO_CAPPING("dialtone_photo_capping"),
    DIALTONE_FEED_CAPPING("dialtone_feed_capping"),
    DIALTONE_AUTOMATIC_MODE("automatic_mode"),
    DIALTONE_AUTOMATIC_MODE_WITH_CONFIRMATION("automatic_mode_with_confirmation"),
    DIALTONE_MANUAL_SWITCHER_MODE("manual_switcher_mode"),
    DIALTONE_STICKY_MODE("dialtone_sticky_mode"),
    DIALTONE_SWITCHER_NUX("dialtone_toggle_nux"),
    DIALTONE_SWITCHER_ZERO_BALANCE_REMINDER("dialtone_switcher_zero_balance_reminder"),
    DIALTONE_OPTOUT_REMINDER("dialtone_optout_reminder"),
    SWITCH_TO_DIALTONE("switch_to_dialtone_mode"),
    DIALTONE_TOGGLE_BOOKMARK("dialtone_toggle_bookmark"),
    MESSAGE_CAPPING("message_capping"),
    MESSAGE_CAPPING_SETTING("message_capping_setting"),
    FREE_MESSENGER_SETTING("free_messenger_setting"),
    UPSELL_DONT_WARN_AGAIN("upsell_dont_warn_again"),
    FREE_DATA_NOTIFICATION("free_data_persistent_notification"),
    DIALTONE_PHOTOCAP_SPINNER("dialtone_photocap_spinner"),
    DIALTONE_PHOTOCAP_ERROR("dialtone_photocap_error"),
    VPN_DATA_CONTROL("vpn_data_control"),
    IORG_EXTERNAL_URL("iorg_external_url"),
    IORG_EXTERNAL_URL_SAFE_MODE_PROMPT("iorg_external_url_safe_mode_prompt"),
    IORG_FB4A_URL("iorg_fb4a_url"),
    IORG_BACKGROUND_EXTERNAL_URL_PROMPT("iorg_background_external_url_prompt"),
    IORG_BACKGROUND_EXTERNAL_URL_STATUS("iorg_background_external_url_status"),
    FBS_MANAGE_DATA_TAB("fbs_app_manage_data_tab"),
    FBS_OPEN_PLATFORM("fbs_open_platform"),
    FBS_CONTENT_SEARCH("fbs_content_search"),
    FBS_SYSTEM_NOTIFICATIONS("fbs_system_notifications"),
    FBS_CONTENT_NOTIFICATIONS("fbs_content-notifications");
    
    @Nullable
    private static ImmutableList<ZeroFeatureKey> mIorgZeroFeatureKeys;
    public static final List<ZeroFeatureKey> sDialtoneFeatureKeys = null;
    public final String prefString;

    static {
        sDialtoneFeatureKeys = ImmutableList.of(DIALTONE_PHOTO, DIALTONE_PHOTO_CAPPING, DIALTONE_FACEWEB, DIALTONE_FEED_CAPPING, DIALTONE_AUTOMATIC_MODE, DIALTONE_AUTOMATIC_MODE_WITH_CONFIRMATION, DIALTONE_MANUAL_SWITCHER_MODE);
    }

    private ZeroFeatureKey(String str) {
        this.prefString = str;
    }

    public final String toString() {
        return this.prefString;
    }

    public static ZeroFeatureKey fromString(String str) {
        if (str != null) {
            for (ZeroFeatureKey zeroFeatureKey : values()) {
                if (str.equalsIgnoreCase(zeroFeatureKey.prefString)) {
                    return zeroFeatureKey;
                }
            }
        }
        return UNKNOWN;
    }

    public static ImmutableSet<ZeroFeatureKey> fromStrings(Iterable<String> iterable) {
        Collection arrayList = new ArrayList();
        for (String fromString : iterable) {
            arrayList.add(fromString(fromString));
        }
        return ImmutableSet.copyOf(arrayList);
    }

    public static ImmutableList<String> toStrings(Iterable<ZeroFeatureKey> iterable) {
        Collection arrayList = new ArrayList();
        for (ZeroFeatureKey zeroFeatureKey : iterable) {
            arrayList.add(zeroFeatureKey.prefString);
        }
        return ImmutableList.copyOf(arrayList);
    }

    public static synchronized ImmutableList<ZeroFeatureKey> getFbsFixedFeatureKeys() {
        ImmutableList<ZeroFeatureKey> immutableList;
        synchronized (ZeroFeatureKey.class) {
            if (mIorgZeroFeatureKeys == null) {
                mIorgZeroFeatureKeys = ImmutableList.of(IORG_EXTERNAL_URL, IORG_EXTERNAL_URL_SAFE_MODE_PROMPT, IORG_BACKGROUND_EXTERNAL_URL_PROMPT, IORG_BACKGROUND_EXTERNAL_URL_STATUS, IORG_FB4A_URL);
            }
            immutableList = mIorgZeroFeatureKeys;
        }
        return immutableList;
    }
}
