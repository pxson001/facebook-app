package com.facebook.nodes;

import android.content.Context;
import android.support.v4.view.GravityCompat;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;

/* compiled from: thread_games */
public final class VerticalLayoutNode extends LinearLayoutNode {
    private int f3175f;

    public VerticalLayoutNode(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    protected final void mo184a(int i, int i2) {
        int i3;
        Object obj;
        int i4;
        int i5;
        int j;
        int i6;
        int i7;
        int i8;
        this.f3175f = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        Object obj2 = 1;
        float f = 0.0f;
        int y = m4126y();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj3 = null;
        Object obj4 = null;
        int i12 = 0;
        while (i12 < y) {
            Object obj5;
            Object obj6;
            Object obj7;
            float f2;
            Node g = m4125g(i12);
            if (g.m4108t() != 8) {
                LayoutParams layoutParams = (LayoutParams) g.m4106r();
                float f3 = f + layoutParams.weight;
                if (mode2 == 1073741824 && layoutParams.height == 0 && layoutParams.weight > 0.0f) {
                    i3 = this.f3175f;
                    this.f3175f = Math.max(i3, (layoutParams.topMargin + i3) + layoutParams.bottomMargin);
                    obj = 1;
                } else {
                    i3 = Integer.MIN_VALUE;
                    if (layoutParams.height == 0 && layoutParams.weight > 0.0f) {
                        i3 = 0;
                        layoutParams.height = -2;
                    }
                    i4 = i3;
                    m4115a(g, i, 0, i2, f3 == 0.0f ? this.f3175f : 0);
                    if (i4 != Integer.MIN_VALUE) {
                        layoutParams.height = i4;
                    }
                    i3 = g.m4099k();
                    int i13 = this.f3175f;
                    this.f3175f = Math.max(i13, ((i3 + i13) + layoutParams.topMargin) + layoutParams.bottomMargin);
                    obj = obj4;
                }
                obj5 = null;
                if (mode == 1073741824 || layoutParams.width != -1) {
                    obj6 = obj3;
                } else {
                    obj6 = 1;
                    obj5 = 1;
                }
                i5 = layoutParams.leftMargin + layoutParams.rightMargin;
                j = g.m4098j() + i5;
                int max = Math.max(i9, j);
                Object obj8 = (obj2 == null || layoutParams.width != -1) ? null : 1;
                if (layoutParams.weight > 0.0f) {
                    if (obj5 != null) {
                        i3 = i5;
                    } else {
                        i3 = j;
                    }
                    obj7 = obj8;
                    j = Math.max(i11, i3);
                    i6 = max;
                    f2 = f3;
                    obj5 = obj;
                    i7 = i10;
                } else {
                    if (obj5 == null) {
                        i5 = j;
                    }
                    i3 = Math.max(i10, i5);
                    obj7 = obj8;
                    j = i11;
                    i6 = max;
                    f2 = f3;
                    int i14 = i3;
                    obj5 = obj;
                    i7 = i14;
                }
            } else {
                obj5 = obj4;
                f2 = f;
                obj7 = obj2;
                j = i11;
                i7 = i10;
                i6 = i9;
                obj6 = obj3;
            }
            i12++;
            obj4 = obj5;
            obj2 = obj7;
            i11 = j;
            i10 = i7;
            i9 = i6;
            obj3 = obj6;
            f = f2;
        }
        this.f3175f += m4104p() + m4105q();
        i4 = Node.m4076d(this.f3175f, i2);
        i5 = (16777215 & i4) - this.f3175f;
        if (obj4 != null || (i5 != 0 && f > 0.0f)) {
            this.f3175f = 0;
            obj = obj2;
            i6 = i10;
            int i15 = i9;
            int i16 = 0;
            while (i16 < y) {
                Node g2 = m4125g(i16);
                if (g2.m4108t() != 8) {
                    Object obj9;
                    LayoutParams layoutParams2 = (LayoutParams) g2.m4106r();
                    float f4 = layoutParams2.weight;
                    if (f4 > 0.0f) {
                        i8 = (int) ((((float) i5) * f4) / f);
                        f -= f4;
                        i5 -= i8;
                        j = ViewGroup.getChildMeasureSpec(i, ((m4102n() + m4103o()) + layoutParams2.leftMargin) + layoutParams2.rightMargin, layoutParams2.width);
                        if (layoutParams2.height == 0 && mode2 == 1073741824) {
                            if (i8 <= 0) {
                                i8 = 0;
                            }
                            g2.m4089b(j, MeasureSpec.makeMeasureSpec(i8, 1073741824));
                        } else {
                            i8 += g2.m4099k();
                            if (i8 < 0) {
                                i8 = 0;
                            }
                            g2.m4089b(j, MeasureSpec.makeMeasureSpec(i8, 1073741824));
                            f2 = f;
                            i13 = i5;
                            i5 = layoutParams2.leftMargin + layoutParams2.rightMargin;
                            j = g2.m4098j() + i5;
                            i15 = Math.max(i15, j);
                            obj9 = (mode == 1073741824 && layoutParams2.width == -1) ? 1 : null;
                            if (obj9 == null) {
                                i5 = j;
                            }
                            j = Math.max(i6, i5);
                            obj7 = (obj == null && layoutParams2.width == -1) ? 1 : null;
                            i7 = this.f3175f;
                            this.f3175f = Math.max(i7, layoutParams2.bottomMargin + ((g2.m4099k() + i7) + layoutParams2.topMargin));
                            i3 = j;
                            j = i15;
                        }
                    }
                    f2 = f;
                    i13 = i5;
                    i5 = layoutParams2.leftMargin + layoutParams2.rightMargin;
                    j = g2.m4098j() + i5;
                    i15 = Math.max(i15, j);
                    if (mode == 1073741824) {
                    }
                    if (obj9 == null) {
                        i5 = j;
                    }
                    j = Math.max(i6, i5);
                    if (obj == null) {
                    }
                    i7 = this.f3175f;
                    this.f3175f = Math.max(i7, layoutParams2.bottomMargin + ((g2.m4099k() + i7) + layoutParams2.topMargin));
                    i3 = j;
                    j = i15;
                } else {
                    f2 = f;
                    i3 = i6;
                    j = i15;
                    i13 = i5;
                    obj7 = obj;
                }
                i16++;
                i6 = i3;
                i15 = j;
                obj = obj7;
                i5 = i13;
                f = f2;
            }
            this.f3175f += m4104p() + m4105q();
            obj2 = obj;
            i3 = i6;
            i8 = i15;
        } else {
            i3 = Math.max(i10, i11);
            i8 = i9;
        }
        if (obj2 != null || mode == 1073741824) {
            i3 = i8;
        }
        m4091c(Node.m4076d(i3 + (m4102n() + m4103o()), i), i4);
        if (obj3 != null) {
            m4224e(y, i2);
        }
    }

    protected final void mo185a(int i, int i2, int i3, int i4) {
        int n = m4102n();
        int o = m4103o();
        int p = m4104p();
        int i5 = i3 - i;
        int i6 = i5 - o;
        int i7 = (i5 - n) - o;
        int y = m4126y();
        int i8 = this.f3096b & 8388615;
        switch (this.f3096b & 112) {
            case 16:
                p += ((i4 - i2) - this.f3175f) / 2;
                break;
            case 80:
                p = ((p + i4) - i2) - this.f3175f;
                break;
        }
        int i9 = 0;
        int i10 = p;
        while (i9 < y) {
            Node g = m4125g(i9);
            if (g.m4108t() != 8) {
                int j = g.m4098j();
                int k = g.m4099k();
                LayoutParams layoutParams = (LayoutParams) g.m4106r();
                p = layoutParams.gravity;
                if (p < 0) {
                    p = i8;
                }
                switch (GravityCompat.a(p, m4109u()) & 7) {
                    case 1:
                        i5 = ((((i7 - j) / 2) + n) + layoutParams.leftMargin) - layoutParams.rightMargin;
                        break;
                    case 5:
                        i5 = (i6 - j) - layoutParams.rightMargin;
                        break;
                    default:
                        i5 = n + layoutParams.leftMargin;
                        break;
                }
                i10 += layoutParams.topMargin;
                m4121b(g, i5, i10, j, k);
                p = (layoutParams.bottomMargin + k) + i10;
            } else {
                p = i10;
            }
            i9++;
            i10 = p;
        }
    }

    private void m4224e(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f3089t, 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            Node g = m4125g(i3);
            if (g.m4108t() != 8) {
                LayoutParams layoutParams = (LayoutParams) g.f3075f;
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = g.f3090u;
                    m4115a(g, makeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }
}
