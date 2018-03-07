package android.support.v7.graphics;

import android.graphics.Color;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.graphics.Palette.Swatch;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/* compiled from: share_error */
public final class ColorCutQuantizer {
    private static final String f3701a = ColorCutQuantizer.class.getSimpleName();
    private static final Comparator<Vbox> f3702f = new C03341();
    public final float[] f3703b = new float[3];
    public final int[] f3704c;
    public final SparseIntArray f3705d;
    public final List<Swatch> f3706e;

    /* compiled from: share_error */
    final class C03341 implements Comparator<Vbox> {
        C03341() {
        }

        public final int compare(Object obj, Object obj2) {
            return ((Vbox) obj2).m3426a() - ((Vbox) obj).m3426a();
        }
    }

    /* compiled from: share_error */
    public class Vbox {
        public final /* synthetic */ ColorCutQuantizer f3692a;
        public int f3693b;
        public int f3694c;
        public int f3695d;
        public int f3696e;
        public int f3697f;
        public int f3698g;
        public int f3699h;
        public int f3700i;

        Vbox(ColorCutQuantizer colorCutQuantizer, int i, int i2) {
            this.f3692a = colorCutQuantizer;
            this.f3693b = i;
            this.f3694c = i2;
            m3425f();
        }

        final int m3426a() {
            return (((this.f3696e - this.f3695d) + 1) * ((this.f3698g - this.f3697f) + 1)) * ((this.f3700i - this.f3699h) + 1);
        }

        public final boolean m3427b() {
            if ((this.f3694c - this.f3693b) + 1 > 1) {
                return true;
            }
            return false;
        }

