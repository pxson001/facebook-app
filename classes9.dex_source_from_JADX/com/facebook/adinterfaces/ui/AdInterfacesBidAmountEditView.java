package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View.OnFocusChangeListener;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterEditTextView;
import com.facebook.widget.text.BetterTextView;

/* compiled from: VIDEO_CLIP */
public class AdInterfacesBidAmountEditView extends CustomLinearLayout {
    private BetterTextView f22584a;
    private BetterEditTextView f22585b;

    public AdInterfacesBidAmountEditView(Context context) {
        super(context);
        m24456b();
    }

    public AdInterfacesBidAmountEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24456b();
    }

    protected AdInterfacesBidAmountEditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24456b();
    }

    private void m24456b() {
        setContentView(2130903105);
        setOrientation(0);
        this.f22585b = (BetterEditTextView) a(2131559264);
        this.f22584a = (BetterTextView) a(2131559263);
    }

    public void setBidAmount(CharSequence charSequence) {
        this.f22585b.setText(charSequence);
    }

    public void setCurrencySymbol(CharSequence charSequence) {
        this.f22584a.setText(charSequence);
    }

    public void setOnFocusChangeListenerEditText(OnFocusChangeListener onFocusChangeListener) {
        this.f22585b.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void setCursorVisible(boolean z) {
        this.f22585b.setCursorVisible(z);
    }

    public final void m24457a(TextWatcher textWatcher) {
        this.f22585b.addTextChangedListener(textWatcher);
    }

    public final void m24459b(TextWatcher textWatcher) {
        this.f22585b.removeTextChangedListener(textWatcher);
    }

    public final boolean m24458a() {
        return this.f22585b.requestFocus();
    }

    public String getBidAmountText() {
        return this.f22585b.getText().toString();
    }
}
