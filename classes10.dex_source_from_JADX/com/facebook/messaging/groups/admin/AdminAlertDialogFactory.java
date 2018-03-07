package com.facebook.messaging.groups.admin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;

/* compiled from: sideloading_send_request_to_oxygen */
public class AdminAlertDialogFactory {

    /* compiled from: sideloading_send_request_to_oxygen */
    final class C04051 implements OnClickListener {
        C04051() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public static Builder m2336a(Context context) {
        return new FbAlertDialogBuilder(context).a(true).a(2131231897).b(2131231898).a(17039370, new C04051());
    }
}
