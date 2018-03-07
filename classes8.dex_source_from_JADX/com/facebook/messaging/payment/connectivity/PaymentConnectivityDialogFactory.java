package com.facebook.messaging.payment.connectivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;

/* compiled from: tooltip_title */
public class PaymentConnectivityDialogFactory {

    /* compiled from: tooltip_title */
    final class C01631 implements OnClickListener {
        C01631() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: tooltip_title */
    final class C01642 implements OnClickListener {
        C01642() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public static void m1705a(Context context) {
        new FbAlertDialogBuilder(context).a(2131238316).b(2131238317).c(2131230726, new C01631()).a().show();
    }

    public static void m1707a(Context context, ServiceException serviceException) {
        if (serviceException.errorCode == ErrorCode.CONNECTION_FAILURE) {
            m1705a(context);
        } else {
            m1708b(context);
        }
    }

    public static void m1708b(Context context) {
        m1706a(context, 2131238318);
    }

    public static void m1706a(Context context, int i) {
        new FbAlertDialogBuilder(context).a(i).b(2131238319).c(2131230726, new C01642()).a().show();
    }
}
