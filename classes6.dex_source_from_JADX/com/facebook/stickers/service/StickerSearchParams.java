package com.facebook.stickers.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.calls.InterfaceInputInterface;

/* compiled from: e5a64958a55327c8ddf04a24e039a18d */
public class StickerSearchParams implements Parcelable {
    public static final Creator<StickerSearchParams> CREATOR = new C12101();
    public final String f16921a;
    public final InterfaceInputInterface f16922b;

    /* compiled from: e5a64958a55327c8ddf04a24e039a18d */
    final class C12101 implements Creator<StickerSearchParams> {
        C12101() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new StickerSearchParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new StickerSearchParams[i];
        }
    }

    public StickerSearchParams(String str, InterfaceInputInterface interfaceInputInterface) {
        this.f16921a = str;
        this.f16922b = interfaceInputInterface;
    }

    public StickerSearchParams(Parcel parcel) {
        this.f16921a = parcel.readString();
        this.f16922b = InterfaceInputInterface.valueOf(parcel.readString());
    }

    public final String m24620a() {
        return this.f16921a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f16921a);
        parcel.writeString(this.f16922b.name());
    }
}
