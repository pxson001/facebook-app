package com.facebook.fig.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.CallSuper;
import android.support.annotation.StyleRes;
import android.support.annotation.StyleableRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.Gravity;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView.BufferType;
import com.facebook.R;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.common.i18n.StringLengthHelper;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.fig.common.ViewUtils;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.utils.ResourceUtils;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: media_attachment_count */
public class FigButton extends FigBaseButton {
    private static SparseIntArray f10459j;
    int f10460a;
    int f10461b;
    int f10462c;
    int f10463d;
    int f10464e;
    int f10465f;
    ColorStateList f10466g;
    public Drawable f10467h;
    Rect f10468i = new Rect();
    @Inject
    private AllCapsTransformationMethod f10469k;
    private CharSequence f10470l;
    private boolean f10471m;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: media_attachment_count */
    public @interface FigButtonType {
    }

    private static <T extends View> void m16634a(Class<T> cls, T t) {
        m16635a((Object) t, t.getContext());
    }

    private static void m16635a(Object obj, Context context) {
        ((FigButton) obj).m16644a(AllCapsTransformationMethod.b(FbInjector.get(context)));
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f10459j = sparseIntArray;
        sparseIntArray.append(1, 2131624555);
        f10459j.append(2, 2131624556);
        f10459j.append(4, 2131624557);
        f10459j.append(8, 2131624558);
        f10459j.append(16, 2131624563);
        f10459j.append(32, 2131624561);
        f10459j.append(64, 2131624562);
        f10459j.append(128, 2131624565);
        f10459j.append(256, 2131624566);
        f10459j.append(512, 2131624567);
    }

    void m16644a(AllCapsTransformationMethod allCapsTransformationMethod) {
        this.f10469k = allCapsTransformationMethod;
    }

    public FigButton(Context context) {
        super(context);
        m16637b();
    }

