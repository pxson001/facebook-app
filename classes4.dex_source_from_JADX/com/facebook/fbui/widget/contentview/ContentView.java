package com.facebook.fbui.widget.contentview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.fbui.widget.layout.ImageBlockLayout.LayoutParams;
import com.facebook.fbui.widget.text.ResourceTextLayoutHelper;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

/* compiled from: templateParameters */
public class ContentView extends ImageBlockLayout {
    private static final int[] f1238h = new int[]{2130772413, 2130772414, 2130772415, 2130772416, 2130772417};
    private ThumbnailSize f1239i;
    private int f1240j;
    private TextHelper f1241k;
    private TextHelper f1242l;
    private TextHelper f1243m;
    private boolean f1244n;
    private boolean f1245o;
    private int f1246p;
    private int f1247q;

    public final /* synthetic */ LayoutParams m1492a(AttributeSet attributeSet) {
        return m1487b(attributeSet);
    }

    protected final /* synthetic */ LayoutParams m1493a(ViewGroup.LayoutParams layoutParams) {
        return m1488b(layoutParams);
    }

    protected final /* synthetic */ LayoutParams m1496d() {
        return m1490f();
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return m1490f();
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m1487b(attributeSet);
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m1488b(layoutParams);
    }

    public ContentView(Context context) {
        this(context, null);
    }

