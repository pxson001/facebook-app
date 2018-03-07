package com.facebook.stickers.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.stickers.model.Sticker;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.List;

/* compiled from: pwd */
public class FetchStickersResult implements Parcelable {
    public static final Creator<FetchStickersResult> CREATOR = new C01841();
    public final ImmutableList<Sticker> f4000a;

    /* compiled from: pwd */
    final class C01841 implements Creator<FetchStickersResult> {
        C01841() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchStickersResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchStickersResult[i];
        }
    }

    public FetchStickersResult(List<Sticker> list) {
        ImmutableList copyOf;
        if (list != null) {
            copyOf = ImmutableList.copyOf(list);
        } else {
            copyOf = RegularImmutableList.a;
        }
        this.f4000a = copyOf;
    }

    public FetchStickersResult(Parcel parcel) {
        this.f4000a = ImmutableList.copyOf(parcel.readArrayList(Sticker.class.getClassLoader()));
    }

    public final ImmutableList<Sticker> m4497a() {
        return this.f4000a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f4000a);
    }
}
