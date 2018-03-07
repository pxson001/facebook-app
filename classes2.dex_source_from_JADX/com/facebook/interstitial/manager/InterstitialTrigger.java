package com.facebook.interstitial.manager;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Preconditions;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = InterstitialTriggerDeserializer.class)
/* compiled from: rectangle */
public class InterstitialTrigger implements Parcelable, Comparable<InterstitialTrigger> {
    public static final Creator<InterstitialTrigger> CREATOR = new C03351();
    public final InterstitialTriggerContext f7862a;
    @JsonProperty("action")
    public final Action action;
    @JsonProperty("activity_class")
    public final String activityClass;

    /* compiled from: rectangle */
    final class C03351 implements Creator<InterstitialTrigger> {
        C03351() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new InterstitialTrigger(parcel);
        }

        public final Object[] newArray(int i) {
            return new InterstitialTrigger[i];
        }
    }

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = InterstitialTrigger_ActionDeserializer.class)
    @Immutable
    /* compiled from: rectangle */
    public enum Action {
        FEED_STORY_LOADED,
        NEWSFEED,
        FEED_STORY_CARET,
        FEED_STORY_ONLY_ME_SHARE,
        MESSENGER_APP_DID_BECOME_ACTIVE,
        MESSENGER_NEW_USER_SETUP_COMPLETE,
        MESSENGER_THREAD_LIST_BLOCKING,
        MESSENGER_THREAD_LIST,
        MESSENGER_THREAD_LIST_PTR,
        MESSENGER_THREAD_OPEN,
        MESSENGER_AUDIO_CLIP_VISIBLE,
        MESSENGER_RTC_PRESENCE_CHANGE,
        MAPS_LAUNCH_EXTERNAL_MAP_APP,
        PAGES_MANAGER_APP_DID_BECOME_ACTIVE,
        PAGES_MANAGER_APP_OPENED_NEW_PAGE,
        PAGES_MANAGER_APP_MORE_TAB,
        PAGES_MANAGER_ADS_MANAGER_BOOKMARK_TAPPED,
        VOIP_CALL_START,
        VOIP_CALL_END,
        ACTIVITY_CONFIGURATION_CHANGED,
        ACTIVITY_CREATED,
        APP_FOREGROUND,
        BASIC_SERVICES_OPEN,
        BUILT_IN_BROWSER,
        COMPOSER,
        DIVEBAR_OPEN,
        BACKSTAGE_NUX,
        FRIEND_REQUEST_SENT,
        MINUTIAE_TAG_PICKER,
        PHOTO_PICKER,
        PHOTO_PICKER_DETECTED_RECENT_VIDEO,
        NEWSFEED_USER_REFRESH,
        PAGE_ACTIONBAR,
        PAGE_ADMIN_TIMELINE_VIEW,
        PAGE_ADMIN_TIMELINE_VIEW_VERIFY_ELIGIBLE,
        PAGE_ADMIN_OVERVIEW,
        PAGE_STORY,
        PAGE_CALL_TO_ACTION_BUTTON,
        PAGE_CONTACT_INBOX_ENTRY_POINT,
        PEOPLE_HIGHLIGHTS_TAB_START,
        POST_CREATED,
        PROFILE_FRIEND_REQUEST_SENT,
        PERSONAL_PROFILE_OWNER,
        PERSONAL_PROFILE_FRIEND,
        PERSONAL_PROFILE_NONFRIEND,
        SAVED_DASHBOARD_START,
        SAVED_MAIN_TAB_VISIBLE,
        ITEM_SAVED,
        ITEM_SAVED_IN_CHECKIN_STORY,
        SESSION_COLD_START,
        SIMPLE_SEARCH_CLEAR_TEXT_ICON_CLICK,
        SEARCH_BAR_TOOLTIP,
        SEARCH_NULL_STATE,
        SEARCH_TUTORIAL_NUX,
        SEARCH_TRENDING_TOPIC_LOADED,
        TAB_NAVIGATION_FEED,
        TAB_NAVIGATION_MESSAGES,
        THREAD_LIST_INTERSTITIAL_OPEN,
        TAB_NAVIGATION_NOTIFICATIONS,
        TAB_NAVIGATION_FRIEND_REQUESTS,
        TAB_NAVIGATION_MORE,
        TAB_NAVIGATION_ATTACHED,
        REQUEST_TAB_FRIENDING_ACTION_PERFORMED,
        FEED_PYMK_FRIEND_REQUEST_SENT,
        FEED_PYMK_SCROLLED,
        FEED_PYMK_XOUTED,
        THREAD_LIST_OPEN,
        UNFOLLOW_IN_NFX,
        TIMELINE,
        TIMELINE_INTRO_CARD_SUGGESTED_PHOTOS,
        TIMELINE_INTRO_CARD_SUGGESTED_BIO,
        TIMELINE_INTRO_CARD_BIO_POST_TO_FEED,
        TIMELINE_INTRO_CARD_FAV_PHOTOS_POST_TO_FEED,
        TIMELINE_FEATURED,
        GROUP_CREATE_VIEW,
        GROUP_INFO_VIEW,
        GROUP_MALL_VIEW,
        ADMIN_GROUP_MALL_MULTITIER_ENABLED_VIEW,
        MOD_GROUP_MALL_MULTITIER_ENABLED_VIEW,
        GROUP_ADD_MODERATOR,
        GROUP_SCOPED_SEARCH,
        GROUP_SEEDS_COMPOSER,
        GROUPS_DISCOVER_TAB_TOOL_TIP,
        ME_TAB_INTERSTITIAL,
        ME_TAB_TOOLTIP,
        VIDEO_HOME_TAB_TOOLTIP,
        VIDEO_HOME_FEED,
        PERMALINK_STORY_OPEN,
        PERMALINK_DRAFT_SAVE,
        APP_INVITE_CARET,
        APP_INVITE_FEED,
        MESSAGES_DIODE_CANONICAL_THREAD,
        MESSAGES_DIODE_GROUP_THREAD,
        MESSAGES_DIODE_CREATE_THREAD,
        MESSAGES_DIODE_TAB,
        SEE_FIRST_INDICATOR,
        LEAD_GEN_OPEN,
        NOW_PUBLISHED_STATUS,
        NOW_COMPOSER_OPENED,
        NOW_OPENED,
        VIDEO_AUTOPLAY,
        VIDEO_DOWNLOAD,
        MEDIA_GALLERY_OPENED,
        TO_ADS_MANAGER_M_SITE,
        FEED_INLINE_COMPOSER,
        EVENTS_GUEST_LIST_INVITED_TAB,
        UFI_CLICKED,
        COMMENT_UFI_LIKE_CLICKED,
        EVENTS_CREATION_LOCKED_PRIVACY_EDUCATION_WIDGET,
        NOTIFICATIONS_TAB_FULLY_SHOWN,
        EVENTS_COVER_PHOTO_SELECTOR_THEME_NUX,
        BIRTHDAY_QUICK_VIDEO,
        INSTANT_ARTICLE,
        EVENTS_INTERESTED_RSVP_NUX,
        INSTANT_SHOPPING_SAVE_NUX,
        FIRST_NEWSFEED_AFTER_LOGIN,
        EVENTS_INVITE_THROUGH_MESSENGER_NUX,
        EVENTS_EXTENDED_INVITE_IMPORT_CONTACTS_NUX,
        EVENTS_EXTENDED_INVITE_ADD_NOTE_BUTTON_NUX,
        EVENTS_EXTENDED_INVITE_NOTE_NUX,
        REDSPACE_OPENED,
        REDSPACE_BADGE_LOAD,
        AD_INTERFACES_VIEW_RESULTS,
        SOUVENIR_EDIT,
        NOTIFICATIONS_ADAPTER_CREATION,
        FEEDBACK_COMPOSER_INIT,
        UNKNOWN;

        @JsonCreator
        public static Action fromString(String str) {
            try {
                return valueOf(str.toUpperCase(Locale.US));
            } catch (Exception e) {
                return UNKNOWN;
            }
        }
    }

    public int compareTo(Object obj) {
        return toString().compareTo(((InterstitialTrigger) obj).toString());
    }

    public InterstitialTrigger(InterstitialTrigger interstitialTrigger, @Nullable InterstitialTriggerContext interstitialTriggerContext) {
        this.action = interstitialTrigger.action;
        this.activityClass = interstitialTrigger.activityClass;
        this.f7862a = interstitialTriggerContext;
    }

    public InterstitialTrigger(Action action, @Nullable String str) {
        this.activityClass = str;
        this.action = (Action) Preconditions.checkNotNull(action);
        this.f7862a = null;
    }

    public InterstitialTrigger(Action action, @Nullable Class<? extends Activity> cls) {
        String name;
        if (cls != null) {
            name = cls.getName();
        } else {
            name = null;
        }
        this.activityClass = name;
        this.action = (Action) Preconditions.checkNotNull(action);
        this.f7862a = null;
    }

    public InterstitialTrigger(Action action) {
        this(action, null);
    }

    public InterstitialTrigger() {
        this(Action.UNKNOWN, null);
    }

    public InterstitialTrigger(Parcel parcel) {
        this.action = Action.fromString(parcel.readString());
        this.activityClass = parcel.readString();
        this.f7862a = (InterstitialTriggerContext) parcel.readParcelable(InterstitialTriggerContext.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof InterstitialTrigger) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public String toString() {
        return this.activityClass != null ? this.action.name() + ":" + this.activityClass : this.action.name();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.action.name());
        parcel.writeString(this.activityClass);
        parcel.writeParcelable(this.f7862a, i);
    }

    public static String m12445a(InterstitialTrigger interstitialTrigger) {
        if (interstitialTrigger == null) {
            return null;
        }
        return interstitialTrigger.toString();
    }

    public static InterstitialTrigger m12444a(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(":");
        if (lastIndexOf < 0) {
            return new InterstitialTrigger(Action.fromString(str));
        }
        String substring = str.substring(0, lastIndexOf);
        lastIndexOf++;
        return new InterstitialTrigger(Action.fromString(substring), str.length() > lastIndexOf ? str.substring(lastIndexOf) : "");
    }
}
