package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.PerspectiveTransform;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.qrcode.decoder.Version;
import java.util.Map;

/* compiled from: event_export_to_calendar_click */
public class Detector {
    private final BitMatrix f13564a;
    private ResultPointCallback f13565b;

    public Detector(BitMatrix bitMatrix) {
        this.f13564a = bitMatrix;
    }

    private static BitMatrix m13789a(BitMatrix bitMatrix, PerspectiveTransform perspectiveTransform, int i) {
        return GridSampler.f13488a.mo680a(bitMatrix, i, i, perspectiveTransform);
    }

    public final DetectorResult m13794a(Map<DecodeHintType, ?> map) {
        this.f13565b = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        return m13790a(new FinderPatternFinder(this.f13564a, this.f13565b).m13805a((Map) map));
    }

    private DetectorResult m13790a(FinderPatternInfo finderPatternInfo) {
        ResultPoint b = finderPatternInfo.m13807b();
        ResultPoint c = finderPatternInfo.m13808c();
        ResultPoint a = finderPatternInfo.m13806a();
        float a2 = m13787a(b, c, a);
        if (a2 < 1.0f) {
            throw NotFoundException.m13654a();
        }
        ResultPoint[] resultPointArr;
        int a3 = m13788a(b, c, a, a2);
        Version a4 = Version.m13770a(a3);
        int d = a4.m13777d() - 7;
        ResultPoint resultPoint = null;
        if (a4.m13775b().length > 0) {
            float a5 = (c.m13663a() - b.m13663a()) + a.m13663a();
            float b2 = (c.m13664b() - b.m13664b()) + a.m13664b();
            float f = 1.0f - (3.0f / ((float) d));
            int a6 = (int) (((a5 - b.m13663a()) * f) + b.m13663a());
            d = (int) (b.m13664b() + (f * (b2 - b.m13664b())));
            int i = 4;
            while (i <= 16) {
                try {
                    resultPoint = m13792a(a2, a6, d, (float) i);
                    break;
                } catch (NotFoundException e) {
                    i <<= 1;
                }
            }
        }
        BitMatrix a7 = m13789a(this.f13564a, m13791a(b, c, a, resultPoint, a3), a3);
        if (resultPoint == null) {
            resultPointArr = new ResultPoint[]{a, b, c};
        } else {
            resultPointArr = new ResultPoint[]{a, b, c, resultPoint};
        }
        return new DetectorResult(a7, resultPointArr);
    }

    private static PerspectiveTransform m13791a(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i) {
        float a;
        float b;
        float f;
        float f2;
        float f3 = ((float) i) - 3.5f;
        if (resultPoint4 != null) {
            a = resultPoint4.m13663a();
            b = resultPoint4.m13664b();
            f = f3 - 3.0f;
            f2 = f;
        } else {
            a = (resultPoint2.m13663a() - resultPoint.m13663a()) + resultPoint3.m13663a();
            b = (resultPoint2.m13664b() - resultPoint.m13664b()) + resultPoint3.m13664b();
            f = f3;
            f2 = f3;
        }
        return PerspectiveTransform.m13695a(3.5f, 3.5f, f3, 3.5f, f2, f, 3.5f, f3, resultPoint.m13663a(), resultPoint.m13664b(), resultPoint2.m13663a(), resultPoint2.m13664b(), a, b, resultPoint3.m13663a(), resultPoint3.m13664b());
    }

    private static int m13788a(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, float f) {
        int a = ((MathUtils.m13701a(ResultPoint.m13661a(resultPoint, resultPoint2) / f) + MathUtils.m13701a(ResultPoint.m13661a(resultPoint, resultPoint3) / f)) >> 1) + 7;
        switch (a & 3) {
            case 0:
                return a + 1;
            case 2:
                return a - 1;
            case 3:
                throw NotFoundException.f13456a;
            default:
                return a;
        }
    }

    private float m13787a(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        return (m13786a(resultPoint, resultPoint2) + m13786a(resultPoint, resultPoint3)) / 2.0f;
    }

