package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class zza {

    public class zza extends RuntimeException {
        public zza(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    public static ArrayList<String> m12201A(Parcel parcel, int i) {
        int D = m12204D(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(D + dataPosition);
        return createStringArrayList;
    }

    public static Parcel m12202B(Parcel parcel, int i) {
        int D = m12204D(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, D);
        parcel.setDataPosition(D + dataPosition);
        return obtain;
    }

    public static Parcel[] m12203C(Parcel parcel, int i) {
        int D = m12204D(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i2] = obtain;
                parcel.setDataPosition(readInt2 + dataPosition2);
            } else {
                parcelArr[i2] = null;
            }
        }
        parcel.setDataPosition(dataPosition + D);
        return parcelArr;
    }

    public static int m12204D(Parcel parcel, int i) {
        return (i & -65536) != -65536 ? (i >> 16) & 65535 : parcel.readInt();
    }

    public static int m12205a(int i) {
        return 65535 & i;
    }

    public static int m12206a(Parcel parcel) {
        return parcel.readInt();
    }

    public static <T extends Parcelable> T m12207a(Parcel parcel, int i, Creator<T> creator) {
        int D = m12204D(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(D + dataPosition);
        return parcelable;
    }

    public static void m12208a(Parcel parcel, int i) {
        parcel.setDataPosition(m12204D(parcel, i) + parcel.dataPosition());
    }

    private static void m12209a(Parcel parcel, int i, int i2) {
        int D = m12204D(parcel, i);
        if (D != i2) {
            throw new zza("Expected size " + i2 + " got " + D + " (0x" + Integer.toHexString(D) + ")", parcel);
        }
    }

    public static int m12210b(Parcel parcel) {
        int a = m12206a(parcel);
        int D = m12204D(parcel, a);
        int dataPosition = parcel.dataPosition();
        if (m12205a(a) != 20293) {
            throw new zza("Expected object header. Got 0x" + Integer.toHexString(a), parcel);
        }
        a = dataPosition + D;
        if (a >= dataPosition && a <= parcel.dataSize()) {
            return a;
        }
        throw new zza("Size read is invalid start=" + dataPosition + " end=" + a, parcel);
    }

    public static void m12211b(Parcel parcel, int i, int i2) {
        if (i != i2) {
            throw new zza("Expected size " + i2 + " got " + i + " (0x" + Integer.toHexString(i) + ")", parcel);
        }
    }

    public static boolean m12212b(Parcel parcel, int i) {
        m12209a(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static <T> T[] m12213b(Parcel parcel, int i, Creator<T> creator) {
        int D = m12204D(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        T[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(D + dataPosition);
        return createTypedArray;
    }

    public static byte m12214c(Parcel parcel, int i) {
        m12209a(parcel, i, 4);
        return (byte) parcel.readInt();
    }

    public static <T> ArrayList<T> m12215c(Parcel parcel, int i, Creator<T> creator) {
        int D = m12204D(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(D + dataPosition);
        return createTypedArrayList;
    }

    public static short m12216d(Parcel parcel, int i) {
        m12209a(parcel, i, 4);
        return (short) parcel.readInt();
    }

    public static int m12217e(Parcel parcel, int i) {
        m12209a(parcel, i, 4);
        return parcel.readInt();
    }

    public static long m12218g(Parcel parcel, int i) {
        m12209a(parcel, i, 8);
        return parcel.readLong();
    }

    public static Long m12219h(Parcel parcel, int i) {
        int D = m12204D(parcel, i);
        if (D == 0) {
            return null;
        }
        m12211b(parcel, D, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static BigInteger m12220i(Parcel parcel, int i) {
        int D = m12204D(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(D + dataPosition);
        return new BigInteger(createByteArray);
    }

    public static float m12221j(Parcel parcel, int i) {
        m12209a(parcel, i, 4);
        return parcel.readFloat();
    }

    public static double m12222l(Parcel parcel, int i) {
        m12209a(parcel, i, 8);
        return parcel.readDouble();
    }

    public static BigDecimal m12223m(Parcel parcel, int i) {
        int D = m12204D(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(D + dataPosition);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    public static String m12224n(Parcel parcel, int i) {
        int D = m12204D(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(D + dataPosition);
        return readString;
    }

    public static IBinder m12225o(Parcel parcel, int i) {
        int D = m12204D(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(D + dataPosition);
        return readStrongBinder;
    }

    public static Bundle m12226p(Parcel parcel, int i) {
        int D = m12204D(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(D + dataPosition);
        return readBundle;
    }

    public static byte[] m12227q(Parcel parcel, int i) {
        int D = m12204D(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(D + dataPosition);
        return createByteArray;
    }

    public static boolean[] m12228r(Parcel parcel, int i) {
        int D = m12204D(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(D + dataPosition);
        return createBooleanArray;
    }

    public static int[] m12229s(Parcel parcel, int i) {
        int D = m12204D(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(D + dataPosition);
        return createIntArray;
    }

    public static long[] m12230t(Parcel parcel, int i) {
        int D = m12204D(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(D + dataPosition);
        return createLongArray;
    }

    public static BigInteger[] m12231u(Parcel parcel, int i) {
        int D = m12204D(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            bigIntegerArr[i2] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + D);
        return bigIntegerArr;
    }

    public static float[] m12232v(Parcel parcel, int i) {
        int D = m12204D(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(D + dataPosition);
        return createFloatArray;
    }

    public static double[] m12233w(Parcel parcel, int i) {
        int D = m12204D(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(D + dataPosition);
        return createDoubleArray;
    }

    public static BigDecimal[] m12234x(Parcel parcel, int i) {
        int D = m12204D(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            byte[] createByteArray = parcel.createByteArray();
            bigDecimalArr[i2] = new BigDecimal(new BigInteger(createByteArray), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + D);
        return bigDecimalArr;
    }

    public static String[] m12235y(Parcel parcel, int i) {
        int D = m12204D(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(D + dataPosition);
        return createStringArray;
    }

    public static ArrayList<Integer> m12236z(Parcel parcel, int i) {
        int D = m12204D(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(dataPosition + D);
        return arrayList;
    }
}
