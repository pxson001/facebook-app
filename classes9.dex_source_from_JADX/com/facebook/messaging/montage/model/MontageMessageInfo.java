package com.facebook.messaging.montage.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.messaging.model.messages.Message;
import com.google.common.base.Preconditions;

/* compiled from: is_invite_all */
public class MontageMessageInfo implements Parcelable {
    public static final Creator<MontageMessageInfo> CREATOR = new C13991();
    public final MontageMessageType f12554a;
    public final Message f12555b;
    public final long f12556c;

    /* compiled from: is_invite_all */
    final class C13991 implements Creator<MontageMessageInfo> {
        C13991() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MontageMessageInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new MontageMessageInfo[i];
        }
    }

    public MontageMessageInfo(MontageMessageType montageMessageType, Message message, long j) {
        Preconditions.checkNotNull(montageMessageType);
        Preconditions.checkNotNull(message);
        Preconditions.checkArgument(j >= 0);
        this.f12554a = montageMessageType;
        this.f12555b = message;
        this.f12556c = j;
    }

    protected MontageMessageInfo(Parcel parcel) {
        this.f12554a = (MontageMessageType) ParcelUtil.c(parcel, MontageMessageType.class);
        this.f12555b = (Message) parcel.readParcelable(Message.class.getClassLoader());
        this.f12556c = parcel.readLong();
    }

    public int describeContents() {
        return hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f12554a);
        parcel.writeParcelable(this.f12555b, i);
        parcel.writeLong(this.f12556c);
    }
}