    private float m13786a(ResultPoint resultPoint, ResultPoint resultPoint2) {
        float a = m13785a((int) resultPoint.f13473a, (int) resultPoint.f13474b, (int) resultPoint2.f13473a, (int) resultPoint2.f13474b);
        float a2 = m13785a((int) resultPoint2.f13473a, (int) resultPoint2.f13474b, (int) resultPoint.f13473a, (int) resultPoint.f13474b);
        if (Float.isNaN(a)) {
            return a2 / 7.0f;
        }
        if (Float.isNaN(a2)) {
            return a / 7.0f;
        }
        return (a + a2) / 14.0f;
    }

    private float m13785a(int i, int i2, int i3, int i4) {
        float f;
        int i5;
        int i6 = 0;
        float b = m13793b(i, i2, i3, i4);
        int i7 = i - (i3 - i);
        if (i7 < 0) {
            f = ((float) i) / ((float) (i - i7));
            i5 = 0;
        } else if (i7 >= this.f13564a.f13477a) {
            f = ((float) ((this.f13564a.f13477a - 1) - i)) / ((float) (i7 - i));
            i5 = this.f13564a.f13477a - 1;
        } else {
            i5 = i7;
            f = 1.0f;
        }
        i7 = (int) (((float) i2) - (f * ((float) (i4 - i2))));
        if (i7 < 0) {
            f = ((float) i2) / ((float) (i2 - i7));
        } else if (i7 >= this.f13564a.f13478b) {
            f = ((float) ((this.f13564a.f13478b - 1) - i2)) / ((float) (i7 - i2));
            i6 = this.f13564a.f13478b - 1;
        } else {
            i6 = i7;
            f = 1.0f;
        }
        return (m13793b(i, i2, (int) ((f * ((float) (i5 - i))) + ((float) i)), i6) + b) - 1.0f;
    }

    private float m13793b(int i, int i2, int i3, int i4) {
        Object obj;
        if (Math.abs(i4 - i2) > Math.abs(i3 - i)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            int i5 = i4;
            i4 = i3;
            i3 = i5;
            int i6 = i2;
            i2 = i;
            i = i6;
        }
        int abs = Math.abs(i4 - i2);
        int abs2 = Math.abs(i3 - i);
        int i7 = (-abs) >> 1;
        int i8 = i2 < i4 ? 1 : -1;
        int i9 = i < i3 ? 1 : -1;
        int i10 = 0;
        int i11 = i4 + i8;
        int i12 = i2;
        int i13 = i7;
        i7 = i;
        while (i12 != i11) {
            int i14;
            int i15;
            int i16;
            if (obj != null) {
                i14 = i7;
            } else {
                i14 = i12;
            }
            if (obj != null) {
                i15 = i12;
            } else {
                i15 = i7;
            }
            if ((i10 == 1) != this.f13564a.m13674a(i14, i15)) {
                i15 = i10;
            } else if (i10 == 2) {
                return MathUtils.m13700a(i12, i7, i2, i);
            } else {
                i15 = i10 + 1;
            }
            i10 = i13 + abs2;
            if (i10 > 0) {
                if (i7 == i3) {
                    i9 = i15;
                    break;
                }
                i16 = i7 + i9;
                i7 = i10 - abs;
            } else {
                i16 = i7;
                i7 = i10;
            }
            i12 += i8;
            i10 = i15;
            i13 = i7;
            i7 = i16;
        }
        i9 = i10;
        if (i9 == 2) {
            return MathUtils.m13700a(i4 + i8, i3, i2, i);
        }
        return Float.NaN;
    }

    private AlignmentPattern m13792a(float f, int i, int i2, float f2) {
        int i3 = (int) (f2 * f);
        int max = Math.max(0, i - i3);
        int min = Math.min(this.f13564a.f13477a - 1, i + i3);
        if (((float) (min - max)) < f * 3.0f) {
            throw NotFoundException.f13456a;
        }
        int max2 = Math.max(0, i2 - i3);
        int min2 = Math.min(this.f13564a.f13478b - 1, i3 + i2);
        if (((float) (min2 - max2)) < f * 3.0f) {
            throw NotFoundException.f13456a;
        }
        return new AlignmentPatternFinder(this.f13564a, max, max2, min - max, min2 - max2, f, this.f13565b).m13784a();
    }
}
