package com.facebook.ui.emoji.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: friending_block_user */
public final class Emoji implements Parcelable {
    public static final Creator<Emoji> CREATOR = new C09331();
    public final int f23123a;
    public final int f23124b;
    public final int f23125c;
    public final int f23126d;
    @Nullable
    public final ImmutableList<Integer> f23127e;

    /* compiled from: friending_block_user */
    final class C09331 implements Creator<Emoji> {
        C09331() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new Emoji(parcel);
        }

        public final Object[] newArray(int i) {
            return new Emoji[i];
        }
    }

    public Emoji(int i, int i2) {
        this.f23123a = i;
        this.f23124b = i2;
        this.f23125c = 0;
        this.f23126d = 0;
        this.f23127e = null;
    }

    public Emoji(int i, int i2, int i3) {
        this.f23123a = i;
        this.f23124b = i2;
        this.f23125c = i3;
        this.f23126d = 0;
        this.f23127e = null;
    }

    public Emoji(int i, int i2, int i3, int i4) {
        this.f23123a = i;
        this.f23124b = i2;
        this.f23125c = i3;
        this.f23126d = i4;
        this.f23127e = null;
    }

    public Emoji(int i, int i2, int i3, List<Integer> list) {
        this.f23123a = i;
        this.f23124b = i2;
        this.f23125c = i3;
        this.f23127e = ImmutableList.copyOf((Collection) list);
        this.f23126d = 0;
    }

    public Emoji(Parcel parcel) {
        this.f23123a = parcel.readInt();
        this.f23124b = parcel.readInt();
        this.f23125c = parcel.readInt();
        this.f23126d = parcel.readInt();
        Collection readArrayList = parcel.readArrayList(Integer.class.getClassLoader());
        this.f23127e = readArrayList == null ? null : ImmutableList.copyOf(readArrayList);
    }

    public final String m31236f() {
        if (this.f23125c <= 0) {
            return new String(Character.toChars(this.f23124b));
        }
        int[] iArr;
        if (this.f23127e == null) {
            iArr = new int[]{this.f23124b, this.f23125c};
        } else {
            int[] iArr2 = new int[(this.f23127e.size() + 2)];
            iArr2[0] = this.f23124b;
            iArr2[1] = this.f23125c;
            for (int i = 0; i < this.f23127e.size(); i++) {
                iArr2[i + 2] = ((Integer) this.f23127e.get(i)).intValue();
            }
            iArr = iArr2;
        }
        return new String(iArr, 0, iArr.length);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(11);
        stringBuilder.append(Integer.toHexString(this.f23124b));
        if (this.f23125c != 0) {
            stringBuilder.append('_');
            stringBuilder.append(Integer.toHexString(this.f23125c));
        }
        if (this.f23127e != null) {
            int size = this.f23127e.size();
            for (int i = 0; i < size; i++) {
                Integer num = (Integer) this.f23127e.get(i);
                stringBuilder.append('_');
                stringBuilder.append(Integer.toHexString(num.intValue()));
            }
        }
        return stringBuilder.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Emoji)) {
            return false;
        }
        Emoji emoji = (Emoji) obj;
        if (this.f23123a == emoji.f23123a && this.f23124b == emoji.f23124b && this.f23125c == emoji.f23125c && Objects.equal(this.f23127e, emoji.f23127e)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = (((this.f23123a * 31) + this.f23124b) * 31) + this.f23125c;
        if (this.f23127e != null) {
            return (i * 31) + this.f23127e.hashCode();
        }
        return i;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f23123a);
        parcel.writeInt(this.f23124b);
        parcel.writeInt(this.f23125c);
        parcel.writeInt(this.f23126d);
        parcel.writeList(this.f23127e);
    }

    public final int m31237g() {
        int charCount = Character.charCount(this.f23124b);
        if (this.f23125c != 0) {
            charCount += Character.charCount(this.f23125c);
        }
        if (this.f23127e == null) {
            return charCount;
        }
        int i = charCount;
        for (int i2 = 0; i2 < this.f23127e.size(); i2++) {
            i += Character.charCount(((Integer) this.f23127e.get(i2)).intValue());
        }
        return i;
    }
}
