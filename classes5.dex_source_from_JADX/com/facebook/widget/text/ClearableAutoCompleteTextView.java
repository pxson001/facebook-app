package com.facebook.widget.text;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.facebook.R;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbAutoCompleteTextView;

/* compiled from: com.facebook.katana.login.LoginActivityComponent */
public class ClearableAutoCompleteTextView extends FbAutoCompleteTextView {
    private Drawable f5853b;

    public ClearableAutoCompleteTextView(Context context) {
        this(context, null);
    }

    public ClearableAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842859);
    }

    public ClearableAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10599a(context, attributeSet, i);
    }

    private void m10599a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BetterEditTextView, i, 0);
        this.f5853b = obtainStyledAttributes.getDrawable(2);
        if (this.f5853b == null) {
            this.f5853b = getResources().getDrawable(2130838319);
        }
        obtainStyledAttributes.recycle();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1210508626);
        if (motionEvent.getAction() == 1 && m10602a(motionEvent)) {
            setText("");
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        Logger.a(2, EntryType.UI_INPUT_END, 242983379, a);
        return onTouchEvent;
    }

    private boolean m10601a() {
        Drawable drawable;
        if (RTLUtil.a(getContext())) {
            drawable = getCompoundDrawables()[0];
        } else {
            drawable = getCompoundDrawables()[2];
        }
        if (this.f5853b == null || this.f5853b != r0) {
            return false;
        }
        return true;
    }

    private boolean m10602a(MotionEvent motionEvent) {
        boolean z = !RTLUtil.a(getContext()) ? motionEvent.getX() > ((float) (getWidth() - getCompoundPaddingRight())) : motionEvent.getX() < ((float) getCompoundPaddingLeft());
        if (z && m10601a()) {
            return true;
        }
        return false;
    }

    private void m10600a(CharSequence charSequence) {
        if (this.f5853b != null) {
            if (StringUtil.a(charSequence)) {
                m10604c();
            } else {
                m10603b();
            }
        }
    }

    private void m10603b() {
        setEndDrawable(this.f5853b);
    }

    private void m10604c() {
        setEndDrawable(null);
    }

    private void setEndDrawable(Drawable drawable) {
        boolean a = RTLUtil.a(getContext());
        Drawable[] compoundDrawables = getCompoundDrawables();
        Drawable drawable2 = a ? drawable : compoundDrawables[0];
        if (a) {
            drawable = compoundDrawables[2];
        }
        setCompoundDrawablesWithIntrinsicBounds(drawable2, compoundDrawables[1], drawable, compoundDrawables[3]);
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        m10600a(charSequence);
    }
}
