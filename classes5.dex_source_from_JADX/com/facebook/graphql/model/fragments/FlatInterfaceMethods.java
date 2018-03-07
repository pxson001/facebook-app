package com.facebook.graphql.model.fragments;

import android.os.Parcel;
import com.facebook.dracula.api.FlatImplementation;

@FlatImplementation
/* compiled from: eglCreatePbufferSurface */
public class FlatInterfaceMethods {
    static void m9584b(int i) {
        throw new IllegalArgumentException();
    }

    public static int m9581a(int i, int i2) {
        if (i == 0) {
            return 0;
        }
        throw new IllegalArgumentException();
    }

    public static void m9583a(int i, int i2, Parcel parcel) {
        if (i == 0) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            throw new IllegalArgumentException();
        }
    }

    public static int m9582a(Parcel parcel, int i) {
        int i2;
        if (parcel.readByte() != (byte) 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i2 == 0) {
            return 0;
        }
        throw new IllegalArgumentException();
    }
}
