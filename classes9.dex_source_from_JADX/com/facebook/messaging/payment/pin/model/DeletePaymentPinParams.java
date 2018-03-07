package com.facebook.messaging.payment.pin.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: handleRemoveFromFavoritesFailure */
public class DeletePaymentPinParams implements Parcelable {
    public static final Creator<DeletePaymentPinParams> CREATOR = new C15421();
    public static String f13705a = "deletePaymentPinParams";
    public final String f13706b;
    public final long f13707c;
    public final boolean f13708d;

    /* compiled from: handleRemoveFromFavoritesFailure */
    final class C15421 implements Creator<DeletePaymentPinParams> {
        C15421() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DeletePaymentPinParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new DeletePaymentPinParams[i];
        }
    }

    public DeletePaymentPinParams(long j, String str, boolean z) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(str));
        this.f13706b = str;
        this.f13707c = j;
        this.f13708d = z;
    }

    public DeletePaymentPinParams(Parcel parcel) {
        this.f13706b = parcel.readString();
        this.f13707c = parcel.readLong();
        this.f13708d = ParcelUtil.a(parcel);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("pinOrPassword", this.f13706b).add("pinId", this.f13707c).add("isPin", this.f13708d).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f13706b);
        parcel.writeLong(this.f13707c);
        ParcelUtil.a(parcel, this.f13708d);
    }
}
