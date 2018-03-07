package com.facebook.iorg.common.upsell.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* compiled from: mAddressListData */
public class UpsellDialogButton extends RelativeLayout {
    private TextView f11359a;
    private ProgressBar f11360b;

    public UpsellDialogButton(Context context) {
        super(context);
        m18151b();
    }

    public UpsellDialogButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18151b();
    }

    private void m18151b() {
        View inflate = LayoutInflater.from(getContext()).inflate(2130907616, this);
        this.f11359a = (TextView) inflate.findViewById(2131568216);
        this.f11360b = (ProgressBar) inflate.findViewById(2131568217);
    }

    public void setText(String str) {
        this.f11359a.setText(str);
    }

    public void setText(int i) {
        this.f11359a.setText(i);
    }

    public final void m18152a() {
        this.f11359a.setVisibility(8);
        this.f11360b.setVisibility(0);
    }

    public void setTextColor(int i) {
        this.f11359a.setTextColor(i);
    }
}
