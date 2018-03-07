package com.facebook.stickers.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.stickers.model.StickerPack;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: qe_ */
public class FetchStickerPacksResult implements Parcelable {
    public static final Creator<FetchStickerPacksResult> CREATOR = new C01811();
    public static final FetchStickerPacksResult f3954a = new FetchStickerPacksResult(null);
    public final Optional<ImmutableList<StickerPack>> f3955b;
    private final Optional<ImmutableMap<String, Availability>> f3956c;

    /* compiled from: qe_ */
    final class C01811 implements Creator<FetchStickerPacksResult> {
        C01811() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchStickerPacksResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchStickerPacksResult[i];
        }
    }

    public FetchStickerPacksResult(@Nullable List<StickerPack> list) {
        this(list, null);
    }

    public FetchStickerPacksResult(@Nullable List<StickerPack> list, @Nullable Map<String, Availability> map) {
        Optional of;
        if (list != null) {
            of = Optional.of(ImmutableList.copyOf(list));
        } else {
            of = Absent.INSTANCE;
        }
        this.f3955b = of;
        if (map != null) {
            of = Optional.of(ImmutableMap.copyOf(map));
        } else {
            of = Absent.INSTANCE;
        }
        this.f3956c = of;
    }

    public FetchStickerPacksResult(Parcel parcel) {
        Collection readArrayList = parcel.readArrayList(StickerPack.class.getClassLoader());
        if (readArrayList != null) {
            this.f3955b = Optional.of(ImmutableList.copyOf(readArrayList));
        } else {
            this.f3955b = Absent.INSTANCE;
        }
        Map readHashMap = parcel.readHashMap(Availability.class.getClassLoader());
        if (readHashMap != null) {
            Builder builder = ImmutableMap.builder();
            builder.a(readHashMap);
            this.f3956c = Optional.of(builder.b());
            return;
        }
        this.f3956c = Absent.INSTANCE;
    }

    public final Optional<ImmutableList<StickerPack>> m4447a() {
        return this.f3955b;
    }

    public final Optional<ImmutableMap<String, Availability>> m4449b() {
        return this.f3956c;
    }

    public final Optional<Availability> m4448a(StickerPack stickerPack) {
        String str = stickerPack.a;
        if (this.f3956c.isPresent() && ((ImmutableMap) this.f3956c.get()).containsKey(str)) {
            return Optional.of(((ImmutableMap) this.f3956c.get()).get(str));
        }
        return Absent.INSTANCE;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList((List) this.f3955b.orNull());
        parcel.writeMap((Map) this.f3956c.orNull());
    }
}