        private void m3425f() {
            this.f3699h = 255;
            this.f3697f = 255;
            this.f3695d = 255;
            this.f3700i = 0;
            this.f3698g = 0;
            this.f3696e = 0;
            for (int i = this.f3693b; i <= this.f3694c; i++) {
                int i2 = this.f3692a.f3704c[i];
                int red = Color.red(i2);
                int green = Color.green(i2);
                i2 = Color.blue(i2);
                if (red > this.f3696e) {
                    this.f3696e = red;
                }
                if (red < this.f3695d) {
                    this.f3695d = red;
                }
                if (green > this.f3698g) {
                    this.f3698g = green;
                }
                if (green < this.f3697f) {
                    this.f3697f = green;
                }
                if (i2 > this.f3700i) {
                    this.f3700i = i2;
                }
                if (i2 < this.f3699h) {
                    this.f3699h = i2;
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final android.support.v7.graphics.ColorCutQuantizer.Vbox m3428c() {
            /*
            r13 = this;
            r0 = r13.m3427b();
            if (r0 != 0) goto L_0x000e;
        L_0x0006:
            r0 = new java.lang.IllegalStateException;
            r1 = "Can not split a box with only 1 color";
            r0.<init>(r1);
            throw r0;
        L_0x000e:
            r9 = r13.f3696e;
            r10 = r13.f3695d;
            r9 = r9 - r10;
            r10 = r13.f3698g;
            r11 = r13.f3697f;
            r10 = r10 - r11;
            r11 = r13.f3700i;
            r12 = r13.f3699h;
            r11 = r11 - r12;
            if (r9 < r10) goto L_0x0089;
        L_0x001f:
            if (r9 < r11) goto L_0x0089;
        L_0x0021:
            r9 = -3;
        L_0x0022:
            r6 = r9;
            r5 = r13.f3692a;
            r7 = r13.f3693b;
            r8 = r13.f3694c;
            android.support.v7.graphics.ColorCutQuantizer.m3431a(r5, r6, r7, r8);
            r5 = r13.f3692a;
            r5 = r5.f3704c;
            r7 = r13.f3693b;
            r8 = r13.f3694c;
            r8 = r8 + 1;
            java.util.Arrays.sort(r5, r7, r8);
            r5 = r13.f3692a;
            r7 = r13.f3693b;
            r8 = r13.f3694c;
            android.support.v7.graphics.ColorCutQuantizer.m3431a(r5, r6, r7, r8);
            switch(r6) {
                case -2: goto L_0x0092;
                case -1: goto L_0x009a;
                default: goto L_0x0045;
            };
        L_0x0045:
            r9 = r13.f3695d;
            r10 = r13.f3696e;
            r9 = r9 + r10;
            r9 = r9 / 2;
        L_0x004c:
            r7 = r9;
            r5 = r13.f3693b;
        L_0x004f:
            r8 = r13.f3694c;
            if (r5 > r8) goto L_0x0085;
        L_0x0053:
            r8 = r13.f3692a;
            r8 = r8.f3704c;
            r8 = r8[r5];
            switch(r6) {
                case -3: goto L_0x005f;
                case -2: goto L_0x0077;
                case -1: goto L_0x007e;
                default: goto L_0x005c;
            };
        L_0x005c:
            r5 = r5 + 1;
            goto L_0x004f;
        L_0x005f:
            r8 = android.graphics.Color.red(r8);
            if (r8 < r7) goto L_0x005c;
        L_0x0065:
            r0 = r5;
            r1 = new android.support.v7.graphics.ColorCutQuantizer$Vbox;
            r2 = r13.f3692a;
            r3 = r0 + 1;
            r4 = r13.f3694c;
            r1.<init>(r2, r3, r4);
            r13.f3694c = r0;
            r13.m3425f();
            return r1;
        L_0x0077:
            r8 = android.graphics.Color.green(r8);
            if (r8 < r7) goto L_0x005c;
        L_0x007d:
            goto L_0x0065;
        L_0x007e:
            r8 = android.graphics.Color.blue(r8);
            if (r8 <= r7) goto L_0x005c;
        L_0x0084:
            goto L_0x0065;
        L_0x0085:
            r5 = r13.f3693b;
            goto L_0x0065;
        L_0x0089:
            if (r10 < r9) goto L_0x008f;
        L_0x008b:
            if (r10 < r11) goto L_0x008f;
        L_0x008d:
            r9 = -2;
            goto L_0x0022;
        L_0x008f:
            r9 = -1;
            goto L_0x0022;
        L_0x0092:
            r9 = r13.f3697f;
            r10 = r13.f3698g;
            r9 = r9 + r10;
            r9 = r9 / 2;
            goto L_0x004c;
        L_0x009a:
            r9 = r13.f3699h;
            r10 = r13.f3700i;
            r9 = r9 + r10;
            r9 = r9 / 2;
            goto L_0x004c;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.graphics.ColorCutQuantizer.Vbox.c():android.support.v7.graphics.ColorCutQuantizer$Vbox");
        }
    }

    public ColorCutQuantizer(ColorHistogram colorHistogram, int i) {
        int i2;
        int i3 = 0;
        int i4 = colorHistogram.f3709c;
        int[] iArr = colorHistogram.f3707a;
        int[] iArr2 = colorHistogram.f3708b;
        this.f3705d = new SparseIntArray(i4);
        for (i2 = 0; i2 < iArr.length; i2++) {
            this.f3705d.append(iArr[i2], iArr2[i2]);
        }
        this.f3704c = new int[i4];
        int length = iArr.length;
        int i5 = 0;
        i4 = 0;
        while (i5 < length) {
            int i6 = iArr[i5];
            ColorUtils.a(Color.red(i6), Color.green(i6), Color.blue(i6), this.f3703b);
            if (m3432a(this.f3703b)) {
                i2 = i4;
            } else {
                i2 = i4 + 1;
                this.f3704c[i4] = i6;
            }
            i5++;
            i4 = i2;
        }
        if (i4 <= i) {
            this.f3706e = new ArrayList();
            int[] iArr3 = this.f3704c;
            i4 = iArr3.length;
            while (i3 < i4) {
                i5 = iArr3[i3];
                this.f3706e.add(new Swatch(i5, this.f3705d.get(i5)));
                i3++;
            }
            return;
        }
        this.f3706e = m3429a(i4 - 1, i);
    }

    private List<Swatch> m3429a(int i, int i2) {
        Collection priorityQueue = new PriorityQueue(i2, f3702f);
        priorityQueue.offer(new Vbox(this, 0, i));
        while (priorityQueue.size() < i2) {
            Vbox vbox = (Vbox) priorityQueue.poll();
            if (vbox == null || !vbox.m3427b()) {
                break;
            }
            priorityQueue.offer(vbox.m3428c());
            priorityQueue.offer(vbox);
        }
        return m3430a(priorityQueue);
    }

    private static List<Swatch> m3430a(Collection<Vbox> collection) {
        List arrayList = new ArrayList(collection.size());
        for (Vbox vbox : collection) {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = vbox.f3693b; i5 <= vbox.f3694c; i5++) {
                int i6 = vbox.f3692a.f3704c[i5];
                int i7 = vbox.f3692a.f3705d.get(i6);
                i += i7;
                i4 += Color.red(i6) * i7;
                i3 += Color.green(i6) * i7;
                i2 += Color.blue(i6) * i7;
            }
            Swatch swatch = new Swatch(Math.round(((float) i4) / ((float) i)), Math.round(((float) i3) / ((float) i)), Math.round(((float) i2) / ((float) i)), i);
            if (!m3432a(swatch.m3457b())) {
                arrayList.add(swatch);
            }
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m3431a(android.support.v7.graphics.ColorCutQuantizer r4, int r5, int r6, int r7) {
        /*
        switch(r5) {
            case -3: goto L_0x0003;
            case -2: goto L_0x0004;
            case -1: goto L_0x001f;
            default: goto L_0x0003;
        };
    L_0x0003:
        return;
    L_0x0004:
        if (r6 > r7) goto L_0x0003;
    L_0x0006:
        r0 = r4.f3704c;
        r0 = r0[r6];
        r1 = r4.f3704c;
        r2 = r0 >> 8;
        r2 = r2 & 255;
        r3 = r0 >> 16;
        r3 = r3 & 255;
        r0 = r0 & 255;
        r0 = android.graphics.Color.rgb(r2, r3, r0);
        r1[r6] = r0;
        r6 = r6 + 1;
        goto L_0x0004;
    L_0x001f:
        if (r6 > r7) goto L_0x0003;
    L_0x0021:
        r0 = r4.f3704c;
        r0 = r0[r6];
        r1 = r4.f3704c;
        r2 = r0 & 255;
        r3 = r0 >> 8;
        r3 = r3 & 255;
        r0 = r0 >> 16;
        r0 = r0 & 255;
        r0 = android.graphics.Color.rgb(r2, r3, r0);
        r1[r6] = r0;
        r6 = r6 + 1;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.graphics.ColorCutQuantizer.a(android.support.v7.graphics.ColorCutQuantizer, int, int, int):void");
    }

    public static boolean m3432a(float[] fArr) {
        Object obj;
        if (fArr[2] >= 0.95f) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            if ((fArr[2] <= 0.05f ? 1 : null) == null) {
                int i = 1;
                if (fArr[0] < 10.0f || fArr[0] > 37.0f || fArr[1] > 0.82f) {
                    i = 0;
                }
                if (i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
