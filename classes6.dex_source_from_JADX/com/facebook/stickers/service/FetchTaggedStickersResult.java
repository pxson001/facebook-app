package com.facebook.stickers.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.stickers.model.Sticker;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;

/* compiled from: e94872c575928bd1c08728c46a96aec8 */
public class FetchTaggedStickersResult implements Parcelable {
    public static final Creator<FetchTaggedStickersResult> CREATOR = new C12081();
    public final Map<String, ImmutableList<Sticker>> f16907a;

    /* compiled from: e94872c575928bd1c08728c46a96aec8 */
    final class C12081 implements Creator<FetchTaggedStickersResult> {
        C12081() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchTaggedStickersResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchTaggedStickersResult[i];
        }
    }

    public FetchTaggedStickersResult(Map<String, ImmutableList<Sticker>> map) {
        this.f16907a = map;
    }

    public FetchTaggedStickersResult(Parcel parcel) {
        this.f16907a = Maps.c();
        for (int readInt = parcel.readInt(); readInt > 0; readInt--) {
            this.f16907a.put(parcel.readString(), ImmutableList.copyOf(parcel.readArrayList(Sticker.class.getClassLoader())));
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f16907a.keySet().size());
        for (String str : this.f16907a.keySet()) {
            parcel.writeString(str);
            parcel.writeList((List) this.f16907a.get(str));
        }
    }
}
