package com.facebook.privacy.checkup.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.R;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.FbInjector;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: SUGGESTIONS_BANNER */
public class StepByStepCircleProgressBar extends View {
    @Inject
    GlyphColorizer f11247a;
    @Inject
    Resources f11248b;
    private int f11249c;
    private int f11250d;
    private int f11251e;
    private int f11252f;
    private int f11253g;
    private boolean f11254h;
    private List<ShapeDrawable> f11255i;
    private List<Drawable> f11256j;
    private Paint f11257k;
    private Paint f11258l;
    private int f11259m;
    private int f11260n;

    private static <T extends View> void m11643a(Class<T> cls, T t) {
        m11644a((Object) t, t.getContext());
    }

    private static void m11644a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((StepByStepCircleProgressBar) obj).m11642a(GlyphColorizer.a(fbInjector), ResourcesMethodAutoProvider.a(fbInjector));
    }

    public StepByStepCircleProgressBar(Context context) {
        super(context);
    }

    public StepByStepCircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11641a(attributeSet);
    }

    public StepByStepCircleProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11641a(attributeSet);
    }

    private void m11641a(AttributeSet attributeSet) {
        m11643a(StepByStepCircleProgressBar.class, (View) this);
        this.f11259m = this.f11248b.getColor(2131361916);
        this.f11260n = this.f11248b.getColor(2131361940);
        this.f11257k = new Paint();
        this.f11257k.setColor(this.f11259m);
        this.f11258l = new Paint();
        this.f11258l.setColor(this.f11260n);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.StepByStepCircleProgressBarView);
            this.f11249c = obtainStyledAttributes.getInt(0, 2);
            this.f11250d = obtainStyledAttributes.getInt(1, 0);
            this.f11251e = obtainStyledAttributes.getDimensionPixelSize(2, 0);
            this.f11253g = obtainStyledAttributes.getDimensionPixelSize(4, 0);
            this.f11252f = obtainStyledAttributes.getDimensionPixelSize(3, 0);
            this.f11254h = obtainStyledAttributes.getBoolean(5, false);
            obtainStyledAttributes.recycle();
        }
    }

    private void m11640a() {
        this.f11255i = new ArrayList(this.f11249c);
        if (this.f11254h) {
            this.f11256j = new ArrayList(this.f11250d);
        }
        int color = this.f11248b.getColor(2131361920);
        for (int i = 0; i < this.f11249c; i++) {
            this.f11255i.add(new ShapeDrawable(new OvalShape()));
            if (this.f11254h) {
                this.f11256j.add(this.f11247a.a(2130839774, color));
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3 = ((this.f11251e + this.f11252f) * this.f11249c) - this.f11252f;
        int i4 = this.f11251e;
        setMeasuredDimension(View.resolveSize(Math.max(i3, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i4, getSuggestedMinimumHeight()), i2));
    }

    protected void onDraw(Canvas canvas) {
        m11640a();
        float f = ((float) (this.f11251e - this.f11253g)) / 2.0f;
        float f2 = ((float) (this.f11251e + this.f11253g)) / 2.0f;
        if (this.f11250d > 0) {
            canvas.drawRect(((float) this.f11251e) / 2.0f, f, ((float) ((this.f11251e + this.f11252f) * this.f11250d)) + (((float) this.f11251e) / 2.0f), f2, this.f11257k);
        }
        if (this.f11250d < this.f11249c - 1) {
            canvas.drawRect(((float) ((this.f11251e + this.f11252f) * this.f11250d)) + (((float) this.f11251e) / 2.0f), f, ((float) ((this.f11251e + this.f11252f) * (this.f11249c - 1))) + (((float) this.f11251e) / 2.0f), f2, this.f11258l);
        }
        int i = 0;
        while (i < this.f11249c) {
            int i2 = i * (this.f11251e + this.f11252f);
            ShapeDrawable shapeDrawable = (ShapeDrawable) this.f11255i.get(i);
            shapeDrawable.setBounds(i2, 0, this.f11251e + i2, this.f11251e);
            shapeDrawable.getPaint().setColor(i <= this.f11250d ? this.f11259m : this.f11260n);
            shapeDrawable.draw(canvas);
            if (this.f11254h && i < this.f11250d) {
                Drawable drawable = (Drawable) this.f11256j.get(i);
                drawable.setBounds(i2, 0, this.f11251e + i2, this.f11251e);
                drawable.draw(canvas);
            }
            i++;
        }
    }

    public void setNumSteps(int i) {
        Preconditions.checkArgument(i > 0);
        this.f11249c = i;
    }

    public void setCurrentStep(int i) {
        boolean z = i >= 0 && i < this.f11249c;
        Preconditions.checkArgument(z, "Current step must be between [0, mNumSteps-1], inclusive.");
        this.f11250d = i;
    }

    private void m11642a(GlyphColorizer glyphColorizer, Resources resources) {
        this.f11247a = glyphColorizer;
        this.f11248b = resources;
    }
}
