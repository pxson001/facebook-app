package com.facebook.iorg.common.upsell.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: lowResWidth */
public class UpsellDontShowAgainCheckbox extends LinearLayout {
    private CheckBox f11385a;
    private TextView f11386b;

    public UpsellDontShowAgainCheckbox(Context context) {
        super(context);
        m18175a();
    }

    public UpsellDontShowAgainCheckbox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18175a();
    }

    private void m18175a() {
        View inflate = LayoutInflater.from(getContext()).inflate(2130907619, this);
        this.f11386b = (TextView) inflate.findViewById(2131568224);
        this.f11385a = (CheckBox) inflate.findViewById(2131568223);
        this.f11385a.setButtonDrawable(Resources.getSystem().getIdentifier("btn_check_holo_light", "drawable", "android"));
    }

    public void setText(String str) {
        this.f11386b.setText(str);
    }

    public void setText(int i) {
        this.f11386b.setText(i);
    }

    public void setCheckListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.f11385a.setOnCheckedChangeListener(onCheckedChangeListener);
    }
}
