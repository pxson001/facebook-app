package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.google.common.collect.ImmutableList;

/* compiled from: Unregister handler mismatch for request code  */
public class DurationRadioGroupView extends BaseEditableRadioGroupView {
    public DurationRadioGroupView(Context context) {
        super(context);
    }

    public DurationRadioGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected DurationRadioGroupView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final void mo1033a() {
        setContentView(2130903932);
        this.a = (EditableRadioGroup) a(2131559257);
        this.b = (EditableRadioButton) a(2131561082);
        this.c = ImmutableList.of((FbCustomRadioButton) a(2131561078), (FbCustomRadioButton) a(2131561079), (FbCustomRadioButton) a(2131561080), (FbCustomRadioButton) a(2131561081));
        for (int i = 0; i < this.f23059c.size(); i++) {
            ((FbCustomRadioButton) this.f23059c.get(i)).setTag(Integer.valueOf(i));
        }
        this.f23058b.setTag(Integer.valueOf(this.f23059c.size()));
    }
}
