package com.facebook.notifications.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.notifications.logging.NotificationType;
import com.facebook.notifications.logging.NotificationsLogger.NotificationLogObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.annotation.Nonnull;

@AutoGenJsonDeserializer
@JsonDeserialize(using = SystemTrayNotificationDeserializer.class)
/* compiled from: fetchMessagingFavorites */
public class SystemTrayNotification implements Parcelable {
    public static final Creator<SystemTrayNotification> CREATOR = new C05681();
    public static final ImmutableMap<String, NotificationType> f11753a = ImmutableMap.builder().b("orca_message", NotificationType.MSG).b("msg", NotificationType.MSG).b("webrtc_voip_call", NotificationType.MSG).b("wall", NotificationType.WALL).b("mention", NotificationType.MENTION).b("friend", NotificationType.FRIEND_REQUEST).b("friend_confirmed", NotificationType.FRIEND_CONFIRMED).b("photo_tag", NotificationType.PHOTO_TAG).b("photo_tag_request", NotificationType.PHOTO_TAG_REQUEST).b("photo_tagged_by_non_owner", NotificationType.PHOTO_TAGGED_BY_NON_OWNER).b("event_invite", NotificationType.EVENT).b("plan_user_invited", NotificationType.EVENT).b("place_tagged_in_checkin", NotificationType.PLACE_TAG).b("place_checkin_nearby", NotificationType.NEARBY).b("item_comment", NotificationType.COMMENT).b("item_reply", NotificationType.COMMENT).b("comment_mention", NotificationType.COMMENT_MENTION).b("like", NotificationType.LIKE).b("group_activity", NotificationType.GROUP_ACTIVITY).b("group_comment", NotificationType.GROUP_COMMENT).b("group_comment_reply", NotificationType.GROUP_COMMENT_REPLY).b("group_post_mention", NotificationType.GROUP_POST_MENTION).b("hotp_login_approvals", NotificationType.CODE_GENERATOR).b("la_push_authenticate", NotificationType.LOGIN_APPROVALS_REVIEW_LOGIN).b("login_approvals_push_auth", NotificationType.LOGIN_APPROVALS_PUSH_AUTHENTICATE).b("close_friend_activity", NotificationType.CLOSE_FRIEND_ACTIVITY).b("tagged_with_story", NotificationType.TAGGED_WITH_STORY).b("share_wall_create", NotificationType.SHARE_WALL_CREATE).b("activate_vault", NotificationType.ACTIVATE_VAULT).b("gift_recipient", NotificationType.GIFT_RECIPIENT).b("stale_client_notification", NotificationType.STALE_CLIENT_NOTIFICATION).b("request_location_update", NotificationType.BACKGROUND_LOCATION).b("request_lockscreen_reset", NotificationType.ANSIBLE_LOCKSCREEN_RESET).b("birthday_reminder", NotificationType.BIRTHDAY_REMINDER).b("near_saved_place", NotificationType.NEAR_SAVED_PLACE).b("zero", NotificationType.ZERO).b("wakeup_mqtt", NotificationType.WAKEUP_MQTT).b("now_update", NotificationType.NOW_UPDATE).b("bootstrap_updated", NotificationType.BOOTSTRAP_UPDATED).b("pre_reg_push", NotificationType.PRE_REG_PUSH).b("internal", NotificationType.INTERNAL).b("place_feed_nearby", NotificationType.PLACE_FEED_NEARBY).b("place_feed_nearby_cancel", NotificationType.PLACE_FEED_NEARBY_CANCEL).b("logged_out_push", NotificationType.LOGGED_OUT_PUSH).b("event_photo_check", NotificationType.EVENT_PHOTO_CHECK).b("today_unit_update", NotificationType.TODAY_UNIT_UPDATE).b("stale_email", NotificationType.STALE_EMAIL).b("stale_contact_import", NotificationType.STALE_CONTACT_IMPORT).b("stale_notifications", NotificationType.STALE_NOTIFICATIONS).b("backstage_friend_posted", NotificationType.BACKSTAGE_FRIEND_POSTED).b("backstage_friend_reacted", NotificationType.BACKSTAGE_FRIEND_REACTED).b("mobile_zero_free_facebook_launch", NotificationType.MOBILE_ZERO_FREE_FACEBOOK_LAUNCH).b("page_wall", NotificationType.PAGE_WALL).b("page_review", NotificationType.PAGE_REVIEW).b("page_checkin", NotificationType.PAGE_CHECKIN).b("page_tag", NotificationType.PAGE_TAG).b("page_share", NotificationType.PAGE_SHARE).b("fbpage_presence", NotificationType.FBPAGE_PRESENCE).b("neko_install_reminder", NotificationType.NEKO_INSTALL_REMINDER).b("live_video_explicit", NotificationType.LIVE_VIDEO_ON_VIDEO_TAB).b();
    public static final ImmutableMap<String, ActionType> f11754b = ImmutableMap.builder().b("la_authenticate_approve", ActionType.LA_AUTHENTICATE_APPROVE).b("la_authenticate_deny", ActionType.LA_AUTHENTICATE_DENY).b();
    private static final String f11755c = SystemTrayNotification.class.getSimpleName();
    private static final ImmutableMap<String, ObjectType> f11756d = ImmutableMap.builder().b("A", ObjectType.ALBUM).b("R", ObjectType.APP_REQUEST).b("C", ObjectType.CHECKIN).b("E", ObjectType.EVENT).b("F", ObjectType.FRIEND).b("K", ObjectType.GIFT).b("G", ObjectType.GROUP).b("a", ObjectType.LIVE_VIDEO).b("N", ObjectType.NOTE).b("P", ObjectType.PAGE).b("H", ObjectType.PHOTO).b("O", ObjectType.POKE).b("Q", ObjectType.QUESTION).b("S", ObjectType.STREAM).b("D", ObjectType.SUPPORT_DASHBOARD).b("U", ObjectType.USER).b("T", ObjectType.USER_ABOUT).b("V", ObjectType.VIDEO).b("B", ObjectType.NEARBY_FRIEND).b("9", ObjectType.PLACE_FEED).b("2", ObjectType.CONTACT_IMPORTER).b();
    private static final ImmutableSet<NotificationType> f11757e = ImmutableSet.of(NotificationType.CODE_GENERATOR, NotificationType.LOGIN_APPROVALS_REVIEW_LOGIN, NotificationType.LOGIN_APPROVALS_PUSH_AUTHENTICATE, NotificationType.ACTIVATE_VAULT, NotificationType.POST_FAILED, NotificationType.AUTHENTICATION_FAILED, new NotificationType[]{NotificationType.COMMENT_FAILED, NotificationType.PLACE_FEED_NEARBY});
    private Optional<Long> f11758f;
    private Optional<String> f11759g;
    private Optional<String> f11760h;
    private String f11761i;
    private String f11762j;
    private long f11763k;
    @JsonProperty("href")
    public final String mHref;
    @JsonProperty("is_logged_out_push")
    public final boolean mIsLoggedOutPush;
    @JsonProperty("message")
    public final String mMessage;
    @JsonProperty("params")
    public final Map<String, Object> mParams;
    @JsonProperty("time")
    public final long mServerUtcSecs;
    @JsonProperty("target_uid")
    public final long mTargetUid;
    @JsonProperty("type")
    public final String mType;
    @JsonProperty("unread_count")
    public final int mUnreadCount;

