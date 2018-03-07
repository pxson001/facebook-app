package com.facebook.friendsharing.souvenirs.models;

import android.os.Parcel;
import com.facebook.friendsharing.souvenirs.models.SouvenirItem.Type;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: ROTATED_CW */
public class SouvenirItemList {
    public static void m26167a(ImmutableList<SouvenirItem> immutableList, Parcel parcel, int i) {
        parcel.writeInt(immutableList.size());
        int size = immutableList.size();
        for (int i2 = 0; i2 < size; i2++) {
            SouvenirItem souvenirItem = (SouvenirItem) immutableList.get(i2);
            parcel.writeString(souvenirItem.hw_().toString());
            parcel.writeParcelable(souvenirItem, i);
        }
    }

    public static ImmutableList<SouvenirItem> m26166a(Parcel parcel) {
        int readInt = parcel.readInt();
        Builder builder = new Builder();
        for (int i = 0; i < readInt; i++) {
            ClassLoader classLoader;
            Type valueOf = Type.valueOf(parcel.readString());
            switch (valueOf) {
                case Photo:
                    classLoader = SouvenirPhotoItem.class.getClassLoader();
                    break;
                case Video:
                    classLoader = SouvenirVideoItem.class.getClassLoader();
                    break;
                case Burst:
                    classLoader = SouvenirBurstItem.class.getClassLoader();
                    break;
                default:
                    throw new IllegalArgumentException("readList: invalid type " + valueOf);
            }
            builder.c((SouvenirItem) parcel.readParcelable(classLoader));
        }
        return builder.b();
    }
}
