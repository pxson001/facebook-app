package com.facebook.account.recovery.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.List;

@AutoGenJsonDeserializer
@JsonDeserialize(using = AccountCandidateContactPointListDeserializer.class)
/* compiled from: local_category */
public class AccountCandidateContactPointList implements Parcelable {
    public static final Creator<AccountCandidateContactPointList> CREATOR = new C10901();
    @JsonProperty("data")
    private List<AccountCandidateContactPoint> candidateContactPoints;

    /* compiled from: local_category */
    final class C10901 implements Creator<AccountCandidateContactPointList> {
        C10901() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AccountCandidateContactPointList(parcel);
        }

        public final Object[] newArray(int i) {
            return new AccountCandidateContactPointList[i];
        }
    }

    public AccountCandidateContactPointList() {
        this.candidateContactPoints = Lists.a();
    }

    public AccountCandidateContactPointList(Parcel parcel) {
        this.candidateContactPoints = parcel.createTypedArrayList(AccountCandidateContactPoint.CREATOR);
    }

    public final ImmutableList<AccountCandidateContactPoint> m12084a() {
        return this.candidateContactPoints == null ? RegularImmutableList.a : ImmutableList.copyOf(this.candidateContactPoints);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.candidateContactPoints);
    }
}
