package com.facebook.stickers.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.stickers.model.StickerInterface;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collection;

/* compiled from: earlier_message_from_thread_failed */
public class FetchTaggedStickersParams implements Parcelable {
    public static final Creator<FetchTaggedStickersParams> CREATOR = new C12071();
    public final ImmutableList<String> f16904a;
    public final FilterType f16905b;
    public final StickerInterface f16906c;

    /* compiled from: earlier_message_from_thread_failed */
    final class C12071 implements Creator<FetchTaggedStickersParams> {
        C12071() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchTaggedStickersParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchTaggedStickersParams[i];
        }
    }

    /* compiled from: earlier_message_from_thread_failed */
    public enum FilterType {
        ALL_STICKERS,
        TRAY_STICKERS,
        AVAILABLE_STICKERS
    }

    public FetchTaggedStickersParams(ImmutableList<String> immutableList, FilterType filterType, StickerInterface stickerInterface) {
        this.f16904a = immutableList;
        this.f16905b = filterType;
        this.f16906c = stickerInterface;
    }

    public FetchTaggedStickersParams(Parcel parcel) {
        Collection a = Lists.a();
        parcel.readStringList(a);
        this.f16904a = ImmutableList.copyOf(a);
        this.f16905b = FilterType.valueOf(parcel.readString());
        this.f16906c = StickerInterface.valueOf(parcel.readString());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f16904a);
        parcel.writeString(this.f16905b.toString());
        parcel.writeString(this.f16906c.toString());
    }
}
