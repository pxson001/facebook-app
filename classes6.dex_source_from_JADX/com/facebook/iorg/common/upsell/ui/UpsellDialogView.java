package com.facebook.iorg.common.upsell.ui;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.common.util.StringUtil;
import com.facebook.iorg.common.upsell.model.UpsellDialogViewModel;

/* compiled from: lt */
public class UpsellDialogView extends LinearLayout {
    public ProgressBar f11375a = ((ProgressBar) findViewById(2131568208));
    public TextView f11376b = ((TextView) findViewById(2131568203));
    public ViewGroup f11377c = ((ViewGroup) findViewById(2131560065));
    public TextView f11378d = ((TextView) findViewById(2131568205));
    public UpsellDialogContentView f11379e = ((UpsellDialogContentView) findViewById(2131568207));
    public UpsellDialogExtraTitleBarView f11380f = ((UpsellDialogExtraTitleBarView) findViewById(2131568202));
    private UpsellDialogButton f11381g;
    private UpsellDialogButton f11382h;
    private UpsellDialogButton f11383i;
    private LinearLayout f11384j;

    public UpsellDialogView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(2130907614, this);
        setLayoutParams(new LayoutParams(-1, -2));
    }

    public final void m18173a() {
        this.f11375a.setVisibility(0);
    }

    public final void m18174a(UpsellDialogViewModel upsellDialogViewModel) {
        int i;
        int i2;
        int i3 = 1;
        this.f11375a.setVisibility(8);
        if (upsellDialogViewModel.f11270r != 0) {
            this.f11380f.setTitleImageResource(upsellDialogViewModel.f11270r);
            this.f11380f.setVisibility(0);
        } else if (!StringUtil.c(upsellDialogViewModel.f11271s)) {
            this.f11380f.setTitleImageByUrl(upsellDialogViewModel.f11271s);
            this.f11380f.setVisibility(0);
        }
        if (!StringUtil.c(upsellDialogViewModel.f11253a)) {
            this.f11376b.setText(upsellDialogViewModel.f11253a);
            this.f11376b.setContentDescription(upsellDialogViewModel.f11253a);
            if (upsellDialogViewModel.f11254b) {
                this.f11376b.setTextColor(getResources().getColor(2131362666));
            }
            this.f11376b.setVisibility(0);
        }
        if (!StringUtil.c(upsellDialogViewModel.f11255c)) {
            if (upsellDialogViewModel.f11256d != null) {
                this.f11378d.setText(upsellDialogViewModel.f11256d);
                this.f11378d.setMovementMethod(LinkMovementMethod.getInstance());
            } else {
                this.f11378d.setText(upsellDialogViewModel.f11255c);
            }
            this.f11378d.setContentDescription(upsellDialogViewModel.f11255c);
            this.f11378d.setVisibility(0);
            if (StringUtil.c(upsellDialogViewModel.f11253a)) {
                this.f11378d.setPadding(this.f11378d.getPaddingLeft(), getResources().getDimensionPixelSize(2131428350), this.f11378d.getPaddingRight(), this.f11378d.getPaddingBottom());
            }
        }
        this.f11379e.m18154a(upsellDialogViewModel);
        if (upsellDialogViewModel.f11268p != null) {
            UpsellDontShowAgainCheckbox upsellDontShowAgainCheckbox = (UpsellDontShowAgainCheckbox) findViewById(2131568206);
            upsellDontShowAgainCheckbox.setVisibility(0);
            upsellDontShowAgainCheckbox.setCheckListener(upsellDialogViewModel.f11268p);
        }
        if (StringUtil.c(upsellDialogViewModel.f11261i) || upsellDialogViewModel.f11262j == null) {
            i = 0;
        } else {
            i = 1;
        }
        if (StringUtil.c(upsellDialogViewModel.f11263k) || upsellDialogViewModel.f11264l == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (StringUtil.c(upsellDialogViewModel.f11265m) || upsellDialogViewModel.f11266n == null) {
            i3 = 0;
        }
        if (!(i == 0 && i2 == 0 && i3 == 0)) {
            this.f11384j = (LinearLayout) findViewById(2131568209);
            this.f11384j.setVisibility(0);
            if (upsellDialogViewModel.m18131q().booleanValue()) {
                this.f11384j.setOrientation(0);
                this.f11382h = (UpsellDialogButton) findViewById(2131568212);
                this.f11384j.removeView(this.f11382h);
                this.f11384j.addView(this.f11382h, 0);
            }
        }
        if (i != 0) {
            this.f11381g = (UpsellDialogButton) findViewById(2131568210);
            this.f11381g.setText(upsellDialogViewModel.f11261i);
            this.f11381g.setContentDescription(upsellDialogViewModel.f11261i);
            this.f11381g.setOnClickListener(upsellDialogViewModel.f11262j);
            this.f11381g.setVisibility(0);
        }
        if (i2 != 0) {
            this.f11382h = (UpsellDialogButton) findViewById(2131568212);
            this.f11382h.setText(upsellDialogViewModel.f11263k);
            this.f11382h.setContentDescription(upsellDialogViewModel.f11263k);
            this.f11382h.setOnClickListener(upsellDialogViewModel.f11264l);
            this.f11382h.setVisibility(0);
            if (upsellDialogViewModel.m18131q().booleanValue()) {
                this.f11382h.setTextColor(getResources().getColor(2131362663));
            }
        }
        if (i3 == 0) {
            return;
        }
        if (upsellDialogViewModel.m18131q().booleanValue()) {
            throw new IllegalStateException("Should not have 3 horizontal buttons");
        }
        this.f11383i = (UpsellDialogButton) findViewById(2131568211);
        this.f11383i.setText(upsellDialogViewModel.f11265m);
        this.f11383i.setContentDescription(upsellDialogViewModel.f11265m);
        this.f11383i.setOnClickListener(upsellDialogViewModel.f11266n);
        this.f11383i.setVisibility(0);
    }
}
