package com.facebook.uberbar.ui;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ViewGroup;
import android.widget.EditText;
import com.facebook.analytics.InteractionLogger;
import com.google.common.base.Preconditions;

/* compiled from: need_profile_permission */
public abstract class AbstractUberbarDelegate {
    protected Activity f5084a;
    protected InteractionLogger f5085b;
    public boolean f5086c = false;
    public EditText f5087d;
    public ViewGroup f5088e;
    protected TextWatcher f5089f;

    public abstract void mo146a(String str);

    public abstract void mo147d();

    public AbstractUberbarDelegate(InteractionLogger interactionLogger, Activity activity) {
        this.f5084a = activity;
        this.f5085b = interactionLogger;
    }

    public final void m6373a(TextWatcher textWatcher) {
        Preconditions.checkNotNull(this.f5087d);
        this.f5089f = textWatcher;
        this.f5087d.addTextChangedListener(this.f5089f);
    }

    public final void m6372a(Editable editable) {
        Preconditions.checkState(this.f5086c);
        if (editable == null) {
            mo145a();
            return;
        }
        String trim = editable.toString().replace("\"", "").trim();
        if (trim.length() > 0) {
            mo146a(trim);
            this.f5088e.setVisibility(0);
            return;
        }
        mo145a();
        mo147d();
    }

    private void mo145a() {
        this.f5088e.setVisibility(8);
    }
}
