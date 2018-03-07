package com.facebook.notifications.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
/* compiled from: negativefeedback_redirect_action */
public class SMSNotificationURL implements Parcelable {
    public static final Creator<SMSNotificationURL> CREATOR = new C06741();
    @JsonProperty("data")
    public final ImmutableList<NotificationLongURL> notificationLongUrlList;

    /* compiled from: negativefeedback_redirect_action */
    final class C06741 implements Creator<SMSNotificationURL> {
        C06741() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SMSNotificationURL(parcel);
        }

        public final Object[] newArray(int i) {
            return new SMSNotificationURL[i];
        }
    }

    @AutoGenJsonDeserializer
    @Immutable
    /* compiled from: negativefeedback_redirect_action */
    public class NotificationLongURL implements Parcelable {
        public static final Creator<NotificationLongURL> CREATOR = new C06751();
        @JsonProperty("long_url")
        public final String longUrl;

        /* compiled from: negativefeedback_redirect_action */
        final class C06751 implements Creator<NotificationLongURL> {
            C06751() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new NotificationLongURL(parcel);
            }

            public final Object[] newArray(int i) {
                return new NotificationLongURL[i];
            }
        }

        private NotificationLongURL() {
            this.longUrl = null;
        }

        public NotificationLongURL(Parcel parcel) {
            this.longUrl = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.longUrl);
        }
    }

    private SMSNotificationURL() {
        this.notificationLongUrlList = null;
    }

    public SMSNotificationURL(Parcel parcel) {
        Collection arrayList = new ArrayList();
        parcel.readTypedList(arrayList, NotificationLongURL.CREATOR);
        this.notificationLongUrlList = ImmutableList.copyOf(arrayList);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.notificationLongUrlList);
    }
}
