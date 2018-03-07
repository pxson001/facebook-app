package com.facebook.messaging.payment.service.model.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fetch_blacklised_sync_paths */
public class FetchPaymentRequestsParams implements Parcelable {
    public static final Creator<FetchPaymentRequestsParams> CREATOR = new C16941();
    public static String f14718a = "FetchPaymentRequestsParams";
    public final QueryType f14719b;

    /* compiled from: fetch_blacklised_sync_paths */
    final class C16941 implements Creator<FetchPaymentRequestsParams> {
        C16941() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchPaymentRequestsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchPaymentRequestsParams[i];
        }
    }

    /* compiled from: fetch_blacklised_sync_paths */
    public enum QueryType {
        INCOMING,
        OUTGOING
    }

    public FetchPaymentRequestsParams(QueryType queryType) {
        this.f14719b = queryType;
    }

    public FetchPaymentRequestsParams(Parcel parcel) {
        this.f14719b = (QueryType) parcel.readSerializable();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f14719b);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("queryType", this.f14719b).toString();
    }
}
