package com.google.zxing.qrcode.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.List;

/* compiled from: event_group_summary_click */
final class AlignmentPatternFinder {
    private final BitMatrix f13555a;
    private final List<AlignmentPattern> f13556b = new ArrayList(5);
    private final int f13557c;
    private final int f13558d;
    private final int f13559e;
    private final int f13560f;
    private final float f13561g;
    private final int[] f13562h;
    private final ResultPointCallback f13563i;

    AlignmentPatternFinder(BitMatrix bitMatrix, int i, int i2, int i3, int i4, float f, ResultPointCallback resultPointCallback) {
        this.f13555a = bitMatrix;
        this.f13557c = i;
        this.f13558d = i2;
        this.f13559e = i3;
        this.f13560f = i4;
        this.f13561g = f;
        this.f13562h = new int[3];
        this.f13563i = resultPointCallback;
    }

    final AlignmentPattern m13784a() {
        int i = this.f13557c;
        int i2 = this.f13560f;
        int i3 = i + this.f13559e;
        int i4 = this.f13558d + (i2 >> 1);
        int[] iArr = new int[3];
        for (int i5 = 0; i5 < i2; i5++) {
            int i6;
            AlignmentPattern a;
            if ((i5 & 1) == 0) {
                i6 = (i5 + 1) >> 1;
            } else {
                i6 = -((i5 + 1) >> 1);
            }
            int i7 = i4 + i6;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            i6 = i;
            while (i6 < i3 && !this.f13555a.m13674a(i6, i7)) {
                i6++;
            }
            i6 = 0;
            for (int i8 = i6; i8 < i3; i8++) {
                if (this.f13555a.m13674a(i8, i7)) {
                    if (i6 != 1) {
                        if (i6 == 2) {
                            if (m13783a(iArr)) {
                                a = m13782a(iArr, i7, i8);
                                if (a != null) {
                                    return a;
                                }
                            }
                            iArr[0] = iArr[2];
                            iArr[1] = 1;
                            iArr[2] = 0;
                            i6 = 1;
                        } else {
                            i6++;
                            iArr[i6] = iArr[i6] + 1;
                        }
                    }
                    iArr[i6] = iArr[i6] + 1;
                } else {
                    if (i6 == 1) {
                        i6++;
                    }
                    iArr[i6] = iArr[i6] + 1;
                }
            }
            if (m13783a(iArr)) {
                a = m13782a(iArr, i7, i3);
                if (a != null) {
                    return a;
                }
            }
        }
        if (!this.f13556b.isEmpty()) {
            return (AlignmentPattern) this.f13556b.get(0);
        }
        throw NotFoundException.f13456a;
    }

    private static float m13781a(int[] iArr, int i) {
        return ((float) (i - iArr[2])) - (((float) iArr[1]) / 2.0f);
    }

    private boolean m13783a(int[] iArr) {
        float f = this.f13561g;
        float f2 = f / 2.0f;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(f - ((float) iArr[i])) >= f2) {
                return false;
            }
        }
        return true;
    }

    private float m13780a(int i, int i2, int i3, int i4) {
        BitMatrix bitMatrix = this.f13555a;
        int i5 = bitMatrix.f13478b;
        int[] iArr = this.f13562h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i6 = i;
        while (i6 >= 0 && bitMatrix.m13674a(i2, i6) && iArr[1] <= i3) {
            iArr[1] = iArr[1] + 1;
            i6--;
        }
        if (i6 < 0 || iArr[1] > i3) {
            return Float.NaN;
        }
        while (i6 >= 0 && !bitMatrix.m13674a(i2, i6) && iArr[0] <= i3) {
            iArr[0] = iArr[0] + 1;
            i6--;
        }
        if (iArr[0] > i3) {
            return Float.NaN;
        }
        i6 = i + 1;
        while (i6 < i5 && bitMatrix.m13674a(i2, i6) && iArr[1] <= i3) {
            iArr[1] = iArr[1] + 1;
            i6++;
        }
        if (i6 == i5 || iArr[1] > i3) {
            return Float.NaN;
        }
        while (i6 < i5 && !bitMatrix.m13674a(i2, i6) && iArr[2] <= i3) {
            iArr[2] = iArr[2] + 1;
            i6++;
        }
        if (iArr[2] > i3 || Math.abs(((iArr[0] + iArr[1]) + iArr[2]) - i4) * 5 >= i4 * 2 || !m13783a(iArr)) {
            return Float.NaN;
        }
        return m13781a(iArr, i6);
    }

    private AlignmentPattern m13782a(int[] iArr, int i, int i2) {
        int i3 = (iArr[0] + iArr[1]) + iArr[2];
        float a = m13781a(iArr, i2);
        float a2 = m13780a(i, (int) a, iArr[1] * 2, i3);
        if (!Float.isNaN(a2)) {
            float f = ((float) ((iArr[0] + iArr[1]) + iArr[2])) / 3.0f;
            for (AlignmentPattern alignmentPattern : this.f13556b) {
                Object obj = null;
                if (Math.abs(a2 - alignmentPattern.f13474b) <= f && Math.abs(a - alignmentPattern.f13473a) <= f) {
                    float abs = Math.abs(f - alignmentPattern.f13554a);
                    if (abs <= 1.0f || abs <= alignmentPattern.f13554a) {
                        obj = 1;
                    }
                }
                if (obj != null) {
                    return alignmentPattern.m13779b(a2, a, f);
                }
            }
            this.f13556b.add(new AlignmentPattern(a, a2, f));
        }
        return null;
    }
}
