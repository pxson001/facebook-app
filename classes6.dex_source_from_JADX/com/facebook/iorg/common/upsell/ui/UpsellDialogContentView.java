package com.facebook.iorg.common.upsell.ui;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.common.util.StringUtil;
import com.facebook.iorg.common.upsell.model.UpsellDialogViewModel;

/* compiled from: mAddedTimeInMS */
public class UpsellDialogContentView extends LinearLayout {
    private TextView f11361a;
    private TextView f11362b;
    private TextView f11363c;
    private TextView f11364d;

    public UpsellDialogContentView(Context context) {
        super(context);
        m18153a();
    }

    public UpsellDialogContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18153a();
    }

    private void m18153a() {
        LayoutInflater.from(getContext()).inflate(2130907617, this);
        this.f11361a = (TextView) findViewById(2131568218);
        this.f11362b = (TextView) findViewById(2131568219);
        this.f11363c = (TextView) findViewById(2131568220);
        this.f11364d = (TextView) findViewById(2131568221);
        setOrientation(1);
        setVisibility(8);
    }

    public final void m18154a(UpsellDialogViewModel upsellDialogViewModel) {
        if (!(StringUtil.c(upsellDialogViewModel.f11257e) && StringUtil.c(upsellDialogViewModel.f11258f))) {
            if (!StringUtil.c(upsellDialogViewModel.f11258f)) {
                this.f11362b.setText(upsellDialogViewModel.f11258f);
                this.f11362b.setContentDescription(upsellDialogViewModel.f11258f);
                this.f11362b.setVisibility(0);
            }
            if (!StringUtil.c(upsellDialogViewModel.f11259g)) {
                this.f11363c.setText(upsellDialogViewModel.f11259g);
                this.f11363c.setContentDescription(upsellDialogViewModel.f11259g);
            }
            this.f11361a.setText(upsellDialogViewModel.f11257e);
            this.f11361a.setContentDescription(upsellDialogViewModel.f11257e);
            setVisibility(0);
        }
        if (!StringUtil.c(upsellDialogViewModel.f11260h)) {
            this.f11364d.setText(Html.fromHtml(upsellDialogViewModel.f11260h));
            this.f11364d.setContentDescription(upsellDialogViewModel.f11260h);
            this.f11364d.setVisibility(0);
        }
    }
}
