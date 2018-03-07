package com.facebook.payments.paymentmethods.picker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.adspayments.analytics.PaymentsFlowContext;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.payments.model.PaymentItemType;
import com.facebook.payments.model.PaymentsFlowType;
import com.facebook.payments.paymentmethods.model.NewPaymentOptionType;
import com.facebook.payments.picker.model.PickerScreenFetcherParams;
import com.facebook.payments.util.PaymentItemTypeUtil;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: bookmark_identifier */
public final class PickerScreenCommonParams implements PickerScreenParams {
    public static final Creator<PickerScreenCommonParams> CREATOR = new C21971();
    public final PickerScreenStyleParams f18784a;
    public final PickerScreenAnalyticsParams f18785b;
    public final PickerScreenStyle f18786c;
    public final PaymentItemType f18787d;
    public final ImmutableList<NewPaymentOptionType> f18788e;
    public final String f18789f;
    public final String f18790g;
    public final PaymentsFlowContext f18791h;
    public final PickerScreenFetcherParams f18792i;

    /* compiled from: bookmark_identifier */
    final class C21971 implements Creator<PickerScreenCommonParams> {
        C21971() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PickerScreenCommonParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new PickerScreenCommonParams[i];
        }
    }

    public static PickerScreenCommonParamsBuilder newBuilder() {
        return new PickerScreenCommonParamsBuilder();
    }

    public PickerScreenCommonParams(Parcel parcel) {
        this.f18784a = (PickerScreenStyleParams) parcel.readParcelable(PickerScreenStyleParams.class.getClassLoader());
        this.f18785b = (PickerScreenAnalyticsParams) parcel.readParcelable(PickerScreenAnalyticsParams.class.getClassLoader());
        this.f18786c = (PickerScreenStyle) ParcelUtil.c(parcel, PickerScreenStyle.class);
        this.f18787d = (PaymentItemType) ParcelUtil.c(parcel, PaymentItemType.class);
        this.f18788e = ImmutableList.copyOf(parcel.readArrayList(NewPaymentOptionType.class.getClassLoader()));
        this.f18789f = parcel.readString();
        this.f18790g = parcel.readString();
        this.f18792i = (PickerScreenFetcherParams) parcel.readParcelable(PickerScreenFetcherParams.class.getClassLoader());
        this.f18791h = (PaymentsFlowContext) ParcelUtil.b(parcel, PaymentsFlowContext.class);
    }

    public PickerScreenCommonParams(PickerScreenCommonParamsBuilder pickerScreenCommonParamsBuilder) {
        ImmutableList immutableList;
        String str;
        this.f18784a = (PickerScreenStyleParams) Preconditions.checkNotNull(pickerScreenCommonParamsBuilder.f18794b);
        this.f18785b = (PickerScreenAnalyticsParams) Preconditions.checkNotNull(pickerScreenCommonParamsBuilder.f18793a);
        this.f18786c = (PickerScreenStyle) Preconditions.checkNotNull(pickerScreenCommonParamsBuilder.f18795c);
        if (PaymentItemTypeUtil.a(pickerScreenCommonParamsBuilder.f18796d)) {
            boolean z;
            if (StringUtil.a(pickerScreenCommonParamsBuilder.f18798f)) {
                z = false;
            } else {
                z = true;
            }
            Preconditions.checkArgument(z, "Account id is needed for " + pickerScreenCommonParamsBuilder.f18796d);
        }
        this.f18787d = pickerScreenCommonParamsBuilder.f18796d;
        if (pickerScreenCommonParamsBuilder.f18797e == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = pickerScreenCommonParamsBuilder.f18797e;
        }
        this.f18788e = immutableList;
        if (StringUtil.a(pickerScreenCommonParamsBuilder.f18798f)) {
            str = "0";
        } else {
            str = pickerScreenCommonParamsBuilder.f18798f;
        }
        this.f18789f = str;
        this.f18790g = (String) Preconditions.checkNotNull(pickerScreenCommonParamsBuilder.f18799g);
        this.f18792i = (PickerScreenFetcherParams) Preconditions.checkNotNull(pickerScreenCommonParamsBuilder.f18800h);
        this.f18791h = pickerScreenCommonParamsBuilder.f18801i;
    }

    public final PaymentsFlowContext m18791b() {
        return this.f18791h != null ? this.f18791h : new PaymentsFlowContext(this.f18785b.f18776a, this.f18789f, this.f18787d, PaymentsFlowType.PICKER_SCREEN, this.f18785b.f18779d, null);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f18784a, i);
        parcel.writeParcelable(this.f18785b, i);
        ParcelUtil.a(parcel, this.f18786c);
        ParcelUtil.a(parcel, this.f18787d);
        parcel.writeList(this.f18788e.asList());
        parcel.writeString(this.f18789f);
        parcel.writeString(this.f18790g);
        parcel.writeParcelable(this.f18792i, i);
        parcel.writeParcelable(this.f18791h, i);
    }

    public final PickerScreenCommonParams mo743a() {
        return this;
    }
}
