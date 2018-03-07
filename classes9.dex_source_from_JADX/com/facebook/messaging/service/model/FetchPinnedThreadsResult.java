package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: country_alpha_two */
public class FetchPinnedThreadsResult implements Parcelable {
    public static final Creator<FetchPinnedThreadsResult> CREATOR = new C20221();
    public static final FetchPinnedThreadsResult f17099a = newBuilder().m17097e();
    public final long f17100b;
    public final ImmutableList<ThreadSummary> f17101c;
    public final boolean f17102d;
    public final long f17103e;

    /* compiled from: country_alpha_two */
    final class C20221 implements Creator<FetchPinnedThreadsResult> {
        C20221() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchPinnedThreadsResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchPinnedThreadsResult[i];
        }
    }

    public static FetchPinnedThreadsResultBuilder newBuilder() {
        return new FetchPinnedThreadsResultBuilder();
    }

    public FetchPinnedThreadsResult(FetchPinnedThreadsResultBuilder fetchPinnedThreadsResultBuilder) {
        this.f17101c = ImmutableList.copyOf(fetchPinnedThreadsResultBuilder.f17104a);
        this.f17102d = fetchPinnedThreadsResultBuilder.f17105b;
        this.f17103e = fetchPinnedThreadsResultBuilder.f17106c;
        this.f17100b = fetchPinnedThreadsResultBuilder.f17107d;
    }

    public FetchPinnedThreadsResult(Parcel parcel) {
        this.f17101c = ImmutableList.copyOf(parcel.readArrayList(ThreadSummary.class.getClassLoader()));
        this.f17102d = ParcelUtil.a(parcel);
        this.f17103e = parcel.readLong();
        this.f17100b = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f17101c);
        ParcelUtil.a(parcel, this.f17102d);
        parcel.writeLong(this.f17103e);
        parcel.writeLong(this.f17100b);
    }
}
