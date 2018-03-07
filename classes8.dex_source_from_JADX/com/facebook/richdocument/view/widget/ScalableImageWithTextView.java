package com.facebook.richdocument.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.R;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.richdocument.ham.HamDimensions;
import com.facebook.richdocument.utils.OffUiThreadImageDecoder;
import com.facebook.richdocument.utils.OffUiThreadImageDecoder.DrawableDecodedCallback;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: offers_web_redirect_page */
public class ScalableImageWithTextView extends CustomLinearLayout {
    public final ImageView f7236a;
    @Inject
    public HamDimensions f7237b;
    @Inject
    public GatekeeperStoreImpl f7238c;
    @Inject
    public OffUiThreadImageDecoder f7239d;
    public final RichTextView f7240e;
    private boolean f7241f;
    private int f7242g;
    public int f7243h;

    /* compiled from: offers_web_redirect_page */
    class C08441 implements DrawableDecodedCallback {
        final /* synthetic */ ScalableImageWithTextView f7407a;

        C08441(ScalableImageWithTextView scalableImageWithTextView) {
            this.f7407a = scalableImageWithTextView;
        }

        public final void mo470a(int i, Drawable drawable) {
            if (i == this.f7407a.f7243h) {
                this.f7407a.f7236a.setImageDrawable(drawable);
            }
        }
    }

    private static <T extends View> void m7507a(Class<T> cls, T t) {
        m7508a((Object) t, t.getContext());
    }

    private static void m7508a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ScalableImageWithTextView scalableImageWithTextView = (ScalableImageWithTextView) obj;
        HamDimensions a = HamDimensions.m5268a(injectorLike);
        GatekeeperStoreImpl a2 = GatekeeperStoreImplMethodAutoProvider.a(injectorLike);
        OffUiThreadImageDecoder a3 = OffUiThreadImageDecoder.m6857a(injectorLike);
        scalableImageWithTextView.f7237b = a;
        scalableImageWithTextView.f7238c = a2;
        scalableImageWithTextView.f7239d = a3;
    }

    public ScalableImageWithTextView(Context context) {
        this(context, null);
    }

    public ScalableImageWithTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableImageWithTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7507a(ScalableImageWithTextView.class, (View) this);
        setOrientation(0);
        this.f7236a = new ImageView(getContext(), attributeSet);
        this.f7236a.setScaleType(ScaleType.FIT_XY);
        this.f7240e = new RichTextView(getContext(), attributeSet);
        setupChild(this.f7236a);
        setupChild(this.f7240e);
        this.f7240e.setPaddingRelative(this.f7237b.m5276b(2131558725), 0, 0, 0);
        this.f7236a.setPaddingRelative(0, 0, 0, 0);
        this.f7236a.setCropToPadding(false);
        ((LayoutParams) this.f7236a.getLayoutParams()).gravity = 16;
        ((LayoutParams) this.f7240e.getLayoutParams()).gravity = 16;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ScalableImageWithTextView, i, 0);
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            if (resourceId != 0) {
                this.f7236a.getLayoutParams().width = this.f7237b.m5276b(resourceId);
                this.f7236a.invalidate();
            }
            resourceId = obtainStyledAttributes.getResourceId(1, 0);
            if (resourceId != 0) {
                this.f7236a.getLayoutParams().height = this.f7237b.m5276b(resourceId);
                this.f7236a.invalidate();
            }
            resourceId = obtainStyledAttributes.getResourceId(2, 0);
            if (resourceId != 0) {
                setImageResource(resourceId);
            }
            resourceId = obtainStyledAttributes.getDimensionPixelSize(3, 0);
            if (resourceId != 0) {
                this.f7240e.setPaddingRelative(resourceId, 0, 0, 0);
            }
            obtainStyledAttributes.recycle();
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f7241f) {
            int measuredHeight = this.f7240e.getMeasuredHeight();
            int measuredHeight2 = this.f7236a.getMeasuredHeight();
            if (measuredHeight < measuredHeight2) {
                this.f7242g = (measuredHeight2 - measuredHeight) / 2;
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight() + (this.f7242g * 2));
                return;
            }
            this.f7242g = 0;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f7242g > 0) {
            int top = this.f7236a.getTop() + this.f7242g;
            this.f7236a.layout(this.f7236a.getLeft(), top, this.f7236a.getRight(), (this.f7236a.getBottom() - this.f7236a.getTop()) + top);
        }
    }

    private void setupChild(View view) {
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        addView(view, layoutParams);
    }

    public void setAlignImageToTextTop(boolean z) {
        if (this.f7241f != z) {
            this.f7242g = 0;
        }
        this.f7241f = z;
    }

    public RichTextView getRichTextView() {
        return this.f7240e;
    }

    public void setImageScaleX(float f) {
        this.f7236a.setScaleX(f);
    }

    public void setImageScaleY(float f) {
        this.f7236a.setScaleY(f);
    }

    public void setText(int i) {
        this.f7240e.f7393d.setText(i);
    }

    public void setImageResource(int i) {
        this.f7243h = i;
        if (this.f7238c.a(697, false)) {
            this.f7239d.m6859a(getContext(), i, new C08441(this));
        } else {
            this.f7236a.setImageResource(i);
        }
    }

    public Drawable getDrawable() {
        return this.f7236a.getDrawable();
    }

    public void setTextColor(int i) {
        this.f7240e.f7393d.setTextColor(i);
    }

    public Typeface getTypeface() {
        return this.f7240e.f7393d.getTypeface();
    }
}
