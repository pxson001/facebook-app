package com.facebook.nodes;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.support.v4.text.TextDirectionHeuristicCompat;
import android.support.v4.text.TextDirectionHeuristicsCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.facebook.R;
import com.facebook.fbui.textcachewarmer.FbTextLayoutCacheWarmer;
import com.facebook.fbui.widget.text.staticlayouthelper.StaticLayoutHelper;
import com.facebook.nodes.canvas.DeferredModeCanvasProxy;

/* compiled from: thread_icon */
public class TextNode extends Node {
    private static final Paint f3153a = m4210y();
    private static final TruncateAt[] f3154b = new TruncateAt[]{null, TruncateAt.START, TruncateAt.MIDDLE, TruncateAt.END, TruncateAt.MARQUEE};
    private static final Alignment f3155e;
    private static final Alignment f3156f;
    public TextPaint f3157g;
    public CharSequence f3158h;
    private boolean f3159i;
    public Metrics f3160j;
    public Boolean f3161k;
    private float f3162l;
    private float f3163m;
    public boolean f3164n;
    private TruncateAt f3165o;
    public boolean f3166p;
    public int f3167q;
    public int f3168r;
    private int f3169s;
    private boolean f3170t;
    private final Paint f3171u;
    public TextLayoutState f3172v;
    public FbTextLayoutCacheWarmer f3173w;
    public boolean f3174x;

    /* compiled from: thread_icon */
    public class TextNodeAccessibilityProvider extends NodeAccessibilityProvider {
        public CharSequence f3152a;

        public TextNodeAccessibilityProvider(TextNodeAccessibilityProvider textNodeAccessibilityProvider) {
            super(textNodeAccessibilityProvider);
            if (textNodeAccessibilityProvider != null) {
                this.f3152a = textNodeAccessibilityProvider.f3152a;
            }
        }

        protected final void mo201a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.mo201a(accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.c(this.f3152a);
        }
    }

    static {
        Alignment valueOf;
        Alignment valueOf2;
        try {
            valueOf = Alignment.valueOf("ALIGN_LEFT");
            valueOf2 = Alignment.valueOf("ALIGN_RIGHT");
        } catch (Exception e) {
            valueOf = Alignment.ALIGN_NORMAL;
            valueOf2 = Alignment.ALIGN_OPPOSITE;
        }
        f3155e = valueOf;
        f3156f = valueOf2;
    }

    public TextNode() {
        this.f3162l = 1.0f;
        this.f3163m = 0.0f;
        this.f3164n = true;
        this.f3165o = TruncateAt.END;
        this.f3166p = false;
        this.f3167q = Integer.MAX_VALUE;
        this.f3168r = 8388659;
        this.f3169s = 1;
        this.f3170t = false;
        this.f3171u = new Paint(f3153a);
        this.f3172v = new TextLayoutState(this.f3171u);
        this.f3174x = false;
        this.f3157g = TextAppearance.m4192a(-16777216, 15, -1, -16777216, 0, 0.0f, 0.0f, 0.0f);
    }

