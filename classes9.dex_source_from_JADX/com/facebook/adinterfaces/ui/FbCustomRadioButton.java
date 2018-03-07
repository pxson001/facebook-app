package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.ImageButton;
import android.widget.RadioButton;
import com.facebook.R;
import com.facebook.adinterfaces.ui.EditableRadioGroup.CheckedStateTracker;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import com.facebook.widget.text.CustomFontHelper;
import com.facebook.widget.text.CustomFontHelper.FontFamily;
import com.facebook.widget.text.CustomFontHelper.FontWeight;

/* compiled from: Unknown request code  */
public class FbCustomRadioButton extends CustomLinearLayout implements Checkable, HasOnCheckedChangeWidgetListener {
    private boolean f23146a;
    private boolean f23147b;
    private CheckedStateTracker f23148c;
    private ImageButton f23149d;
    private BetterTextView f23150e;
    private BetterTextView f23151f;

    public FbCustomRadioButton(Context context) {
        this(context, null);
    }

    public FbCustomRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m25130a(context, attributeSet);
    }

    public FbCustomRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m25130a(context, attributeSet);
    }

    private void m25130a(Context context, AttributeSet attributeSet) {
        setContentView(2130904262);
        setClickable(true);
        this.f23149d = (ImageButton) a(2131558956);
        ViewCompat.d(this.f23149d, 2);
        this.f23150e = (BetterTextView) a(2131561812);
        this.f23151f = (BetterTextView) a(2131561813);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BetterButton);
        int i = obtainStyledAttributes.getInt(0, 0);
        int i2 = obtainStyledAttributes.getInt(1, FontWeight.BUILTIN.ordinal());
        CustomFontHelper.a(this.f23150e, FontFamily.fromIndex(i), FontWeight.fromIndex(i2), this.f23150e.getTypeface());
        i = obtainStyledAttributes.getResourceId(3, 0);
        if (i != 0) {
            setTextTextViewStart(getResources().getString(i));
        }
        obtainStyledAttributes.recycle();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(RadioButton.class.getName());
        accessibilityEvent.setChecked(this.f23146a);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(RadioButton.class.getName());
        accessibilityNodeInfo.setCheckable(true);
        accessibilityNodeInfo.setChecked(this.f23146a);
    }

    public void setChecked(boolean z) {
        if (this.f23146a != z) {
            this.f23146a = z;
            this.f23149d.setSelected(z);
            super.refreshDrawableState();
        }
        if (!this.f23147b) {
            this.f23147b = true;
            if (this.f23148c != null) {
                this.f23148c.m25117a(this);
            }
            this.f23147b = false;
        }
    }

    public boolean isChecked() {
        return this.f23146a;
    }

    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    public void toggle() {
        if (!this.f23146a) {
            setChecked(true);
        }
    }

    public void setOnCheckedChangeWidgetListener(CheckedStateTracker checkedStateTracker) {
        this.f23148c = checkedStateTracker;
    }

    public void setTextTextViewStart(CharSequence charSequence) {
        this.f23150e.setText(charSequence);
    }

    public void setTextTextViewEnd(CharSequence charSequence) {
        this.f23151f.setText(charSequence);
    }

    public void setContentDescriptionTextViewEnd(CharSequence charSequence) {
        this.f23151f.setContentDescription(charSequence);
    }
}
