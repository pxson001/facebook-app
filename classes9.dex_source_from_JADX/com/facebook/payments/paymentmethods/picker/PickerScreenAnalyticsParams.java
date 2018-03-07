package com.facebook.payments.paymentmethods.picker;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.identifiers.UniqueIdGenerator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.payments.model.PaymentsFlowType;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: bookmark_name */
public class PickerScreenAnalyticsParams implements Parcelable {
    public static final Creator<PickerScreenAnalyticsParams> CREATOR = new C21961();
    public final String f18776a;
    @Nullable
    public final String f18777b;
    public final PaymentsFlowType f18778c;
    public final long f18779d;

    /* compiled from: bookmark_name */
    final class C21961 implements Creator<PickerScreenAnalyticsParams> {
        C21961() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PickerScreenAnalyticsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new PickerScreenAnalyticsParams[i];
        }
    }

    public static PickerScreenAnalyticsParamsBuilder newBuilder() {
        return new PickerScreenAnalyticsParamsBuilder();
    }

    public PickerScreenAnalyticsParams(PickerScreenAnalyticsParamsBuilder pickerScreenAnalyticsParamsBuilder) {
        boolean z;
        long a;
        if (StringUtil.c(pickerScreenAnalyticsParamsBuilder.f18780a)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        Preconditions.checkNotNull(pickerScreenAnalyticsParamsBuilder.f18782c);
        this.f18776a = pickerScreenAnalyticsParamsBuilder.f18780a;
        this.f18777b = pickerScreenAnalyticsParamsBuilder.f18781b;
        this.f18778c = pickerScreenAnalyticsParamsBuilder.f18782c;
        if (pickerScreenAnalyticsParamsBuilder.f18783d == 0) {
            a = new UniqueIdGenerator().a();
        } else {
            a = pickerScreenAnalyticsParamsBuilder.f18783d;
        }
        this.f18779d = a;
    }

    public PickerScreenAnalyticsParams(Parcel parcel) {
        this.f18776a = parcel.readString();
        this.f18777b = parcel.readString();
        this.f18778c = (PaymentsFlowType) ParcelUtil.c(parcel, PaymentsFlowType.class);
        this.f18779d = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f18776a);
        parcel.writeString(this.f18777b);
        ParcelUtil.a(parcel, this.f18778c);
        parcel.writeLong(this.f18779d);
    }
}
