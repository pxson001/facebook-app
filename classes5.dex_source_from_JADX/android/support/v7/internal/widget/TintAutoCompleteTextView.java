package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.view.TintableBackgroundView;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

/* compiled from: unconnected_story */
public class TintAutoCompleteTextView extends AutoCompleteTextView implements TintableBackgroundView {
    private static final int[] f1203a = new int[]{16842964, 16843126};
    private TintManager f1204b;
    private TintInfo f1205c;

    public TintAutoCompleteTextView(Context context) {
        this(context, null);
    }

    public TintAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842859);
    }

    public TintAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.m1679a(context), attributeSet, i);
        if (TintManager.f1213a) {
            TintTypedArray a = TintTypedArray.m1693a(getContext(), attributeSet, f1203a, i, 0);
            this.f1204b = a.m1700c();
            if (a.m1702d(0)) {
                setSupportBackgroundTintList(this.f1204b.m1692b(a.m1704f(0, -1)));
            }
            if (a.m1702d(1)) {
                setDropDownBackgroundDrawable(a.m1695a(1));
            }
            a.m1698b();
        }
    }

    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(this.f1204b.m1690a(i));
    }

    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.f1205c == null) {
            this.f1205c = new TintInfo();
        }
        this.f1205c.f1211a = colorStateList;
        m1678a();
    }

    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        return this.f1205c != null ? this.f1205c.f1211a : null;
    }

    public void setSupportBackgroundTintMode(@Nullable Mode mode) {
        if (this.f1205c == null) {
            this.f1205c = new TintInfo();
        }
        this.f1205c.f1212b = mode;
        m1678a();
    }

    @Nullable
    public Mode getSupportBackgroundTintMode() {
        return this.f1205c != null ? this.f1205c.f1212b : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        m1678a();
    }

    private void m1678a() {
        if (getBackground() != null && this.f1205c != null) {
            TintInfo tintInfo = this.f1205c;
            Drawable background = getBackground();
            if (tintInfo.f1211a != null) {
                TintManager.m1682a(background, tintInfo.f1211a.getColorForState(getDrawableState(), tintInfo.f1211a.getDefaultColor()), tintInfo.f1212b != null ? tintInfo.f1212b : TintManager.f1214b);
            } else {
                background.clearColorFilter();
            }
        }
    }
}
