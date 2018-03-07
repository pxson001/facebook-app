package com.facebook.events.tickets.modal.views;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.resources.ui.FbTextView;

/* compiled from: applink_navigation_event */
public class EventBuyTicketProgressDialog extends AlertDialog {
    private FbTextView f19343b;

    public EventBuyTicketProgressDialog(Context context) {
        super(context);
    }

    protected void onCreate(Bundle bundle) {
        View inflate = LayoutInflater.from(getContext()).inflate(2130903993, null);
        this.f19343b = (FbTextView) inflate.findViewById(2131561204);
        a(inflate);
        setCancelable(false);
        super.onCreate(bundle);
    }

    public final void m19494a(CharSequence charSequence) {
        this.f19343b.setText(charSequence);
    }

    public final void m19493a(int i, CharSequence charSequence, OnClickListener onClickListener) {
        throw new UnsupportedOperationException();
    }
}
