package com.facebook.stickers.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.model.StickerPack;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

/* compiled from: push_url */
public class FetchStickerPacksAndStickersResult implements Parcelable {
    public static final Creator<FetchStickerPacksAndStickersResult> CREATOR = new C01851();
    public static final FetchStickerPacksAndStickersResult f4001a = new FetchStickerPacksAndStickersResult(null, null);
    public final ImmutableList<StickerPack> f4002b;
    public final ImmutableMap<String, ImmutableList<Sticker>> f4003c;

    /* compiled from: push_url */
    final class C01851 implements Creator<FetchStickerPacksAndStickersResult> {
        C01851() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchStickerPacksAndStickersResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchStickerPacksAndStickersResult[i];
        }
    }

    public FetchStickerPacksAndStickersResult(@Nullable List<StickerPack> list, @Nullable ImmutableMap<String, ImmutableList<Sticker>> immutableMap) {
        ImmutableList copyOf;
        ImmutableMap copyOf2;
        if (list != null) {
            copyOf = ImmutableList.copyOf(list);
        } else {
            copyOf = RegularImmutableList.a;
        }
        this.f4002b = copyOf;
        if (immutableMap != null) {
            copyOf2 = ImmutableMap.copyOf(immutableMap);
        } else {
            copyOf2 = RegularImmutableBiMap.a;
        }
        this.f4003c = copyOf2;
    }

    public FetchStickerPacksAndStickersResult(Parcel parcel) {
        this.f4002b = ImmutableList.copyOf(parcel.readArrayList(StickerPack.class.getClassLoader()));
        Map readHashMap = parcel.readHashMap(Sticker.class.getClassLoader());
        Builder builder = ImmutableMap.builder();
        for (Entry entry : readHashMap.entrySet()) {
            builder.b(entry.getKey(), ImmutableList.copyOf((Collection) entry.getValue()));
        }
        this.f4003c = builder.b();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f4002b);
        parcel.writeMap(this.f4003c);
    }
}
