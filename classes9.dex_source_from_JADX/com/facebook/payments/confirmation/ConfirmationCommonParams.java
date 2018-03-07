package com.facebook.payments.confirmation;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: call_type */
public class ConfirmationCommonParams implements ConfirmationParams {
    public static final Creator<ConfirmationCommonParams> CREATOR = new C21551();
    public final ConfirmationStyle f18593a;
    public final boolean f18594b;
    public final String f18595c;

    /* compiled from: call_type */
    final class C21551 implements Creator<ConfirmationCommonParams> {
        C21551() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ConfirmationCommonParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ConfirmationCommonParams[i];
        }
    }

    public static ConfirmationCommonParamsBuilder newBuilder() {
        return new ConfirmationCommonParamsBuilder();
    }

    public ConfirmationCommonParams(ConfirmationCommonParamsBuilder confirmationCommonParamsBuilder) {
        this.f18593a = (ConfirmationStyle) Preconditions.checkNotNull(confirmationCommonParamsBuilder.f18596a);
        this.f18594b = confirmationCommonParamsBuilder.f18597b;
        this.f18595c = (String) Preconditions.checkNotNull(confirmationCommonParamsBuilder.f18598c);
    }

    public ConfirmationCommonParams(Parcel parcel) {
        this.f18593a = (ConfirmationStyle) ParcelUtil.c(parcel, ConfirmationStyle.class);
        this.f18594b = ParcelUtil.a(parcel);
        this.f18595c = parcel.readString();
    }

    public final ConfirmationCommonParams mo732a() {
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f18593a);
        ParcelUtil.a(parcel, this.f18594b);
        parcel.writeString(this.f18595c);
    }
}
