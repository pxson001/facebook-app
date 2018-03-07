package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.messaging.model.threads.ThreadCriteria;
import com.google.common.base.Objects;

/* compiled from: conversion_pixels */
public class FetchThreadParams implements Parcelable {
    public static final Creator<FetchThreadParams> CREATOR = new C20291();
    public final ThreadCriteria f17155a;
    public final DataFreshnessParam f17156b;
    public final DataFreshnessParam f17157c;
    public final boolean f17158d;
    public final long f17159e;
    public final int f17160f;
    public final long f17161g;
    public final boolean f17162h;

    /* compiled from: conversion_pixels */
    final class C20291 implements Creator<FetchThreadParams> {
        C20291() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchThreadParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchThreadParams[i];
        }
    }

    FetchThreadParams(FetchThreadParamsBuilder fetchThreadParamsBuilder) {
        DataFreshnessParam dataFreshnessParam;
        this.f17155a = fetchThreadParamsBuilder.f17163a;
        this.f17156b = fetchThreadParamsBuilder.f17164b;
        if (fetchThreadParamsBuilder.f17165c == null) {
            dataFreshnessParam = fetchThreadParamsBuilder.f17164b;
        } else {
            dataFreshnessParam = fetchThreadParamsBuilder.f17165c;
        }
        this.f17157c = dataFreshnessParam;
        this.f17158d = fetchThreadParamsBuilder.f17167e;
        this.f17159e = fetchThreadParamsBuilder.f17166d;
        this.f17160f = fetchThreadParamsBuilder.f17168f;
        this.f17161g = fetchThreadParamsBuilder.f17169g;
        this.f17162h = fetchThreadParamsBuilder.f17170h;
    }

    public FetchThreadParams(Parcel parcel) {
        boolean z = true;
        this.f17155a = (ThreadCriteria) parcel.readParcelable(ThreadCriteria.class.getClassLoader());
        this.f17156b = DataFreshnessParam.valueOf(parcel.readString());
        this.f17157c = DataFreshnessParam.valueOf(parcel.readString());
        this.f17158d = parcel.readInt() != 0;
        this.f17159e = parcel.readLong();
        this.f17160f = parcel.readInt();
        this.f17161g = parcel.readLong();
        if (parcel.readInt() == 0) {
            z = false;
        }
        this.f17162h = z;
    }

    public static FetchThreadParamsBuilder newBuilder() {
        return new FetchThreadParamsBuilder();
    }

    public final ThreadCriteria m17130a() {
        return this.f17155a;
    }

    public final DataFreshnessParam m17131b() {
        return this.f17156b;
    }

    public final DataFreshnessParam m17132c() {
        return this.f17157c;
    }

    public final int m17133f() {
        return this.f17160f;
    }

    public final boolean m17134h() {
        return this.f17162h;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeParcelable(this.f17155a, i);
        parcel.writeString(this.f17156b.toString());
        parcel.writeString(this.f17157c.toString());
        parcel.writeInt(this.f17158d ? 1 : 0);
        parcel.writeLong(this.f17159e);
        parcel.writeInt(this.f17160f);
        parcel.writeLong(this.f17161g);
        if (!this.f17162h) {
            i2 = 0;
        }
        parcel.writeInt(i2);
    }

    public String toString() {
        return Objects.toStringHelper(FetchThreadParams.class).add("threadCriteria", this.f17155a).add("dataFreshness", this.f17156b).add("originalDataFreshness", this.f17157c).add("updateLastRead", this.f17158d).add("updateLastReadTimeActionId", this.f17159e).add("numToFetch", this.f17160f).add("sinceActionId", this.f17161g).add("shouldTraceFetch", this.f17162h).toString();
    }
}
