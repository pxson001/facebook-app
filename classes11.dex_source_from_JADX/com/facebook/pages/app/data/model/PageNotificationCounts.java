package com.facebook.pages.app.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

@AutoGenJsonDeserializer
/* compiled from: tap_composer_privacy */
public class PageNotificationCounts implements Parcelable {
    public static final Creator<PageNotificationCounts> CREATOR = new C01601();
    private long f1132a;
    @JsonProperty("new_like_count")
    public final long newLikeCount;
    @JsonProperty("unread_message_count")
    public final long unreadMessageCount;
    @JsonProperty("unread_notif_count")
    public final long unreadNotifCount;
    @JsonProperty("unseen_message_count")
    public final long unseenMessageCount;

    /* compiled from: tap_composer_privacy */
    final class C01601 implements Creator<PageNotificationCounts> {
        C01601() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PageNotificationCounts(parcel);
        }

        public final Object[] newArray(int i) {
            return new PageNotificationCounts[i];
        }
    }

    private PageNotificationCounts() {
        this.f1132a = 0;
        this.newLikeCount = 0;
        this.unseenMessageCount = 0;
        this.unreadMessageCount = 0;
        this.unreadNotifCount = 0;
        this.f1132a = 0;
    }

    public PageNotificationCounts(Parcel parcel) {
        this.f1132a = 0;
        this.newLikeCount = parcel.readLong();
        this.unseenMessageCount = parcel.readLong();
        this.unreadMessageCount = parcel.readLong();
        this.unreadNotifCount = parcel.readLong();
        this.f1132a = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.newLikeCount);
        parcel.writeLong(this.unseenMessageCount);
        parcel.writeLong(this.unreadMessageCount);
        parcel.writeLong(this.unreadNotifCount);
        parcel.writeLong(this.f1132a);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("new like count", this.newLikeCount).add("unseen message count", this.unseenMessageCount).add("unread message count", this.unreadMessageCount).add("unread notification count", this.unreadNotifCount).toString();
    }

    public int hashCode() {
        int i = ((int) this.newLikeCount) + 49631;
        i = ((i << 5) - i) + ((int) this.unseenMessageCount);
        i = ((i << 5) - i) + ((int) this.unreadMessageCount);
        return ((i << 5) - i) + ((int) this.unreadNotifCount);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PageNotificationCounts)) {
            return false;
        }
        PageNotificationCounts pageNotificationCounts = (PageNotificationCounts) obj;
        if (this.newLikeCount == pageNotificationCounts.newLikeCount && this.unseenMessageCount == pageNotificationCounts.unseenMessageCount && this.unreadMessageCount == pageNotificationCounts.unreadMessageCount && this.unreadNotifCount == pageNotificationCounts.unreadNotifCount) {
            return true;
        }
        return false;
    }
}
