package com.facebook.nearby.v2.typeahead;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import com.facebook.resources.ui.FbEditText;

/* compiled from: path is null */
public class NearbyPlacesTypeaheadEditText extends FbEditText {
    private TextWatcher f5181b;

    public NearbyPlacesTypeaheadEditText(Context context) {
        this(context, null);
    }

    public NearbyPlacesTypeaheadEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842862);
    }

    public NearbyPlacesTypeaheadEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        m4652a();
        super.setText(charSequence, bufferType);
        m4653b();
    }

    public void setInputTextListener(TextWatcher textWatcher) {
        m4652a();
        this.f5181b = textWatcher;
        m4653b();
    }

    private void m4652a() {
        if (this.f5181b != null) {
            removeTextChangedListener(this.f5181b);
        }
    }

    private void m4653b() {
        if (this.f5181b != null) {
            addTextChangedListener(this.f5181b);
        }
    }
}
