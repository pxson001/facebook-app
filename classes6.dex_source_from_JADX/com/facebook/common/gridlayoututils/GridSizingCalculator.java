package com.facebook.common.gridlayoututils;

import android.content.res.Resources;
import com.facebook.common.util.SizeUtil;
import com.google.common.annotations.VisibleForTesting;

/* compiled from: place_picker_removed_place */
public class GridSizingCalculator {
    private final Resources f7737a;
    private final Params f7738b;

    /* compiled from: place_picker_removed_place */
    public class Params {
        private final int f7716a;
        private final int f7717b;
        public final float f7718c;
        private final int f7719d;
        private final int f7720e;
        private final int f7721f;
        private final int f7722g;
        private final int f7723h;
        private final int f7724i;

        public Params(int i, int i2, float f, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.f7716a = i;
            this.f7717b = i2;
            this.f7719d = i3;
            this.f7720e = i4;
            this.f7721f = i5;
            this.f7722g = i6;
            this.f7723h = i7;
            this.f7718c = f;
            this.f7724i = i8;
        }

        public final int m11027a() {
            return this.f7716a;
        }

        public final int m11028b() {
            return this.f7717b;
        }

        public final int m11029d() {
            return this.f7719d;
        }

        public final int m11030e() {
            return this.f7720e;
        }

        public final int m11031f() {
            return this.f7721f;
        }

        public final int m11032g() {
            return this.f7722g;
        }

        public final int m11033h() {
            return this.f7723h;
        }

        public final int m11034i() {
            return this.f7724i;
        }
    }

    /* compiled from: place_picker_removed_place */
    public class Sizes {
        public final int f7725a;
        private final float f7726b;
        public final int f7727c;
        public final int f7728d;
        private final int f7729e;
        private final int f7730f;
        private final int f7731g;
        private final int f7732h;
        public final int f7733i;
        public final int f7734j;
        private final int f7735k;
        private final int f7736l;

        public Sizes(int i, float f, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
            this.f7725a = i;
            this.f7726b = f;
            this.f7727c = i2;
            this.f7728d = i3;
            this.f7729e = i4;
            this.f7730f = i5;
            this.f7731g = i6;
            this.f7732h = i7;
            this.f7733i = i8;
            this.f7734j = i9;
            this.f7735k = i10;
            this.f7736l = i11;
        }

        public final int m11035a() {
            return this.f7725a;
        }

        public final int m11036c() {
            return this.f7734j;
        }

        public final int m11037d() {
            return this.f7727c;
        }

        public final int m11038e() {
            return this.f7728d;
        }

        public final int m11039f() {
            return this.f7729e;
        }

        public final int m11040g() {
            return this.f7730f;
        }
    }

    public GridSizingCalculator(Resources resources, Params params) {
        this.f7737a = resources;
        this.f7738b = params;
    }

    public final Sizes m11042a(int i, int i2, boolean z) {
        int i3;
        int a = SizeUtil.a(this.f7737a, (float) this.f7738b.m11030e());
        int a2 = SizeUtil.a(this.f7737a, (float) this.f7738b.m11032g());
        int a3 = SizeUtil.a(this.f7737a, (float) this.f7738b.m11031f());
        int a4 = SizeUtil.a(this.f7737a, (float) this.f7738b.m11033h());
        int a5 = SizeUtil.a(this.f7737a, (float) this.f7738b.m11029d());
        int a6 = SizeUtil.a(this.f7737a, (float) this.f7738b.m11034i());
        int i4 = i2 - a6;
        int i5 = i / a5;
        if (i5 > this.f7738b.m11027a()) {
            i5 = Math.max(this.f7738b.m11027a(), i5 - 2);
        }
        int i6 = i4 / a5;
        if (i6 <= 0) {
            i6 = (int) Math.ceil(((double) i4) / ((double) a5));
        }
        float f = (float) i6;
        if (!z && f > ((float) this.f7738b.m11028b())) {
            f = (float) this.f7738b.m11028b();
        }
        float a7 = m11041a((double) f);
        int i7 = i / i5;
        if (i7 > a5) {
            i6 = i7 - a5;
            a += (i6 / 2) + (i6 % 2);
            a2 += i6 / 2;
        } else {
            i7 = a5;
        }
        int i8 = (int) (((float) i4) / a7);
        if (i8 > a5) {
            i6 = i8 - a5;
            i4 = ((i6 / 2) + (i6 % 2)) + a3;
            i3 = a4 + (i6 / 2);
        } else {
            i3 = a4;
            i4 = a3;
            i8 = a5;
        }
        return new Sizes(i5, a7, a, a2, i4, i3, a3, a4, i7, i8, a5, (int) ((((float) i7) * a7) + ((float) a6)));
    }

    @VisibleForTesting
    private float m11041a(double d) {
        float ceil = ((float) Math.ceil(4.0d * d)) / 4.0f;
        if (Math.floor((double) ceil) == ((double) ceil)) {
            ceil += 0.25f;
        }
        return Math.max(ceil, this.f7738b.f7718c);
    }
}
