package com.facebook.stickers.service;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: e82227271758f9756832355bdf788bb9 */
public class SaveStickerAssetParams implements Parcelable {
    public static final Creator<SaveStickerAssetParams> CREATOR = new C12091();
    public final String f16908a;
    public final String f16909b;
    public final Uri f16910c;

    /* compiled from: e82227271758f9756832355bdf788bb9 */
    final class C12091 implements Creator<SaveStickerAssetParams> {
        C12091() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SaveStickerAssetParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SaveStickerAssetParams[i];
        }
    }

    public SaveStickerAssetParams(String str, String str2, Uri uri) {
        this.f16908a = str;
        this.f16909b = str2;
        this.f16910c = uri;
    }

    public SaveStickerAssetParams(Parcel parcel) {
        this.f16908a = parcel.readString();
        this.f16909b = parcel.readString();
        this.f16910c = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f16908a);
        parcel.writeString(this.f16909b);
        parcel.writeParcelable(this.f16910c, i);
    }
}
