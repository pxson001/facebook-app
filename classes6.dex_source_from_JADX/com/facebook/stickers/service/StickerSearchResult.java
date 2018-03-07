package com.facebook.stickers.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.stickers.model.Sticker;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.List;

/* compiled from: e52637ab9ecc4f51e2eb1875098c74fd */
public class StickerSearchResult implements Parcelable {
    public static final Creator<StickerSearchResult> CREATOR = new C12111();
    public final ImmutableList<Sticker> f16923a;

    /* compiled from: e52637ab9ecc4f51e2eb1875098c74fd */
    final class C12111 implements Creator<StickerSearchResult> {
        C12111() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new StickerSearchResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new StickerSearchResult[i];
        }
    }

    public StickerSearchResult(List<Sticker> list) {
        ImmutableList copyOf;
        if (list != null) {
            copyOf = ImmutableList.copyOf(list);
        } else {
            copyOf = RegularImmutableList.a;
        }
        this.f16923a = copyOf;
    }

    public StickerSearchResult(Parcel parcel) {
        this.f16923a = ImmutableList.copyOf(parcel.readArrayList(Sticker.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f16923a);
    }
}
