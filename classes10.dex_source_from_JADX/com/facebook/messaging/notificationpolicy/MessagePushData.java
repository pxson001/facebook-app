package com.facebook.messaging.notificationpolicy;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.push.PushProperty;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: retry_tapped */
public class MessagePushData implements Parcelable {
    public static final Creator<MessagePushData> CREATOR = new C05451();
    public final String f3377a;
    public final String f3378b;
    public final PushProperty f3379c;

    /* compiled from: retry_tapped */
    final class C05451 implements Creator<MessagePushData> {
        C05451() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MessagePushData(parcel);
        }

        public final Object[] newArray(int i) {
            return new MessagePushData[i];
        }
    }

    MessagePushData(String str, String str2, PushProperty pushProperty) {
        this.f3377a = str;
        this.f3378b = str2;
        this.f3379c = pushProperty;
    }

    public MessagePushData(Parcel parcel) {
        this.f3377a = parcel.readString();
        this.f3378b = parcel.readString();
        this.f3379c = (PushProperty) parcel.readSerializable();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3377a);
        parcel.writeString(this.f3378b);
        parcel.writeParcelable(this.f3379c, i);
    }
}
