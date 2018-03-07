package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.SpinnerAdapter;
import com.google.common.collect.ImmutableList;

/* compiled from: Unset (Use GK value) */
public class BudgetOptionsView extends BaseEditableRadioGroupView {
    private AdInterfacesSpinnerView f23128d;
    private View f23129e;

    public BudgetOptionsView(Context context) {
        super(context);
    }

    public BudgetOptionsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected BudgetOptionsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final void mo1033a() {
        setContentView(2130903449);
        this.a = (EditableRadioGroup) a(2131559257);
        this.b = (EditableRadioButton) a(2131560048);
        this.c = ImmutableList.of((FbCustomRadioButton) a(2131560043), (FbCustomRadioButton) a(2131560044), (FbCustomRadioButton) a(2131560045), (FbCustomRadioButton) a(2131560046), (FbCustomRadioButton) a(2131560047));
        for (int i = 0; i < this.f23059c.size(); i++) {
            ((FbCustomRadioButton) this.f23059c.get(i)).setTag(Integer.valueOf(i));
        }
        this.f23058b.setTag(Integer.valueOf(this.f23059c.size()));
        this.f23128d = (AdInterfacesSpinnerView) a(2131560041);
        this.f23129e = a(2131560042);
    }

    public final void m25111a(AdInterfacesSpinnerAdapter adInterfacesSpinnerAdapter, OnItemSelectedListener onItemSelectedListener) {
        setSpinnerVisibility(true);
        this.f23128d.m24922a((SpinnerAdapter) adInterfacesSpinnerAdapter, onItemSelectedListener);
    }

    public void setSpinnerVisibility(boolean z) {
        int i;
        int i2 = 0;
        AdInterfacesSpinnerView adInterfacesSpinnerView = this.f23128d;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        adInterfacesSpinnerView.setVisibility(i);
        View view = this.f23129e;
        if (!z) {
            i2 = 8;
        }
        view.setVisibility(i2);
    }

    public void setSpinnerSelected(int i) {
        this.f23128d.setSelected(i);
    }
}
