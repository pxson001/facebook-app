package com.facebook.messaging.notify;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.notify.MessagingNotification.Type;

/* compiled from: isFacebookRequestCode */
public class JoinRequestNotification extends MessagingNotification {
    public static final Creator<JoinRequestNotification> CREATOR = new C14241();
    public final String f12672a;
    public final String f12673b;
    public final ThreadKey f12674c;
    public boolean f12675d;

    /* compiled from: isFacebookRequestCode */
    final class C14241 implements Creator<JoinRequestNotification> {
        C14241() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new JoinRequestNotification(parcel);
        }

        public final Object[] newArray(int i) {
            return new JoinRequestNotification[i];
        }
    }

    public JoinRequestNotification(String str, String str2, ThreadKey threadKey) {
        super(Type.JOIN_REQUEST);
        this.f12672a = str;
        this.f12673b = str2;
        this.f12674c = threadKey;
    }

    protected JoinRequestNotification(Parcel parcel) {
        super(parcel);
        this.f12672a = parcel.readString();
        this.f12673b = parcel.readString();
        this.f12674c = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
        this.f12675d = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.m13110a(parcel);
        parcel.writeString(this.f12672a);
        parcel.writeString(this.f12673b);
        parcel.writeParcelable(this.f12674c, i);
        ParcelUtil.a(parcel, this.f12675d);
    }
}
