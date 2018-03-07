package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.service.DataFreshnessParam;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: country_selected */
public class FetchPinnedThreadsParams implements Parcelable {
    public static final Creator<FetchPinnedThreadsParams> CREATOR = new C20211();
    public static final FetchPinnedThreadsParams f17094a = new FetchPinnedThreadsParamsBuilder().m17092c();
    public final DataFreshnessParam f17095b;
    public final long f17096c;

    /* compiled from: country_selected */
    final class C20211 implements Creator<FetchPinnedThreadsParams> {
        C20211() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchPinnedThreadsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchPinnedThreadsParams[i];
        }
    }

    public FetchPinnedThreadsParams(DataFreshnessParam dataFreshnessParam, long j) {
        this.f17095b = dataFreshnessParam;
        this.f17096c = j;
    }

    FetchPinnedThreadsParams(FetchPinnedThreadsParamsBuilder fetchPinnedThreadsParamsBuilder) {
        this.f17095b = fetchPinnedThreadsParamsBuilder.f17097a;
        this.f17096c = fetchPinnedThreadsParamsBuilder.f17098b;
    }

    public FetchPinnedThreadsParams(Parcel parcel) {
        this.f17095b = DataFreshnessParam.valueOf(parcel.readString());
        this.f17096c = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f17095b.toString());
        parcel.writeLong(this.f17096c);
    }
}
