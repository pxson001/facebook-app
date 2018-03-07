package com.facebook.messaging.payment.service.model.transactions;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fetchThread */
public class MutatePaymentPlatformContextParams implements Parcelable {
    public static final Creator<MutatePaymentPlatformContextParams> CREATOR = new C17071();
    public final Mutation f14751a;
    public final String f14752b;

    /* compiled from: fetchThread */
    final class C17071 implements Creator<MutatePaymentPlatformContextParams> {
        C17071() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MutatePaymentPlatformContextParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new MutatePaymentPlatformContextParams[i];
        }
    }

    /* compiled from: fetchThread */
    public enum Mutation {
        MARK_AS_SOLD("p2p_platform_banner_mark_as_sold"),
        BANNER_DISMISS("p2p_platform_banner_dismissal");
        
        public final String mutation;

        private Mutation(String str) {
            this.mutation = str;
        }
    }

    public MutatePaymentPlatformContextParams(Mutation mutation, String str) {
        this.f14751a = mutation;
        this.f14752b = str;
    }

    public MutatePaymentPlatformContextParams(Parcel parcel) {
        this.f14751a = (Mutation) parcel.readSerializable();
        this.f14752b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f14751a);
        parcel.writeString(this.f14752b);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("mutation", this.f14751a).add("platformContextId", this.f14752b).toString();
    }
}
