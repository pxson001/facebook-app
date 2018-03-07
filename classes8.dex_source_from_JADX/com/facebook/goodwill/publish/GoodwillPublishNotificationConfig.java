package com.facebook.goodwill.publish;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: yyyy/MM/dd */
public class GoodwillPublishNotificationConfig implements Parcelable {
    public static final Creator<GoodwillPublishNotificationConfig> CREATOR = new C00211();
    public String f155a;
    public String f156b;
    public String f157c;

    /* compiled from: yyyy/MM/dd */
    final class C00211 implements Creator<GoodwillPublishNotificationConfig> {
        C00211() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GoodwillPublishNotificationConfig(parcel);
        }

        public final Object[] newArray(int i) {
            return new GoodwillPublishNotificationConfig[i];
        }
    }

    public GoodwillPublishNotificationConfig(String str, String str2, String str3) {
        this.f155a = str;
        this.f156b = str2;
        this.f157c = str3;
    }

    public GoodwillPublishNotificationConfig(Parcel parcel) {
        this.f155a = parcel.readString();
        this.f156b = parcel.readString();
        this.f157c = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f155a);
        parcel.writeString(this.f156b);
        parcel.writeString(this.f157c);
    }

    public int describeContents() {
        return 0;
    }
}
