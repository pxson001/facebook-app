package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.contacts.graphql.Contact;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: recentCalls */
public class FetchAllContactsResult extends BaseResult implements Parcelable {
    public static final Creator<FetchAllContactsResult> CREATOR = new C01731();
    public final ImmutableList<Contact> f3695a;
    public final String f3696b;
    public final boolean f3697c;
    public final String f3698d;
    public final String f3699e;

    /* compiled from: recentCalls */
    final class C01731 implements Creator<FetchAllContactsResult> {
        C01731() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchAllContactsResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchAllContactsResult[i];
        }
    }

    public FetchAllContactsResult(DataFreshnessResult dataFreshnessResult, ImmutableList<Contact> immutableList, String str, boolean z, String str2, long j, @Nullable String str3) {
        super(dataFreshnessResult, j);
        Preconditions.checkNotNull(immutableList);
        this.f3695a = immutableList;
        this.f3696b = str;
        this.f3697c = z;
        this.f3698d = str2;
        this.f3699e = str3;
    }

    public FetchAllContactsResult(FetchAllContactsResultBuilder fetchAllContactsResultBuilder) {
        this(fetchAllContactsResultBuilder.a, fetchAllContactsResultBuilder.c, fetchAllContactsResultBuilder.d, fetchAllContactsResultBuilder.e, fetchAllContactsResultBuilder.f, fetchAllContactsResultBuilder.b, fetchAllContactsResultBuilder.g);
    }

    public FetchAllContactsResult(Parcel parcel) {
        boolean z = true;
        super(parcel);
        this.f3695a = ImmutableList.copyOf(parcel.readArrayList(Contact.class.getClassLoader()));
        this.f3696b = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.f3697c = z;
        this.f3698d = parcel.readString();
        this.f3699e = parcel.readString();
    }

    public final ImmutableList<Contact> m4151c() {
        return this.f3695a;
    }

    public final String m4152d() {
        return this.f3696b;
    }

    public final boolean m4153e() {
        return this.f3697c;
    }

    public final String m4154f() {
        return this.f3698d;
    }

    @Nullable
    public final String m4155g() {
        return this.f3699e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeList(this.f3695a);
        parcel.writeString(this.f3696b);
        parcel.writeInt(this.f3697c ? 1 : 0);
        parcel.writeString(this.f3698d);
        parcel.writeString(this.f3699e);
    }
}
