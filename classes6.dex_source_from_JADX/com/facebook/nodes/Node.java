package com.facebook.nodes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import com.facebook.R;
import com.facebook.nodes.canvas.CanvasOperation;
import com.facebook.nodes.canvas.DeferredModeCanvasProxy;

/* compiled from: ticket_provider_type */
public class Node {
    private static final int[] f3070a = new int[]{0, 4, 8};
    public NodeParent f3071b;
    protected boolean f3072c = false;
    public NodeAccessibilityProvider f3073d = mo202a(null);
    public int f3074e = 0;
    public LayoutParams f3075f;
    private int f3076g = -1;
    public int f3077h;
    public int f3078i;
    public int f3079j;
    public int f3080k;
    public int f3081l;
    public int f3082m;
    public int f3083n;
    public int f3084o;
    public State f3085p;
    public BaseThreadingModel f3086q;
    private int f3087r = -1;
    private int f3088s = -1;
    public int f3089t;
    public int f3090u;
    public NodeTouchHandler f3091v;
    private BoundViewInfo f3092w;

    /* compiled from: ticket_provider_type */
    class BoundViewInfo {
        int f3112a;
        int f3113b;
    }

    /* compiled from: ticket_provider_type */
    public class State implements AttachDetachListener, CanvasOperation {
        public Drawable f3114a;

        public final void mo188a(Canvas canvas) {
            this.f3114a.draw(canvas);
        }

        public final void mo189a(View view) {
            this.f3114a.setCallback(view);
        }

        public final void mo187a() {
            this.f3114a.setCallback(null);
        }
    }

