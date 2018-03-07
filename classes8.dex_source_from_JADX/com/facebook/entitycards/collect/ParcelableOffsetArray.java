package com.facebook.entitycards.collect;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Preconditions;

/* compiled from: includeFontPadding */
public class ParcelableOffsetArray implements Parcelable {
    public static final Creator<ParcelableOffsetArray> CREATOR = new C11681();
    private final int f10903a;
    private final String[] f10904b;

    /* compiled from: includeFontPadding */
    final class C11681 implements Creator<ParcelableOffsetArray> {
        C11681() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ParcelableOffsetArray(parcel);
        }

        public final Object[] newArray(int i) {
            return new ParcelableOffsetArray[i];
        }
    }

    public ParcelableOffsetArray(ImmutableOffsetArray<String> immutableOffsetArray) {
        Preconditions.checkNotNull(immutableOffsetArray);
        this.f10904b = new String[immutableOffsetArray.m12838b()];
        int i = 0;
        for (int i2 = 0; i2 < immutableOffsetArray.m12838b(); i2++) {
            int a = immutableOffsetArray.m12835a(i2);
            String str = (String) immutableOffsetArray.m12839b(i2);
            if (i2 == 0) {
                i = a;
            }
            this.f10904b[i2] = str;
        }
        this.f10903a = i;
    }

    public ParcelableOffsetArray(Parcel parcel) {
        this.f10903a = parcel.readInt();
        this.f10904b = parcel.createStringArray();
    }

    public final ImmutableOffsetArray<String> m12847a() {
        OffsetArray immutableOffsetArray = new ImmutableOffsetArray(this.f10903a);
        for (int i = 0; i < this.f10904b.length; i++) {
            immutableOffsetArray.mo771a(this.f10903a + i, this.f10904b[i]);
        }
        immutableOffsetArray.m12844a();
        return immutableOffsetArray;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f10903a);
        parcel.writeStringArray(this.f10904b);
    }
}
