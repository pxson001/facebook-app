package com.facebook.ui.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.AlertDialog.Builder;

/* compiled from: east */
public class FbAlertDialogBuilder extends Builder {
    public OnClickListener f13421a;
    public OnClickListener f13422b;
    public OnClickListener f13423c;

    public FbAlertDialogBuilder(Context context) {
        super(new DialogContext(context));
    }

    public FbAlertDialogBuilder(Context context, int i) {
        super(new DialogContext(context), i);
    }

    public final Builder mo962a(int i, OnClickListener onClickListener) {
        this.f13421a = onClickListener;
        return super.mo962a(i, onClickListener);
    }

    public final Builder mo963a(CharSequence charSequence, OnClickListener onClickListener) {
        this.f13421a = onClickListener;
        return super.mo963a(charSequence, onClickListener);
    }

    public final Builder mo967c(int i, OnClickListener onClickListener) {
        this.f13422b = onClickListener;
        return super.mo967c(i, onClickListener);
    }

    public final Builder mo968c(CharSequence charSequence, OnClickListener onClickListener) {
        this.f13422b = onClickListener;
        return super.mo968c(charSequence, onClickListener);
    }

    public final Builder mo965b(int i, OnClickListener onClickListener) {
        this.f13423c = onClickListener;
        return super.mo965b(i, onClickListener);
    }

    public final Builder mo966b(CharSequence charSequence, OnClickListener onClickListener) {
        this.f13423c = onClickListener;
        return super.mo966b(charSequence, onClickListener);
    }

    public final AlertDialog mo964a() {
        Dialog a = super.mo964a();
        DialogWindowUtils.a(a);
        return a;
    }
}
