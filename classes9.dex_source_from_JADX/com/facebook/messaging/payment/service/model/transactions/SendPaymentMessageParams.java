package com.facebook.messaging.payment.service.model.transactions;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.StringUtil;
import com.facebook.messaging.payment.analytics.PaymentFlowType;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fetchPinnedThreadsResult */
public class SendPaymentMessageParams implements Parcelable {
    public static final Creator<SendPaymentMessageParams> CREATOR = new C17101();
    public static String f14759a = "SendPaymentMessageParams";
    public final String f14760b;
    public final String f14761c;
    public final String f14762d;
    public final String f14763e;
    @Nullable
    public final String f14764f;
    @Nullable
    public final String f14765g;
    @Nullable
    public final String f14766h;
    public final String f14767i;
    @Nullable
    public final String f14768j;
    public final PaymentFlowType f14769k;
    @Nullable
    public final String f14770l;
    @Nullable
    public final String f14771m;
    @Nullable
    public final String f14772n;
    @Nullable
    public final String f14773o;

    /* compiled from: fetchPinnedThreadsResult */
    final class C17101 implements Creator<SendPaymentMessageParams> {
        C17101() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SendPaymentMessageParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SendPaymentMessageParams[i];
        }
    }

    public static SendPaymentMessageParamsBuilder newBuilder() {
        return new SendPaymentMessageParamsBuilder();
    }

    public SendPaymentMessageParams(SendPaymentMessageParamsBuilder sendPaymentMessageParamsBuilder) {
        boolean z;
        boolean z2 = true;
        if (StringUtil.a(sendPaymentMessageParamsBuilder.f14774a)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        if (StringUtil.a(sendPaymentMessageParamsBuilder.f14775b)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        if (StringUtil.a(sendPaymentMessageParamsBuilder.f14776c)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        if (StringUtil.a(sendPaymentMessageParamsBuilder.f14777d)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        if (StringUtil.a(sendPaymentMessageParamsBuilder.f14781h)) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        this.f14760b = sendPaymentMessageParamsBuilder.f14774a;
        this.f14761c = sendPaymentMessageParamsBuilder.f14775b;
        this.f14762d = sendPaymentMessageParamsBuilder.f14776c;
        this.f14763e = sendPaymentMessageParamsBuilder.f14777d;
        this.f14764f = sendPaymentMessageParamsBuilder.f14778e;
        this.f14765g = sendPaymentMessageParamsBuilder.f14779f;
        this.f14766h = sendPaymentMessageParamsBuilder.f14780g;
        this.f14767i = sendPaymentMessageParamsBuilder.f14781h;
        this.f14768j = sendPaymentMessageParamsBuilder.f14782i;
        this.f14769k = sendPaymentMessageParamsBuilder.f14783j;
        this.f14770l = sendPaymentMessageParamsBuilder.f14784k;
        this.f14771m = sendPaymentMessageParamsBuilder.f14785l;
        this.f14772n = sendPaymentMessageParamsBuilder.f14786m;
        this.f14773o = sendPaymentMessageParamsBuilder.f14787n;
    }

    public SendPaymentMessageParams(Parcel parcel) {
        this.f14760b = parcel.readString();
        this.f14761c = parcel.readString();
        this.f14762d = parcel.readString();
        this.f14763e = parcel.readString();
        this.f14764f = parcel.readString();
        this.f14765g = parcel.readString();
        this.f14766h = parcel.readString();
        this.f14767i = parcel.readString();
        this.f14768j = parcel.readString();
        this.f14769k = (PaymentFlowType) parcel.readSerializable();
        this.f14770l = parcel.readString();
        this.f14771m = parcel.readString();
        this.f14772n = parcel.readString();
        this.f14773o = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14760b);
        parcel.writeString(this.f14761c);
        parcel.writeString(this.f14762d);
        parcel.writeString(this.f14763e);
        parcel.writeString(this.f14764f);
        parcel.writeString(this.f14765g);
        parcel.writeString(this.f14766h);
        parcel.writeString(this.f14767i);
        parcel.writeString(this.f14768j);
        parcel.writeSerializable(this.f14769k);
        parcel.writeString(this.f14770l);
        parcel.writeString(this.f14771m);
        parcel.writeString(this.f14772n);
        parcel.writeString(this.f14773o);
    }
}
