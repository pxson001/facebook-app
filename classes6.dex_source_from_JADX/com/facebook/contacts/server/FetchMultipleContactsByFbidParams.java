package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: page_attachment_length */
public class FetchMultipleContactsByFbidParams implements Parcelable {
    public static final Creator<FetchMultipleContactsByFbidParams> CREATOR = new C05431();
    public final ImmutableSet<UserKey> f8454a;
    public final DataFreshnessParam f8455b;

    /* compiled from: page_attachment_length */
    final class C05431 implements Creator<FetchMultipleContactsByFbidParams> {
        C05431() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchMultipleContactsByFbidParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchMultipleContactsByFbidParams[i];
        }
    }

    public FetchMultipleContactsByFbidParams(ImmutableSet<UserKey> immutableSet, DataFreshnessParam dataFreshnessParam) {
        this.f8454a = immutableSet;
        this.f8455b = dataFreshnessParam;
    }

    public FetchMultipleContactsByFbidParams(Parcel parcel) {
        this.f8454a = ImmutableSet.copyOf(parcel.readArrayList(UserKey.class.getClassLoader()));
        this.f8455b = DataFreshnessParam.valueOf(parcel.readString());
    }

    public final DataFreshnessParam m12294b() {
        return this.f8455b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(Lists.a(this.f8454a));
        parcel.writeString(this.f8455b.toString());
    }
}
