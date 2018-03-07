package com.facebook.friends.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.DrawableRes;
import android.support.annotation.StyleRes;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.facebook.R;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomViewUtils;
import javax.inject.Inject;

/* compiled from: mStringCustomLocation */
public class SmartButtonLite extends ImageWithTextView {
    @Inject
    public Lazy<FbErrorReporter> f10854a;
    private CharSequence f10855b;
    private float f10856c;
    private int f10857d;
    private int f10858e;

    private static <T extends View> void m17430a(Class<T> cls, T t) {
        m17431a((Object) t, t.getContext());
    }

    private static void m17431a(Object obj, Context context) {
        ((SmartButtonLite) obj).f10854a = IdBasedSingletonScopeProvider.b(FbInjector.get(context), 494);
    }

    public SmartButtonLite(Context context) {
        super(context);
        m17428a(context, null, 0);
    }

    public SmartButtonLite(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17428a(context, attributeSet, 0);
    }

    public SmartButtonLite(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17428a(context, attributeSet, i);
    }

    private void m17429a(Lazy<FbErrorReporter> lazy) {
        this.f10854a = lazy;
    }

    private void m17428a(Context context, AttributeSet attributeSet, int i) {
        m17430a(SmartButtonLite.class, (View) this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmartButtonLite, i, 0);
        this.f10856c = obtainStyledAttributes.getDimension(2, 0.0f);
        obtainStyledAttributes.recycle();
    }

    protected void onMeasure(int i, int i2) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1365766664);
        super.onMeasure(i, i2);
        this.f10857d = i;
        this.f10858e = i2;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -516939257, a);
    }

    public void setPreferredFontPixelSize(float f) {
        this.f10856c = f;
    }

    public final void m17434a(CharSequence charSequence, CharSequence charSequence2) {
        setText(charSequence);
        this.f10855b = charSequence2;
        requestLayout();
    }

    public void setShorterText(CharSequence charSequence) {
        this.f10855b = charSequence;
        requestLayout();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!StringUtil.a(this.f10855b) && !this.f10855b.equals(getText()) && m17432b()) {
            setText(this.f10855b);
            measure(this.f10857d, this.f10858e);
        }
    }

    public void setStyle(int i) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i, typedValue, true);
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(typedValue.resourceId, R.styleable.SmartButtonLite);
        int resourceId = obtainStyledAttributes.getResourceId(1, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        if (resourceId == 0 || resourceId2 == 0) {
            if (resourceId == 0) {
                ((AbstractFbErrorReporter) this.f10854a.get()).a("SmartButtonLite.setStyle", "backgroundResId is not defined or not a resource.");
            }
            if (resourceId2 == 0) {
                ((AbstractFbErrorReporter) this.f10854a.get()).a("SmartButtonLite.setStyle", "textAppearanceResId is not defined or not a resource.");
                return;
            }
            return;
        }
        m17433a(resourceId, resourceId2);
    }

    public final void m17433a(@DrawableRes int i, @StyleRes int i2) {
        CustomViewUtils.a(this, getResources().getDrawable(i));
        setTextAppearance(getContext(), i2);
        if (this.f10856c > 0.0f) {
            setTextSize(0, this.f10856c);
        }
    }

    private boolean m17432b() {
        Layout layout = getLayout();
        if (layout == null) {
            return false;
        }
        int lineCount = layout.getLineCount();
        if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
            return false;
        }
        return true;
    }
}
