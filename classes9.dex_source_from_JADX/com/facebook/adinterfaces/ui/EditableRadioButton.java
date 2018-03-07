package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewCompat;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnFocusChangeListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.ImageButton;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.R;
import com.facebook.adinterfaces.ui.EditableRadioGroup.CheckedStateTracker;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterEditTextView;
import com.facebook.widget.text.BetterTextView;
import com.facebook.widget.text.CustomFontHelper;
import com.facebook.widget.text.CustomFontHelper.FontFamily;
import com.facebook.widget.text.CustomFontHelper.FontWeight;

/* compiled from: Unknown view type  */
public class EditableRadioButton extends CustomLinearLayout implements Checkable, HasOnCheckedChangeWidgetListener {
    private ImageButton f23131a;
    private BetterEditTextView f23132b;
    private BetterTextView f23133c;
    private BetterTextView f23134d;
    public boolean f23135e;
    private boolean f23136f;
    private CheckedStateTracker f23137g;

    /* compiled from: Unknown view type  */
    class C27231 extends AccessibilityDelegate {
        final /* synthetic */ EditableRadioButton f23130a;

        C27231(EditableRadioButton editableRadioButton) {
            this.f23130a = editableRadioButton;
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(EditableRadioButton.class.getName());
            accessibilityNodeInfo.setCheckable(true);
            accessibilityNodeInfo.setChecked(this.f23130a.f23135e);
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(EditableRadioButton.class.getName());
            accessibilityEvent.setChecked(this.f23130a.f23135e);
        }
    }

    public EditableRadioButton(Context context) {
        super(context);
        m25113a(context, null);
    }

    public EditableRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m25113a(context, attributeSet);
    }

    protected EditableRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m25113a(context, attributeSet);
    }

    private void m25113a(Context context, AttributeSet attributeSet) {
        setContentView(2130903961);
        setClickable(true);
        this.f23131a = (ImageButton) a(2131558956);
        ViewCompat.d(this.f23131a, 2);
        this.f23131a.setAccessibilityDelegate(new C27231(this));
        this.f23132b = (BetterEditTextView) a(2131561142);
        this.f23133c = (BetterTextView) a(2131561141);
        this.f23134d = (BetterTextView) a(2131561143);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BetterButton);
            int i = obtainStyledAttributes.getInt(0, 0);
            int i2 = obtainStyledAttributes.getInt(1, FontWeight.BUILTIN.ordinal());
            FontFamily fromIndex = FontFamily.fromIndex(i);
            FontWeight fromIndex2 = FontWeight.fromIndex(i2);
            CustomFontHelper.a(this.f23132b, fromIndex, fromIndex2, this.f23132b.getTypeface());
            CustomFontHelper.a(this.f23133c, fromIndex, fromIndex2, this.f23133c.getTypeface());
            obtainStyledAttributes.recycle();
        }
    }

    public void setTextSuffixTextView(CharSequence charSequence) {
        this.f23134d.setText(charSequence);
    }

    public void setContentDescriptionPrefixTextView(CharSequence charSequence) {
        this.f23133c.setContentDescription(charSequence);
    }

    public void setContentDescriptionSuffixTextView(CharSequence charSequence) {
        this.f23134d.setContentDescription(charSequence);
    }

    public void setTextPrefixTextView(CharSequence charSequence) {
        this.f23133c.setText(charSequence);
    }

    public void setOnEditorActionListenerEditText(OnEditorActionListener onEditorActionListener) {
        this.f23132b.setOnEditorActionListener(onEditorActionListener);
    }

    public void setOnCheckedChangeWidgetListener(CheckedStateTracker checkedStateTracker) {
        this.f23137g = checkedStateTracker;
    }

    public void setOnFocusChangeListenerEditText(OnFocusChangeListener onFocusChangeListener) {
        this.f23132b.setOnFocusChangeListener(onFocusChangeListener);
    }

    public final void m25115a(TextWatcher textWatcher) {
        this.f23132b.addTextChangedListener(textWatcher);
    }

    public final void m25116b(TextWatcher textWatcher) {
        this.f23132b.removeTextChangedListener(textWatcher);
    }

    public void setCursorVisible(boolean z) {
        this.f23132b.setCursorVisible(z);
    }

    public void setVisibilityPrefixTextView(int i) {
        this.f23133c.setVisibility(i);
    }

    public void setVisibilitySuffixTextView(int i) {
        this.f23134d.setVisibility(i);
    }

    public void setLeftAlignedSuffixTextView(boolean z) {
        this.f23134d.setGravity(z ? 8388611 : 8388613);
    }

    public void setHint(CharSequence charSequence) {
        this.f23132b.setHint(charSequence);
    }

    public boolean isChecked() {
        return this.f23135e;
    }

    public String getTextEditText() {
        return this.f23132b.getText().toString();
    }

    public void setTextEditText(CharSequence charSequence) {
        this.f23132b.setText(charSequence);
    }

    public CharSequence getEditTextHint() {
        return this.f23132b.getHint();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    public void setChecked(boolean z) {
        if (this.f23135e != z) {
            this.f23135e = z;
            this.f23131a.setSelected(z);
            super.refreshDrawableState();
        }
        if (!this.f23136f) {
            this.f23136f = true;
            if (this.f23137g != null) {
                this.f23137g.m25117a(this);
            }
            this.f23136f = false;
        }
    }

    public int getCursorPositionOnEditText() {
        return this.f23132b.getSelectionEnd();
    }

    public void setSelectionOnEditText(int i) {
        this.f23132b.setSelection(i);
    }

    public void toggle() {
        if (!this.f23135e) {
            setChecked(true);
            this.f23132b.requestFocus();
        }
    }
}
