package com.facebook.fbui.nodes;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.facebook.R;
import com.facebook.nodes.Node;
import com.facebook.nodes.NodeGroup;

/* compiled from: has_tagged_mediaset */
public class ImageBlockLayoutNode extends NodeGroup {
    protected Node f11580a;
    protected Node f11581b;
    protected int f11582f;
    private int f11583g;
    private int f11584h;
    private int f11585i;
    private int f11586j;

    /* compiled from: has_tagged_mediaset */
    public class LayoutParams extends MarginLayoutParams {
        public boolean f11576a = false;
        public boolean f11577b = false;
        public boolean f11578c = false;
        public int f11579d = -1;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ImageBlockLayout_LayoutParams);
            this.f11576a = obtainStyledAttributes.getBoolean(1, false);
            this.f11577b = obtainStyledAttributes.getBoolean(2, false);
            this.f11578c = obtainStyledAttributes.getBoolean(3, false);
            this.f11579d = obtainStyledAttributes.getInt(0, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    protected final /* synthetic */ android.view.ViewGroup.LayoutParams m13475a() {
        return m13468D();
    }

    public ImageBlockLayoutNode(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ImageBlockLayout, i2, 0);
        this.f11582f = obtainStyledAttributes.getInt(0, 48);
        this.f11583g = obtainStyledAttributes.getDimensionPixelSize(15, 0);
        this.f11584h = obtainStyledAttributes.getDimensionPixelSize(16, 0);
        obtainStyledAttributes.recycle();
    }

