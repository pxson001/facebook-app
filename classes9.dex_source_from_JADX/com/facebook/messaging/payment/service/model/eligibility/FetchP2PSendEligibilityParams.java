package com.facebook.messaging.payment.service.model.eligibility;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fetch_unified_audiences_task_key */
public class FetchP2PSendEligibilityParams implements Parcelable {
    public static final Creator<FetchP2PSendEligibilityParams> CREATOR = new C16811();
    public static String f14660a = "P2PSendEligibilityParams";
    public final DataFreshnessParam f14661b;
    public final String f14662c;

    /* compiled from: fetch_unified_audiences_task_key */
    final class C16811 implements Creator<FetchP2PSendEligibilityParams> {
        C16811() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchP2PSendEligibilityParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchP2PSendEligibilityParams[i];
        }
    }

    public FetchP2PSendEligibilityParams(DataFreshnessParam dataFreshnessParam, String str) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(str));
        this.f14661b = dataFreshnessParam;
        this.f14662c = str;
    }

    public FetchP2PSendEligibilityParams(Parcel parcel) {
        this.f14661b = (DataFreshnessParam) parcel.readSerializable();
        this.f14662c = parcel.readString();
    }

    public String toString() {
        return Objects.toStringHelper(this).add("dataFreshnessParam", this.f14661b).add("receiver", this.f14662c).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f14661b);
        parcel.writeString(this.f14662c);
    }
}
