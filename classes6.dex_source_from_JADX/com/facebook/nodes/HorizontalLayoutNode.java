package com.facebook.nodes;

import android.content.Context;
import android.support.v4.view.GravityCompat;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;

/* compiled from: thumbnail_bitmap */
public final class HorizontalLayoutNode extends LinearLayoutNode {
    private int[] f3097f;
    private int[] f3098g;
    private boolean f3099h;

    public HorizontalLayoutNode(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public final void mo186a(boolean z) {
        this.f3099h = z;
    }

    protected final void mo184a(int i, int i2) {
        Object obj;
        int i3;
        int i4;
        Object obj2;
        int i5;
        int k;
        int i6;
        this.a = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        Object obj3 = 1;
        float f = 0.0f;
        int y = m4126y();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj4 = null;
        Object obj5 = null;
        if (this.f3097f == null || this.f3098g == null) {
            this.f3097f = new int[4];
            this.f3098g = new int[4];
        }
        int[] iArr = this.f3097f;
        int[] iArr2 = this.f3098g;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z = this.f3099h;
        if (mode == 1073741824) {
            obj = 1;
        } else {
            obj = null;
        }
        int i10 = 0;
        while (i10 < y) {
            int i11;
            Object obj6;
            Object obj7;
            Object obj8;
            float f2;
            Node g = m4125g(i10);
            if (g.m4108t() != 8) {
                Object obj9;
                int d;
                LayoutParams layoutParams = (LayoutParams) g.m4106r();
                float f3 = f + layoutParams.weight;
                if (mode == 1073741824 && layoutParams.width == 0 && layoutParams.weight > 0.0f) {
                    if (obj != null) {
                        this.a = this.f3095a + (layoutParams.leftMargin + layoutParams.rightMargin);
                    } else {
                        i3 = this.f3095a;
                        this.a = Math.max(i3, (layoutParams.leftMargin + i3) + layoutParams.rightMargin);
                    }
                    if (z) {
                        i3 = MeasureSpec.makeMeasureSpec(0, 0);
                        g.m4089b(i3, i3);
                        obj9 = obj5;
                    } else {
                        i11 = 1;
                    }
                } else {
                    i3 = Integer.MIN_VALUE;
                    if (layoutParams.width == 0 && layoutParams.weight > 0.0f) {
                        i3 = 0;
                        layoutParams.width = -2;
                    }
                    i4 = i3;
                    m4115a(g, i, f3 == 0.0f ? this.f3095a : 0, i2, 0);
                    if (i4 != Integer.MIN_VALUE) {
                        layoutParams.width = i4;
                    }
                    i3 = g.m4098j();
                    if (obj != null) {
                        this.a = ((i3 + layoutParams.leftMargin) + layoutParams.rightMargin) + this.f3095a;
                        obj9 = obj5;
                    } else {
                        int i12 = this.f3095a;
                        this.a = Math.max(i12, ((i3 + i12) + layoutParams.leftMargin) + layoutParams.rightMargin);
                        obj9 = obj5;
                    }
                }
                obj6 = null;
                if (mode2 == 1073741824 || layoutParams.height != -1) {
                    obj2 = obj4;
                } else {
                    obj2 = 1;
                    obj6 = 1;
                }
                i5 = layoutParams.topMargin + layoutParams.bottomMargin;
                k = g.m4099k() + i5;
                if (z) {
                    d = g.mo204d();
                    if (d != -1) {
                        int i13 = ((((layoutParams.gravity < 0 ? this.f3096b : layoutParams.gravity) & 112) >> 4) & -2) >> 1;
                        iArr[i13] = Math.max(iArr[i13], d);
                        iArr2[i13] = Math.max(iArr2[i13], k - d);
                    }
                }
                d = Math.max(i7, k);
                obj7 = (obj3 == null || layoutParams.height != -1) ? null : 1;
                if (layoutParams.weight > 0.0f) {
                    if (obj6 != null) {
                        i3 = i5;
                    } else {
                        i3 = k;
                    }
                    obj8 = obj7;
                    k = Math.max(i9, i3);
                    i6 = d;
                    f2 = f3;
                    obj6 = obj9;
                    i11 = i8;
                } else {
                    if (obj6 == null) {
                        i5 = k;
                    }
                    i3 = Math.max(i8, i5);
                    obj8 = obj7;
                    k = i9;
                    i6 = d;
                    f2 = f3;
                    int i14 = i3;
                    obj6 = obj9;
                    i11 = i14;
                }
            } else {
                obj6 = obj5;
                f2 = f;
                obj8 = obj3;
                k = i9;
                i11 = i8;
                i6 = i7;
                obj2 = obj4;
            }
            i10++;
            obj5 = obj6;
            obj3 = obj8;
            i9 = k;
            i8 = i11;
            i7 = i6;
            obj4 = obj2;
            f = f2;
        }
        if (!(iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1)) {
            i7 = Math.max(i7, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        }
        this.a = this.f3095a + (m4102n() + m4103o());
        i4 = Node.m4076d(this.f3095a, i);
        i5 = (16777215 & i4) - this.f3095a;
        if (obj5 != null || (i5 != 0 && f > 0.0f)) {
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            int i15 = -1;
            this.a = 0;
            Object obj10 = obj3;
            int i16 = i8;
            int i17 = 0;
            while (i17 < y) {
                float f4;
                Node g2 = m4125g(i17);
                if (g2.m4108t() != 8) {
                    LayoutParams layoutParams2 = (LayoutParams) g2.m4106r();
                    float f5 = layoutParams2.weight;
                    if (f5 > 0.0f) {
                        i13 = (int) ((((float) i5) * f5) / f);
                        f5 = f - f5;
                        i11 = i5 - i13;
                        i12 = ViewGroup.getChildMeasureSpec(i2, ((m4104p() + m4105q()) + layoutParams2.topMargin) + layoutParams2.bottomMargin, layoutParams2.height);
                        if (layoutParams2.width == 0 && mode == 1073741824) {
                            if (i13 <= 0) {
                                i13 = 0;
                            }
                            g2.m4089b(MeasureSpec.makeMeasureSpec(i13, 1073741824), i12);
                        } else {
                            i13 += g2.m4098j();
                            if (i13 < 0) {
                                i13 = 0;
                            }
                            g2.m4089b(MeasureSpec.makeMeasureSpec(i13, 1073741824), i12);
                        }
                    } else {
                        f5 = f;
                        i11 = i5;
                    }
                    if (obj != null) {
                        this.a = this.f3095a + ((g2.m4098j() + layoutParams2.leftMargin) + layoutParams2.rightMargin);
                    } else {
                        i13 = this.f3095a;
                        this.a = Math.max(i13, ((g2.m4098j() + i13) + layoutParams2.leftMargin) + layoutParams2.rightMargin);
                    }
                    obj7 = (mode2 == 1073741824 || layoutParams2.height != -1) ? null : 1;
                    i12 = layoutParams2.topMargin + layoutParams2.bottomMargin;
                    i5 = g2.m4099k() + i12;
                    i15 = Math.max(i15, i5);
                    if (obj7 != null) {
                        i13 = i12;
                    } else {
                        i13 = i5;
                    }
                    i12 = Math.max(i16, i13);
                    obj7 = (obj10 == null || layoutParams2.height != -1) ? null : 1;
                    if (z) {
                        i6 = g2.mo204d();
                        if (i6 != -1) {
                            i3 = ((((layoutParams2.gravity < 0 ? this.f3096b : layoutParams2.gravity) & 112) >> 4) & -2) >> 1;
                            iArr[i3] = Math.max(iArr[i3], i6);
                            iArr2[i3] = Math.max(iArr2[i3], i5 - i6);
                        }
                    }
                    f4 = f5;
                    i5 = i12;
                    obj2 = obj7;
                    k = i15;
                    i13 = i11;
                } else {
                    f4 = f;
                    i13 = i5;
                    k = i15;
                    i5 = i16;
                    obj2 = obj10;
                }
                i17++;
                obj10 = obj2;
                i16 = i5;
                i15 = k;
                i5 = i13;
                f = f4;
            }
            if (!(iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1)) {
                i15 = Math.max(i15, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            }
            obj3 = obj10;
            i3 = i16;
            i13 = i15;
        } else {
            i3 = Math.max(i8, i9);
            i13 = i7;
        }
        if (obj3 != null || mode2 == 1073741824) {
            i3 = i13;
        }
        m4091c(i4, Node.m4076d(i3 + (m4104p() + m4105q()), i2));
        if (obj4 != null) {
            m4134e(y, i);
        }
    }

    protected final void mo185a(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        boolean v = m4110v();
        int n = m4102n();
        int p = m4104p();
        int q = m4105q();
        int i7 = i4 - i2;
        int i8 = i7 - q;
        int i9 = (i7 - p) - q;
        int y = m4126y();
        q = this.f3096b & 8388615;
        int i10 = this.f3096b & 112;
        boolean z = this.f3099h;
        int[] iArr = this.f3097f;
        int[] iArr2 = this.f3098g;
        switch (GravityCompat.a(q, m4109u())) {
            case 1:
                n += ((i3 - i) - this.f3095a) / 2;
                break;
            case 5:
                n = ((n + i3) - i) - this.f3095a;
                break;
        }
        if (v) {
            i5 = -1;
            i6 = y - 1;
        } else {
            i5 = 1;
            i6 = 0;
        }
        int i11 = 0;
        while (i11 < y) {
            Node g = m4125g((i5 * i11) + i6);
            if (g.m4108t() != 8) {
                int i12;
                int j = g.m4098j();
                int k = g.m4099k();
                LayoutParams layoutParams = (LayoutParams) g.m4106r();
                if (!z || layoutParams.height == -1) {
                    q = -1;
                } else {
                    q = g.mo204d();
                }
                int i13 = layoutParams.gravity;
                if (i13 < 0) {
                    i13 = i10;
                }
                switch (i13 & 112) {
                    case 16:
                        i12 = ((((i9 - k) / 2) + p) + layoutParams.topMargin) - layoutParams.bottomMargin;
                        break;
                    case 48:
                        i12 = p + layoutParams.topMargin;
                        if (q != -1) {
                            i12 += iArr[1] - q;
                            break;
                        }
                        break;
                    case 80:
                        i12 = (i8 - k) - layoutParams.bottomMargin;
                        if (q != -1) {
                            i12 -= iArr2[2] - (g.m4099k() - q);
                            break;
                        }
                        break;
                    default:
                        i12 = p;
                        break;
                }
                i13 = n + layoutParams.leftMargin;
                m4121b(g, i13, i12, j, k);
                q = (layoutParams.rightMargin + j) + i13;
            } else {
                q = n;
            }
            i11++;
            n = q;
        }
    }

    private void m4134e(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f3090u, 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            Node g = m4125g(i3);
            if (g.m4108t() != 8) {
                LayoutParams layoutParams = (LayoutParams) g.f3075f;
                if (layoutParams.height == -1) {
                    int i4 = layoutParams.width;
                    layoutParams.width = g.f3089t;
                    m4115a(g, i2, 0, makeMeasureSpec, 0);
                    layoutParams.width = i4;
                }
            }
        }
    }
}