    public TextNode(Context context, AttributeSet attributeSet, int i, int i2) {
        CharSequence text;
        super(context, attributeSet, i, i2);
        this.f3162l = 1.0f;
        this.f3163m = 0.0f;
        this.f3164n = true;
        this.f3165o = TruncateAt.END;
        this.f3166p = false;
        this.f3167q = Integer.MAX_VALUE;
        this.f3168r = 8388659;
        this.f3169s = 1;
        this.f3170t = false;
        this.f3171u = new Paint(f3153a);
        this.f3172v = new TextLayoutState(this.f3171u);
        this.f3174x = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TextNode, i, i2);
        int resourceId = obtainStyledAttributes.getResourceId(8, 0);
        if (resourceId > 0) {
            text = context.getResources().getText(resourceId);
        } else {
            text = obtainStyledAttributes.getText(8);
        }
        m4220a(text);
        this.f3167q = obtainStyledAttributes.getInt(9, this.f3167q);
        this.f3166p = obtainStyledAttributes.getBoolean(10, this.f3166p);
        this.f3168r = obtainStyledAttributes.getInt(7, this.f3168r);
        if (VERSION.SDK_INT >= 17) {
            this.f3169s = obtainStyledAttributes.getInt(18, this.f3169s);
        }
        int i3 = -16777216;
        int i4 = -16777216;
        int i5 = 0;
        int i6 = 15;
        int i7 = -1;
        int i8 = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int resourceId2 = obtainStyledAttributes.getResourceId(0, -1);
        if (resourceId2 != -1) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId2, R.styleable.TextAppearance);
            i3 = obtainStyledAttributes2.getColor(3, -16777216);
            i4 = obtainStyledAttributes2.getColor(5, -16777216);
            i5 = obtainStyledAttributes2.getColor(4, 0);
            i6 = obtainStyledAttributes2.getDimensionPixelSize(0, 15);
            i7 = obtainStyledAttributes2.getInt(2, -1);
            i8 = obtainStyledAttributes2.getInt(6, 0);
            f = obtainStyledAttributes2.getFloat(7, 0.0f);
            f2 = obtainStyledAttributes2.getFloat(8, 0.0f);
            f3 = obtainStyledAttributes2.getFloat(9, 0.0f);
            obtainStyledAttributes2.recycle();
        }
        float f4 = f3;
        resourceId = i3;
        i3 = i5;
        float f5 = f2;
        int i9 = i6;
        float f6 = f;
        int i10 = i7;
        i7 = i8;
        i8 = i4;
        float f7 = f4;
        resourceId = obtainStyledAttributes.getColor(3, resourceId);
        i8 = obtainStyledAttributes.getColor(5, i8);
        resourceId2 = obtainStyledAttributes.getColor(4, i3);
        i9 = obtainStyledAttributes.getDimensionPixelSize(1, i9);
        i10 = obtainStyledAttributes.getInt(2, i10);
        i7 = obtainStyledAttributes.getInt(12, i7);
        f6 = obtainStyledAttributes.getFloat(13, f6);
        f5 = obtainStyledAttributes.getFloat(14, f5);
        f7 = obtainStyledAttributes.getFloat(15, f7);
        this.f3162l = obtainStyledAttributes.getFloat(17, this.f3162l);
        this.f3163m = (float) obtainStyledAttributes.getDimensionPixelSize(16, (int) this.f3163m);
        this.f3164n = obtainStyledAttributes.getBoolean(11, this.f3164n);
        i3 = obtainStyledAttributes.getInteger(6, -1);
        if (i3 < 0) {
            i3 = this.f3166p ? 3 : 0;
        }
        this.f3165o = f3154b[i3];
        obtainStyledAttributes.recycle();
        this.f3157g = TextAppearance.m4192a(resourceId, i9, i10, i8, i7, f6, f5, f7);
        this.f3171u.setColor(resourceId2);
    }

    private void m4200C() {
        BaseThreadingModel baseThreadingModel = this.f3086q;
        if (baseThreadingModel != null && this.f3172v.m4195a()) {
            baseThreadingModel.m4062a(this.f3172v);
        }
        if (this.f3174x && this.f3173w != null) {
            this.f3173w.a(this.f3172v.f3145b);
        }
    }

    private static Paint m4210y() {
        Paint paint = new Paint(1);
        paint.setColor(0);
        return paint;
    }

    public final void m4220a(CharSequence charSequence) {
        this.f3158h = charSequence;
        ((TextNodeAccessibilityProvider) this.f3073d).f3152a = charSequence;
        this.f3161k = null;
        m4211z();
    }

    public final void m4216a(Resources resources, float f) {
        m4206a(resources, 2, f);
    }

    private void m4206a(Resources resources, int i, float f) {
        m4205a(TypedValue.applyDimension(i, f, resources.getDisplayMetrics()));
    }

    private void m4205a(float f) {
        if (this.f3157g.getTextSize() != f) {
            this.f3157g.setTextSize(f);
            m4211z();
        }
    }

    public final void mo203a(int i) {
        if (this.f3157g.getColor() != i) {
            this.f3157g.setColor(i);
            m4211z();
        }
    }

    public final void m4217a(TruncateAt truncateAt) {
        if (this.f3165o != truncateAt) {
            this.f3165o = truncateAt;
            m4211z();
        }
    }

    public final void m4221a(boolean z) {
        if (this.f3166p != z) {
            this.f3166p = z;
            m4211z();
        }
    }

    public final void m4223g(int i) {
        if (this.f3167q != i) {
            this.f3167q = i;
            if (!this.f3166p) {
                m4211z();
            }
        }
    }

    private final void m4211z() {
        BaseThreadingModel baseThreadingModel = this.f3086q;
        if (baseThreadingModel != null && this.f3159i && this.f3172v.m4195a()) {
            baseThreadingModel.m4066b(this.f3172v);
        }
        this.f3159i = false;
        this.f3172v.m4197b(0, 0);
        m4107s();
    }

    private Alignment m4199A() {
        switch (this.f3169s) {
            case 1:
                switch (this.f3168r & 8388615) {
                    case 1:
                        return Alignment.ALIGN_CENTER;
                    case 3:
                        return f3155e;
                    case 5:
                        return f3156f;
                    case 8388611:
                        return Alignment.ALIGN_NORMAL;
                    case 8388613:
                        return Alignment.ALIGN_OPPOSITE;
                    default:
                        return Alignment.ALIGN_NORMAL;
                }
            case 2:
                return Alignment.ALIGN_NORMAL;
            case 3:
                return Alignment.ALIGN_OPPOSITE;
            case 4:
                return Alignment.ALIGN_CENTER;
            case 5:
                return this.f3074e == 1 ? f3156f : f3155e;
            case 6:
                return this.f3074e == 1 ? f3155e : f3156f;
            default:
                return Alignment.ALIGN_NORMAL;
        }
    }

    public final void mo176a(BaseThreadingModel baseThreadingModel) {
        if (this.f3159i && this.f3172v.m4195a()) {
            BaseThreadingModel baseThreadingModel2 = this.f3086q;
            if (baseThreadingModel2 != null) {
                baseThreadingModel2.m4066b(this.f3172v);
            }
            if (baseThreadingModel != null) {
                baseThreadingModel.m4062a(this.f3172v);
            }
        }
        super.mo176a(baseThreadingModel);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void mo184a(int r11, int r12) {
        /*
        r10 = this;
        r0 = r10.f3158h;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x001a;
    L_0x0008:
        r3 = r10.f3081l;
        r0 = r3;
        r3 = r10.f3082m;
        r1 = r3;
        r0 = r0 + r1;
        r3 = r10.f3083n;
        r1 = r3;
        r3 = r10.f3084o;
        r2 = r3;
        r1 = r1 + r2;
        r10.m4091c(r0, r1);
    L_0x0019:
        return;
    L_0x001a:
        r3 = r10.f3161k;
        if (r3 != 0) goto L_0x002e;
    L_0x001e:
        r3 = r10.f3158h;
        r4 = r10.f3157g;
        r5 = r10.f3160j;
        r3 = android.text.BoringLayout.isBoring(r3, r4, r5);
        if (r3 != 0) goto L_0x0099;
    L_0x002a:
        r3 = java.lang.Boolean.FALSE;
        r10.f3161k = r3;
    L_0x002e:
        r3 = r10.f3161k;
        r3 = r3.booleanValue();
        r0 = r3;
        if (r0 == 0) goto L_0x006d;
    L_0x0037:
        r5 = 1;
        r3 = r10.f3160j;
        r4 = r3.width;
        r6 = android.view.View.MeasureSpec.getMode(r11);
        if (r6 == 0) goto L_0x00c5;
    L_0x0042:
        r3 = android.view.View.MeasureSpec.getSize(r11);
        r8 = r10.f3081l;
        r7 = r8;
        r3 = r3 - r7;
        r8 = r10.f3082m;
        r7 = r8;
        r3 = r3 - r7;
        r7 = r10.f3160j;
        r7 = r7.width;
        if (r7 <= r3) goto L_0x00a0;
    L_0x0054:
        r4 = r10.f3166p;
        if (r4 != 0) goto L_0x00a4;
    L_0x0058:
        r4 = r10.f3167q;
        if (r4 <= r5) goto L_0x00a4;
    L_0x005c:
        r3 = 0;
    L_0x005d:
        r0 = r3;
        if (r0 == 0) goto L_0x006d;
    L_0x0060:
        r0 = r10.f3172v;
        r3 = r0.f3145b;
        r0 = r3;
        r0 = r0 instanceof android.text.StaticLayout;
        if (r0 == 0) goto L_0x0019;
    L_0x0069:
        r0 = 0;
        r10.f3159i = r0;
        goto L_0x0019;
    L_0x006d:
        r1 = android.view.View.MeasureSpec.getMode(r11);
        if (r1 != 0) goto L_0x008c;
    L_0x0073:
        r0 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
    L_0x0076:
        r2 = r10.f3159i;
        if (r2 == 0) goto L_0x0085;
    L_0x007a:
        r2 = r10.f3172v;
        r3 = r2.f3145b;
        r2 = r3;
        r2 = r2.getWidth();
        if (r2 == r0) goto L_0x0088;
    L_0x0085:
        r10.m4209j(r0);
    L_0x0088:
        r10.m4207e(r0, r1);
        goto L_0x0019;
    L_0x008c:
        r0 = android.view.View.MeasureSpec.getSize(r11);
        r3 = r10.f3081l;
        r2 = r3;
        r0 = r0 - r2;
        r3 = r10.f3082m;
        r2 = r3;
        r0 = r0 - r2;
        goto L_0x0076;
    L_0x0099:
        r10.f3160j = r3;
        r3 = java.lang.Boolean.TRUE;
        r10.f3161k = r3;
        goto L_0x002e;
    L_0x00a0:
        r7 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r6 != r7) goto L_0x00c5;
    L_0x00a4:
        r4 = r10.f3160j;
        r6 = r10.f3164n;
        if (r6 == 0) goto L_0x00c7;
    L_0x00aa:
        r8 = r4.bottom;
        r9 = r4.top;
        r8 = r8 - r9;
    L_0x00af:
        r4 = r8;
        r8 = r10.f3081l;
        r6 = r8;
        r3 = r3 + r6;
        r8 = r10.f3082m;
        r6 = r8;
        r3 = r3 + r6;
        r8 = r10.f3083n;
        r6 = r8;
        r4 = r4 + r6;
        r8 = r10.f3084o;
        r6 = r8;
        r4 = r4 + r6;
        r10.m4091c(r3, r4);
        r3 = r5;
        goto L_0x005d;
    L_0x00c5:
        r3 = r4;
        goto L_0x00a4;
    L_0x00c7:
        r8 = r4.descent;
        r9 = r4.ascent;
        r8 = r8 - r9;
        goto L_0x00af;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.nodes.TextNode.a(int, int):void");
    }

    protected final void mo185a(int i, int i2, int i3, int i4) {
        if (!TextUtils.isEmpty(this.f3158h)) {
            int i5 = this.f3081l + i;
            int i6 = this.f3083n + i2;
            int i7 = i3 - this.f3082m;
            Layout layout = this.f3172v.f3145b;
            i7 -= i5;
            if (this.f3159i) {
                i7 = layout.getWidth() - i7;
                if (i7 > 0) {
                    float lineLeft = layout.getLineLeft(0);
                    int lineCount = layout.getLineCount();
                    for (int i8 = 1; i8 < lineCount; i8++) {
                        lineLeft = Math.min(lineLeft, layout.getLineLeft(i8));
                    }
                    i5 -= Math.min(Math.round(lineLeft), i7);
                }
            } else {
                m4208h(i7);
            }
            switch (this.f3168r & 112) {
                case 16:
                    i6 += ((i4 - i6) - layout.getHeight()) / 2;
                    break;
                case 80:
                    i6 = i4 - layout.getHeight();
                    break;
            }
            TextLayoutState textLayoutState = this.f3172v;
            textLayoutState.f3146c = i5;
            textLayoutState.f3147d = i6;
        }
    }

    protected final void mo177a(DeferredModeCanvasProxy deferredModeCanvasProxy) {
        if (this.f3159i) {
            deferredModeCanvasProxy.m4235a(this.f3172v);
        }
    }

    protected final NodeAccessibilityProvider mo202a(NodeAccessibilityProvider nodeAccessibilityProvider) {
        return new TextNodeAccessibilityProvider((TextNodeAccessibilityProvider) nodeAccessibilityProvider);
    }

    private void m4208h(int i) {
        Layout layout = this.f3172v.f3145b;
        if (layout instanceof BoringLayout) {
            ((BoringLayout) layout).replaceOrMake(this.f3158h, this.f3157g, i, m4199A(), this.f3162l, this.f3163m, this.f3160j, this.f3164n, this.f3165o, i);
        } else {
            this.f3172v.f3145b = new BoringLayout(this.f3158h, this.f3157g, i, m4199A(), this.f3162l, this.f3163m, this.f3160j, this.f3164n, this.f3165o, i);
        }
        this.f3159i = true;
        m4200C();
    }

    private final void m4209j(int i) {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat;
        int i2 = this.f3166p ? 1 : this.f3167q;
        CharSequence charSequence = this.f3158h;
        int length = this.f3158h.length();
        TextPaint textPaint = this.f3157g;
        Alignment A = m4199A();
        float f = this.f3162l;
        float f2 = this.f3163m;
        boolean z = this.f3164n;
        TruncateAt truncateAt = this.f3165o;
        if (this.f3170t) {
            textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.a;
        } else {
            textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.e;
        }
        this.f3172v.f3145b = StaticLayoutHelper.a(charSequence, 0, length, textPaint, i, A, f, f2, z, truncateAt, i, i2, textDirectionHeuristicCompat);
        this.f3159i = true;
        m4200C();
    }

    private final void m4207e(int i, int i2) {
        Layout layout = this.f3172v.f3145b;
        if (i2 != 1073741824) {
            float f = 0.0f;
            int lineCount = layout.getLineCount();
            for (int i3 = 0; i3 != lineCount; i3++) {
                f = Math.max(f, layout.getLineMax(i3));
            }
            i = (int) Math.ceil((double) f);
        }
        m4091c((this.f3081l + i) + this.f3082m, (layout.getHeight() + this.f3083n) + this.f3084o);
    }

    private Layout m4201D() {
        if (TextUtils.isEmpty(this.f3158h)) {
            return null;
        }
        if (!this.f3159i) {
            m4208h(this.f3089t);
        }
        return this.f3172v.f3145b;
    }

    public final int mo204d() {
        Layout D = m4201D();
        if (D == null) {
            return super.mo204d();
        }
        int F;
        if ((this.f3168r & 112) != 48) {
            F = m4203F();
        } else {
            F = 0;
        }
        return (F + m4204G()) + D.getLineBaseline(0);
    }

    private int m4202E() {
        int i;
        int G = m4204G();
        Layout layout = this.f3172v.f3145b;
        if (layout == null) {
            i = 0;
        } else if (layout.getLineCount() <= this.f3167q) {
            i = this.f3080k;
        } else {
            int i2 = this.f3083n;
            i = this.f3084o;
            i2 = (m4101m() - i2) - i;
            int lineTop = layout.getLineTop(this.f3167q);
            if (lineTop < i2) {
                int i3 = this.f3168r & 112;
                if (i3 == 48) {
                    i = (i + i2) - lineTop;
                } else if (i3 != 80) {
                    i += (i2 - lineTop) / 2;
                }
            }
        }
        return this.f3090u - (G + i);
    }

    private int m4203F() {
        int i = this.f3168r & 112;
        Layout layout = this.f3172v.f3145b;
        if (i == 48) {
            return 0;
        }
        int E = m4202E();
        int height = layout.getHeight();
        if (height >= E) {
            return 0;
        }
        if (i == 80) {
            return E - height;
        }
        return (E - height) >> 1;
    }

    private int m4204G() {
        Layout layout = this.f3172v.f3145b;
        if (layout == null) {
            return 0;
        }
        if (layout.getLineCount() <= this.f3167q) {
            return this.f3083n;
        }
        int i = this.f3083n;
        int m = (m4101m() - i) - this.f3084o;
        int lineTop = layout.getLineTop(this.f3167q);
        if (lineTop >= m) {
            return i;
        }
        int i2 = this.f3168r & 112;
        if (i2 == 48) {
            return i;
        }
        if (i2 == 80) {
            return (i + m) - lineTop;
        }
        return i + ((m - lineTop) / 2);
    }
}
