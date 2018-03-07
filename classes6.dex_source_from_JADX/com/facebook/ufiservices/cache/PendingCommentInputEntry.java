package com.facebook.ufiservices.cache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.StickerItem;
import javax.annotation.Nullable;

/* compiled from: data12 */
public class PendingCommentInputEntry implements Parcelable {
    public static final Creator<PendingCommentInputEntry> CREATOR = new C13001();
    public final String f17971a;
    public final String f17972b;
    public final String f17973c;
    public final boolean f17974d;
    public final boolean f17975e;
    @Nullable
    public final MediaItem f17976f;
    @Nullable
    public final StickerItem f17977g;
    public final boolean f17978h;
    public final int f17979i;

    /* compiled from: data12 */
    final class C13001 implements Creator<PendingCommentInputEntry> {
        C13001() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PendingCommentInputEntry(parcel);
        }

        public final Object[] newArray(int i) {
            return new PendingCommentInputEntry[i];
        }
    }

    public PendingCommentInputEntry(String str, String str2, String str3, boolean z, boolean z2, @Nullable MediaItem mediaItem, @Nullable StickerItem stickerItem, boolean z3, int i) {
        this.f17971a = str;
        this.f17972b = str2;
        this.f17973c = str3;
        this.f17974d = z;
        this.f17975e = z2;
        this.f17976f = mediaItem;
        this.f17977g = stickerItem;
        this.f17978h = z3;
        this.f17979i = i;
    }

    public PendingCommentInputEntry(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f17971a = parcel.readString();
        this.f17972b = parcel.readString();
        this.f17973c = parcel.readString();
        this.f17974d = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17975e = z;
        this.f17976f = (MediaItem) parcel.readParcelable(PendingCommentInputEntry.class.getClassLoader());
        this.f17977g = (StickerItem) parcel.readParcelable(StickerItem.class.getClassLoader());
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f17978h = z2;
        this.f17979i = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.f17971a);
        parcel.writeString(this.f17972b);
        parcel.writeString(this.f17973c);
        parcel.writeByte((byte) (this.f17974d ? 1 : 0));
        if (this.f17975e) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeParcelable(this.f17976f, i);
        parcel.writeParcelable(this.f17977g, i);
        if (!this.f17978h) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeInt(this.f17979i);
    }
}
