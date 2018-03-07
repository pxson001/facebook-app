package com.facebook.messaging.payment.share;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.payment.model.Amount;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fetchPageInfoParams */
public class PaymentEligibleShareExtras implements Parcelable {
    public static final Creator<PaymentEligibleShareExtras> CREATOR = new C17141();
    private final int f14799a;
    private final String f14800b;
    private final String f14801c;
    private final Amount f14802d;
    private final String f14803e;
    private final int f14804f;
    private final long f14805g;

    /* compiled from: fetchPageInfoParams */
    final class C17141 implements Creator<PaymentEligibleShareExtras> {
        C17141() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PaymentEligibleShareExtras(parcel);
        }

        public final Object[] newArray(int i) {
            return new PaymentEligibleShareExtras[i];
        }
    }

    protected PaymentEligibleShareExtras(Parcel parcel) {
        this.f14799a = parcel.readInt();
        this.f14800b = parcel.readString();
        this.f14801c = parcel.readString();
        this.f14802d = (Amount) parcel.readParcelable(Amount.class.getClassLoader());
        this.f14803e = parcel.readString();
        this.f14804f = parcel.readInt();
        this.f14805g = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f14799a);
        parcel.writeString(this.f14800b);
        parcel.writeString(this.f14801c);
        parcel.writeParcelable(this.f14802d, i);
        parcel.writeString(this.f14803e);
        parcel.writeInt(this.f14804f);
        parcel.writeLong(this.f14805g);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("maxRecipients", this.f14799a).add("shareCamption", this.f14800b).add("qpEntryPoint", this.f14801c).add("amount", this.f14802d).add("campaignName", this.f14803e).add("addCardFlowType", this.f14804f).add("incentivesTransferId", this.f14805g).toString();
    }
}
