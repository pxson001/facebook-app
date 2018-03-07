package com.facebook.stickers.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: send_stream_interrupted_interval_in_seconds */
public class StickerPack implements Parcelable {
    public static final Creator<StickerPack> CREATOR = new C03011();
    public final String f4955a;
    public final String f4956b;
    public final String f4957c;
    public final String f4958d;
    public final Uri f4959e;
    @Nullable
    public final Uri f4960f;
    public final Uri f4961g;
    public final Uri f4962h;
    public final int f4963i;
    private final Long f4964j;
    public final boolean f4965k;
    public final boolean f4966l;
    public final boolean f4967m;
    public final boolean f4968n;
    public final boolean f4969o;
    public final boolean f4970p;
    public final boolean f4971q;
    public final boolean f4972r;
    public final ImmutableList<String> f4973s;
    public final ImmutableList<String> f4974t;
    public final boolean f4975u;
    public final boolean f4976v;

    /* compiled from: send_stream_interrupted_interval_in_seconds */
    final class C03011 implements Creator<StickerPack> {
        C03011() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new StickerPack(parcel);
        }

        public final Object[] newArray(int i) {
            return new StickerPack[i];
        }
    }

    public StickerPack(StickerPackBuilder stickerPackBuilder) {
        this.f4955a = stickerPackBuilder.f4977a;
        this.f4956b = stickerPackBuilder.f4978b;
        this.f4957c = stickerPackBuilder.f4979c;
        this.f4958d = stickerPackBuilder.f4980d;
        this.f4959e = stickerPackBuilder.f4981e;
        this.f4960f = stickerPackBuilder.f4982f;
        this.f4961g = stickerPackBuilder.f4983g;
        this.f4962h = stickerPackBuilder.f4984h;
        this.f4963i = stickerPackBuilder.f4985i;
        this.f4964j = Long.valueOf(stickerPackBuilder.f4986j);
        this.f4965k = stickerPackBuilder.f4987k;
        this.f4966l = stickerPackBuilder.f4988l;
        this.f4967m = stickerPackBuilder.f4989m;
        this.f4968n = stickerPackBuilder.f4990n;
        this.f4969o = stickerPackBuilder.f4991o;
        this.f4970p = stickerPackBuilder.f4992p;
        this.f4971q = stickerPackBuilder.f4993q;
        this.f4972r = stickerPackBuilder.f4994r;
        this.f4973s = ImmutableList.copyOf(stickerPackBuilder.f4995s);
        this.f4974t = ImmutableList.copyOf(stickerPackBuilder.f4996t);
        this.f4975u = stickerPackBuilder.f4997u;
        this.f4976v = stickerPackBuilder.f4998v;
    }

    public StickerPack(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f4955a = parcel.readString();
        this.f4956b = parcel.readString();
        this.f4957c = parcel.readString();
        this.f4958d = parcel.readString();
        this.f4959e = Uri.parse(parcel.readString());
        String readString = parcel.readString();
        this.f4960f = Strings.isNullOrEmpty(readString) ? null : Uri.parse(readString);
        this.f4961g = Uri.parse(parcel.readString());
        this.f4962h = Uri.parse(parcel.readString());
        this.f4963i = parcel.readInt();
        this.f4964j = Long.valueOf(parcel.readLong());
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f4965k = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f4966l = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f4967m = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f4968n = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f4969o = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f4970p = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f4971q = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f4972r = z;
        this.f4973s = ImmutableList.copyOf(parcel.createStringArrayList());
        this.f4974t = ImmutableList.copyOf(parcel.createStringArrayList());
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f4975u = z;
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.f4976v = z2;
    }

    public final String m7724a() {
        return this.f4955a;
    }

    public final String m7726b() {
        return this.f4956b;
    }

    public final String m7727c() {
        return this.f4957c;
    }

    public final String m7728d() {
        return this.f4958d;
    }

    public final Uri m7729e() {
        return this.f4959e;
    }

    @Nullable
    public final Uri m7730f() {
        return this.f4960f;
    }

    public final int m7731i() {
        return this.f4963i;
    }

    public final long m7732j() {
        return this.f4964j.longValue();
    }

    public final boolean m7733s() {
        return this.f4972r;
    }

    public final boolean m7725a(StickerInterface stickerInterface) {
        if (stickerInterface != null && stickerInterface == StickerInterface.COMPOSER && !this.f4968n) {
            return false;
        }
        if (stickerInterface == StickerInterface.SMS) {
            return this.f4976v;
        }
        if (stickerInterface == null) {
            return false;
        }
        if (stickerInterface == StickerInterface.MESSENGER || !this.f4975u) {
            return true;
        }
        return false;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.f4955a);
        parcel.writeString(this.f4956b);
        parcel.writeString(this.f4957c);
        parcel.writeString(this.f4958d);
        parcel.writeString(this.f4959e.toString());
        parcel.writeString(this.f4960f == null ? null : this.f4960f.toString());
        parcel.writeString(this.f4961g.toString());
        parcel.writeString(this.f4962h.toString());
        parcel.writeInt(this.f4963i);
        parcel.writeLong(this.f4964j.longValue());
        if (this.f4965k) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f4966l) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f4967m) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f4968n) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f4969o) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f4970p) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f4971q) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f4972r) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeStringList(this.f4973s);
        parcel.writeStringList(this.f4974t);
        if (this.f4975u) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.f4976v) {
            i3 = 0;
        }
        parcel.writeInt(i3);
    }
}
