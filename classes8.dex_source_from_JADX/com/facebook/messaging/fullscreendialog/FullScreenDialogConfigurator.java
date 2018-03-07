package com.facebook.messaging.fullscreendialog;

import android.app.Dialog;

/* compiled from: tos_transition_type */
public class FullScreenDialogConfigurator {
    public final int f1528a;
    public final int f1529b;
    public final Dialog f1530c;

    public static FullScreenDialogConfigurator m1685a(Dialog dialog) {
        return new FullScreenDialogConfigurator(-1, -1, dialog);
    }

    public FullScreenDialogConfigurator(int i, int i2, Dialog dialog) {
        this.f1528a = i;
        this.f1529b = i2;
        this.f1530c = dialog;
    }
}
