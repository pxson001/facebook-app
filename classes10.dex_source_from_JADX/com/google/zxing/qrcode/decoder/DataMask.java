package com.google.zxing.qrcode.decoder;

import com.google.zxing.common.BitMatrix;

/* compiled from: event_location_summary_copy_location */
abstract class DataMask {
    private static final DataMask[] f13533a = new DataMask[]{new DataMask000(), new DataMask001(), new DataMask010(), new DataMask011(), new DataMask100(), new DataMask101(), new DataMask110(), new DataMask111()};

    /* compiled from: event_location_summary_copy_location */
    final class DataMask000 extends DataMask {
        final boolean mo682a(int i, int i2) {
            return ((i + i2) & 1) == 0;
        }
    }

    /* compiled from: event_location_summary_copy_location */
    final class DataMask001 extends DataMask {
        final boolean mo682a(int i, int i2) {
            return (i & 1) == 0;
        }
    }

    /* compiled from: event_location_summary_copy_location */
    final class DataMask010 extends DataMask {
        final boolean mo682a(int i, int i2) {
            return i2 % 3 == 0;
        }
    }

    /* compiled from: event_location_summary_copy_location */
    final class DataMask011 extends DataMask {
        final boolean mo682a(int i, int i2) {
            return (i + i2) % 3 == 0;
        }
    }

    /* compiled from: event_location_summary_copy_location */
    final class DataMask100 extends DataMask {
        final boolean mo682a(int i, int i2) {
            return (((i >>> 1) + (i2 / 3)) & 1) == 0;
        }
    }

    /* compiled from: event_location_summary_copy_location */
    final class DataMask101 extends DataMask {
        final boolean mo682a(int i, int i2) {
            int i3 = i * i2;
            return (i3 % 3) + (i3 & 1) == 0;
        }
    }

    /* compiled from: event_location_summary_copy_location */
    final class DataMask110 extends DataMask {
        final boolean mo682a(int i, int i2) {
            int i3 = i * i2;
            return (((i3 % 3) + (i3 & 1)) & 1) == 0;
        }
    }

    /* compiled from: event_location_summary_copy_location */
    final class DataMask111 extends DataMask {
        final boolean mo682a(int i, int i2) {
            return ((((i + i2) & 1) + ((i * i2) % 3)) & 1) == 0;
        }
    }

    abstract boolean mo682a(int i, int i2);

    final void m13740a(BitMatrix bitMatrix, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < i; i3++) {
                if (mo682a(i2, i3)) {
                    int i4 = (bitMatrix.f13479c * i2) + (i3 >> 5);
                    int[] iArr = bitMatrix.f13480d;
                    iArr[i4] = iArr[i4] ^ (1 << (i3 & 31));
                }
            }
        }
    }

    static DataMask m13739a(int i) {
        if (i >= 0 && i <= 7) {
            return f13533a[i];
        }
        throw new IllegalArgumentException();
    }
}
