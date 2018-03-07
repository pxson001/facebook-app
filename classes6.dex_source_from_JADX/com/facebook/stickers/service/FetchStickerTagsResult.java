package com.facebook.stickers.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.stickers.model.StickerTag;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.List;

/* compiled from: eba64729e00ff99e1bc02d464baed5de */
public class FetchStickerTagsResult implements Parcelable {
    public static final Creator<FetchStickerTagsResult> CREATOR = new C12061();
    public final ImmutableList<StickerTag> f16902a;

    /* compiled from: eba64729e00ff99e1bc02d464baed5de */
    final class C12061 implements Creator<FetchStickerTagsResult> {
        C12061() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchStickerTagsResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchStickerTagsResult[i];
        }
    }

    public FetchStickerTagsResult(List<StickerTag> list) {
        ImmutableList copyOf;
        if (list != null) {
            copyOf = ImmutableList.copyOf(list);
        } else {
            copyOf = RegularImmutableList.a;
        }
        this.f16902a = copyOf;
    }

    public FetchStickerTagsResult(Parcel parcel) {
        this.f16902a = ImmutableList.copyOf(parcel.readArrayList(StickerTag.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f16902a);
    }
}
