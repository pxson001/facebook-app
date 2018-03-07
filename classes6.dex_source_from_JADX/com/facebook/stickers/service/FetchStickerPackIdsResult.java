package com.facebook.stickers.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: editComment */
public class FetchStickerPackIdsResult implements Parcelable {
    public static final Creator<FetchStickerPackIdsResult> CREATOR = new C12021();
    public final ImmutableList<String> f16889a;

    /* compiled from: editComment */
    final class C12021 implements Creator<FetchStickerPackIdsResult> {
        C12021() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchStickerPackIdsResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchStickerPackIdsResult[i];
        }
    }

    public FetchStickerPackIdsResult(ImmutableList<String> immutableList) {
        this.f16889a = immutableList;
    }

    public FetchStickerPackIdsResult(Parcel parcel) {
        this.f16889a = ImmutableList.copyOf(parcel.readArrayList(String.class.getClassLoader()));
    }

    public final ImmutableList<String> m24608a() {
        return this.f16889a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f16889a);
    }
}