    /* compiled from: fetchMessagingFavorites */
    public enum ObjectType {
        ALBUM,
        APP_REQUEST,
        CHECKIN,
        EVENT,
        FRIEND,
        GIFT,
        GROUP,
        LIVE_VIDEO,
        NOTE,
        PAGE,
        PHOTO,
        POKE,
        QUESTION,
        STREAM,
        SUPPORT_DASHBOARD,
        USER,
        USER_ABOUT,
        VIDEO,
        NEARBY_FRIEND,
        PLACE_FEED,
        CONTACT_IMPORTER
    }

    /* compiled from: fetchMessagingFavorites */
    public enum ActionType {
        LA_AUTHENTICATE_APPROVE,
        LA_AUTHENTICATE_DENY
    }

    /* compiled from: fetchMessagingFavorites */
    final class C05681 implements Creator<SystemTrayNotification> {
        C05681() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SystemTrayNotification(parcel);
        }

        public final Object[] newArray(int i) {
            return new SystemTrayNotification[i];
        }
    }

    private SystemTrayNotification() {
        this.mType = null;
        this.mServerUtcSecs = 0;
        this.mMessage = null;
        this.mUnreadCount = 0;
        this.mTargetUid = -1;
        this.mHref = null;
        this.mParams = null;
        this.mIsLoggedOutPush = false;
        this.f11760h = null;
    }

    public SystemTrayNotification(Parcel parcel) {
        boolean z = true;
        this.mType = parcel.readString();
        this.mServerUtcSecs = parcel.readLong();
        this.mMessage = parcel.readString();
        this.mUnreadCount = parcel.readInt();
        this.mTargetUid = parcel.readLong();
        this.mHref = parcel.readString();
        this.mParams = Maps.c();
        parcel.readMap(this.mParams, Map.class.getClassLoader());
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.mIsLoggedOutPush = z;
        this.f11761i = parcel.readString();
        this.f11762j = parcel.readString();
        this.f11763k = parcel.readLong();
    }

    public final NotificationType m12307a() {
        return m12304e(this.mType);
    }

    public final String m12311b() {
        return this.mType;
    }

    private NotificationType m12304e(String str) {
        if (str != null) {
            int indexOf = str.indexOf(58);
            if (indexOf >= 0) {
                str = str.substring(0, indexOf);
            }
            NotificationType notificationType = (NotificationType) f11753a.get(str);
            if (notificationType != null) {
                Optional A;
                if (notificationType == NotificationType.STALE_EMAIL) {
                    A = m12299A();
                    if (A.isPresent() && A.get() == ObjectType.CONTACT_IMPORTER) {
                        return NotificationType.STALE_CONTACT_IMPORT;
                    }
                    return notificationType;
                } else if (notificationType != NotificationType.LIVE_VIDEO_ON_VIDEO_TAB) {
                    return notificationType;
                } else {
                    A = m12299A();
                    if (A.isPresent() && A.get() == ObjectType.LIVE_VIDEO) {
                        return notificationType;
                    }
                    return NotificationType.DEFAULT_PUSH_OF_JEWEL_NOTIF;
                }
            }
        }
        return NotificationType.DEFAULT_PUSH_OF_JEWEL_NOTIF;
    }

    public final NotificationLogObject m12312c() {
        NotificationLogObject notificationLogObject = new NotificationLogObject();
        notificationLogObject.a = this.mType;
        notificationLogObject = notificationLogObject;
        notificationLogObject.b = m12307a();
        NotificationLogObject notificationLogObject2 = notificationLogObject;
        notificationLogObject2.i = (String) m12303c(this.mParams, "log_data").orNull();
        notificationLogObject2 = notificationLogObject2;
        notificationLogObject2.e = ((Long) m12306z().or(Long.valueOf(0))).longValue();
        notificationLogObject2 = notificationLogObject2;
        notificationLogObject2.f = (String) m12314d().orNull();
        notificationLogObject2 = notificationLogObject2;
        notificationLogObject2.g = (String) m12303c(this.mParams, "o").orNull();
        notificationLogObject2 = notificationLogObject2;
        notificationLogObject2.h = (String) m12303c(this.mParams, "t").orNull();
        notificationLogObject = notificationLogObject2;
        notificationLogObject.t = this.f11762j;
        notificationLogObject = notificationLogObject;
        notificationLogObject.s = this.f11761i;
        notificationLogObject = notificationLogObject;
        notificationLogObject.u = this.f11763k;
        return notificationLogObject;
    }

    public final SystemTrayNotification m12309a(String str) {
        this.f11762j = str;
        return this;
    }

    public final SystemTrayNotification m12310b(String str) {
        this.f11761i = str;
        return this;
    }

    public final SystemTrayNotification m12308a(long j) {
        this.f11763k = j;
        return this;
    }

    @VisibleForTesting
    private Optional<Long> m12306z() {
        if (this.f11758f == null) {
            this.f11758f = m12302b(this.mParams, "i");
        }
        return this.f11758f;
    }

    public final Optional<String> m12314d() {
        if (this.f11759g == null) {
            this.f11759g = m12303c(this.mParams, "gi");
        }
        return this.f11759g;
    }

    public final Optional<String> m12316e() {
        if (this.f11760h == null) {
            this.f11760h = m12303c(this.mParams, "ppu");
        }
        return this.f11760h;
    }

    public final Optional<Long> m12317f() {
        return m12302b(this.mParams, "o");
    }

    private Optional<ObjectType> m12299A() {
        Optional c = m12303c(this.mParams, "t");
        if (c.isPresent()) {
            return Optional.fromNullable(f11756d.get(c.get()));
        }
        return Absent.INSTANCE;
    }

    public final Optional<String> m12318g() {
        return m12303c(this.mParams, "d");
    }

    public final Optional<String> m12313c(String str) {
        return m12303c(this.mParams, str);
    }

    public final Optional<Integer> m12315d(String str) {
        return m12300a(this.mParams, str);
    }

    public final Optional<String> m12319h() {
        return m12303c(this.mParams, "id_override");
    }

    public final boolean m12320i() {
        return m12305f("disable_light");
    }

    public final boolean m12321j() {
        return m12305f("disable_sound");
    }

    public final boolean m12322k() {
        return m12305f("disable_vibrate");
    }

    private boolean m12305f(String str) {
        return ((Long) m12302b(this.mParams, str).or(Long.valueOf(0))).equals(Long.valueOf(1));
    }

    public final boolean m12323l() {
        return this.mIsLoggedOutPush;
    }

    public final boolean m12324m() {
        return this.mParams.containsKey("subtext");
    }

    public final boolean m12325n() {
        return this.mParams.containsKey("pa_type") || this.mParams.containsKey("pa_href");
    }

    public final boolean m12326o() {
        return m12325n() && (this.mParams.containsKey("sa_type") || this.mParams.containsKey("sa_href"));
    }

    public final Optional<String> m12327p() {
        return m12303c(this.mParams, "pa_type");
    }

    public final Optional<String> m12328q() {
        return m12303c(this.mParams, "sa_type");
    }

    public final Optional<String> m12329r() {
        return m12303c(this.mParams, "pa_href");
    }

    public final Optional<String> m12330s() {
        return m12303c(this.mParams, "sa_href");
    }

    public final Optional<String> m12331t() {
        return m12303c(this.mParams, "pa_text");
    }

    public final Optional<String> m12332u() {
        return m12303c(this.mParams, "sa_text");
    }

    public final Optional<String> m12333v() {
        return m12303c(this.mParams, "a_md");
    }

    public final String m12334w() {
        return this.mParams.containsKey("subtext") ? String.valueOf(this.mParams.get("subtext")) : null;
    }

    public final long m12335x() {
        return this.mTargetUid;
    }

    public final boolean m12336y() {
        return this.mTargetUid != -1;
    }

    public static boolean m12301a(NotificationType notificationType) {
        return !f11757e.contains(notificationType);
    }

    @Nonnull
    private static Optional<Integer> m12300a(Map<String, Object> map, String str) {
        Optional c = m12303c(map, str);
        if (!c.isPresent()) {
            return Absent.withType();
        }
        try {
            return Optional.of(Integer.valueOf(Integer.parseInt((String) c.get())));
        } catch (Throwable e) {
            BLog.b(f11755c, e, "NumberFormatException: %s must be a number", new Object[]{str});
            return Absent.withType();
        }
    }

    @Nonnull
    private static Optional<Long> m12302b(Map<String, Object> map, String str) {
        Optional c = m12303c(map, str);
        if (!c.isPresent()) {
            return Absent.withType();
        }
        try {
            return Optional.of(Long.valueOf(Long.parseLong((String) c.get())));
        } catch (Throwable e) {
            BLog.b(f11755c, e, "NumberFormatException: %s must be a number", new Object[]{str});
            return Absent.withType();
        }
    }

    @Nonnull
    private static Optional<String> m12303c(Map<String, Object> map, String str) {
        if (map == null) {
            return Absent.INSTANCE;
        }
        Object obj = map.get(str);
        if (obj == null) {
            return Absent.INSTANCE;
        }
        CharSequence obj2 = obj.toString();
        if (StringUtil.c(obj2)) {
            return Absent.INSTANCE;
        }
        return Optional.of(obj2);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mType);
        parcel.writeLong(this.mServerUtcSecs);
        parcel.writeString(this.mMessage);
        parcel.writeInt(this.mUnreadCount);
        parcel.writeLong(this.mTargetUid);
        parcel.writeString(this.mHref);
        parcel.writeMap(this.mParams);
        parcel.writeByte((byte) (this.mIsLoggedOutPush ? 1 : 0));
        parcel.writeString(this.f11761i);
        parcel.writeString(this.f11762j);
        parcel.writeLong(this.f11763k);
    }
}
