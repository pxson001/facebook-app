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
/* compiled from: page_cover_photo */
public class FetchDeltaContactsResult extends BaseResult implements Parcelable {
    public static final Creator<FetchDeltaContactsResult> CREATOR = new C05421();
    private final ImmutableList<Contact> f8450a;
    private final ImmutableList<String> f8451b;
    private final String f8452c;
    private final boolean f8453d;

    /* compiled from: page_cover_photo */
    final class C05421 implements Creator<FetchDeltaContactsResult> {
        C05421() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchDeltaContactsResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchDeltaContactsResult[i];
        }
    }

    public FetchDeltaContactsResult(DataFreshnessResult dataFreshnessResult, ImmutableList<Contact> immutableList, ImmutableList<String> immutableList2, String str, boolean z, long j) {
        super(dataFreshnessResult, j);
        Preconditions.checkNotNull(immutableList);
        Preconditions.checkNotNull(immutableList2);
        this.f8450a = immutableList;
        this.f8451b = immutableList2;
        this.f8452c = str;
        this.f8453d = z;
    }

    public FetchDeltaContactsResult(Parcel parcel) {
        boolean z = true;
        super(parcel);
        this.f8450a = ImmutableList.copyOf(parcel.readArrayList(Contact.class.getClassLoader()));
        this.f8451b = ImmutableList.copyOf(parcel.createStringArrayList());
        this.f8452c = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.f8453d = z;
    }

    public final ImmutableList<Contact> m12290c() {
        return this.f8450a;
    }

    public final ImmutableList<String> m12291d() {
        return this.f8451b;
    }

    public final String m12292e() {
        return this.f8452c;
    }

    public final boolean m12293f() {
        return this.f8453d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeList(this.f8450a);
        parcel.writeList(this.f8451b);
        parcel.writeString(this.f8452c);
        parcel.writeInt(this.f8453d ? 1 : 0);
    }
}
