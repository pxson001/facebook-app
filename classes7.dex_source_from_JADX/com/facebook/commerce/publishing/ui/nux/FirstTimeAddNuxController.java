package com.facebook.commerce.publishing.ui.nux;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.support.annotation.Nullable;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: creativecam_open_simple_picker */
public class FirstTimeAddNuxController {
    public final boolean f16595a;
    private final Lazy<FBAlertDialogBuilderWrapper> f16596b;

    /* compiled from: creativecam_open_simple_picker */
    class C13141 implements OnClickListener {
        final /* synthetic */ FirstTimeAddNuxController f16594a;

        C13141(FirstTimeAddNuxController firstTimeAddNuxController) {
            this.f16594a = firstTimeAddNuxController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    @Inject
    public FirstTimeAddNuxController(@Assisted boolean z, Lazy<FBAlertDialogBuilderWrapper> lazy) {
        this.f16595a = z;
        this.f16596b = lazy;
    }

    private void m20650b() {
        Preconditions.checkState(this.f16595a, "Not able to show, call canShowNux before calling");
    }

    public final void m20651a(Activity activity, @Nullable OnDismissListener onDismissListener) {
        m20650b();
        m20649b(activity, onDismissListener).show();
    }

    private AlertDialog m20649b(Activity activity, @Nullable OnDismissListener onDismissListener) {
        m20650b();
        this.f16596b.get();
        FbAlertDialogBuilder a = FBAlertDialogBuilderWrapper.m20648a(activity);
        a.a(2131239318).b(2131239319).a(2131230726, new C13141(this));
        if (onDismissListener != null) {
            a.a(onDismissListener);
        }
        return a.a();
    }
}
