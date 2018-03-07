package com.facebook.account.recovery.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = AccountCandidatesSummaryDeserializer.class)
/* compiled from: load_start_available_memory */
public class AccountCandidatesSummary implements Parcelable {
    public static final Creator<AccountCandidatesSummary> CREATOR = new C10921();
    @JsonProperty("total_count")
    private int totalCount;

    /* compiled from: load_start_available_memory */
    final class C10921 implements Creator<AccountCandidatesSummary> {
        C10921() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AccountCandidatesSummary(parcel);
        }

        public final Object[] newArray(int i) {
            return new AccountCandidatesSummary[i];
        }
    }

    public AccountCandidatesSummary() {
        this.totalCount = 0;
    }

    public AccountCandidatesSummary(Parcel parcel) {
        this.totalCount = parcel.readInt();
    }

    public final int m12102a() {
        return this.totalCount;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.totalCount);
    }
}
