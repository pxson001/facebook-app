package com.facebook.stickers.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.stickers.model.StickerPack;
import com.google.common.collect.ImmutableList;
import java.util.Collection;

/* compiled from: ecd488a2f42f508823b0d485437de4d6 */
public class FetchStickerPacksByIdParams implements Parcelable {
    public static final Creator<FetchStickerPacksByIdParams> CREATOR = new C12041();
    public final ImmutableList<String> f16898a;

    /* compiled from: ecd488a2f42f508823b0d485437de4d6 */
    final class C12041 implements Creator<FetchStickerPacksByIdParams> {
        C12041() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchStickerPacksByIdParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchStickerPacksByIdParams[i];
        }
    }

    public FetchStickerPacksByIdParams(Collection<String> collection) {
        this.f16898a = ImmutableList.copyOf(collection);
    }

    public FetchStickerPacksByIdParams(Parcel parcel) {
        this.f16898a = ImmutableList.copyOf(parcel.readArrayList(StickerPack.class.getClassLoader()));
    }

    public final ImmutableList<String> m24612a() {
        return this.f16898a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f16898a);
    }
}
