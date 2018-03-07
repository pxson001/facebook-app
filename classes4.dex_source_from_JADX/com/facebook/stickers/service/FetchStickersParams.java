package com.facebook.stickers.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.stickers.model.Sticker;
import com.google.common.collect.ImmutableList;
import java.util.Collection;

/* compiled from: qe/ */
public class FetchStickersParams implements Parcelable {
    public static final Creator<FetchStickersParams> CREATOR = new C01821();
    public final ImmutableList<String> f3957a;
    private final StickersUpdateOperation f3958b;

    /* compiled from: qe/ */
    final class C01821 implements Creator<FetchStickersParams> {
        C01821() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchStickersParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchStickersParams[i];
        }
    }

    /* compiled from: qe/ */
    public enum StickersUpdateOperation {
        REPLACE_FROM_NETWORK,
        DO_NOT_UPDATE_IF_CACHED
    }

    public FetchStickersParams(Collection<String> collection, StickersUpdateOperation stickersUpdateOperation) {
        this.f3957a = ImmutableList.copyOf(collection);
        this.f3958b = stickersUpdateOperation;
    }

    public FetchStickersParams(Parcel parcel) {
        this.f3957a = ImmutableList.copyOf(parcel.readArrayList(Sticker.class.getClassLoader()));
        this.f3958b = StickersUpdateOperation.valueOf(parcel.readString());
    }

    public final ImmutableList<String> m4450a() {
        return this.f3957a;
    }

    public final StickersUpdateOperation m4451b() {
        return this.f3958b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f3957a);
        parcel.writeString(this.f3958b.toString());
    }
}
