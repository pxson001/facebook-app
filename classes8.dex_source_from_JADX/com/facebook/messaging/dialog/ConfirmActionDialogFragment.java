package com.facebook.messaging.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.google.common.base.Preconditions;

/* compiled from: total_slides */
public abstract class ConfirmActionDialogFragment extends FbDialogFragment {
    public ConfirmActionParams am;

    /* compiled from: total_slides */
    class C01551 implements OnClickListener {
        final /* synthetic */ ConfirmActionDialogFragment f1490a;

        C01551(ConfirmActionDialogFragment confirmActionDialogFragment) {
            this.f1490a = confirmActionDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f1490a.aq();
        }
    }

    /* compiled from: total_slides */
    class C01562 implements OnClickListener {
        final /* synthetic */ ConfirmActionDialogFragment f1491a;

        C01562(ConfirmActionDialogFragment confirmActionDialogFragment) {
            this.f1491a = confirmActionDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f1491a.ar();
        }
    }

    /* compiled from: total_slides */
    class C01573 implements OnClickListener {
        final /* synthetic */ ConfirmActionDialogFragment f1492a;

        C01573(ConfirmActionDialogFragment confirmActionDialogFragment) {
            this.f1492a = confirmActionDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f1492a.as();
        }
    }

    public Dialog m1677c(Bundle bundle) {
        Preconditions.checkNotNull(this.am);
        CharSequence charSequence = this.am.f1501a;
        CharSequence charSequence2 = this.am.f1503c;
        CharSequence charSequence3 = this.am.f1502b;
        CharSequence charSequence4 = this.am.f1505e;
        CharSequence charSequence5 = this.am.f1507g;
        boolean z = this.am.f1508h;
        FbAlertDialogBuilder fbAlertDialogBuilder = new FbAlertDialogBuilder(getContext());
        fbAlertDialogBuilder.a(charSequence);
        fbAlertDialogBuilder.b(charSequence2);
        fbAlertDialogBuilder.a(charSequence3, new C01551(this));
        if (charSequence4 != null) {
            fbAlertDialogBuilder.c(charSequence4, new C01562(this));
        }
        OnClickListener c01573 = new C01573(this);
        if (charSequence5 != null) {
            fbAlertDialogBuilder.b(charSequence5, c01573);
        } else if (!z) {
            fbAlertDialogBuilder.b(2131230727, c01573);
        }
        return fbAlertDialogBuilder.b();
    }

    protected void aq() {
    }

    protected void ar() {
    }

    protected void as() {
        a();
    }
}
