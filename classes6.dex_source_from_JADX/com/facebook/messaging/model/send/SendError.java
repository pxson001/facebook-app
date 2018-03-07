package com.facebook.messaging.model.send;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: uploadTime */
public class SendError implements Parcelable {
    public static final Creator<SendError> CREATOR = new C01061();
    public static final SendError f2168a = new SendError(SendErrorType.NONE);
    public final SendErrorType f2169b;
    @Nullable
    public final String f2170c;
    public final int f2171d;
    public final long f2172e;
    @Nullable
    public final String f2173f;

    /* compiled from: uploadTime */
    final class C01061 implements Creator<SendError> {
        C01061() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SendError(parcel);
        }

        public final Object[] newArray(int i) {
            return new SendError[i];
        }
    }

    SendError(SendErrorBuilder sendErrorBuilder) {
        this.f2169b = sendErrorBuilder.f2174a;
        this.f2170c = sendErrorBuilder.f2175b;
        this.f2172e = sendErrorBuilder.f2176c;
        this.f2173f = sendErrorBuilder.f2177d;
        this.f2171d = sendErrorBuilder.f2178e;
    }

    private SendError(SendErrorType sendErrorType) {
        this.f2169b = sendErrorType;
        this.f2170c = null;
        this.f2172e = -1;
        this.f2173f = null;
        this.f2171d = -1;
    }

    public SendError(Parcel parcel) {
        this.f2169b = (SendErrorType) parcel.readSerializable();
        this.f2170c = parcel.readString();
        this.f2172e = parcel.readLong();
        this.f2173f = parcel.readString();
        this.f2171d = parcel.readInt();
    }

    public static SendError m3463a(SendErrorType sendErrorType) {
        return new SendError(sendErrorType);
    }

    public static SendErrorBuilder newBuilder() {
        return new SendErrorBuilder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f2169b);
        parcel.writeString(this.f2170c);
        parcel.writeLong(this.f2172e);
        parcel.writeString(this.f2173f);
        parcel.writeInt(this.f2171d);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("timeStamp", this.f2172e).add("type", this.f2169b.serializedString).add("errorMessage", this.f2170c).add("errorNumber", this.f2171d).add("errorUrl", this.f2173f).toString();
    }
}
