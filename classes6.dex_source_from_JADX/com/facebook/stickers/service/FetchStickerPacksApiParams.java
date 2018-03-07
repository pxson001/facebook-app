package com.facebook.stickers.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.StringUtil;
import javax.annotation.Nullable;

/* compiled from: edge-sgp-search */
public class FetchStickerPacksApiParams implements Parcelable {
    public static final Creator<FetchStickerPacksApiParams> CREATOR = new C12031();
    public final FetchStickerPacksParams f16894a;
    public final int f16895b;
    public final String f16896c;
    public final long f16897d;

    /* compiled from: edge-sgp-search */
    final class C12031 implements Creator<FetchStickerPacksApiParams> {
        C12031() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchStickerPacksApiParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchStickerPacksApiParams[i];
        }
    }

    /* compiled from: edge-sgp-search */
    public class Builder {
        private FetchStickerPacksParams f16890a;
        private int f16891b;
        private String f16892c;
        private long f16893d = 0;

        public Builder(FetchStickerPacksParams fetchStickerPacksParams) {
            this.f16890a = fetchStickerPacksParams;
        }

        public final Builder m24609a(long j) {
            this.f16893d = j;
            return this;
        }

        public final FetchStickerPacksApiParams m24610a() {
            return new FetchStickerPacksApiParams(this.f16890a, this.f16891b, this.f16892c, this.f16893d);
        }
    }

    private FetchStickerPacksApiParams(FetchStickerPacksParams fetchStickerPacksParams, int i, @Nullable String str, long j) {
        this.f16894a = fetchStickerPacksParams;
        this.f16895b = i;
        this.f16896c = str;
        this.f16897d = j;
    }

    public FetchStickerPacksApiParams(Parcel parcel) {
        this.f16894a = (FetchStickerPacksParams) parcel.readParcelable(FetchStickerPacksParams.class.getClassLoader());
        this.f16895b = parcel.readInt();
        this.f16896c = parcel.readString();
        this.f16897d = parcel.readLong();
    }

    public final FetchStickerPacksParams m24611a() {
        return this.f16894a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f16894a, 0);
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (this.f16894a != null) {
            hashCode = this.f16894a.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = ((hashCode * 31) + this.f16895b) * 31;
        if (this.f16896c != null) {
            i = this.f16896c.hashCode();
        }
        return ((hashCode + i) * 31) + ((int) (this.f16897d ^ (this.f16897d >>> 32)));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FetchStickerPacksApiParams)) {
            return false;
        }
        FetchStickerPacksApiParams fetchStickerPacksApiParams = (FetchStickerPacksApiParams) obj;
        if (this.f16894a.equals(fetchStickerPacksApiParams.f16894a) && this.f16895b == fetchStickerPacksApiParams.f16895b && StringUtil.a(this.f16896c, fetchStickerPacksApiParams.f16896c) && this.f16897d == fetchStickerPacksApiParams.f16897d) {
            return true;
        }
        return false;
    }
}