    public FigButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m16637b();
        if (attributeSet != null) {
            m16633a(context, attributeSet);
        }
    }

    @CallSuper
    private void m16637b() {
        m16634a(FigButton.class, (View) this);
        this.f10471m = !RTLUtil.a(getContext());
        super.setGravity(17);
        super.setLines(1);
        super.setEllipsize(TruncateAt.END);
        super.setTransformationMethod(this.f10469k);
        super.setPadding(0, 0, 0, 0);
        setIncludeFontPadding(false);
        this.f10457a = true;
    }

    private void m16633a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FigButton);
        if (obtainStyledAttributes.hasValue(2)) {
            setType(obtainStyledAttributes.getInt(2, -1));
            setGlyph(obtainStyledAttributes.getDrawable(1));
            this.f10470l = ResourceUtils.a(context, obtainStyledAttributes, 0);
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalArgumentException("The buttonType attribute needs to be set via XML");
    }

    public int getType() {
        return this.f10460a;
    }

    public void setType(int i) {
        this.f10457a = false;
        m16638b(i);
        this.f10460a = i;
        m16632a(f10459j.get(i & 15, -1), R.styleable.FigButtonAttrs);
        m16632a(f10459j.get(i & 4080, -1), R.styleable.FigButtonAttrs);
        this.f10457a = true;
    }

    private static boolean m16636a(int i) {
        switch (i) {
            case 17:
            case 18:
            case 24:
            case 36:
            case 40:
            case 68:
            case 72:
            case 129:
            case 130:
            case 136:
            case 257:
            case 258:
            case 264:
            case 513:
            case 514:
            case 520:
                return true;
            default:
                return false;
        }
    }

    private void m16638b(int i) {
        if (!m16636a(i)) {
            throw new IllegalStateException(String.format("%s doesn't support the supplied type: 0x%X", new Object[]{getClass().getSimpleName(), Integer.valueOf(i)}));
        }
    }

    @CallSuper
    private void m16632a(@StyleRes int i, @StyleableRes int[] iArr) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, iArr);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == 2) {
                this.f10464e = obtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == 3) {
                this.f10465f = obtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == 5) {
                setTextSize(0, (float) obtainStyledAttributes.getDimensionPixelSize(index, 0));
            } else if (index == 8) {
                this.f10463d = obtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == 0) {
                this.f10461b = obtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == 1) {
                ViewUtils.m16664a(this, obtainStyledAttributes.getDrawable(index));
            } else if (index == 4) {
                this.f10466g = obtainStyledAttributes.getColorStateList(index);
                setTextColor(this.f10466g);
            } else if (index == 6) {
                this.f10462c = obtainStyledAttributes.getDimensionPixelSize(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public void setGlyph(int i) {
        setGlyph(ContextCompat.a(getContext(), i));
    }

    public void setGlyph(Drawable drawable) {
        if (drawable != this.f10467h) {
            this.f10467h = null;
            if (m16643e()) {
                this.f10457a = false;
                if (drawable != null) {
                    this.f10467h = DrawableCompat.c(drawable.mutate());
                    DrawableCompat.a(this.f10467h, this.f10466g);
                    this.f10467h.setState(getDrawableState());
                    setCompoundDrawablePadding(this.f10463d);
                }
                this.f10457a = true;
            }
            requestLayout();
            invalidate();
        }
    }

    private boolean m16639c() {
        return this.f10467h != null;
    }

    private Drawable getGlyph() {
        return this.f10467h;
    }

    public int getCompoundPaddingLeft() {
        if (this.f10471m) {
            return getCompoundPaddingStart();
        }
        return getCompoundPaddingEnd();
    }

    public int getCompoundPaddingRight() {
        if (this.f10471m) {
            return getCompoundPaddingEnd();
        }
        return getCompoundPaddingStart();
    }

    public int getCompoundPaddingStart() {
        return m16639c() ? (this.f10464e + this.f10462c) + this.f10463d : this.f10464e;
    }

    public int getCompoundPaddingEnd() {
        return this.f10465f;
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        super.setText(charSequence, bufferType);
        this.f10470l = null;
    }

    public void setShorterText(CharSequence charSequence) {
        this.f10470l = charSequence;
        requestLayout();
    }

    protected void onMeasure(int i, int i2) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -602168444);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f10461b, 1073741824);
        super.onMeasure(i, makeMeasureSpec);
        if (TextUtils.isEmpty(this.f10470l) || this.f10470l.equals(getText())) {
            Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1176824199, a);
            return;
        }
        if (m16641d()) {
            setText(this.f10470l);
            measure(i, makeMeasureSpec);
        }
        LogUtils.g(-110177827, a);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (m16639c()) {
            Layout layout = getLayout();
            String charSequence = layout.getText().toString();
            Rect a = ViewUtils.m16663a();
            layout.getPaint().getTextBounds(charSequence, 0, StringLengthHelper.a(charSequence), a);
            int width = (this.f10462c + this.f10463d) + a.width();
            a.set(0, 0, getWidth(), getHeight());
            Gravity.apply(17, width, 0, a, 0, 0, this.f10468i);
            width = (getHeight() - this.f10462c) >> 1;
            int i5 = this.f10471m ? this.f10468i.left : this.f10468i.right - this.f10462c;
            this.f10467h.setBounds(i5, width, this.f10462c + i5, this.f10462c + width);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (m16639c()) {
            this.f10467h.draw(canvas);
        }
    }

    private boolean m16641d() {
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

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (m16639c()) {
            this.f10467h.setState(getDrawableState());
        }
    }

    public void setLayoutParams(LayoutParams layoutParams) {
        if (!(layoutParams == null || mo1047a())) {
            layoutParams.width = -2;
        }
        super.setLayoutParams(layoutParams);
    }

    final boolean mo1047a() {
        return !m16640c(96);
    }

    private boolean m16643e() {
        return !m16642d(8);
    }

    private boolean m16640c(int i) {
        return (this.f10460a & i) > 0;
    }

    private boolean m16642d(int i) {
        return (this.f10460a & i) > 0;
    }
}
