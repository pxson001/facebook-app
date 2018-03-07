package com.facebook.messaging.notify;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.messaging.notify.MessagingNotification.Type;

/* compiled from: inviter_id */
public class PromotionNotification extends MessagingNotification {
    public static final Creator<PromotionNotification> CREATOR = new C14331();
    public final String f12762a;
    public final String f12763b;
    public final String f12764c;
    public final String f12765d;
    public boolean f12766e;

    /* compiled from: inviter_id */
    final class C14331 implements Creator<PromotionNotification> {
        C14331() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PromotionNotification(parcel);
        }

        public final Object[] newArray(int i) {
            return new PromotionNotification[i];
        }
    }

    public PromotionNotification(String str, String str2, String str3, String str4) {
        super(Type.PROMOTION);
        this.f12762a = str;
        this.f12763b = str2;
        this.f12764c = str3;
        this.f12765d = str4;
    }

    protected PromotionNotification(Parcel parcel) {
        super(parcel);
        this.f12762a = parcel.readString();
        this.f12763b = parcel.readString();
        this.f12764c = parcel.readString();
        this.f12765d = parcel.readString();
        this.f12766e = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.m13110a(parcel);
        parcel.writeString(this.f12762a);
        parcel.writeString(this.f12763b);
        parcel.writeString(this.f12764c);
        parcel.writeString(this.f12765d);
        ParcelUtil.a(parcel, this.f12766e);
    }
}
