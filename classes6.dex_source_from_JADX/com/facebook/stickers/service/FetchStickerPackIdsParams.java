package com.facebook.stickers.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.stickers.model.StickerPackType;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: editPhotoAlbum */
public class FetchStickerPackIdsParams implements Parcelable {
    public static final Creator<FetchStickerPackIdsParams> CREATOR = new C12011();
    public final StickerPackType f16883a;
    public long f16884b;
    public boolean f16885c;

    /* compiled from: editPhotoAlbum */
    final class C12011 implements Creator<FetchStickerPackIdsParams> {
        C12011() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchStickerPackIdsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchStickerPackIdsParams[i];
        }
    }

    public FetchStickerPackIdsParams(FetchStickerPackIdsParamsBuilder fetchStickerPackIdsParamsBuilder) {
        this.f16883a = fetchStickerPackIdsParamsBuilder.f16886a;
        this.f16884b = fetchStickerPackIdsParamsBuilder.f16887b;
        this.f16885c = fetchStickerPackIdsParamsBuilder.f16888c;
    }

    public FetchStickerPackIdsParams(Parcel parcel) {
        this.f16883a = StickerPackType.valueOf(parcel.readString());
        this.f16884b = parcel.readLong();
        this.f16885c = parcel.readInt() != 0;
    }

    public static FetchStickerPackIdsParamsBuilder newBuilder() {
        return new FetchStickerPackIdsParamsBuilder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f16883a.toString());
        parcel.writeLong(this.f16884b);
        parcel.writeInt(this.f16885c ? 1 : 0);
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (this.f16883a != null) {
            hashCode = this.f16883a.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = ((hashCode * 31) + Long.valueOf(this.f16884b).hashCode()) * 31;
        if (this.f16885c) {
            i = 1;
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FetchStickerPackIdsParams)) {
            return false;
        }
        FetchStickerPackIdsParams fetchStickerPackIdsParams = (FetchStickerPackIdsParams) obj;
        if (this.f16883a == fetchStickerPackIdsParams.f16883a && this.f16884b == fetchStickerPackIdsParams.f16884b && this.f16885c == fetchStickerPackIdsParams.f16885c) {
            return true;
        }
        return false;
    }
}
