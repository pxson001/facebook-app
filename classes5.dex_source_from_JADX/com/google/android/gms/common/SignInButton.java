package com.google.android.gms.common;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamic.zzg.zza;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class SignInButton extends FrameLayout implements OnClickListener {
    private int f6450a;
    private int f6451b;
    private Scope[] f6452c;
    private View f6453d;
    private OnClickListener f6454e;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ButtonSize {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorScheme {
    }

    private static Button m12125a(Context context, int i, int i2, Scope[] scopeArr) {
        Button com_google_android_gms_common_internal_zzac = new zzac(context);
        com_google_android_gms_common_internal_zzac.m12275a(context.getResources(), i, i2, scopeArr);
        return com_google_android_gms_common_internal_zzac;
    }

    private void m12126a(int i, int i2, Scope[] scopeArr) {
        this.f6450a = i;
        this.f6451b = i2;
        this.f6452c = scopeArr;
        m12127a(getContext());
    }

    private void m12127a(Context context) {
        if (this.f6453d != null) {
            removeView(this.f6453d);
        }
        try {
            this.f6453d = zzab.m12267a(context, this.f6450a, this.f6451b, this.f6452c);
        } catch (zza e) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            this.f6453d = m12125a(context, this.f6450a, this.f6451b, this.f6452c);
        }
        addView(this.f6453d);
        this.f6453d.setEnabled(isEnabled());
        this.f6453d.setOnClickListener(this);
    }

    public final void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1614765557);
        if (this.f6454e != null && view == this.f6453d) {
            this.f6454e.onClick(this);
        }
        Logger.a(2, EntryType.UI_INPUT_END, -1585872884, a);
    }

    public final void setColorScheme(int i) {
        m12126a(this.f6450a, i, this.f6452c);
    }

    public final void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f6453d.setEnabled(z);
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.f6454e = onClickListener;
        if (this.f6453d != null) {
            this.f6453d.setOnClickListener(this);
        }
    }

    public final void setScopes(Scope[] scopeArr) {
        m12126a(this.f6450a, this.f6451b, scopeArr);
    }

    public final void setSize(int i) {
        m12126a(i, this.f6451b, this.f6452c);
    }
}
