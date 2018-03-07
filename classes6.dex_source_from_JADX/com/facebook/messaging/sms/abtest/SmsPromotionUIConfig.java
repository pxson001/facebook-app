package com.facebook.messaging.sms.abtest;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.Nullable;

/* compiled from: is_delta_update */
public class SmsPromotionUIConfig implements Parcelable {
    public static final Creator<SmsPromotionUIConfig> CREATOR = new C07851();
    @Nullable
    private final SmsPromotionStyle f12109a;
    @Nullable
    private final String f12110b;
    @Nullable
    private final String f12111c;
    @Nullable
    private final String f12112d;
    @Nullable
    private final String f12113e;

    /* compiled from: is_delta_update */
    final class C07851 implements Creator<SmsPromotionUIConfig> {
        C07851() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SmsPromotionUIConfig(parcel);
        }

        public final Object[] newArray(int i) {
            return new SmsPromotionUIConfig[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public SmsPromotionUIConfig(Parcel parcel) {
        this.f12109a = SmsPromotionStyle.fromOrdinal(parcel.readInt());
        this.f12110b = parcel.readString();
        this.f12111c = parcel.readString();
        this.f12112d = parcel.readString();
        this.f12113e = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f12109a != null ? this.f12109a.ordinal() : -1);
        parcel.writeString(this.f12110b);
        parcel.writeString(this.f12111c);
        parcel.writeString(this.f12112d);
        parcel.writeString(this.f12113e);
    }
}
