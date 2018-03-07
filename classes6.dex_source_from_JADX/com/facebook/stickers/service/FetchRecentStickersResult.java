package com.facebook.stickers.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.stickers.model.Sticker;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* compiled from: editPhotoLocationParams */
public class FetchRecentStickersResult implements Parcelable {
    public static final Creator<FetchRecentStickersResult> CREATOR = new C12001();
    public final ImmutableList<Sticker> f16881a;

    /* compiled from: editPhotoLocationParams */
    final class C12001 implements Creator<FetchRecentStickersResult> {
        C12001() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchRecentStickersResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchRecentStickersResult[i];
        }
    }

    public FetchRecentStickersResult(List<Sticker> list) {
        this.f16881a = ImmutableList.copyOf(list);
    }

    public FetchRecentStickersResult(Parcel parcel) {
        this.f16881a = ImmutableList.copyOf(parcel.readArrayList(Sticker.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f16881a);
    }
}
