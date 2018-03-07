package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: page_index */
public class FetchContactsParams implements Parcelable {
    public static final Creator<FetchContactsParams> CREATOR = new C05391();
    public final ImmutableSet<String> f8446a;

    /* compiled from: page_index */
    final class C05391 implements Creator<FetchContactsParams> {
        C05391() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchContactsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchContactsParams[i];
        }
    }

    public FetchContactsParams(ImmutableSet<String> immutableSet) {
        this.f8446a = immutableSet;
    }

    public FetchContactsParams(Parcel parcel) {
        this.f8446a = ImmutableSet.copyOf(parcel.createStringArrayList());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(Lists.a(this.f8446a));
    }
}
