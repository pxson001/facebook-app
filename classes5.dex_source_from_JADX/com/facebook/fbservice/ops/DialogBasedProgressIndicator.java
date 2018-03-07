package com.facebook.fbservice.ops;

import android.content.Context;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.ui.dialogs.DialogWindowUtils;

/* compiled from: retreive_employee_logs_for_data_sensitivity */
public class DialogBasedProgressIndicator {
    private final Context f3019a;
    private final String f3020b;
    private ProgressDialog f3021c;

    public DialogBasedProgressIndicator(Context context, String str) {
        this.f3019a = context;
        this.f3020b = str;
    }

    public DialogBasedProgressIndicator(Context context, int i) {
        this.f3019a = context;
        this.f3020b = context.getString(i);
    }

    public final void m4189a() {
        if (this.f3021c == null) {
            this.f3021c = new ProgressDialog(this.f3019a);
            this.f3021c.setCancelable(false);
            this.f3021c.a(this.f3020b);
            DialogWindowUtils.m10316a(this.f3021c);
            this.f3021c.show();
        }
    }

    public final void m4190b() {
        if (this.f3021c != null && this.f3021c.isShowing()) {
            this.f3021c.dismiss();
            this.f3021c = null;
        }
    }
}
