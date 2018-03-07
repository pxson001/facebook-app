package com.facebook.messaging.notify;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.messaging.notify.MessagingNotification.Type;
import com.facebook.push.PushProperty;
import com.fasterxml.jackson.databind.JsonNode;

/* compiled from: isInstantVideo %b */
public class FriendInstallNotification extends MessagingNotification {
    public static final Creator<FriendInstallNotification> CREATOR = new C14221();
    public final String f12657a;
    public final String f12658b;
    public final String f12659c;
    public final String f12660d;
    public final PushProperty f12661e;
    public boolean f12662f;

    /* compiled from: isInstantVideo %b */
    final class C14221 implements Creator<FriendInstallNotification> {
        C14221() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FriendInstallNotification(parcel);
        }

        public final Object[] newArray(int i) {
            return new FriendInstallNotification[i];
        }
    }

    public static FriendInstallNotification m13112a(String str, String str2, JsonNode jsonNode, PushProperty pushProperty) {
        if (!jsonNode.d("i_id")) {
            return null;
        }
        String B = jsonNode.b("i_id").B();
        if (B != null) {
            return new FriendInstallNotification(B, str2, str, str, pushProperty);
        }
        return null;
    }

    private FriendInstallNotification(String str, String str2, String str3, String str4, PushProperty pushProperty) {
        super(Type.FRIEND_INSTALL);
        this.f12657a = str;
        this.f12658b = str2;
        this.f12659c = str3;
        this.f12660d = str4;
        this.f12661e = pushProperty;
    }

    public FriendInstallNotification(Parcel parcel) {
        super(parcel);
        this.f12657a = parcel.readString();
        this.f12658b = parcel.readString();
        this.f12659c = parcel.readString();
        this.f12660d = parcel.readString();
        this.f12661e = (PushProperty) parcel.readParcelable(PushProperty.class.getClassLoader());
        this.f12662f = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.m13110a(parcel);
        parcel.writeString(this.f12657a);
        parcel.writeString(this.f12658b);
        parcel.writeString(this.f12659c);
        parcel.writeString(this.f12660d);
        parcel.writeParcelable(this.f12661e, i);
        ParcelUtil.a(parcel, this.f12662f);
    }
}