    public Node(Context context, AttributeSet attributeSet, int i, int i2) {
        int i3 = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Node, i, i2);
        this.f3076g = obtainStyledAttributes.getResourceId(0, -1);
        m4087b(obtainStyledAttributes.getDrawable(1));
        if (obtainStyledAttributes.hasValue(2)) {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(2, 0);
            this.f3081l = dimensionPixelSize;
            this.f3083n = dimensionPixelSize;
            this.f3082m = dimensionPixelSize;
            this.f3084o = dimensionPixelSize;
        } else {
            this.f3081l = obtainStyledAttributes.getDimensionPixelSize(3, 0);
            this.f3083n = obtainStyledAttributes.getDimensionPixelSize(4, 0);
            this.f3082m = obtainStyledAttributes.getDimensionPixelSize(5, 0);
            this.f3084o = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        }
        if (obtainStyledAttributes.getBoolean(9, false)) {
            this.f3092w = new BoundViewInfo();
        }
        m4096e(f3070a[obtainStyledAttributes.getInteger(7, 0)]);
        this.f3073d.f3119d = obtainStyledAttributes.getText(8);
        obtainStyledAttributes.recycle();
        if (this.f3076g == -1 && attributeSet != null) {
            int attributeCount = attributeSet.getAttributeCount();
            while (i3 < attributeCount) {
                if (attributeSet.getAttributeName(i3).equals("android:id")) {
                    this.f3076g = attributeSet.getAttributeResourceValue(i3, -1);
                    return;
                }
                i3++;
            }
        }
    }

    public void mo176a(BaseThreadingModel baseThreadingModel) {
        if (this.f3085p != null) {
            if (this.f3086q != null) {
                this.f3086q.m4065b(this.f3085p);
            }
            if (baseThreadingModel != null) {
                baseThreadingModel.m4060a(this.f3085p);
            }
        }
        this.f3086q = baseThreadingModel;
    }

    public final void m4080a(OnClickListener onClickListener) {
        if (this.f3091v != null) {
            AndroidTouchHandler androidTouchHandler = (AndroidTouchHandler) this.f3091v;
            OnTouchListener onTouchListener = androidTouchHandler.f3063a;
            if (!(androidTouchHandler.f3063a == onTouchListener && androidTouchHandler.f3064b == onClickListener)) {
                if (this.f3086q != null) {
                    this.f3086q.m4066b(this.f3091v);
                    if (onClickListener == null && onTouchListener == null) {
                        this.f3091v = null;
                    } else {
                        this.f3091v = new AndroidTouchHandler(onTouchListener, onClickListener);
                        this.f3086q.m4062a(this.f3091v);
                        this.f3091v.m4053a(this.f3077h, this.f3078i, this.f3079j, this.f3080k);
                    }
                } else if (onTouchListener == null && onClickListener == null) {
                    this.f3091v = null;
                } else {
                    androidTouchHandler.f3063a = onTouchListener;
                    androidTouchHandler.f3064b = onClickListener;
                }
            }
        } else if (onClickListener != null) {
            this.f3091v = new AndroidTouchHandler(null, onClickListener);
            if (this.f3086q != null) {
                this.f3086q.m4062a(this.f3091v);
                this.f3091v.m4053a(this.f3077h, this.f3078i, this.f3079j, this.f3080k);
            }
        }
    }

    @SuppressLint({"WrongCall"})
    public final boolean m4089b(int i, int i2) {
        if (this.f3087r == i && this.f3088s == i2) {
            return false;
        }
        this.f3087r = i;
        this.f3088s = i2;
        mo184a(i, i2);
        return true;
    }

    public int mo204d() {
        return -1;
    }

    @SuppressLint({"WrongCall"})
    public final void m4086b(int i, int i2, int i3, int i4) {
        int i5 = 0;
        if (this.f3092w != null) {
            this.f3092w.f3112a = i;
            this.f3092w.f3113b = i2;
            i3 -= i;
            i4 -= i2;
            i2 = 0;
        } else {
            i5 = i;
        }
        this.f3077h = i5;
        this.f3078i = i2;
        this.f3079j = i3;
        this.f3080k = i4;
        if (this.f3085p != null) {
            this.f3085p.f3114a.setBounds(i5, i2, i3, i4);
        }
        if (this.f3091v != null) {
            this.f3091v.m4053a(i5, i2, i3, i4);
        }
        NodeAccessibilityProvider nodeAccessibilityProvider = this.f3073d;
        nodeAccessibilityProvider.f3120e = i5;
        nodeAccessibilityProvider.f3121f = i2;
        nodeAccessibilityProvider.f3122g = i3;
        nodeAccessibilityProvider.f3123h = i4;
        mo185a(i5, i2, i3, i4);
    }

    protected void mo185a(int i, int i2, int i3, int i4) {
    }

    @SuppressLint({"WrongCall"})
    public final void m4088b(DeferredModeCanvasProxy deferredModeCanvasProxy) {
        if (this.f3085p != null) {
            deferredModeCanvasProxy.m4235a(this.f3085p);
        }
        mo177a(deferredModeCanvasProxy);
    }

    protected void mo177a(DeferredModeCanvasProxy deferredModeCanvasProxy) {
    }

    public Node mo179b(int i) {
        return this.f3076g == i ? this : null;
    }

    Node mo180c(int i) {
        return m4095e() == i ? this : null;
    }

    public final int m4095e() {
        NodeAccessibilityProvider nodeAccessibilityProvider = this.f3073d;
        if (nodeAccessibilityProvider.f3116a == Integer.MIN_VALUE) {
            int i = NodeAccessibilityProvider.f3115i;
            NodeAccessibilityProvider.f3115i = i + 1;
            nodeAccessibilityProvider.f3116a = i;
        }
        return nodeAccessibilityProvider.f3116a;
    }

    public final int m4098j() {
        return this.f3089t;
    }

    public final int m4099k() {
        return this.f3090u;
    }

    public final int m4100l() {
        return this.f3079j - this.f3077h;
    }

    public final int m4101m() {
        return this.f3080k - this.f3078i;
    }

    protected void mo184a(int i, int i2) {
        int i3 = this.f3081l + this.f3082m;
        if (this.f3085p != null) {
            i3 += this.f3085p.f3114a.getMinimumWidth();
        }
        int d = m4076d(i3, i);
        i3 = this.f3083n + this.f3084o;
        if (this.f3085p != null) {
            i3 += this.f3085p.f3114a.getMinimumHeight();
        }
        m4091c(d, m4076d(i3, i2));
    }

    public final int m4102n() {
        return this.f3081l;
    }

    public final int m4103o() {
        return this.f3082m;
    }

    public final int m4104p() {
        return this.f3083n;
    }

    public final int m4105q() {
        return this.f3084o;
    }

    public final void m4092c(int i, int i2, int i3, int i4) {
        if (this.f3081l != i || this.f3083n != i2 || this.f3082m != i3 || this.f3084o != i4) {
            this.f3081l = i;
            this.f3083n = i2;
            this.f3082m = i3;
            this.f3084o = i4;
            m4107s();
        }
    }

    public final void m4087b(Drawable drawable) {
        if (drawable != null || this.f3085p != null) {
            BaseThreadingModel baseThreadingModel = this.f3086q;
            if (this.f3085p == null) {
                this.f3085p = new State();
            } else {
                if (baseThreadingModel != null) {
                    baseThreadingModel.m4065b(this.f3085p);
                }
                if (drawable == null) {
                    this.f3085p = null;
                    m4107s();
                    return;
                }
            }
            this.f3085p.f3114a = drawable;
            if (baseThreadingModel != null) {
                baseThreadingModel.m4060a(this.f3085p);
                if (drawable.isStateful()) {
                    drawable.setState(baseThreadingModel.m4068d());
                }
            }
            m4107s();
        }
    }

    public void mo205a(LayoutParams layoutParams) {
        this.f3075f = layoutParams;
        m4073A();
        m4107s();
    }

    public final LayoutParams m4106r() {
        return this.f3075f;
    }

    private final void m4073A() {
        if (VERSION.SDK_INT >= 17) {
            this.f3075f.resolveLayoutDirection(this.f3074e);
        }
    }

    public final void m4107s() {
        if (this.f3087r != -1) {
            m4074B();
        }
    }

    private final void m4074B() {
        this.f3087r = -1;
        this.f3088s = -1;
        if (this.f3071b != null) {
            this.f3071b.mo200s();
        }
    }

    public final void m4094d(int i) {
        this.f3076g = i;
    }

    public final int m4108t() {
        return this.f3073d.f3118c;
    }

    public final void m4096e(int i) {
        if (this.f3073d.f3118c != i) {
            this.f3073d.f3118c = i;
            m4074B();
        }
    }

    public void mo181f(int i) {
        this.f3074e = i;
        if (this.f3075f != null) {
            m4073A();
            m4107s();
        }
    }

    public final int m4109u() {
        return this.f3074e;
    }

    public final boolean m4110v() {
        if (this.f3074e == 1) {
            return true;
        }
        return false;
    }

    protected NodeAccessibilityProvider mo202a(NodeAccessibilityProvider nodeAccessibilityProvider) {
        return new NodeAccessibilityProvider(nodeAccessibilityProvider);
    }

    protected void mo178a(int[] iArr) {
        if (this.f3085p != null && this.f3085p.f3114a.isStateful()) {
            this.f3085p.f3114a.setState(iArr);
        }
    }

    public final void m4091c(int i, int i2) {
        this.f3089t = m4076d(i, this.f3087r);
        this.f3090u = m4076d(i2, this.f3088s);
        boolean z = mo203a(this.f3089t) || mo203a(this.f3090u);
        this.f3072c = z;
    }

    public static int m4076d(int i, int i2) {
        switch (MeasureSpec.getMode(i2)) {
            case Integer.MIN_VALUE:
                int size = MeasureSpec.getSize(i2);
                if (size < i) {
                    return size | 16777216;
                }
                return i;
            case 1073741824:
                return MeasureSpec.getSize(i2);
            default:
                return i;
        }
    }

    private static boolean mo203a(int i) {
        return (i & 16777216) == 16777216;
    }
}
