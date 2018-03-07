package com.facebook.stickers.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: sendSucceeded */
public class StickerTag implements Parcelable {
    public static final Creator<StickerTag> CREATOR = new C03021();
    public final String f4999a;
    public final String f5000b;
    public final String f5001c;
    private final boolean f5002d;
    public final int f5003e;
    public final String f5004f;

    /* compiled from: sendSucceeded */
    final class C03021 implements Creator<StickerTag> {
        C03021() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new StickerTag(parcel);
        }

        public final Object[] newArray(int i) {
            return new StickerTag[i];
        }
    }

    StickerTag(String str, String str2, String str3, boolean z, int i, String str4) {
        this.f4999a = str;
        this.f5000b = str2;
        this.f5001c = str3;
        this.f5002d = z;
        this.f5003e = i;
        this.f5004f = str4;
    }

    public static StickerTagBuilder newBuilder() {
        return new StickerTagBuilder();
    }

    public StickerTag(Parcel parcel) {
        this.f4999a = parcel.readString();
        this.f5000b = parcel.readString();
        this.f5001c = parcel.readString();
        this.f5002d = parcel.readInt() > 0;
        this.f5003e = parcel.readInt();
        this.f5004f = parcel.readString();
    }

    public final String m7757a() {
        return this.f5000b;
    }

    public final String m7758b() {
        return this.f4999a;
    }

    public final String m7759c() {
        return this.f5001c;
    }

    public final boolean m7760d() {
        return this.f5002d;
    }

    public final int m7761e() {
        return this.f5003e;
    }

    public final String m7762f() {
        return this.f5004f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4999a);
        parcel.writeString(this.f5000b);
        parcel.writeString(this.f5001c);
        parcel.writeInt(this.f5002d ? 1 : 0);
        parcel.writeInt(this.f5003e);
        parcel.writeString(this.f5004f);
    }
}
