package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.contacts.graphql.Contact;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: page_ids */
public class FetchContactsResult extends BaseResult implements Parcelable {
    public static final Creator<FetchContactsResult> CREATOR = new C05401();
    public final ImmutableList<Contact> f8447a;

    /* compiled from: page_ids */
    final class C05401 implements Creator<FetchContactsResult> {
        C05401() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchContactsResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchContactsResult[i];
        }
    }

    public FetchContactsResult(DataFreshnessResult dataFreshnessResult, long j, ImmutableList<Contact> immutableList) {
        super(dataFreshnessResult, j);
        Preconditions.checkNotNull(immutableList);
        this.f8447a = immutableList;
    }

    public FetchContactsResult(Parcel parcel) {
        super(parcel);
        this.f8447a = ImmutableList.copyOf(parcel.readArrayList(Contact.class.getClassLoader()));
    }

    public final ImmutableList<Contact> m12289c() {
        return this.f8447a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeList(this.f8447a);
    }

    public String toString() {
        return "FetchContactsResult: " + this.f8447a;
    }
}