    public ContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130772407);
    }

    public ContentView(Context context, AttributeSet attributeSet, int i) {
        boolean z = false;
        super(context, attributeSet, i);
        this.f1244n = true;
        this.f1241k = new TextHelper(this);
        this.f1242l = new TextHelper(this);
        this.f1243m = new TextHelper(this);
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(2130772410, typedValue, true);
        ResourceTextLayoutHelper.a(this.f1241k.b, context, typedValue.resourceId);
        context.getTheme().resolveAttribute(2130772411, typedValue, true);
        ResourceTextLayoutHelper.a(this.f1242l.b, context, typedValue.resourceId);
        context.getTheme().resolveAttribute(2130772412, typedValue, true);
        ResourceTextLayoutHelper.a(this.f1243m.b, context, typedValue.resourceId);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ContentView, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(2, 0);
        if (resourceId > 0) {
            setTitleText(resourceId);
        } else {
            setTitleText(obtainStyledAttributes.getText(2));
        }
        resourceId = obtainStyledAttributes.getResourceId(3, 0);
        if (resourceId > 0) {
            setSubtitleText(resourceId);
        } else {
            setSubtitleText(obtainStyledAttributes.getText(3));
        }
        resourceId = obtainStyledAttributes.getResourceId(4, 0);
        if (resourceId > 0) {
            setMetaText(resourceId);
        } else {
            setMetaText(obtainStyledAttributes.getText(4));
        }
        resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId > 0) {
            setTitleTextAppearance(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(1, 0);
        if (resourceId > 0) {
            setSubtitleTextAppearance(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(7, 0);
        if (resourceId > 0) {
            setMetaTextAppearance(resourceId);
        }
        setThumbnailSize(ThumbnailSize.values()[obtainStyledAttributes.getInteger(5, 0)]);
        this.f1244n = obtainStyledAttributes.getBoolean(6, true);
        boolean hasValue = obtainStyledAttributes.hasValue(8);
        boolean hasValue2 = obtainStyledAttributes.hasValue(9);
        Preconditions.checkState(hasValue == hasValue2, "titleMaxLines and subtitleMaxLines must both be specified if one is specified");
        if (hasValue && hasValue2) {
            z = true;
        }
        this.f1245o = z;
        this.f1246p = obtainStyledAttributes.getInteger(8, 1);
        this.f1247q = obtainStyledAttributes.getInteger(9, 1);
        m1491g();
        obtainStyledAttributes.recycle();
        this.b = 16;
    }

    protected String getFeatureTag() {
        return "thumbnail";
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 2;
        int i4 = 0;
        if (this.f1244n || this.f1245o) {
            boolean z;
            int i5;
            boolean g = this.f1241k.g();
            boolean g2 = this.f1242l.g();
            boolean g3 = this.f1243m.g();
            if (!this.f1244n) {
                setTitleMaxLines(this.f1246p);
                setSubtitleMaxLines(this.f1247q);
                z = g3;
                g3 = g2;
            } else if (this.f1239i == ThumbnailSize.LARGE) {
                if (g3) {
                    setTitleMaxLines(1);
                } else {
                    setTitleMaxLines(2);
                }
                setSubtitleMaxLines(1);
                z = g3;
                g3 = g2;
            } else if (this.f1239i == ThumbnailSize.XLARGE) {
                setTitleMaxLines(2);
                if (g3) {
                    i3 = 1;
                }
                setSubtitleMaxLines(i3);
                z = g3;
                g3 = g2;
            } else {
                setTitleMaxLines(1);
                setSubtitleMaxLines(1);
                g3 = this.f1239i == ThumbnailSize.MEDIUM;
                z = false;
            }
            this.f1243m.c(1);
            TextHelper textHelper = this.f1241k;
            if (g) {
                i5 = 0;
            } else {
                i5 = 8;
            }
            textHelper.b(i5);
            textHelper = this.f1242l;
            if (g3) {
                i5 = 0;
            } else {
                i5 = 8;
            }
            textHelper.b(i5);
            TextHelper textHelper2 = this.f1243m;
            if (!z) {
                i4 = 8;
            }
            textHelper2.b(i4);
        }
        super.onMeasure(i, i2);
    }

    protected final void m1494a(int i, int i2) {
        this.f1241k.a(i, i2);
        int max = Math.max(0, this.f1241k.c());
        int f = (this.f1241k.f() + this.f1241k.d()) + 0;
        this.f1242l.a(i, i2);
        max = Math.max(max, this.f1242l.c());
        f += this.f1242l.f() + this.f1242l.d();
        this.f1243m.a(i, i2);
        b(Math.max(max, this.f1243m.c()), f + (this.f1243m.f() + this.f1243m.d()));
    }

    protected final void m1495a(int i, int i2, int i3) {
        this.f1241k.a(i, this.f1241k.e() + i2, i3);
        int f = (this.f1241k.f() + this.f1241k.d()) + i2;
        this.f1242l.a(i, this.f1242l.e() + f, i3);
        this.f1243m.a(i, (f + (this.f1242l.f() + this.f1242l.d())) + this.f1243m.e(), i3);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.f1241k.a(canvas);
        this.f1242l.a(canvas);
        this.f1243m.a(canvas);
    }

    private static LayoutParams m1490f() {
        return new LayoutParams(-2, -2);
    }

    private LayoutParams m1487b(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    private LayoutParams m1488b(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return (LayoutParams) layoutParams;
        }
        return m1490f();
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof LayoutParams);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            switch (1.a[((LayoutParams) layoutParams).e.ordinal()]) {
                case 1:
                    i = m1483a(this.f1241k, view, i);
                    break;
                case 2:
                    i = m1483a(this.f1242l, view, i);
                    break;
                case 3:
                    i = m1483a(this.f1243m, view, i);
                    break;
            }
        }
        super.addView(view, i, layoutParams);
        if (view == this.f) {
            setThumbnailSize(this.f1240j);
        }
    }

    private int m1483a(TextHelper textHelper, View view, int i) {
        View view2 = textHelper.a;
        if (view2 != null) {
            i = indexOfChild(view2);
            removeView(view2);
        }
        textHelper.a = view;
        textHelper.b = null;
        textHelper.c = null;
        return i;
    }

    public void removeView(View view) {
        if (view != null) {
            m1484a(view);
            super.removeView(view);
        }
    }

    public void removeViewInLayout(View view) {
        if (view != null) {
            m1484a(view);
            super.removeViewInLayout(view);
        }
    }

    private void m1484a(View view) {
        if (view.getLayoutParams() instanceof LayoutParams) {
            switch (1.a[((LayoutParams) view.getLayoutParams()).e.ordinal()]) {
                case 1:
                    this.f1241k.a = null;
                    this.f1241k.b = null;
                    this.f1241k.c = null;
                    return;
                case 2:
                    this.f1242l.a = null;
                    this.f1242l.b = null;
                    this.f1242l.c = null;
                    return;
                case 3:
                    this.f1243m.a = null;
                    this.f1243m.b = null;
                    this.f1243m.c = null;
                    return;
                default:
                    return;
            }
        }
    }

    private void setTitleMaxLines(int i) {
        this.f1246p = i;
        this.f1241k.c(i);
    }

    @VisibleForTesting
    public int getTitleMaxLines() {
        return this.f1246p;
    }

    private void setSubtitleMaxLines(int i) {
        this.f1247q = i;
        this.f1242l.c(i);
    }

    @VisibleForTesting
    public int getSubtitleMaxLines() {
        return this.f1247q;
    }

    protected final int getThumbnailDimensionSize() {
        int i;
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(f1238h[this.f1239i.ordinal()], typedValue, true);
        if (typedValue.resourceId == 0) {
            i = 2131427458;
        } else {
            i = typedValue.resourceId;
        }
        return getResources().getDimensionPixelSize(i);
    }

    public ThumbnailSize getThumbnailSize() {
        return this.f1239i;
    }

    public void setThumbnailSize(ThumbnailSize thumbnailSize) {
        if (thumbnailSize != this.f1239i) {
            this.f1239i = thumbnailSize;
            this.f1240j = getThumbnailDimensionSize();
            setThumbnailSize(this.f1240j);
            requestLayout();
        }
    }

    public void setThumbnailDrawable(Drawable drawable) {
        setThumbnailSize(this.f1240j);
        super.setThumbnailDrawable(drawable);
    }

    public void setMaxLinesFromThumbnailSize(boolean z) {
        if (this.f1244n != z) {
            this.f1244n = z;
            m1491g();
            requestLayout();
            invalidate();
        }
    }

    public final void m1497e(int i, int i2) {
        if (!this.f1245o || this.f1246p != i || this.f1247q != i2) {
            this.f1246p = i;
            this.f1247q = i2;
            this.f1245o = true;
            m1491g();
            requestLayout();
            invalidate();
        }
    }

    public final void nF_() {
        this.f1247q = 1;
        this.f1246p = 1;
        this.f1245o = false;
        requestLayout();
        invalidate();
    }

    private void m1491g() {
        boolean z = false;
        boolean z2 = this.f1246p >= 0 && this.f1247q >= 0;
        Preconditions.checkState(z2, "titleMaxLines and subtitleMaxLines must be non-negative");
        if (!(this.f1244n && this.f1245o)) {
            z = true;
        }
        Preconditions.checkState(z, "maxLinesFromThumbnailSize must be false if titleMaxLines and subtitleMaxLines are specified");
    }

    public View getTitleView() {
        return this.f1241k.a;
    }

    public void setTitleText(CharSequence charSequence) {
        this.f1241k.a(charSequence);
        requestLayout();
        invalidate();
    }

    public void setTitleText(int i) {
        this.f1241k.a(getContext().getText(i));
        requestLayout();
        invalidate();
    }

    public void setTitleGravity(int i) {
        this.f1241k.a(i);
        requestLayout();
        invalidate();
    }

    public CharSequence getTitleText() {
        return this.f1241k.b();
    }

    public Layout getTitleLayout() {
        switch (1.b[this.f1241k.a().ordinal()]) {
            case 1:
                if (this.f1241k.a instanceof TextView) {
                    return ((TextView) this.f1241k.a).getLayout();
                }
                return null;
            case 2:
                return this.f1241k.c;
            default:
                return null;
        }
    }

    public View getSubtitleView() {
        return this.f1242l.a;
    }

    public void setSubtitleText(CharSequence charSequence) {
        this.f1242l.a(charSequence);
        requestLayout();
        invalidate();
    }

    public void setSubtitleText(int i) {
        this.f1242l.a(getContext().getText(i));
        requestLayout();
        invalidate();
    }

    public void setSubtitleGravity(int i) {
        this.f1242l.a(i);
        requestLayout();
        invalidate();
    }

    public CharSequence getSubtitleText() {
        return this.f1242l.b();
    }

    public Layout getSubitleLayout() {
        switch (1.b[this.f1242l.a().ordinal()]) {
            case 1:
                if (this.f1242l.a instanceof TextView) {
                    return ((TextView) this.f1242l.a).getLayout();
                }
                return null;
            case 2:
                return this.f1242l.c;
            default:
                return null;
        }
    }

    public View getMetaView() {
        return this.f1243m.a;
    }

    public void setMetaText(CharSequence charSequence) {
        this.f1243m.a(charSequence);
        requestLayout();
        invalidate();
    }

    public void setMetaText(int i) {
        this.f1243m.a(getContext().getText(i));
        requestLayout();
        invalidate();
    }

    public CharSequence getMetaText() {
        return this.f1243m.b();
    }

    public Layout getMetaLayout() {
        switch (1.b[this.f1243m.a().ordinal()]) {
            case 1:
                if (this.f1243m.a instanceof TextView) {
                    return ((TextView) this.f1243m.a).getLayout();
                }
                return null;
            case 2:
                return this.f1243m.c;
            default:
                return null;
        }
    }

    public void setTitleTextAppearance(int i) {
        this.f1241k.d(i);
        requestLayout();
        invalidate();
    }

    public void setSubtitleTextAppearance(int i) {
        this.f1242l.d(i);
        requestLayout();
        invalidate();
    }

    public void setMetaTextAppearance(int i) {
        this.f1243m.d(i);
        requestLayout();
        invalidate();
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        this.f1241k.a(accessibilityEvent);
        this.f1242l.a(accessibilityEvent);
        this.f1243m.a(accessibilityEvent);
        super.onPopulateAccessibilityEvent(accessibilityEvent);
    }
}
