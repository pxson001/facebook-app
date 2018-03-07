package com.google.zxing;

/* compiled from: event_subscriptions */
public class ResultPoint {
    public final float f13473a;
    public final float f13474b;

    public ResultPoint(float f, float f2) {
        this.f13473a = f;
        this.f13474b = f2;
    }

    public final float m13663a() {
        return this.f13473a;
    }

    public final float m13664b() {
        return this.f13474b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ResultPoint)) {
            return false;
        }
        ResultPoint resultPoint = (ResultPoint) obj;
        if (this.f13473a == resultPoint.f13473a && this.f13474b == resultPoint.f13474b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f13473a) * 31) + Float.floatToIntBits(this.f13474b);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(25);
        stringBuilder.append('(');
        stringBuilder.append(this.f13473a);
        stringBuilder.append(',');
        stringBuilder.append(this.f13474b);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    public static void m13662a(ResultPoint[] resultPointArr) {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        float a = m13661a(resultPointArr[0], resultPointArr[1]);
        float a2 = m13661a(resultPointArr[1], resultPointArr[2]);
        float a3 = m13661a(resultPointArr[0], resultPointArr[2]);
        if (a2 >= a && a2 >= a3) {
            resultPoint = resultPointArr[0];
            resultPoint2 = resultPointArr[1];
            resultPoint3 = resultPointArr[2];
        } else if (a3 < a2 || a3 < a) {
            resultPoint = resultPointArr[2];
            resultPoint2 = resultPointArr[0];
            resultPoint3 = resultPointArr[1];
        } else {
            resultPoint = resultPointArr[1];
            resultPoint2 = resultPointArr[0];
            resultPoint3 = resultPointArr[2];
        }
        float f = resultPoint.f13473a;
        float f2 = resultPoint.f13474b;
        if (((resultPoint3.f13473a - f) * (resultPoint2.f13474b - f2)) - ((resultPoint2.f13473a - f) * (resultPoint3.f13474b - f2)) >= 0.0f) {
            ResultPoint resultPoint4 = resultPoint3;
            resultPoint3 = resultPoint2;
            resultPoint2 = resultPoint4;
        }
        resultPointArr[0] = resultPoint3;
        resultPointArr[1] = resultPoint;
        resultPointArr[2] = resultPoint2;
    }

    public static float m13661a(ResultPoint resultPoint, ResultPoint resultPoint2) {
        float f = resultPoint.f13473a;
        float f2 = resultPoint.f13474b;
        float f3 = f - resultPoint2.f13473a;
        float f4 = f2 - resultPoint2.f13474b;
        return (float) Math.sqrt((double) ((f3 * f3) + (f4 * f4)));
    }
}
