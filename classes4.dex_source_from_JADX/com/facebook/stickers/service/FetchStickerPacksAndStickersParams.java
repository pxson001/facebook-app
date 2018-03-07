package com.facebook.stickers.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.stickers.model.StickerPackType;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: reactors */
public class FetchStickerPacksAndStickersParams implements Parcelable {
    public static final Creator<FetchStickerPacksAndStickersParams> CREATOR = new C01761();
    public final StickerPackType f3766a;
    public final DataFreshnessParam f3767b;

    /* compiled from: reactors */
    final class C01761 implements Creator<FetchStickerPacksAndStickersParams> {
        C01761() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchStickerPacksAndStickersParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchStickerPacksAndStickersParams[i];
        }
    }

    public FetchStickerPacksAndStickersParams(StickerPackType stickerPackType, DataFreshnessParam dataFreshnessParam) {
        this.f3766a = stickerPackType;
        Preconditions.checkArgument(dataFreshnessParam == DataFreshnessParam.DO_NOT_CHECK_SERVER, "only supports local data fetch.");
        this.f3767b = dataFreshnessParam;
    }

    public FetchStickerPacksAndStickersParams(Parcel parcel) {
        this.f3766a = StickerPackType.valueOf(parcel.readString());
        this.f3767b = DataFreshnessParam.valueOf(parcel.readString());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3766a.toString());
        parcel.writeString(this.f3767b.toString());
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (this.f3766a != null) {
            hashCode = this.f3766a.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode *= 31;
        if (this.f3767b != null) {
            i = this.f3767b.hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FetchStickerPacksAndStickersParams)) {
            return false;
        }
        FetchStickerPacksAndStickersParams fetchStickerPacksAndStickersParams = (FetchStickerPacksAndStickersParams) obj;
        if (this.f3766a == fetchStickerPacksAndStickersParams.f3766a && this.f3767b == fetchStickerPacksAndStickersParams.f3767b) {
            return true;
        }
        return false;
    }
}
