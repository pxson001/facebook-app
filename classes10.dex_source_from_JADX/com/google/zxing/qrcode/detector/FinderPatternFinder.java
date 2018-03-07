package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* compiled from: event_edit */
public class FinderPatternFinder {
    private final BitMatrix f13568a;
    private final List<FinderPattern> f13569b = new ArrayList();
    private boolean f13570c;
    private final int[] f13571d = new int[5];
    private final ResultPointCallback f13572e;

    /* compiled from: event_edit */
    final class CenterComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        public final int compare(Object obj, Object obj2) {
            FinderPattern finderPattern = (FinderPattern) obj;
            FinderPattern finderPattern2 = (FinderPattern) obj2;
            if (finderPattern2.f13567b != finderPattern.f13567b) {
                return finderPattern2.f13567b - finderPattern.f13567b;
            }
            float abs = Math.abs(finderPattern2.f13566a - this.average);
            float abs2 = Math.abs(finderPattern.f13566a - this.average);
            if (abs < abs2) {
                return 1;
            }
            return abs == abs2 ? 0 : -1;
        }

        public CenterComparator(float f) {
            this.average = f;
        }
    }

    /* compiled from: event_edit */
    final class FurthestFromAverageComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        public final int compare(Object obj, Object obj2) {
            FinderPattern finderPattern = (FinderPattern) obj;
            float abs = Math.abs(((FinderPattern) obj2).f13566a - this.average);
            float abs2 = Math.abs(finderPattern.f13566a - this.average);
            if (abs < abs2) {
                return -1;
            }
            return abs == abs2 ? 0 : 1;
        }

        public FurthestFromAverageComparator(float f) {
            this.average = f;
        }
    }

    public FinderPatternFinder(BitMatrix bitMatrix, ResultPointCallback resultPointCallback) {
        this.f13568a = bitMatrix;
        this.f13572e = resultPointCallback;
    }

    final FinderPatternInfo m13805a(Map<DecodeHintType, ?> map) {
        int i = (map == null || !map.containsKey(DecodeHintType.TRY_HARDER)) ? 0 : 1;
        int d = this.f13568a.m13679d();
        int c = this.f13568a.m13678c();
        int i2 = (d * 3) / 228;
        if (i2 < 3 || i != 0) {
            i = 3;
        } else {
            i = i2;
        }
        int[] iArr = new int[5];
        int i3 = i - 1;
        boolean z = false;
        int i4 = i;
        while (i3 < d && !r6) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            i2 = 0;
            i = 0;
            while (i2 < c) {
                if (this.f13568a.m13674a(i2, i3)) {
                    if ((i & 1) == 1) {
                        i++;
                    }
                    iArr[i] = iArr[i] + 1;
                } else if ((i & 1) != 0) {
                    iArr[i] = iArr[i] + 1;
                } else if (i != 4) {
                    i++;
                    iArr[i] = iArr[i] + 1;
                } else if (!m13798a(iArr)) {
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = iArr[4];
                    iArr[3] = 1;
                    iArr[4] = 0;
                    i = 3;
                } else if (m13799a(iArr, i3, i2)) {
                    boolean c2;
                    if (this.f13570c) {
                        c2 = m13803c();
                    } else {
                        i = m13802b();
                        if (i > iArr[2]) {
                            i2 = i3 + ((i - iArr[2]) - 2);
                            i = c - 1;
                        } else {
                            i = i2;
                            i2 = i3;
                        }
                        i3 = i2;
                        i2 = i;
                        c2 = z;
                    }
                    iArr[0] = 0;
                    iArr[1] = 0;
                    iArr[2] = 0;
                    iArr[3] = 0;
                    iArr[4] = 0;
                    z = c2;
                    i4 = 2;
                    i = 0;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = iArr[4];
                    iArr[3] = 1;
                    iArr[4] = 0;
                    i = 3;
                }
                i2++;
            }
            if (m13798a(iArr) && m13799a(iArr, i3, c)) {
                i4 = iArr[0];
                if (this.f13570c) {
                    z = m13803c();
                }
            }
            i3 += i4;
        }
        ResultPoint[] d2 = m13804d();
        ResultPoint.m13662a(d2);
        return new FinderPatternInfo(d2);
    }

    private static float m13797a(int[] iArr, int i) {
        return ((float) ((i - iArr[4]) - iArr[3])) - (((float) iArr[2]) / 2.0f);
    }

    private static boolean m13798a(int[] iArr) {
        int i;
        int i2 = 0;
        for (i = 0; i < 5; i++) {
            int i3 = iArr[i];
            if (i3 == 0) {
                return false;
            }
            i2 += i3;
        }
        if (i2 < 7) {
            return false;
        }
        i = (i2 << 8) / 7;
        i2 = i / 2;
        if (Math.abs(i - (iArr[0] << 8)) >= i2 || Math.abs(i - (iArr[1] << 8)) >= i2 || Math.abs((i * 3) - (iArr[2] << 8)) >= i2 * 3 || Math.abs(i - (iArr[3] << 8)) >= i2 || Math.abs(i - (iArr[4] << 8)) >= i2) {
            return false;
        }
        return true;
    }

    private int[] m13800a() {
        this.f13571d[0] = 0;
        this.f13571d[1] = 0;
        this.f13571d[2] = 0;
        this.f13571d[3] = 0;
        this.f13571d[4] = 0;
        return this.f13571d;
    }

    private float m13796a(int i, int i2, int i3, int i4) {
        BitMatrix bitMatrix = this.f13568a;
        int d = bitMatrix.m13679d();
        int[] a = m13800a();
        int i5 = i;
        while (i5 >= 0 && bitMatrix.m13674a(i2, i5)) {
            a[2] = a[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bitMatrix.m13674a(i2, i5) && a[1] <= i3) {
            a[1] = a[1] + 1;
            i5--;
        }
        if (i5 < 0 || a[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && bitMatrix.m13674a(i2, i5) && a[0] <= i3) {
            a[0] = a[0] + 1;
            i5--;
        }
        if (a[0] > i3) {
            return Float.NaN;
        }
        i5 = i + 1;
        while (i5 < d && bitMatrix.m13674a(i2, i5)) {
            a[2] = a[2] + 1;
            i5++;
        }
        if (i5 == d) {
            return Float.NaN;
        }
        while (i5 < d && !bitMatrix.m13674a(i2, i5) && a[3] < i3) {
            a[3] = a[3] + 1;
            i5++;
        }
        if (i5 == d || a[3] >= i3) {
            return Float.NaN;
        }
        while (i5 < d && bitMatrix.m13674a(i2, i5) && a[4] < i3) {
            a[4] = a[4] + 1;
            i5++;
        }
        if (a[4] >= i3 || Math.abs(((((a[0] + a[1]) + a[2]) + a[3]) + a[4]) - i4) * 5 >= i4 * 2 || !m13798a(a)) {
            return Float.NaN;
        }
        return m13797a(a, i5);
    }

    private float m13801b(int i, int i2, int i3, int i4) {
        BitMatrix bitMatrix = this.f13568a;
        int c = bitMatrix.m13678c();
        int[] a = m13800a();
        int i5 = i;
        while (i5 >= 0 && bitMatrix.m13674a(i5, i2)) {
            a[2] = a[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bitMatrix.m13674a(i5, i2) && a[1] <= i3) {
            a[1] = a[1] + 1;
            i5--;
        }
        if (i5 < 0 || a[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && bitMatrix.m13674a(i5, i2) && a[0] <= i3) {
            a[0] = a[0] + 1;
            i5--;
        }
        if (a[0] > i3) {
            return Float.NaN;
        }
        i5 = i + 1;
        while (i5 < c && bitMatrix.m13674a(i5, i2)) {
            a[2] = a[2] + 1;
            i5++;
        }
        if (i5 == c) {
            return Float.NaN;
        }
        while (i5 < c && !bitMatrix.m13674a(i5, i2) && a[3] < i3) {
            a[3] = a[3] + 1;
            i5++;
        }
        if (i5 == c || a[3] >= i3) {
            return Float.NaN;
        }
        while (i5 < c && bitMatrix.m13674a(i5, i2) && a[4] < i3) {
            a[4] = a[4] + 1;
            i5++;
        }
        if (a[4] >= i3 || Math.abs(((((a[0] + a[1]) + a[2]) + a[3]) + a[4]) - i4) * 5 >= i4 || !m13798a(a)) {
            return Float.NaN;
        }
        return m13797a(a, i5);
    }

    private boolean m13799a(int[] iArr, int i, int i2) {
        boolean z = false;
        int i3 = (((iArr[0] + iArr[1]) + iArr[2]) + iArr[3]) + iArr[4];
        float a = m13797a(iArr, i2);
        float a2 = m13796a(i, (int) a, iArr[2], i3);
        if (Float.isNaN(a2)) {
            return false;
        }
        float b = m13801b((int) a, (int) a2, iArr[2], i3);
        if (Float.isNaN(b)) {
            return false;
        }
        float f = ((float) i3) / 7.0f;
        for (int i4 = 0; i4 < this.f13569b.size(); i4++) {
            FinderPattern finderPattern = (FinderPattern) this.f13569b.get(i4);
            Object obj = null;
            if (Math.abs(a2 - finderPattern.f13474b) <= f && Math.abs(b - finderPattern.f13473a) <= f) {
                float abs = Math.abs(f - finderPattern.f13566a);
                if (abs <= 1.0f || abs <= finderPattern.f13566a) {
                    obj = 1;
                }
            }
            if (obj != null) {
                this.f13569b.set(i4, finderPattern.m13795b(a2, b, f));
                z = true;
                break;
            }
        }
        if (!z) {
            this.f13569b.add(new FinderPattern(b, a2, f));
        }
        return true;
    }

    private int m13802b() {
        if (this.f13569b.size() <= 1) {
            return 0;
        }
        ResultPoint resultPoint = null;
        for (ResultPoint resultPoint2 : this.f13569b) {
            if (resultPoint2.f13567b >= 2) {
                if (resultPoint == null) {
                    resultPoint = resultPoint2;
                } else {
                    this.f13570c = true;
                    return ((int) (Math.abs(resultPoint.f13473a - resultPoint2.f13473a) - Math.abs(resultPoint.f13474b - resultPoint2.f13474b))) / 2;
                }
            }
        }
        return 0;
    }

    private boolean m13803c() {
        float f = 0.0f;
        int size = this.f13569b.size();
        float f2 = 0.0f;
        int i = 0;
        for (FinderPattern finderPattern : this.f13569b) {
            float f3;
            int i2;
            if (finderPattern.f13567b >= 2) {
                f3 = finderPattern.f13566a + f2;
                i2 = i + 1;
            } else {
                f3 = f2;
                i2 = i;
            }
            i = i2;
            f2 = f3;
        }
        if (i < 3) {
            return false;
        }
        float f4 = f2 / ((float) size);
        for (FinderPattern finderPattern2 : this.f13569b) {
            f += Math.abs(finderPattern2.f13566a - f4);
        }
        if (f <= 0.05f * f2) {
            return true;
        }
        return false;
    }

    private FinderPattern[] m13804d() {
        float f = 0.0f;
        int size = this.f13569b.size();
        if (size < 3) {
            throw NotFoundException.f13456a;
        }
        if (size > 3) {
            float f2;
            float f3 = 0.0f;
            float f4 = 0.0f;
            for (FinderPattern finderPattern : this.f13569b) {
                f2 = finderPattern.f13566a;
                f4 += f2;
                f3 = (f2 * f2) + f3;
            }
            f4 /= (float) size;
            f2 = (float) Math.sqrt((double) ((f3 / ((float) size)) - (f4 * f4)));
            Collections.sort(this.f13569b, new FurthestFromAverageComparator(f4));
            float max = Math.max(0.2f * f4, f2);
            int i = 0;
            while (i < this.f13569b.size() && this.f13569b.size() > 3) {
                if (Math.abs(((FinderPattern) this.f13569b.get(i)).f13566a - f4) > max) {
                    this.f13569b.remove(i);
                    i--;
                }
                i++;
            }
        }
        if (this.f13569b.size() > 3) {
            for (FinderPattern finderPattern2 : this.f13569b) {
                f += finderPattern2.f13566a;
            }
            Collections.sort(this.f13569b, new CenterComparator(f / ((float) this.f13569b.size())));
            this.f13569b.subList(3, this.f13569b.size()).clear();
        }
        return new FinderPattern[]{(FinderPattern) this.f13569b.get(0), (FinderPattern) this.f13569b.get(1), (FinderPattern) this.f13569b.get(2)};
    }
}
