package com.facebook.payments.paymentmethods.cardform;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.TextInputLayout;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.R;
import com.facebook.resources.ui.FbEditText;
import javax.annotation.Nullable;

/* compiled from: tap_action_surface */
public class PaymentFormEditTextView extends TextInputLayout {
    private FbEditText f1857a;
    public boolean f1858b;

    public PaymentFormEditTextView(Context context) {
        this(context, null);
    }

    public PaymentFormEditTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PaymentFormEditTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2036d();
        m2034a(context);
        m2035a(context, attributeSet, i);
    }

    private void m2036d() {
        setLayoutParams(new LayoutParams(-1, -2));
        setHintTextAppearance(2131624222);
        this.r = true;
    }

    private void m2034a(Context context) {
        this.f1857a = new FbEditText(context);
        this.f1857a.setImeOptions(268435462);
        this.f1857a.setSingleLine(true);
        this.f1857a.setTextSize(0, (float) getResources().getDimensionPixelSize(2131432419));
        addView(this.f1857a);
        m2037e();
    }

    private void m2035a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PaymentFormEditText, i, 0);
        setMaxLength(obtainStyledAttributes.getInteger(1, 0));
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId > 0) {
            setHint(getResources().getString(resourceId));
        }
        resourceId = obtainStyledAttributes.getResourceId(2, 0);
        if (resourceId > 0) {
            setErrorEnabled(true);
            setError(getResources().getString(resourceId));
        }
        obtainStyledAttributes.recycle();
    }

    private void m2037e() {
        this.f1857a.setBackground(this.f1857a.getBackground().getConstantState().newDrawable());
    }

    public void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
        this.f1857a.setOnEditorActionListener(onEditorActionListener);
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.f1857a.setOnFocusChangeListener(onFocusChangeListener);
    }

    public final void m2038a(TextWatcher textWatcher) {
        this.f1857a.addTextChangedListener(textWatcher);
    }

    public final void m2042b(TextWatcher textWatcher) {
        this.f1857a.removeTextChangedListener(textWatcher);
    }

    public final boolean m2040a() {
        return this.f1858b;
    }

    public final void m2041b() {
        this.f1858b = true;
        this.f1857a.setEnabled(false);
    }

    public void setEnabled(boolean z) {
        if (!this.f1858b) {
            this.f1857a.setEnabled(z);
        }
    }

    public String getInputText() {
        return this.f1857a.getText().toString();
    }

    public void setInputText(CharSequence charSequence) {
        this.f1857a.setText(charSequence);
    }

    public void setInputId(int i) {
        this.f1857a.setId(i);
    }

    public void setInputType(int i) {
        this.f1857a.setInputType(i);
    }

    public final void m2043c() {
        setError(null);
        setErrorEnabled(false);
    }

    public final void m2039a(@Nullable String str) {
        setError(str);
        setErrorEnabled(str != null);
    }

    public void setMaxLength(int i) {
        if (i > 0) {
            this.f1857a.setFilters(new InputFilter[]{new LengthFilter(i)});
        }
    }
}
