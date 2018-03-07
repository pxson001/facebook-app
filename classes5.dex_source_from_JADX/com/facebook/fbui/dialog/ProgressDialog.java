package com.facebook.fbui.dialog;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.R;
import java.text.NumberFormat;

/* compiled from: resetFocus/setParameters failed */
public class ProgressDialog extends AlertDialog {
    public ProgressBar f3131b;
    private TextView f3132c;
    public int f3133d = 0;
    public TextView f3134e;
    public String f3135f = "%1d/%2d";
    public TextView f3136g;
    public NumberFormat f3137h = NumberFormat.getPercentInstance();
    private int f3138i;
    private int f3139j;
    private int f3140k;
    private int f3141l;
    private int f3142m;
    public Drawable f3143n;
    public Drawable f3144o;
    private CharSequence f3145p;
    private boolean f3146q;
    private boolean f3147r;
    private Handler f3148s;

    /* compiled from: resetFocus/setParameters failed */
    class C02271 extends Handler {
        final /* synthetic */ ProgressDialog f3130a;

        C02271(ProgressDialog progressDialog) {
            this.f3130a = progressDialog;
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            int progress = this.f3130a.f3131b.getProgress();
            int max = this.f3130a.f3131b.getMax();
            if (this.f3130a.f3135f != null) {
                String str = this.f3130a.f3135f;
                this.f3130a.f3134e.setText(String.format(str, new Object[]{Integer.valueOf(progress), Integer.valueOf(max)}));
            } else {
                this.f3130a.f3134e.setText("");
            }
            if (this.f3130a.f3137h != null) {
                CharSequence spannableString = new SpannableString(this.f3130a.f3137h.format(((double) progress) / ((double) max)));
                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
                this.f3130a.f3136g.setText(spannableString);
                return;
            }
            this.f3130a.f3136g.setText("");
        }
    }

    public ProgressDialog(Context context) {
        super(context);
        this.f3137h.setMaximumFractionDigits(0);
    }

    public static ProgressDialog m4236a(Context context, CharSequence charSequence, CharSequence charSequence2) {
        return m4237a(context, charSequence, charSequence2, false);
    }

    public static ProgressDialog m4237a(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z) {
        return m4239a(context, charSequence, charSequence2, z, false, null);
    }

    public static ProgressDialog m4238a(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z, boolean z2) {
        return m4239a(context, charSequence, charSequence2, z, z2, null);
    }

    private static ProgressDialog m4239a(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z, boolean z2, OnCancelListener onCancelListener) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(charSequence);
        progressDialog.a(charSequence2);
        progressDialog.m4247a(z);
        progressDialog.setCancelable(z2);
        progressDialog.setOnCancelListener(onCancelListener);
        progressDialog.show();
        return progressDialog;
    }

    protected void onCreate(Bundle bundle) {
        Drawable drawable;
        LayoutInflater from = LayoutInflater.from(getContext());
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, R.styleable.AlertDialog, 2130772445, 0);
        View inflate;
        if (this.f3133d == 1) {
            this.f3148s = new C02271(this);
            inflate = from.inflate(obtainStyledAttributes.getResourceId(6, 2130907322), null);
            this.f3131b = (ProgressBar) inflate.findViewById(2131559623);
            this.f3134e = (TextView) inflate.findViewById(2131561836);
            this.f3136g = (TextView) inflate.findViewById(2131561835);
            a(inflate);
        } else {
            inflate = from.inflate(obtainStyledAttributes.getResourceId(5, 2130907323), null);
            this.f3131b = (ProgressBar) inflate.findViewById(2131559623);
            this.f3132c = (TextView) inflate.findViewById(2131559674);
            a(inflate);
        }
        obtainStyledAttributes.recycle();
        if (this.f3138i > 0) {
            m4249c(this.f3138i);
        }
        if (this.f3139j > 0) {
            m4248b(this.f3139j);
        }
        if (this.f3140k > 0) {
            m4241e(this.f3140k);
        }
        if (this.f3141l > 0) {
            m4242f(this.f3141l);
        }
        if (this.f3142m > 0) {
            m4243g(this.f3142m);
        }
        if (this.f3143n != null) {
            drawable = this.f3143n;
            if (this.f3131b != null) {
                this.f3131b.setProgressDrawable(drawable);
            } else {
                this.f3143n = drawable;
            }
        }
        if (this.f3144o != null) {
            drawable = this.f3144o;
            if (this.f3131b != null) {
                this.f3131b.setIndeterminateDrawable(drawable);
            } else {
                this.f3144o = drawable;
            }
        }
        if (this.f3145p != null) {
            a(this.f3145p);
        }
        m4247a(this.f3146q);
        m4240c();
        super.onCreate(bundle);
    }

    public void onStart() {
        super.onStart();
        this.f3147r = true;
    }

    protected void onStop() {
        super.onStop();
        this.f3147r = false;
    }

    public final void m4248b(int i) {
        if (this.f3147r) {
            this.f3131b.setProgress(i);
            m4240c();
            return;
        }
        this.f3139j = i;
    }

    private void m4241e(int i) {
        if (this.f3131b != null) {
            this.f3131b.setSecondaryProgress(i);
            m4240c();
            return;
        }
        this.f3140k = i;
    }

    public final void m4249c(int i) {
        if (this.f3131b != null) {
            this.f3131b.setMax(i);
            m4240c();
            return;
        }
        this.f3138i = i;
    }

    private void m4242f(int i) {
        if (this.f3131b != null) {
            this.f3131b.incrementProgressBy(i);
            m4240c();
            return;
        }
        this.f3141l += i;
    }

    private void m4243g(int i) {
        if (this.f3131b != null) {
            this.f3131b.incrementSecondaryProgressBy(i);
            m4240c();
            return;
        }
        this.f3142m += i;
    }

    public final void m4247a(boolean z) {
        if (this.f3131b != null) {
            this.f3131b.setIndeterminate(z);
        } else {
            this.f3146q = z;
        }
    }

    public final void m4244a(CharSequence charSequence) {
        if (this.f3131b == null) {
            this.f3145p = charSequence;
        } else if (this.f3133d == 1) {
            super.a(charSequence);
        } else {
            this.f3132c.setText(charSequence);
        }
    }

    public final void m4245a(String str) {
        this.f3135f = str;
        m4240c();
    }

    public final void m4246a(NumberFormat numberFormat) {
        this.f3137h = numberFormat;
        m4240c();
    }

    private void m4240c() {
        if (this.f3133d == 1 && this.f3148s != null && !this.f3148s.hasMessages(0)) {
            this.f3148s.sendEmptyMessage(0);
        }
    }
}
