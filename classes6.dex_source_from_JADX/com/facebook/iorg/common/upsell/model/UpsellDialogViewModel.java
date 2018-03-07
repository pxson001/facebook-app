package com.facebook.iorg.common.upsell.model;

import android.text.Spannable;
import android.view.View.OnClickListener;
import android.widget.CompoundButton.OnCheckedChangeListener;

/* compiled from: mCanSeeViewerMontageThread */
public class UpsellDialogViewModel {
    public String f11253a;
    public boolean f11254b;
    public String f11255c;
    public Spannable f11256d;
    public String f11257e;
    public String f11258f;
    public String f11259g;
    public String f11260h;
    public String f11261i;
    public OnClickListener f11262j;
    public String f11263k;
    public OnClickListener f11264l;
    public String f11265m;
    public OnClickListener f11266n;
    private boolean f11267o;
    public OnCheckedChangeListener f11268p;
    private boolean f11269q = false;
    public int f11270r = 0;
    public String f11271s = "";

    public final UpsellDialogViewModel m18126a(String str) {
        return m18128a(str, false);
    }

    public final UpsellDialogViewModel m18128a(String str, boolean z) {
        this.f11253a = str;
        this.f11254b = z;
        return this;
    }

    public final UpsellDialogViewModel m18127a(String str, OnClickListener onClickListener) {
        this.f11261i = str;
        this.f11262j = onClickListener;
        return this;
    }

    public final UpsellDialogViewModel m18129b(String str, OnClickListener onClickListener) {
        this.f11263k = str;
        this.f11264l = onClickListener;
        return this;
    }

    public final UpsellDialogViewModel m18130c(String str, OnClickListener onClickListener) {
        this.f11265m = str;
        this.f11266n = onClickListener;
        this.f11267o = true;
        return this;
    }

    public final UpsellDialogViewModel m18125a(Boolean bool) {
        this.f11269q = bool.booleanValue();
        return this;
    }

    public final Boolean m18131q() {
        return Boolean.valueOf(this.f11269q);
    }
}
