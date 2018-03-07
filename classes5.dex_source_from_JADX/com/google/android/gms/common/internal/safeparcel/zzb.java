package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class zzb {
    public static int m12237a(Parcel parcel) {
        return m12255b(parcel, 20293);
    }

    public static void m12238a(Parcel parcel, int i, byte b) {
        m12256b(parcel, i, 4);
        parcel.writeInt(b);
    }

    public static void m12239a(Parcel parcel, int i, double d) {
        m12256b(parcel, i, 8);
        parcel.writeDouble(d);
    }

    public static void m12240a(Parcel parcel, int i, float f) {
        m12256b(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void m12241a(Parcel parcel, int i, int i2) {
        m12256b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void m12242a(Parcel parcel, int i, long j) {
        m12256b(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void m12243a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int b = m12255b(parcel, i);
            parcel.writeBundle(bundle);
            m12258c(parcel, b);
        } else if (z) {
            m12256b(parcel, i, 0);
        }
    }

    public static void m12244a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int b = m12255b(parcel, i);
            parcel.writeStrongBinder(iBinder);
            m12258c(parcel, b);
        } else if (z) {
            m12256b(parcel, i, 0);
        }
    }

    public static void m12245a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int b = m12255b(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            m12258c(parcel, b);
        } else if (z) {
            m12256b(parcel, i, 0);
        }
    }

    public static void m12246a(Parcel parcel, int i, Long l, boolean z) {
        if (l != null) {
            m12256b(parcel, i, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            m12256b(parcel, i, 0);
        }
    }

    public static void m12247a(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int b = m12255b(parcel, i);
            parcel.writeString(str);
            m12258c(parcel, b);
        } else if (z) {
            m12256b(parcel, i, 0);
        }
    }

    public static void m12248a(Parcel parcel, int i, List<Integer> list, boolean z) {
        if (list != null) {
            int b = m12255b(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(((Integer) list.get(i2)).intValue());
            }
            m12258c(parcel, b);
        } else if (z) {
            m12256b(parcel, i, 0);
        }
    }

    public static void m12249a(Parcel parcel, int i, boolean z) {
        m12256b(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void m12250a(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr != null) {
            int b = m12255b(parcel, i);
            parcel.writeByteArray(bArr);
            m12258c(parcel, b);
        } else if (z) {
            m12256b(parcel, i, 0);
        }
    }

    public static void m12251a(Parcel parcel, int i, int[] iArr, boolean z) {
        if (iArr != null) {
            int b = m12255b(parcel, i);
            parcel.writeIntArray(iArr);
            m12258c(parcel, b);
        } else if (z) {
            m12256b(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void m12252a(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int b = m12255b(parcel, i);
            parcel.writeInt(r3);
            for (Parcelable parcelable : tArr) {
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    m12254a(parcel, parcelable, i2);
                }
            }
            m12258c(parcel, b);
        } else if (z) {
            m12256b(parcel, i, 0);
        }
    }

    public static void m12253a(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr != null) {
            int b = m12255b(parcel, i);
            parcel.writeStringArray(strArr);
            m12258c(parcel, b);
        } else if (z) {
            m12256b(parcel, i, 0);
        }
    }

    private static <T extends Parcelable> void m12254a(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    public static int m12255b(Parcel parcel, int i) {
        parcel.writeInt(-65536 | i);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void m12256b(Parcel parcel, int i, int i2) {
        if (i2 >= 65535) {
            parcel.writeInt(-65536 | i);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt((i2 << 16) | i);
    }

    public static void m12257b(Parcel parcel, int i, List<String> list, boolean z) {
        if (list != null) {
            int b = m12255b(parcel, i);
            parcel.writeStringList(list);
            m12258c(parcel, b);
        } else if (z) {
            m12256b(parcel, i, 0);
        }
    }

    public static void m12258c(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        int i2 = dataPosition - i;
        parcel.setDataPosition(i - 4);
        parcel.writeInt(i2);
        parcel.setDataPosition(dataPosition);
    }

    public static <T extends Parcelable> void m12259c(Parcel parcel, int i, List<T> list, boolean z) {
        if (list != null) {
            int b = m12255b(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    m12254a(parcel, parcelable, 0);
                }
            }
            m12258c(parcel, b);
        } else if (z) {
            m12256b(parcel, i, 0);
        }
    }
}
