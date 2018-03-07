package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import com.google.common.annotations.VisibleForTesting;

/* compiled from: Upload failed final waiting stage with sessionId %s and streamId %s */
public class AdInterfacesSpinnerView extends CustomLinearLayout {
    private Spinner f22956a;
    private BetterTextView f22957b;
    private BetterTextView f22958c;

    public AdInterfacesSpinnerView(Context context) {
        super(context);
        m24921b();
    }

    public AdInterfacesSpinnerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24921b();
    }

    public AdInterfacesSpinnerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24921b();
    }

    private void m24921b() {
        setOrientation(1);
        setContentView(2130903146);
        this.f22956a = (Spinner) a(2131559335);
        this.f22957b = (BetterTextView) a(2131559333);
        this.f22958c = (BetterTextView) a(2131559334);
    }

    public final boolean m24924a() {
        return this.f22956a.isEnabled();
    }

    public final void m24922a(SpinnerAdapter spinnerAdapter, OnItemSelectedListener onItemSelectedListener) {
        this.f22956a.setAdapter(spinnerAdapter);
        this.f22956a.setOnItemSelectedListener(onItemSelectedListener);
        this.f22957b.setVisibility(8);
        this.f22958c.setVisibility(8);
        this.f22956a.setVisibility(0);
    }

    public final void m24923a(String str, String str2) {
        int i = 8;
        this.f22956a.setVisibility(8);
        this.f22957b.setText(str);
        this.f22957b.setVisibility(0);
        BetterTextView betterTextView = this.f22958c;
        if (str2 != null) {
            i = 0;
        }
        betterTextView.setVisibility(i);
        if (str2 != null) {
            this.f22958c.setText(str2);
        }
    }

    public void setSelected(int i) {
        this.f22956a.setSelection(i);
    }

    @VisibleForTesting
    public Object getSelectedItem() {
        return this.f22956a.getSelectedItem();
    }
}
