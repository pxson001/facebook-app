package com.facebook.ui.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;

/* compiled from: communicationRank */
public class DialogWindowUtils {

    /* compiled from: communicationRank */
    public interface CustomDialogHostContext {
    }

    public static void m10316a(Dialog dialog) {
        Context context = dialog.getContext();
        while ((context instanceof ContextWrapper) && !(context instanceof CustomDialogHostContext)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
    }
}