    protected final void m13478a(int i, int i2) {
        LayoutParams layoutParams;
        int i3;
        int j;
        Object obj;
        int max;
        Object obj2;
        this.f11585i = 0;
        this.f11586j = 0;
        int n = n() + o();
        int p = p() + q();
        int i4;
        if (m13474z()) {
            Object obj3;
            int i5;
            layoutParams = (LayoutParams) this.f11580a.r();
            i3 = layoutParams.leftMargin + layoutParams.rightMargin;
            int i6 = layoutParams.topMargin + layoutParams.bottomMargin;
            if (layoutParams.height == -1) {
                obj3 = 1;
            } else {
                obj3 = null;
            }
            a(this.f11580a, i, n, i2, p);
            j = this.f11580a.j();
            int k = this.f11580a.k();
            n += i3;
            if (j == 0) {
                i5 = 0;
            } else {
                i5 = this.f11583g + j;
            }
            n += i5;
            i3 = j;
            obj = obj3;
            max = Math.max(0, k + i6);
            i4 = k;
        } else {
            i3 = 0;
            obj = null;
            max = 0;
            i4 = 0;
        }
        if (m13465A()) {
            layoutParams = (LayoutParams) this.f11581b.r();
            int i7 = layoutParams.leftMargin + layoutParams.rightMargin;
            int i8 = layoutParams.topMargin + layoutParams.bottomMargin;
            if (layoutParams.height == -1) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            a(this.f11581b, i, n, i2, p);
            j = this.f11581b.j();
            k = this.f11581b.k();
            n += j == 0 ? 0 : (j + i7) + m13467C();
            max = Math.max(max, k + i8);
        } else {
            k = 0;
            j = 0;
            obj2 = null;
        }
        m13471e(MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i) - n, MeasureSpec.getMode(i)), MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2) - p, MeasureSpec.getMode(i2)));
        int max2 = Math.max(0, this.f11585i);
        max = Math.max(max, this.f11586j);
        if (!(obj == null || r6 == max)) {
            layoutParams = (LayoutParams) this.f11580a.r();
            this.f11580a.b(MeasureSpec.makeMeasureSpec(i3, 1073741824), MeasureSpec.makeMeasureSpec((max - layoutParams.topMargin) - layoutParams.bottomMargin, 1073741824));
        }
        if (!(obj2 == null || r1 == max)) {
            layoutParams = (LayoutParams) this.f11581b.r();
            this.f11581b.b(MeasureSpec.makeMeasureSpec(j, 1073741824), MeasureSpec.makeMeasureSpec((max - layoutParams.topMargin) - layoutParams.bottomMargin, 1073741824));
        }
        c(View.resolveSize(max2 + n, i), View.resolveSize(max + p, i2));
    }

    private void m13471e(int i, int i2) {
        int y = y();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < y) {
            int i6;
            Node g = g(i3);
            if (g.t() == 8 || !m13472e(g)) {
                i6 = i4;
                i4 = i5;
            } else {
                LayoutParams layoutParams = (LayoutParams) g.f;
                int i7 = layoutParams.leftMargin + layoutParams.rightMargin;
                int i8 = layoutParams.topMargin + layoutParams.bottomMargin;
                g.b(ViewGroup.getChildMeasureSpec(i, i7, layoutParams.width), ViewGroup.getChildMeasureSpec(i2, i8, layoutParams.height));
                i6 = (g.u + i8) + i4;
                i4 = Math.max(i5, g.t + i7);
            }
            i3++;
            i5 = i4;
            i4 = i6;
        }
        m13473f(i5, i4);
    }

    private void m13473f(int i, int i2) {
        this.f11585i = i;
        this.f11586j = i2;
    }

    protected final void m13479a(int i, int i2, int i3, int i4) {
        LayoutParams layoutParams;
        int i5;
        int i6;
        int b;
        int i7;
        int j;
        int k;
        int b2;
        int i8;
        int i9 = i3 - i;
        int i10 = i4 - i2;
        boolean B = m13466B();
        int p = p();
        int q = q();
        int n = n();
        int o = o();
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        if (m13474z()) {
            layoutParams = (LayoutParams) this.f11580a.r();
            i5 = (layoutParams.f11579d < 0 ? 48 : layoutParams.f11579d) & 112;
            i11 = this.f11580a.j();
            i12 = this.f11580a.k();
            i6 = i11 == 0 ? 0 : this.f11583g + i11;
            i13 = MarginLayoutParamsCompat.a(layoutParams);
            b = MarginLayoutParamsCompat.b(layoutParams);
            if (i5 == 16) {
                i5 = i6;
                i6 = b;
                b = i13;
                i13 = (layoutParams.topMargin + (((i10 - i12) - (((layoutParams.topMargin + layoutParams.bottomMargin) + p) + q)) / 2)) + p;
            } else if (i5 == 80) {
                i5 = i6;
                i6 = b;
                b = i13;
                i13 = ((i10 - q) - layoutParams.bottomMargin) - i12;
            } else {
                i5 = i6;
                i6 = b;
                b = i13;
                i13 = layoutParams.topMargin + p;
            }
        } else {
            i5 = 0;
            b = 0;
            i6 = 0;
        }
        if (m13465A()) {
            layoutParams = (LayoutParams) this.f11581b.r();
            i7 = (layoutParams.f11579d < 0 ? 17 : layoutParams.f11579d) & 112;
            j = this.f11581b.j();
            k = this.f11581b.k();
            b2 = MarginLayoutParamsCompat.b(layoutParams);
            int i14;
            if (i7 == 48) {
                i14 = b2;
                b2 = layoutParams.topMargin + p;
                i8 = i14;
            } else if (i7 == 80) {
                i14 = b2;
                b2 = ((i10 - q) - layoutParams.bottomMargin) - k;
                i8 = i14;
            } else {
                i14 = b2;
                b2 = (layoutParams.topMargin + (((i10 - k) - (((layoutParams.topMargin + layoutParams.bottomMargin) + p) + q)) / 2)) + p;
                i8 = i14;
            }
        } else {
            i8 = 0;
            b2 = 0;
            k = 0;
            j = 0;
        }
        i7 = this.f11582f & 112;
        if (i7 == 16) {
            p = ((((i10 - this.f11586j) - p) - q) / 2) + p;
        } else if (i7 != 48) {
            p = (i10 - q) - this.f11586j;
        }
        if (B) {
            b += n;
            i6 += i5 + b;
            i5 = ((i9 - o) - j) - i8;
            i7 = i6;
        } else {
            i6 = (((i9 - o) - i5) - b) - i6;
            i5 = i8 + n;
            b = ((i9 - o) - b) - i11;
            i7 = i6;
        }
        if (m13474z()) {
            b(this.f11580a, b, i13, i11, i12);
        }
        if (m13465A()) {
            b(this.f11581b, i5, b2, j, k);
        }
        i8 = B ? i7 : i7 - this.f11585i;
        if (B) {
            i7 += this.f11585i;
        }
        m13469a(i8, p, i7);
    }

    private void m13469a(int i, int i2, int i3) {
        boolean B = m13466B();
        int y = y();
        int i4 = 0;
        int i5 = i2;
        while (i4 < y) {
            int i6;
            Node g = g(i4);
            if (g.t() == 8 || !m13472e(g)) {
                i6 = i5;
            } else {
                LayoutParams layoutParams = (LayoutParams) g.r();
                i6 = (layoutParams.f11579d < 0 ? 8388611 : layoutParams.f11579d) & 7;
                int a = MarginLayoutParamsCompat.a(layoutParams);
                int b = MarginLayoutParamsCompat.b(layoutParams);
                int j = g.j();
                int k = g.k();
                if (B) {
                    if (i6 == 3) {
                        a += i;
                    } else if (i6 == 5) {
                        a = (i3 - b) - j;
                    } else {
                        a += (((((i3 - i) - a) - j) - b) / 2) + i;
                    }
                } else if (i6 == 3) {
                    a = (i3 - a) - j;
                } else if (i6 == 5) {
                    a = i + b;
                } else {
                    a = ((((((i3 - i) - a) - j) - b) / 2) + i) + b;
                }
                i5 += layoutParams.topMargin;
                b(g, a, i5, j, k);
                i6 = (layoutParams.bottomMargin + k) + i5;
            }
            i4++;
            i5 = i6;
        }
    }

    public final void m13480a(Node node, android.view.ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        if (layoutParams2.f11576a) {
            if (this.f11580a != null) {
                b(this.f11580a);
            }
            if (layoutParams2.f11579d < 0) {
                layoutParams2.f11579d = 48;
            }
            this.f11580a = node;
        } else if (layoutParams2.f11577b) {
            if (this.f11581b != null) {
                b(this.f11581b);
            }
            if (layoutParams2.f11579d < 0) {
                layoutParams2.f11579d = 16;
            }
            this.f11581b = node;
        }
        super.a(node, layoutParams);
    }

    public final void m13481b(Node node) {
        m13470d(node);
        super.b(node);
    }

    private void m13470d(Node node) {
        if (node == this.f11580a) {
            this.f11580a = null;
        } else if (node == this.f11581b) {
            this.f11581b = null;
        }
    }

    private boolean m13474z() {
        return (this.f11580a == null || this.f11580a.t() == 8) ? false : true;
    }

    private boolean m13465A() {
        return (this.f11581b == null || this.f11581b.t() == 8) ? false : true;
    }

    public final void m13483c(Node node) {
        if (this.f11580a != null) {
            b(this.f11580a);
        }
        if (node != null) {
            android.view.ViewGroup.LayoutParams layoutParams = node.f;
            if (m13482b(layoutParams)) {
                layoutParams = (LayoutParams) layoutParams;
            } else if (layoutParams == null) {
                layoutParams = m13468D();
            } else {
                layoutParams = new LayoutParams(layoutParams);
            }
            layoutParams.f11576a = true;
            a(node, layoutParams);
        }
    }

    public final void m13477a(int i) {
        if (this.f11582f != i) {
            this.f11582f = i;
            s();
        }
    }

    public final void m13484h(int i) {
        if (this.f11583g != i) {
            this.f11583g = i;
            s();
        }
    }

    private int m13467C() {
        return this.f11584h;
    }

    private static LayoutParams m13468D() {
        return new LayoutParams(-2, -2);
    }

    public final android.view.ViewGroup.LayoutParams m13476a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    protected final boolean m13482b(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof LayoutParams);
    }

    private static boolean m13472e(Node node) {
        LayoutParams layoutParams = (LayoutParams) node.f;
        return (layoutParams.f11576a || layoutParams.f11577b || layoutParams.f11578c) ? false : true;
    }

    private final boolean m13466B() {
        return this.e == 0;
    }
}
