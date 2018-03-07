package com.facebook.fig.dialog;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.ContextThemeWrapper;
import android.view.View;
import com.facebook.fbui.dialog.AlertController.AlertParams;
import com.facebook.fbui.dialog.AlertDialog;

/* compiled from: WWW_PAGE_SANDBOX */
public final class FigDialog extends AlertDialog {

    /* compiled from: WWW_PAGE_SANDBOX */
    public class Builder {
        public final AlertParams f12291a;
        protected int f12292b;

        public Builder(Context context) {
            this(context, AlertDialog.a(context, 0));
        }

        private Builder(Context context, int i) {
            this.f12291a = new AlertParams(new ContextThemeWrapper(context, AlertDialog.a(context, i)));
            this.f12292b = i;
        }

        public final Builder m20362a(int i) {
            this.f12291a.f = this.f12291a.a.getText(i);
            return this;
        }

        public final Builder m20364b(int i) {
            this.f12291a.h = this.f12291a.a.getText(i);
            return this;
        }

        public final Builder m20365b(CharSequence charSequence, OnClickListener onClickListener) {
            this.f12291a.m = charSequence;
            this.f12291a.n = onClickListener;
            return this;
        }

        public final FigDialog m20363a() {
            FigDialog figDialog = new FigDialog(this.f12291a.a, this.f12292b);
            this.f12291a.a(figDialog.a);
            figDialog.setCancelable(this.f12291a.q);
            if (this.f12291a.q) {
                figDialog.setCanceledOnTouchOutside(true);
            }
            figDialog.setOnCancelListener(this.f12291a.r);
            figDialog.setOnDismissListener(this.f12291a.s);
            if (this.f12291a.t != null) {
                figDialog.setOnKeyListener(this.f12291a.t);
            }
            return figDialog;
        }

        public final FigDialog m20366b() {
            FigDialog a = m20363a();
            try {
                a.show();
            } catch (Exception e) {
            }
            return a;
        }
    }

    protected FigDialog(Context context, int i) {
        super(context, AlertDialog.a(context, i));
    }

    public final void m20367a(View view) {
    }

    public final void m20368a(View view, int i, int i2, int i3, int i4) {
    }
}
