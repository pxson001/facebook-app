package com.facebook.notifications.logging;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: fetchZeroTokenForDialtone */
public enum NotificationType implements Parcelable {
    ACTIVATE_VAULT,
    ANSIBLE_LOCKSCREEN_RESET,
    APP_REQUEST,
    AUTHENTICATION_FAILED,
    AUTO_UPDATE_AVAILABLE,
    BACKGROUND_LOCATION,
    BACKSTAGE_FRIEND_POSTED,
    BACKSTAGE_FRIEND_REACTED,
    BIRTHDAY_REMINDER,
    BOOTSTRAP_UPDATED,
    CLOSE_FRIEND_ACTIVITY,
    CODE_GENERATOR,
    COMMENT,
    COMMENT_FAILED,
    COMMENT_MENTION,
    DEFAULT_PUSH_OF_JEWEL_NOTIF,
    ERROR_CLIENT_NOTIFICATION,
    EVENT,
    EVENT_PHOTO_CHECK,
    FBPAGE_PRESENCE,
    FRIEND_CONFIRMED,
    FRIEND_REQUEST,
    GIFT_RECIPIENT,
    GROUP_ACTIVITY,
    GROUP_COMMENT,
    GROUP_COMMENT_REPLY,
    GROUP_POST_MENTION,
    INTERNAL,
    LIKE,
    LIVE_VIDEO_ON_VIDEO_TAB,
    LOGGED_OUT_PUSH,
    LOGIN_APPROVALS_PUSH_AUTHENTICATE,
    LOGIN_APPROVALS_REVIEW_LOGIN,
    MENTION,
    MOBILE_ZERO_FREE_FACEBOOK_LAUNCH,
    MSG,
    NEARBY,
    NEAR_SAVED_PLACE,
    NEKO_INSTALL_REMINDER,
    NOW_UPDATE,
    PAGE_CHECKIN,
    PAGE_REVIEW,
    PAGE_SHARE,
    PAGE_TAG,
    PAGE_WALL,
    PHOTO_TAG,
    PHOTO_TAGGED_BY_NON_OWNER,
    PHOTO_TAG_REQUEST,
    PLACE_FEED_NEARBY,
    PLACE_FEED_NEARBY_CANCEL,
    PLACE_TAG,
    POST_FAILED,
    PRE_REG_PUSH,
    SHARE_WALL_CREATE,
    STALE_CLIENT_NOTIFICATION,
    STALE_CONTACT_IMPORT,
    STALE_EMAIL,
    STALE_NOTIFICATIONS,
    TAGGED_WITH_STORY,
    TODAY_UNIT_UPDATE,
    TOR_STATUS,
    UNKNOWN,
    WAKEUP_MQTT,
    WALL,
    WALLFEED_NOTIFICATION,
    ZERO;
    
    public static final Creator<NotificationType> CREATOR = null;

    /* compiled from: fetchZeroTokenForDialtone */
    final class C05671 implements Creator<NotificationType> {
        C05671() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return NotificationType.values()[parcel.readInt()];
        }

        public final Object[] newArray(int i) {
            return new NotificationType[i];
        }
    }

    static {
        CREATOR = new C05671();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ordinal());
    }
}
