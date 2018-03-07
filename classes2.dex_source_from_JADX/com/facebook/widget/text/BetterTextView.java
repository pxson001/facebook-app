package com.facebook.widget.text;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.common.lifecycle.AttachDetachListener;
import com.facebook.common.util.TextRTLUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.text.CustomFontHelper.FontFamily;
import com.facebook.widget.text.CustomFontHelper.FontWeight;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: report_spam_link */
public class BetterTextView extends FbTextView {
    private List<BetterTextViewHook> f7467a;
    private boolean f7468b;
    private boolean f7469c;
    private int f7470d;
    private boolean f7471e;
    private boolean f7472f;
    public boolean f7473g;
    private boolean f7474h;
    private AttachDetachListener f7475i;

    public BetterTextView(Context context) {
        this(context, null, 0);
    }

    public BetterTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BetterTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BetterTextView, i, 0);
        this.f7468b = obtainStyledAttributes.getBoolean(3, false);
        this.f7469c = obtainStyledAttributes.getBoolean(4, false);
        this.f7470d = obtainStyledAttributes.getDimensionPixelOffset(5, -1);
        this.f7471e = obtainStyledAttributes.getBoolean(6, false);
        this.f7472f = obtainStyledAttributes.getBoolean(7, false);
        CustomFontHelper.m11814a((TextView) this, FontFamily.fromIndex(obtainStyledAttributes.getInt(0, FontFamily.BUILTIN.ordinal())), FontWeight.fromIndex(obtainStyledAttributes.getInt(1, FontWeight.BUILTIN.ordinal())), getTypeface());
        if (obtainStyledAttributes.getBoolean(2, false)) {
            setTransformationMethod(new AllCapsTransformationMethod(context));
        }
        obtainStyledAttributes.recycle();
    }

    public float getMaximallyWideThreshold() {
        return (float) this.f7470d;
    }

    public void setMaximallyWideThreshold(int i) {
        this.f7470d = i;
    }

    public boolean getMinimallyWide() {
        return this.f7468b;
    }

    public void setMinimallyWide(boolean z) {
        this.f7468b = z;
        requestLayout();
    }

    public final void m12083a(BetterTextViewHook betterTextViewHook) {
        if (this.f7467a == null) {
            this.f7467a = Lists.m1296a();
        }
        this.f7467a.add(betterTextViewHook);
    }

    public final void m12085b(BetterTextViewHook betterTextViewHook) {
        if (this.f7467a != null && betterTextViewHook != null) {
            this.f7467a.remove(betterTextViewHook);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 2134529245);
        boolean z = false;
        if (this.f7467a != null) {
            for (BetterTextViewHook a2 : this.f7467a) {
                z = a2.a(motionEvent);
                if (z) {
                    break;
                }
            }
        }
        if (!z) {
            z = super.onTouchEvent(motionEvent);
        }
        LogUtils.a(358378038, a);
        return z;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = true;
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1828579077);
        int mode = MeasureSpec.getMode(i2);
        if (this.f7472f && (mode == Integer.MIN_VALUE || mode == 1073741824)) {
            setMaxLines(((MeasureSpec.getSize(i2) - getPaddingBottom()) - getPaddingTop()) / getLineHeight());
        }
        super.onMeasure(i, i2);
        if (getLineCount() > 1) {
            int a2;
            mode = MeasureSpec.getMode(i);
            if (this.f7470d > 0 && mode == Integer.MIN_VALUE) {
                int size = MeasureSpec.getSize(i);
                if ((mo2813a(false) + getCompoundPaddingLeft()) + getCompoundPaddingRight() >= size - this.f7470d) {
                    if (size != getMeasuredWidth()) {
                        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    }
                    if (this.f7468b && ((mode == 1073741824 || mode == Integer.MIN_VALUE) && !r0)) {
                        a2 = (mo2813a(this.f7469c) + getCompoundPaddingLeft()) + getCompoundPaddingRight();
                        if (a2 < getMeasuredWidth()) {
                            super.onMeasure(MeasureSpec.makeMeasureSpec(a2, 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                        }
                    }
                }
            }
            z = false;
            a2 = (mo2813a(this.f7469c) + getCompoundPaddingLeft()) + getCompoundPaddingRight();
            if (a2 < getMeasuredWidth()) {
                super.onMeasure(MeasureSpec.makeMeasureSpec(a2, 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 213272482, a);
    }

    protected void onDraw(Canvas canvas) {
        if (this.f7467a != null) {
            for (BetterTextViewHook a : this.f7467a) {
                a.a(canvas);
            }
        }
        if ((getTransformationMethod() instanceof SingleLineTransformationMethod) && getMovementMethod() != null) {
            bringPointIntoView(0);
        }
        super.onDraw(canvas);
    }

    private int mo2813a(boolean z) {
        Layout layout = getLayout();
        int lineCount = layout.getLineCount();
        float f = 0.0f;
        for (int i = 0; i < lineCount; i++) {
            float lineWidth;
            if (z) {
                lineWidth = layout.getLineWidth(i);
            } else {
                lineWidth = layout.getLineMax(i);
            }
            f = Math.max(f, lineWidth);
        }
        return (int) f;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        this.f7473g = TextRTLUtil.m12086a(this, charSequence, i3);
    }

    public final boolean m12084a() {
        return this.f7473g;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 161653103);
        super.onAttachedToWindow();
        this.f7474h = true;
        if (this.f7475i != null) {
            this.f7475i.a(this);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1943345237, a);
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f7474h = true;
        if (this.f7475i != null) {
            this.f7475i.a(this);
        }
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -343229399);
        this.f7474h = false;
        if (this.f7475i != null) {
            this.f7475i.b(this);
        }
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1480510811, a);
    }

    public void onStartTemporaryDetach() {
        this.f7474h = false;
        if (this.f7475i != null) {
            this.f7475i.b(this);
        }
        super.onStartTemporaryDetach();
    }

    public void setAttachDetachListener(AttachDetachListener attachDetachListener) {
        if (this.f7475i != null) {
            this.f7475i.b(this);
        }
        this.f7475i = attachDetachListener;
        if (this.f7475i != null && this.f7474h) {
            this.f7475i.a(this);
        }
    }
}
