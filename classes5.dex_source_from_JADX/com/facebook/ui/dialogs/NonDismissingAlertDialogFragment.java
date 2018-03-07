package com.facebook.ui.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: commerce_featured_item */
public abstract class NonDismissingAlertDialogFragment extends FbDialogFragment {
    public FbAlertDialogBuilder am;

    public abstract FbAlertDialogBuilder aq();

    public final Dialog m10325c(Bundle bundle) {
        this.am = aq();
        return this.am.a();
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1972845333);
        super.mi_();
        final AlertDialog alertDialog = (AlertDialog) this.f;
        if (alertDialog == null) {
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 185066577, a);
            return;
        }
        Button a2 = alertDialog.a(-1);
        if (a2 != null) {
            a2.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ NonDismissingAlertDialogFragment f5438b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -340669041);
                    this.f5438b.f.hide();
                    this.f5438b.am.a.onClick(alertDialog, -1);
                    Logger.a(2, EntryType.UI_INPUT_END, -20200292, a);
                }
            });
        }
        a2 = alertDialog.a(-3);
        if (a2 != null) {
            a2.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ NonDismissingAlertDialogFragment f5440b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -52873507);
                    this.f5440b.f.hide();
                    this.f5440b.am.b.onClick(alertDialog, -3);
                    Logger.a(2, EntryType.UI_INPUT_END, 192183941, a);
                }
            });
        }
        a2 = alertDialog.a(-2);
        if (a2 != null) {
            a2.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ NonDismissingAlertDialogFragment f5442b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -714766625);
                    this.f5442b.f.hide();
                    this.f5442b.am.c.onClick(alertDialog, -2);
                    Logger.a(2, EntryType.UI_INPUT_END, 479952188, a);
                }
            });
        }
        LogUtils.f(1300291389, a);
    }
}
