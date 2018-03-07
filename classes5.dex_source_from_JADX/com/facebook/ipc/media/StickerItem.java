package com.facebook.ipc.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.stickers.model.Sticker;
import com.google.common.base.Objects;
import java.util.Locale;

/* compiled from: THIN_FACEPILE */
public class StickerItem implements Parcelable {
    public static final Creator<StickerItem> CREATOR = new C13511();
    public Sticker f14092a;
    public final long f14093b;
    public final String f14094c;
    private final String f14095d;

    /* compiled from: THIN_FACEPILE */
    final class C13511 implements Creator<StickerItem> {
        C13511() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new StickerItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new StickerItem[i];
        }
    }

    /* compiled from: THIN_FACEPILE */
    public class Builder {
        public String f14088a;
        public String f14089b;
        public long f14090c;
        public Sticker f14091d;
    }

    public StickerItem(long j, String str, String str2) {
        this.f14093b = j;
        this.f14094c = str;
        this.f14095d = str2;
    }

    public String toString() {
        return String.format(Locale.US, "StickerItem(%d, %s, %s)", new Object[]{Long.valueOf(this.f14093b), this.f14094c, this.f14095d});
    }

    public boolean equals(Object obj) {
        return (obj instanceof StickerItem) && Objects.equal(((StickerItem) obj).f14094c, this.f14094c);
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f14094c});
    }

    public int describeContents() {
        return 0;
    }

    protected StickerItem(Parcel parcel) {
        this.f14093b = parcel.readLong();
        this.f14094c = parcel.readString();
        this.f14095d = parcel.readString();
        this.f14092a = (Sticker) parcel.readParcelable(Sticker.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f14093b);
        parcel.writeString(this.f14094c);
        parcel.writeString(this.f14095d);
        parcel.writeParcelable(this.f14092a, i);
    }
}
