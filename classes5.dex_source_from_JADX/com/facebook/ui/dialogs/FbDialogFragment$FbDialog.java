package com.facebook.ui.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.view.MotionEvent;

/* compiled from: commerce_page_settings */
public class FbDialogFragment$FbDialog extends Dialog {
    final /* synthetic */ FbDialogFragment f5433a;

    public FbDialogFragment$FbDialog(FbDialogFragment fbDialogFragment, Context context, int i) {
        this.f5433a = fbDialogFragment;
        super(context, i);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.f5433a.al.m10320a(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }
}
