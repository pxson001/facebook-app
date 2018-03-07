package com.facebook.ui.dialogs;

import android.content.Context;
import com.facebook.fbui.dialog.AlertDialog;

/* compiled from: commerce_product_visibility */
public class FbAlertDialog extends AlertDialog {
    public FbAlertDialog(Context context) {
        super(new DialogContext(context));
    }

    public void show() {
        DialogWindowUtils.m10316a(this);
        super.show();
    }
}
