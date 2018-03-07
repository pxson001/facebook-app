package com.facebook.caspian.ui.standardheader;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeView;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.google.common.base.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: creativecam_switch_camera_facing */
public class StandardProfileImageView extends DraweeView {
    private static final Class<?> f16585a = StandardProfileImageView.class;
    @Nullable
    private ImageWithTextView f16586b;
    private int f16587c;
    private Drawable f16588d;
    private Drawable f16589e;
    private Drawable f16590f;
    private List<Drawable> f16591g;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: creativecam_switch_camera_facing */
    public @interface EditAffordance {
    }

    public StandardProfileImageView(Context context) {
        this(context, null);
        m20641a(context);
    }

    public StandardProfileImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16587c = 0;
        this.f16591g = null;
        m20641a(context);
    }

    private void m20641a(Context context) {
        setClickable(true);
        this.f16588d = context.getResources().getDrawable(2130843447);
        this.f16589e = context.getResources().getDrawable(2130841703);
        this.f16590f = context.getResources().getDrawable(2130843446);
        setEnableDarkOverlay(false);
    }

    public void setEditAffordance(int i) {
        boolean z = true;
        if (!(i == 0 || i == 1 || i == 2)) {
            z = false;
        }
        Preconditions.checkArgument(z, "Invalid edit affordance value: " + i);
        this.f16587c = i;
        requestLayout();
    }

    public void setEnableDarkOverlay(boolean z) {
        if (z) {
            if (this.f16591g == null) {
                this.f16591g = new ArrayList(2);
                this.f16591g.add(this.f16590f);
                this.f16591g.add(new ColorDrawable(getContext().getResources().getColor(2131362080)));
            }
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(getContext().getResources());
            genericDraweeHierarchyBuilder.f = this.f16588d;
            genericDraweeHierarchyBuilder = genericDraweeHierarchyBuilder;
            genericDraweeHierarchyBuilder.h = this.f16589e;
            genericDraweeHierarchyBuilder = genericDraweeHierarchyBuilder;
            genericDraweeHierarchyBuilder.s = this.f16591g;
            setHierarchy(genericDraweeHierarchyBuilder.u());
            return;
        }
        genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(getContext().getResources());
        genericDraweeHierarchyBuilder.f = this.f16588d;
        genericDraweeHierarchyBuilder = genericDraweeHierarchyBuilder;
        genericDraweeHierarchyBuilder.h = this.f16589e;
        setHierarchy(genericDraweeHierarchyBuilder.f(this.f16590f).u());
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        switch (this.f16587c) {
            case 0:
                return;
            case 1:
            case 2:
                int height = getHeight() - m20640a(this.f16587c).getMeasuredHeight();
                canvas.save();
                canvas.translate(0.0f, (float) height);
                m20640a(this.f16587c).draw(canvas);
                canvas.restore();
                return;
            default:
                BLog.b(f16585a, "Expected a valid EditAffordance, got: %s", new Object[]{Integer.valueOf(this.f16587c)});
                return;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f16587c != 0) {
            m20640a(this.f16587c).layout(0, 0, getMeasuredWidth(), m20640a(this.f16587c).getMeasuredHeight());
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f16587c != 0) {
            ViewCompat.a.e(m20640a(this.f16587c), ViewCompat.h(this));
            m20640a(this.f16587c).measure(MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i), Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), Integer.MIN_VALUE));
        }
    }

    private ImageWithTextView m20640a(int i) {
        if (this.f16586b == null) {
            if (i == 1) {
                this.f16586b = (ImageWithTextView) LayoutInflater.from(getContext()).inflate(2130907216, (ViewGroup) getParent(), false);
            } else if (i == 2) {
                this.f16586b = (ImageWithTextView) LayoutInflater.from(getContext()).inflate(2130907217, (ViewGroup) getParent(), false);
                this.f16586b.setImageDrawable(new GlyphColorizer(getResources()).a(2130839751, -1));
            }
            LayoutParams layoutParams = this.f16586b.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
        }
        return this.f16586b;
    }
}
