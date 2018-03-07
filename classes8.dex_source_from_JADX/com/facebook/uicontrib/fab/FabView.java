package com.facebook.uicontrib.fab;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.R;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.FbInjector;
import com.facebook.uicontrib.fab.FabDrawable.FabType;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mComposerDateInfo */
public class FabView extends View {
    private static final FabType f9552b = FabType.BIG;
    private static final int f9553c = 2131361916;
    @Inject
    public FabDrawable f9554a;
    private int f9555d;
    @Nullable
    private Integer f9556e;
    @Nullable
    private Integer f9557f;

    private static <T extends View> void m11234a(Class<T> cls, T t) {
        m11235a((Object) t, t.getContext());
    }

    private static void m11235a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FabView) obj).f9554a = new FabDrawable(ResourcesMethodAutoProvider.a(fbInjector), GlyphColorizer.a(fbInjector));
    }

    public FabView(Context context) {
        super(context);
        m11237b(null);
    }

    public FabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11237b(attributeSet);
    }

    public FabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11237b(attributeSet);
    }

    private void m11237b(AttributeSet attributeSet) {
        m11234a(FabView.class, (View) this);
        setClickable(true);
        m11238a(attributeSet);
        this.f9554a.setCallback(this);
    }

    public final void m11238a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.FabView, 0, 0);
        try {
            this.f9554a.m11228a(obtainStyledAttributes.getBoolean(6, true));
            this.f9554a.m11227a(m11231a(obtainStyledAttributes));
            m11236b(obtainStyledAttributes);
            this.f9554a.m11230c(obtainStyledAttributes.getResourceId(4, 0));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private static FabType m11231a(TypedArray typedArray) {
        int i = typedArray.getInt(0, -1);
        for (FabType fabType : FabType.values()) {
            if (i == fabType.getAttrEnumValue()) {
                return fabType;
            }
        }
        return f9552b;
    }

    public void setType(FabType fabType) {
        this.f9554a.m11227a(fabType);
        requestLayout();
    }

    private void m11236b(TypedArray typedArray) {
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            this.f9555d = colorStateList.getDefaultColor();
        } else {
            this.f9555d = getResources().getColor(f9553c);
        }
        m11232a();
        ColorStateList colorStateList2 = typedArray.getColorStateList(2);
        if (colorStateList != null) {
            this.f9556e = Integer.valueOf(colorStateList2.getDefaultColor());
        } else {
            this.f9556e = null;
        }
        this.f9557f = Integer.valueOf(typedArray.getInt(3, 200));
        colorStateList = typedArray.getColorStateList(5);
        if (colorStateList != null) {
            this.f9554a.m11229b(colorStateList.getDefaultColor());
        }
    }

    public FabType getType() {
        return this.f9554a.f9544f;
    }

    public void setShowShadow(boolean z) {
        this.f9554a.m11228a(z);
        invalidate();
    }

    public void setFillColor(int i) {
        this.f9555d = i;
        m11232a();
        invalidate();
    }

    public int getFillColor() {
        return this.f9555d;
    }

    public void setPressedFillColor(@Nullable Integer num) {
        this.f9556e = num;
        invalidate();
    }

    @Nullable
    public Integer getPressedFillColor() {
        return this.f9556e;
    }

    public void setPressedFillAlpha(@Nullable Integer num) {
        this.f9557f = num;
        invalidate();
    }

    @Nullable
    public Integer getPressedFillAlpha() {
        return this.f9557f;
    }

    public void setGlyphColor(int i) {
        this.f9554a.m11229b(i);
        invalidate();
    }

    public void setGlyphID(int i) {
        this.f9554a.m11230c(i);
        invalidate();
    }

    public void setGlyph(@Nullable Drawable drawable) {
        this.f9554a.m11226a(drawable);
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f9554a.draw(canvas);
    }

    protected void onMeasure(int i, int i2) {
        int fullSize = getType().getFullSize(getResources());
        setMeasuredDimension(View.resolveSize(fullSize, i), View.resolveSize(fullSize, i2));
        this.f9554a.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        m11232a();
        invalidate();
    }

    private void m11232a() {
        if (!isPressed()) {
            this.f9554a.m11225a(this.f9555d);
            this.f9554a.setAlpha(255);
        } else if (this.f9556e != null) {
            this.f9554a.m11225a(this.f9556e.intValue());
        } else {
            this.f9554a.m11225a(this.f9555d);
            this.f9554a.setAlpha(this.f9557f.intValue());
        }
    }

    private void m11233a(FabDrawable fabDrawable) {
        this.f9554a = fabDrawable;
    }
}
