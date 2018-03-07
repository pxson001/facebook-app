package com.facebook.messaging.payment.service.model.cards;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fetchedSavedAudience */
public class SetPrimaryCardParams implements Parcelable {
    public static final Creator<SetPrimaryCardParams> CREATOR = new C16781();
    public static String f14653a = "setPrimaryCardParams";
    public final long f14654b;
    public final String f14655c;
    public final String f14656d;

    /* compiled from: fetchedSavedAudience */
    final class C16781 implements Creator<SetPrimaryCardParams> {
        C16781() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SetPrimaryCardParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SetPrimaryCardParams[i];
        }
    }

    public SetPrimaryCardParams(long j, String str, @Nullable String str2) {
        this.f14654b = j;
        this.f14655c = str;
        this.f14656d = str2;
    }

    public SetPrimaryCardParams(Parcel parcel) {
        this.f14654b = parcel.readLong();
        this.f14655c = parcel.readString();
        this.f14656d = parcel.readString();
    }

    public String toString() {
        return Objects.toStringHelper(this).add("credentialId", this.f14654b).add("userId", this.f14655c).add("transferId", this.f14656d).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f14654b);
        parcel.writeString(this.f14655c);
        parcel.writeString(this.f14656d);
    }
}
