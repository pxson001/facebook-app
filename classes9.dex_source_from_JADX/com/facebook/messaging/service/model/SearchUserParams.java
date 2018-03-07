package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableSet;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: contact_logs_upload_failed */
public class SearchUserParams implements Parcelable {
    public static final Creator<SearchUserParams> CREATOR = new C20551();
    private final ImmutableSet<Integer> f17297a;
    public final String f17298b;

    /* compiled from: contact_logs_upload_failed */
    final class C20551 implements Creator<SearchUserParams> {
        C20551() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SearchUserParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SearchUserParams[i];
        }
    }

    public SearchUserParams(String str, ImmutableSet<Integer> immutableSet) {
        this.f17297a = immutableSet;
        this.f17298b = str;
    }

    public SearchUserParams(Parcel parcel) {
        this.f17297a = ImmutableSet.copyOf(parcel.readArrayList(SearchUserParams.class.getClassLoader()));
        this.f17298b = parcel.readString();
    }

    public final ImmutableSet<Integer> m17173a() {
        return this.f17297a;
    }

    public final String m17174b() {
        return this.f17298b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f17297a.asList());
        parcel.writeString(this.f17298b);
    }
}
