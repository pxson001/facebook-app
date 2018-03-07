package com.facebook.attachments.photos;

/* compiled from: hipri */
public class NoCropHelper {

    /* compiled from: hipri */
    public class NoCropLayoutParams {
        public final int f21979a;
        public final int f21980b;
        public final int f21981c;
        public final int f21982d;

        public NoCropLayoutParams(int i, int i2, int i3, int i4) {
            this.f21979a = i;
            this.f21980b = i2;
            this.f21981c = i3;
            this.f21982d = i4;
        }
    }

    public static int m28748a(int i, int i2, int i3, boolean z) {
        if (i2 <= 0 || i3 <= 0) {
            return i;
        }
        float f = ((float) i2) / ((float) i3);
        if (z) {
            f = Math.max(f, 0.6666667f);
        }
        return (int) (((float) i) / f);
    }

    public static NoCropLayoutParams m28749a(NoCropLayoutRestrictions noCropLayoutRestrictions) {
        int i = noCropLayoutRestrictions.f21977h;
        int i2 = noCropLayoutRestrictions.f21978i;
        float f = ((float) noCropLayoutRestrictions.f21970a) / ((float) noCropLayoutRestrictions.f21971b);
        if (Float.isInfinite(f) || Float.isNaN(f) || f >= 1.0f) {
            return new NoCropLayoutParams(i, i2, 0, 0);
        }
        f = (float) (((noCropLayoutRestrictions.f21977h - noCropLayoutRestrictions.f21972c) - noCropLayoutRestrictions.f21974e) - (noCropLayoutRestrictions.f21976g * 2));
        float min = Math.min(f / ((float) noCropLayoutRestrictions.f21970a), Math.min(f / 0.6666667f, (float) ((noCropLayoutRestrictions.f21978i - noCropLayoutRestrictions.f21973d) - noCropLayoutRestrictions.f21975f)) / ((float) noCropLayoutRestrictions.f21971b));
        i2 = noCropLayoutRestrictions.f21974e + (((int) f) + noCropLayoutRestrictions.f21972c);
        i = noCropLayoutRestrictions.f21975f + (((int) (((float) noCropLayoutRestrictions.f21971b) * min)) + noCropLayoutRestrictions.f21973d);
        int i3 = noCropLayoutRestrictions.f21976g;
        return new NoCropLayoutParams(i2, i, i3, i3);
    }
}
