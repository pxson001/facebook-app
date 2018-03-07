package com.facebook.fig.sectionheader;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.accessibility.AccessibilityEvent;
import com.facebook.R;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.fbui.widget.layout.ImageBlockLayout.LayoutParams;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.fig.common.FigTextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ultralight.Inject;

/* compiled from: mechanism_my_location_button */
public class FigSectionHeader extends ImageBlockLayout {
    @Inject
    public AllCapsTransformationMethod f10521h;
    private FigTextHelper f10522i;

    private static <T extends View> void m16686a(Class<T> cls, T t) {
        m16687a((Object) t, t.getContext());
    }

    private static void m16687a(Object obj, Context context) {
        ((FigSectionHeader) obj).f10521h = AllCapsTransformationMethod.b(FbInjector.get(context));
    }

    private void m16685a(AllCapsTransformationMethod allCapsTransformationMethod) {
        this.f10521h = allCapsTransformationMethod;
    }

    public FigSectionHeader(Context context) {
        super(context);
        m16684a(null, 0);
    }

    public FigSectionHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16684a(attributeSet, 0);
    }

    public FigSectionHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16684a(attributeSet, i);
    }

    private void m16684a(AttributeSet attributeSet, int i) {
        m16686a(FigSectionHeader.class, (View) this);
        this.f10522i = new FigTextHelper();
        FbTextView fbTextView = new FbTextView(getContext());
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.b = true;
        layoutParams.d = 17;
        fbTextView.setTextAppearance(getContext(), 2131624526);
        fbTextView.setTextAppearance(getContext(), 2131624531);
        super.addView(fbTextView, 0, layoutParams);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(2131430823);
        int dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(2131430824);
        super.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        super.setThumbnailPadding(dimensionPixelSize);
        super.setThumbnailSize(dimensionPixelSize2);
        setAuxViewPadding(dimensionPixelSize);
        this.f10522i.m16659b(1);
        this.f10522i.m16653a(getContext(), 2131624531);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.FigSectionHeader, i, 0);
            dimensionPixelSize2 = obtainStyledAttributes.getResourceId(0, 0);
            if (dimensionPixelSize2 > 0) {
                setTitleText(dimensionPixelSize2);
            } else {
                setTitleText(obtainStyledAttributes.getText(0));
            }
            dimensionPixelSize2 = obtainStyledAttributes.getResourceId(1, 0);
            if (dimensionPixelSize2 > 0) {
                setActionText(dimensionPixelSize2);
            } else {
                setActionText(obtainStyledAttributes.getText(1));
            }
            if (!this.f10522i.m16662d()) {
                this.a.setVisibility(8);
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setThumbnailPadding(int i) {
    }

    public void setThumbnailSize(int i) {
    }

    protected final void m16688a(int i, int i2) {
        this.f10522i.m16661c(i);
        b(Math.max(0, this.f10522i.m16658b()), this.f10522i.m16660c() + 0);
    }

    protected final void m16689a(int i, int i2, int i3) {
        this.f10522i.m16657a(c(), i, i2, i3);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.f10522i.m16654a(canvas);
    }

    public void setTitleText(CharSequence charSequence) {
        this.f10522i.m16656a(this.f10521h.getTransformation(charSequence, null));
        requestLayout();
        invalidate();
    }

    public void setTitleText(int i) {
        setTitleText(getContext().getText(i));
    }

    public void setActionText(CharSequence charSequence) {
        ((FbTextView) this.a).setText(charSequence);
    }

    public void setActionText(int i) {
        ((FbTextView) this.a).setText(i);
    }

    public void setActionOnClickListener(OnClickListener onClickListener) {
        this.a.setOnClickListener(onClickListener);
    }

    public void setActionContentDescription(CharSequence charSequence) {
        this.a.setContentDescription(charSequence);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        this.f10522i.m16655a(accessibilityEvent);
        return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }
}
