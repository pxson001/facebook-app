package com.facebook.ui.dialogs;

import android.app.Dialog;
import android.content.Context;

/* compiled from: commerce_page_type */
public class FbDialog extends Dialog {
    public FbDialog(Context context) {
        super(new DialogContext(context));
    }

    public FbDialog(Context context, int i) {
        super(new DialogContext(context), i);
    }

    public void show() {
        DialogWindowUtils.m10316a(this);
        super.show();
    }
}
