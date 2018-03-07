package com.facebook.negativefeedback.video.ui;

import android.app.Activity;
import android.app.Dialog;
import com.facebook.common.util.ContextUtils;

/* compiled from: tasks-executeVideoUploadedQuery */
public class SystemUIAwareDialogHelper {
    public static void m1890a(Dialog dialog) {
        dialog.getWindow().setFlags(8, 8);
        Activity activity = (Activity) ContextUtils.a(dialog.getContext(), Activity.class);
        if (activity != null) {
            dialog.getWindow().getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility());
        }
        dialog.show();
        dialog.getWindow().clearFlags(8);
    }
}
