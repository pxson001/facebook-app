package com.facebook.fbui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;

/* compiled from: early_cancel */
public class AlertDialog extends Dialog implements DialogInterface {
    public AlertController f13426a;

    /* compiled from: early_cancel */
    public class Builder {
        public final AlertController$AlertParams f13424a;
        private int f13425b;

        public Builder(Context context) {
            this(context, AlertDialog.m14355a(context, 0));
        }

        public Builder(Context context, int i) {
            this.f13424a = new AlertController$AlertParams(new ContextThemeWrapper(context, AlertDialog.m14355a(context, i)));
            this.f13425b = i;
        }

        public final Builder m14329a(int i) {
            this.f13424a.f13448f = this.f13424a.f13443a.getText(i);
            return this;
        }

        public final Builder m14337a(CharSequence charSequence) {
            this.f13424a.f13448f = charSequence;
            return this;
        }

        public final Builder m14334a(View view) {
            this.f13424a.f13449g = view;
            return this;
        }

        public final Builder m14343b(int i) {
            this.f13424a.f13450h = this.f13424a.f13443a.getText(i);
            return this;
        }

        public final Builder m14346b(CharSequence charSequence) {
            this.f13424a.f13450h = charSequence;
            return this;
        }

        public final Builder m14350c(int i) {
            this.f13424a.f13445c = i;
            return this;
        }

        public final Builder m14333a(Drawable drawable) {
            this.f13424a.f13446d = drawable;
            return this;
        }

        public Builder mo962a(int i, OnClickListener onClickListener) {
            this.f13424a.f13453k = this.f13424a.f13443a.getText(i);
            this.f13424a.f13454l = onClickListener;
            return this;
        }

        public Builder mo963a(CharSequence charSequence, OnClickListener onClickListener) {
            this.f13424a.f13453k = charSequence;
            this.f13424a.f13454l = onClickListener;
            return this;
        }

        public Builder mo965b(int i, OnClickListener onClickListener) {
            this.f13424a.f13455m = this.f13424a.f13443a.getText(i);
            this.f13424a.f13456n = onClickListener;
            return this;
        }

        public Builder mo966b(CharSequence charSequence, OnClickListener onClickListener) {
            this.f13424a.f13455m = charSequence;
            this.f13424a.f13456n = onClickListener;
            return this;
        }

        public Builder mo967c(int i, OnClickListener onClickListener) {
            this.f13424a.f13457o = this.f13424a.f13443a.getText(i);
            this.f13424a.f13458p = onClickListener;
            return this;
        }

        public Builder mo968c(CharSequence charSequence, OnClickListener onClickListener) {
            this.f13424a.f13457o = charSequence;
            this.f13424a.f13458p = onClickListener;
            return this;
        }

        public final Builder m14339a(boolean z) {
            this.f13424a.f13459q = z;
            return this;
        }

        public final Builder m14331a(OnCancelListener onCancelListener) {
            this.f13424a.f13460r = onCancelListener;
            return this;
        }

        public final Builder m14332a(OnDismissListener onDismissListener) {
            this.f13424a.f13461s = onDismissListener;
            return this;
        }

        public final Builder m14341a(CharSequence[] charSequenceArr, OnClickListener onClickListener) {
            this.f13424a.f13463u = charSequenceArr;
            this.f13424a.f13465w = onClickListener;
            return this;
        }

        public final Builder m14336a(ListAdapter listAdapter, OnClickListener onClickListener) {
            this.f13424a.f13464v = listAdapter;
            this.f13424a.f13465w = onClickListener;
            return this;
        }

        public final Builder m14340a(CharSequence[] charSequenceArr, int i, OnClickListener onClickListener) {
            this.f13424a.f13463u = charSequenceArr;
            this.f13424a.f13465w = onClickListener;
            this.f13424a.f13434H = i;
            this.f13424a.f13433G = true;
            return this;
        }

        public final Builder m14345b(View view) {
            this.f13424a.f13466x = view;
            this.f13424a.f13430D = false;
            return this;
        }

        public final Builder m14335a(View view, int i, int i2, int i3, int i4) {
            this.f13424a.f13466x = view;
            this.f13424a.f13430D = true;
            this.f13424a.f13468z = i;
            this.f13424a.f13427A = i2;
            this.f13424a.f13428B = i3;
            this.f13424a.f13429C = i4;
            return this;
        }

        public final Builder m14348b(boolean z) {
            this.f13424a.f13439M = z;
            return this;
        }

        public final Builder m14353c(boolean z) {
            this.f13424a.f13442P = z;
            return this;
        }

        public AlertDialog mo964a() {
            AlertDialog alertDialog = new AlertDialog(this.f13424a.f13443a, this.f13425b);
            this.f13424a.m14364a(alertDialog.f13426a);
            alertDialog.setCancelable(this.f13424a.f13459q);
            if (this.f13424a.f13459q) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.f13424a.f13460r);
            alertDialog.setOnDismissListener(this.f13424a.f13461s);
            if (this.f13424a.f13462t != null) {
                alertDialog.setOnKeyListener(this.f13424a.f13462t);
            }
            return alertDialog;
        }

        public final AlertDialog m14349b() {
            AlertDialog a = mo964a();
            try {
                a.show();
            } catch (Exception e) {
            }
            return a;
        }
    }

    protected AlertDialog(Context context) {
        this(context, m14355a(context, 0));
    }

    protected AlertDialog(Context context, int i) {
        super(context, m14355a(context, i));
        this.f13426a = new AlertController(getContext(), this, getWindow());
    }

    public static int m14355a(Context context, int i) {
        if (i == 1) {
            return 2131624483;
        }
        if (i == 2) {
            return 2131624484;
        }
        if (i == 3) {
            return 2131624483;
        }
        if (i == 4) {
            return 2131624484;
        }
        if (i == 5) {
            return 2131624483;
        }
        if (i >= 16777216) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(2130772444, typedValue, true);
        return typedValue.resourceId;
    }

    public final Button m14356a(int i) {
        Button button;
        AlertController alertController = this.f13426a;
        switch (i) {
            case -3:
                button = alertController.s;
                break;
            case -2:
                button = alertController.p;
                break;
            case -1:
                button = alertController.m;
                break;
            default:
                button = null;
                break;
        }
        return button;
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f13426a.a(charSequence);
    }

    public void m14360a(CharSequence charSequence) {
        this.f13426a.b(charSequence);
    }

    public void m14358a(View view) {
        this.f13426a.c(view);
    }

    public void m14359a(View view, int i, int i2, int i3, int i4) {
        this.f13426a.a(view, i, i2, i3, i4);
    }

    public void m14357a(int i, CharSequence charSequence, OnClickListener onClickListener) {
        this.f13426a.a(i, charSequence, onClickListener, null);
    }

    @Deprecated
    public final void m14361a(CharSequence charSequence, OnClickListener onClickListener) {
        m14357a(-1, charSequence, onClickListener);
    }

    @Deprecated
    public final void m14362b(CharSequence charSequence, OnClickListener onClickListener) {
        m14357a(-2, charSequence, onClickListener);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f13426a.a();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AlertController alertController = this.f13426a;
        Object obj = (alertController.v == null || !alertController.v.executeKeyEvent(keyEvent)) ? null : 1;
        return obj != null ? true : super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AlertController alertController = this.f13426a;
        Object obj = (alertController.v == null || !alertController.v.executeKeyEvent(keyEvent)) ? null : 1;
        return obj != null ? true : super.onKeyUp(i, keyEvent);
    }
}
