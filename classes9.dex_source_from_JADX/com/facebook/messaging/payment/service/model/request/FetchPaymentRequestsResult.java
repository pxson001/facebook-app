package com.facebook.messaging.payment.service.model.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.PaymentRequest;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fetchTransferFbId */
public class FetchPaymentRequestsResult implements Parcelable {
    public static final Creator<FetchPaymentRequestsResult> CREATOR = new C16951();
    private final ArrayList<PaymentRequest> f14720a;

    /* compiled from: fetchTransferFbId */
    final class C16951 implements Creator<FetchPaymentRequestsResult> {
        C16951() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchPaymentRequestsResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchPaymentRequestsResult[i];
        }
    }

    public FetchPaymentRequestsResult(ArrayList<PaymentRequest> arrayList) {
        this.f14720a = arrayList;
    }

    public FetchPaymentRequestsResult(Parcel parcel) {
        this.f14720a = (ArrayList) FlatBufferModelHelper.b(parcel);
    }

    public final ImmutableList<PaymentRequest> m15195a() {
        return ImmutableList.copyOf(this.f14720a);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        FlatBufferModelHelper.a(parcel, this.f14720a);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("paymentRequests", this.f14720a).toString();
    }
}
